# 스프링 프레임워크 첫걸음
### 스프링 프레임워크 기초 복습을 위해 읽게됨.

### < 학습총평 >   
자바에서 클래스에 의존, 인터페이스에 의존, DI에 대한 코드를 비교하면서 사용중인 클래스 코드를 점점 변경하지 않는 방향으로 나아감을 확인함. 
스프링 프레임워크에서 지원하는 DI에 대해 복습하고, AOP에 대한 공부에 도움이 됨.

---
## < 스프링 >

### < DI : Dependency Injection 의존성 주입 >
1. DI 컨테이너
    > 스프링 프레임워크는 구현한 클래스를 인스턴스화하는 기능을 하는 DI컨테이너를 제공.     
      따라서 스프링 프레임워크를 사용하는 애플리케이션은 인스턴스를 명시적으로 생성하지 않음. (new 키워드 사용 x)   
      @Component 어노테이션을 클래스에 부여하는 것으로 인스턴스를 생성.   
      생성된 인스턴스를 사용하고 싶은 클래스에서 필드를 생성하고 @Autowired 어노테이션을 부여해 인스턴스 주입.   
      인터페이스를 이용해 의존성을 만들고 DI를 생성해 사용되는 객체 클래스를 변경하는 경우, 사용하는 객체 클래스의 수정 없이 변경 가능.
    > 
    > 즉, 스프링 프레임워크에서 지원하는 **의존성 주입을 사용하는 경우, 설계 변경 시 사용하는 객체 클래스의 수정 없이 변경가능.**      

2. DI 컨테이너에서 인스턴스 생성을 위해 지켜야 할 규칙
   > - 인터페이스를 이용해 의존성 생성    
       (특정 클래스 타입으로 선언하지 않을 것.) 
   > - 인스턴스를 명시적으로 생성하지 않을 것.    
       (new 키워드를 이용해 인터페이스에 저장하지 않을 것.)
   > - 인스턴스를 생성하려는 클래스에 @Component 인스턴스 생성 어노테이션 부여.
   > - 스프링 프레임워크에서 인스턴스 생성    
       (스프링 프레임워크는 실행 시 component scan을 통해 대상 프로젝트의 모든 패키지를 스캔해 인스턴스 생성.)
   > - 인스턴스를 사용하고 싶은 필드에 @Autowired 어노테이션 부여    
       (스프링 프레임워크에 의해 생성된 인스턴스를 이용하는 클래스에 참조를 받는 필드를 선언하고 필드에 @Autowired 어노테이션 부여.)


### < AOP : Aspect Oriented Programming 관점 지향 프로그래밍 >
공통처리 등 횡단적 관심사(품질, 유지보수 관점 반드시 필요한 기능)를 추출해 프로그램의 여러 곳에서 호출할 수 있게 설정하는 구조.   
- Aspect : Advice 작성 클래스   
- Advice : 횡단적 관심사 메서드   
- JoinPoint : Advice를 중심적 관심사에 적용하는 타이밍   
- PointCut : Advice 삽입 위치

1. Before Advice : 메서드(중앙적 관심사) 실행 전 호출됨.
2. After Advice : 메서드 실행 후 호출됨.
3. Around Advice : 메서드 전후로 호출됨.    
                   (중앙적 관심사 실행 전에 수행되어야 할 횡단적 관심사 수행 후 중앙적 관심사로 돌아가기위해(호출하기위해) ProceedingJoinPoint.proceed() 실행 필요.)
4. After Returning Advice : 메서드 정상 종료 후 호출됨. 
5. After Throwing Advice : 메서드 예외 발생 후 호출됨.


### < javax 라이브러리 vs jakarta 라이브러리 >
> 두 라이브러리 모두 자바 공식 표준 API 라이브러리들이다.
> Spring, JPA, Servlet, Validation 등 다양한 java 프레임워크에서 핵심 역할을 수행한다.
> 하지만 스프링부트 버전에 따라 사용가능한 라이브러리 상이하다.
> 스프링부트 2.x 버전까지는 javax, 스프링부트 3.x 버전부터는 jakarta를 사용해야한다.

1. javax
    - Oracle의 Java EE(Enterprise Edition)
    - Java EE 8 이하에서 사용
    - Spring Boot 2.x 버전까지 주로 사용
    - javax.servlet, javax.persistence, javax.validation, javax.annotation 등...

2. jakarta
    - Eclipse 재단의 Java EE
    - Jakarta EE 9 이상에서 사용
    - 추후 Oracle이 Java EE를 Eclipse 재단에 기증하면서 Oracle과 Eclipse 간 상표권 문제 발생. 따라서 강제로 javax에서 jakarta로 라이브러리를 변경.
    - **Spring Boot 3.x 부터 jakarta로 전환되어 사용**
    - ex) javax.servlet.http.HttpServletRequest -> jakarta.servlet.http.HttpServletRequest

---
## < 타임리프 >

### < 타임리프 문법 사용 시 네임스페이스 선언 필수 >
> 타임리프 엔진 사용을 위해 spring-boot-starter-thymeleaf 의존성을 추가합니다. 
> 이 때 타임리프 엔진을 Spring Boot에 통합하는 역할만 합니다.
> 따라서 html에 xmlns:th="http://www.thymeleaf.org" 네임스페이스 선언 없이도 일부 IDE에서는 문법 강조 없이 작동은 가능할 수 있지만,
정상적인 Thymeleaf 문법 인식 및 HTML 렌더링을 보장하려면 반드시 선언해야 합니다.


### < 타임리프 URL 생성 전용 문법 경로 설정 시 ../ 사용불가한 이유 >
> 문제
> 타임리프 URL 생성 전용 문법인 @{}을 이용해 경로를 설정했다.
> URL 설정할 때 /로 시작하느냐 아니냐에 따라 절대경로가 될 수 있고 상대경로가 될 수 있다.
> @{/pathVariable/function/1} -> 절대경로 (/로 시작)
> @{pathVariable/function/1} -> 상대경로 (/없이 시작)
> 
> 여기서 한 발 더 나아가 기존 /pathVariable/showForm 에서 /showForm 경로를 지우고 /pathVariable/function/1 로 요청하기 위해
@{../function/1} 으로 요청을 시도했으나 맵핑 에러가 발생했다.

왜 ../가 안 될까?
타임리프는 HTML이기 때문에 브라우저가 해석하는 경로 처리 방식과도 맞물립니다. 

@{...} 내부의 경로는 Thymeleaf가 컴파일 타임에 URL을 조합해서 HTML 속성에 넣는 것이기 때문에,
../는 HTML이 아닌 **Thymeleaf 파서가 먼저 해석**합니다.
이때 **정확한 현재 경로 컨텍스트를 알기 어렵기 때문에 ../는 잘못된 경로로 변환되거나 무시**될 수 있습니다.


