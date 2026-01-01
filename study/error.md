# 오류와 해결
1. Lombok
   - lombok 인식 오류 해결
   - lombok 사용 시 compileOnly, annotationProcessor 2개의 의존성을 추가해야하는 이유
2. DI
   - 의존성 주입 실패 오류 해결
3. 요청 파라미터
   - 요청 파라미터 취득과 타입 불일치로 인한 오류 해결 (MethodArgumentNotValidException)



---
## 1. Lombok
### < lombok 인식 오류 해결 >
1. 발생오류   
   lombok 어노테이션인 @AllArgsConstructor 사용 시 오류가 발생하고, 이를 제거하고 생성자를 수동으로 작성하면 정상 수행됨.  
2. 발생원인   
   @AllArgsConstructor를 제거하고 생성자를 수동으로 작성하면 잘 되는데 
   Lombok 사용 시 오류가 난다면 IDE가 Lombok이 생성한 생성자를 제대로 인식하지 못하고 있다는 명확한 신호.
3. 해결방법 (확인사항)   
   - Lombok 플러그인 설치
   - Enable annotation processing 체크   
     File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors
     저장 후 프로젝트 Rebuild (Ctrl+F9 또는 Build > Rebuild Project)
   - build.gradle 또는 pom.xml에 Lombok 의존성 추가
   - IDE 캐시 비우고 재시작
   - Lombok 버전 최신으로 유지 (1.18.30 이상 권장)
   - javac 또는 CLI 빌드로 테스트


### < lombok 사용 시 compileOnly, annotationProcessor 2개의 의존성을 추가해야하는 이유 >
1. 의존성 종류와 역할
    - compileOnly    
      컴파일 시 애노테이션과 클래스 존재만 확인 (코드 생성은 안 함)
    - annotationProcessor
      컴파일 시 애노테이션 기반 코드 생성 처리 수행 (Lombok 동작의 핵심)

2. lombok 사용을 위한 의존성 추가
   ~~~
   compileOnly 'org.projectlombok:lombok'
   annotationProcessor 'org.projectlombok:lombok'
   ~~~

- 애노테이션 프로세싱(Annotation Processing)
   Java 컴파일러는 @AllArgsConstructor, @Data, @Builder 등과 같은 ***애노테이션을 분석하고, 
   그에 따라 자동으로 코드를 생성하는 기능을 제공하는데 이 과정***을 애노테이션 프로세싱이라 한다.
   1. ***Enable annotation processing 설정***   
      Lombok 같은 ***애노테이션 기반 코드 생성 라이브러리를 사용할 때 반드시 필요***한 설정.
 
   2. IDE에서 Enable annotation processing 설정이 필요한 이유   
      Lombok은 컴파일 시점에 생성자, getter/setter, equals, hashCode 등을 자동 생성.  
      하지만 IntelliJ나 Eclipse는 이 자동 생성 코드를 기본적으로는 인식하지 못함.  
      그래서 Enable annotation processing 옵션을 꺼두면 컴파일러는 실제 생성자가 있지만 
      IDE는 없는 것으로 판단해 컴파일 에러 또는 IDE 경고 발생.


### < Lombok의 @Data 어노테이션 사용 시 getAnswer() 메서드가 자동 생성되지 않는 이유 >
Quiz 클래스를 생성해 @Data 어노테이션을 부여했을 때 getAnswer() 메서드가 생성되지 않아 호출이 불가 문제
> JavaBean 규약에 따라 boolean 타입은 get 메서드 대신 is 메서드를 생성하는 것이 일반적이다.
> 그리고 Lombokeh JavaBean 규약을 따른다.
> 따라서 네이밍 규칙에 의해 getAnswer()가 아닌 isAnswer() 메서드를 생성한다.
> 단, 객체 타입인 Boolean 타입의 경우에는 get 메서드를 생성한다.
자바에서 boolean 타입 필드만 특별히 isXxx() 형태의 getter 메서드를 갖는 이유는 JavaBean 명세 때문이다.



---
## 2. DI
### < 의존성 주입 실패 오류 해결 >
1. 발생에러   
   > Description:
   > Field repository in com.study.domain.springframeworkfirststep.SpringFrameworkFirstStepApplication required a bean of type 'com.study.domain.springframeworkfirststep.chapter04.repository.MemberCrudRepository' that could not be found.
   > 
   > The injection point has the following annotations:
   > @org.springframework.beans.factory.annotation.Autowired(required=true)
   > 
   > Action:
   > Consider defining a bean of type 'com.study.domain.springframeworkfirststep.chapter04.repository.MemberCrudRepository' in your configuration.
   > Process finished with exit code 1

