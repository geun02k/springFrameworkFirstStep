# 오류와 해결

---
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

---
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

---
### < 애노테이션 프로세싱(Annotation Processing) >
1. 애노테이션 프로세싱(annotation processing)   
   - Java 컴파일러는 @AllArgsConstructor, @Data, @Builder 등과 같은 애노테이션을 분석하고, 
     그에 따라 자동으로 코드를 생성하는 기능을 제공하는데 이 과정을 애노테이션 프로세싱이라 한다.
   - ***Enable annotation processing 설정***은 Lombok 같은 ***애노테이션 기반 코드 생성 라이브러리를 사용할 때 반드시 필요***한 설정.

2. IDE에서 Enable annotation processing 설정이 필요한 이유   
   Lombok은 컴파일 시점에 생성자, getter/setter, equals, hashCode 등을 자동 생성.
   하지만 IntelliJ나 Eclipse는 이 자동 생성 코드를 기본적으로는 인식하지 못함.
   그래서 Enable annotation processing 옵션을 꺼두면 컴파일러는 실제 생성자가 있지만 IDE는 없는 것으로 판단해 컴파일 에러 또는 IDE 경고 발생.

---
### < DI >
1. 발생에러   
   > Description:
   > Field repository in com.study.domain.springframeworkfirststep.SpringFrameworkFirstStepApplication required a bean of type 'com.study.domain.springframeworkfirststep.chapter04.repository.MemberCrudRepository' that could not be found.
   > 
   > The injection point has the following annotations:
   > - @org.springframework.beans.factory.annotation.Autowired(required=true)
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

---
### < @EnableJpaRepositories, @EnableJdbcRepositories 차이 >
1. @EnableJpaRepositories	
   - Spring Data JPA (Hibernate 같은 JPA 구현체를 통해 RDB 접근)
2. @EnableJdbcRepositories	
   - Spring Data JDBC (더 가볍고 단순한 JDBC 기반 접근 방식)