2. 발생원인   
   이 오류 메시지는 Spring 애플리케이션에서 의존성 주입이 실패했음을 의미.   
   Spring은 @Autowired가 붙은 repository 필드에 주입할 MemberCrudRepository 타입의 Bean을 찾지 못함.   
   MemberCrudRepository가 Spring에서 관리하는 Bean으로 등록되지 않음.   
   일반적으로 MemberCrudRepository는 JpaRepository, CrudRepository를 상속한 인터페이스일 것.  
   그러나 Spring이 이 인터페이스를 자동으로 인식하도록 설정하지 않았거나,
   해당 패키지를 컴포넌트 스캔 대상에 포함시키지 않았을 수 있습니다.

3. 해결방법   
   - @SpringBootApplication 위치   	
     repository 패키지를 포함한 최상위 패키지에 위치해야 함
   - MemberCrudRepository 작성 여부	
     CrudRepository 또는 JpaRepository 상속했는지 확인
   - @EnableJpaRepositories 또는 EnableJdbcRepositories 사용 여부	
     필요시 리포지토리 경로 명시 
   - DB 설정 여부   	
     application.properties에 DB 접속 정보 입력했는지 확인

-  @EnableJpaRepositories, @EnableJdbcRepositories 차이
   1. @EnableJpaRepositories	
      - Spring Data JPA (Hibernate 같은 JPA 구현체를 통해 RDB 접근)
   2. @EnableJdbcRepositories	
      - Spring Data JDBC (더 가볍고 단순한 JDBC 기반 접근 방식)



---
## 3. 요청 파라미터
### < 요청 파라미터 취득과 타입 불일치로 인한 오류 해결 >
1. 발생에러
    ~~~
    org.springframework.web.bind.MethodArgumentNotValidException: 
    Validation failed for argument [0] in public java.lang.String com.study.domain.springframeworkfirststep.chapter09.quiz.controller.QuizController.showQuiz(com.study.domain.springframeworkfirststep.chapter09.quiz.form.QuizForm,java.lang.Integer,org.springframework.ui.Model): [Field error in object 'quizForm' on field 'id': rejected value [paly]; codes [typeMismatch.quizForm.id,typeMismatch.id,typeMismatch.java.lang.Integer,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [quizForm.id,id]; arguments []; default message [id]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'java.lang.Integer' for property 'id'; For input string: "paly"]] 
    ~~~

2. 발생원인
   해당 에러는 Spring MVC에서 컨트롤러로 전달된 요청 파라미터가 Java 객체의 필드 타입과 일치하지 않아 변환에 실패했을 때 발생하는 MethodArgumentNotValidException이다.
   컨트롤러의 메서드에서 QuizForm 안의 id 필드는 Integer 타입인데 사용자가 전송한 값은 "paly"라는 문자열이다.
   이 문자열은 Integer로 변환할 수 없기 때문에 타입 변환 예외가 발생했다.
    ~~~
    @GetMapping("/quiz/{id}")
    public String showQuiz(QuizForm quizForm, @PathVariable Integer id, Model model) {
        ...
    }
    @GetMapping("/quiz/paly")
    public String playQuiz(QuizForm quizForm, Model model) {
        ...
    }   
    ~~~
   @GetMapping("/quiz/play"), @GetMapping("/quiz/{id}") 두개의 매핑 경로가 존재할 때
   /quiz/play 경로로 요청 시 @GetMapping("/quiz/play")에 매핑되지 않고 @GetMapping("/quiz/{id}")에 매핑되는 문제가 발생했다.
   해당 문제는 Spring MVC의 URL 패턴 매핑 순서와 경로 변수(PathVariable) 처리 방식과 관련있다.
   ***Spring은 경로 매핑 시 더 구체적인 패턴을 우선해 처리한다.
   하지만 {id}는 와일드카드처럼 동작하므로 우선순위가 모호해지는 경우가 발생한다.***
   즉 {id}는 어떤 문자열도 매칭하므로 /quiz/play는 {id}에 play를 넣으려 시도하지만 play는 Integer 타입이 아니기에 타입변환오류가 발생했다.

3. 해결방법
   @RequestMapping에서 매핑 순서를 명확히 구분해 경로 충돌을 피해야한다.
   따라서 와일드카드처럼 동작하는 {id}를 정규식을 이용해 정수 숫자만 허용되도록 지정해야한다.
    ~~~
    @GetMapping("/quiz/{id:\\id+}")
    public String showQuiz(QuizForm quizForm, @PathVariable Integer id, Model model) {
        ...
    }
    ~~~    
