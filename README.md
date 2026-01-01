# 스프링 프레임워크 첫걸음

Study 내용 정리  
https://www.notion.so/2caf6e3b069b80ae9a24c67b3388bafd

### < 목차 >
1. 스프링 프레임워크
2. 자바 의존 관계와 설계 변경
3. DI (Dependency Injection, 의존성 주입)
4. AOP (Aspect Oriented Programming, 관점 지향 프로그래밍)
5. 어노테이션
6. MVC 모델
7. 요청 파라미터
8. 유효성 검사 
9. 메시지 관리  
10. 애플리케이션 설계 방식 
11. 트랜잭션(Transaction)

---
### < 주요 학습내용 >
> 1. 자바 의존 관계와 설계 변경  
> 설계 변경 시, 자바에서 의존 관계 변경에 따라 사용중인 클래스 코드를 점점 변경하지 않는 방향으로 나아갑니다.   
> 클래스에 의존하는 경우, 호출하는 클래스의 코드 수정량이 많고 이로 인해 해당 기능이 정상 동작하지 않을 가능성이 높습니다.    
> 반면 인터페이스에 의존하는 경우, 인터페이스 타입 변수에 저장하는 구현체만 변경하면 됩니다.   
> 이 때 스프링에서 지원하는 DI를 이용하면 호출하는 클래스의 변경사항 없이도 구현체 변경이 가능함에 대해 학습했습니다.    

> 2. Spring DI와 AOP  
> 스프링 프레임워크에서 지원하는 DI에 대해 복습하고, 
  단순히 개념만 알고 있던 AOP에 대한 구현 방법에 대해 학습할 수 있었습니다.   
> DI는 프로그램에서 의존하는 부분에서 주입하는 기술로
  IoC 컨테이너가 객체를 생성하고, 의존성을 주입하고, 객체의 전체 생명주기를 관리하는 등의 역할을 수행합니다.   
> 생성자 주입 방식이 권장되고 그래야 테스트 코드 작성에도 어려움이 없습니다.   
> AOP는 종단적 관심사에서 횡단적 관심사를 분리하는 방법론으로,
  개발자가 실현해야 할 기능에만 집중할 수 있게 합니다.   
> 이는 Advice를 생성 및 적용해 실현할 수 있습니다.   

> 3. 어노테이션의 역할   
> 어노테이션을 사용하면서도 그 의미를 이해하지 못했습니다.    
> 단순히 어떤 기능 실행을 위해 적용이 필요하다고 생각했습니다.   
> 어노테이션은 주석의 표현으로, 
  소스파일에 어노테이션을 적용해 외부 소프트웨어에 필요한 처리내용 전달합니다.   
> 에러출력, 프로그램의 동작 변경 등을 가능하게 합니다.    

> 4. Spring MVC   
> MVC 패턴을 사용하고 있는 것은 알고 있었지만
  Spring MVC 자체가 프레임워크라는 인지를 명확히 하게 되었습니다.   
> 또한 Spring MVC 요청과 응답 동작 방식에 대해 다시 재학습할 수 있었습니다.   
> Spring MVC는 웹 요청 흐름과 화면 전환을 프레임워크가 관리하고, 
  브라우저와 서버 간 데이터 전달을 객체 중심으로 단순화해주는 웹 프레임워크입니다.   
> 따라서 개발자는 Controller, 비즈니스 처리 로직, View 코드만 작성하면 됩니다.   
> 또한 Front Controller가 모든 요청을 수신해 
  url에 대응하는 Controller 요청 핸들러 메서드를 호출하고 
  비즈니스 로직을 처리해 처리 결과를 Model로 설정하고
  view 이름에 대응하는 화면을 클라이언트에 반환합니다.   

> 5. 요청 파라미터와 취득방법   
> 여러 요청 파라미터와 취득 방법에 대해 정리해 볼 수 있었습니다.   
> 요청 파라미터 종류는 query string, request body, path variable이 있고 
  name 속성값으로 버튼 식별이 가능합니다.   
> 요청 파라미터는 @RequestParam, Form 클래스 생성해 사용하기, @PathVariable을 통해 취득 가능합니다.   

> 6. 유효성 검사와 사용자정의 검증 어노테이션   
> 개발 시 간단하고 반복적인 검증 내용에 대해 
  if문을 작성해 일일이 유효성 검증 수행 로직을 작성하지 않고 
  Bean Validation 라이브러리 의존성을 추가해 어노테이션들을 사용해
  유효성 검증을 간단하게 수행할 수 있었습니다.     
> 또한 사용자 검증 어노테이션, 검증기를 생성해 연결해 사용자 정의 검증 어노테이션을 생성해 적용 가능합니다.   
> 입력 체크 어노테이션 생성을 위해 Bean Validation을 구현한 Hibernate Validator를 사용하거나 
  Spring Validator를 사용하는 두 기술이 있습니다.   
> Bean Validation은 Java가 제공하는 표준 스펙이며, 이를 구현하는 Spring 권장 구현체가 Hibernate Validator 입니다.   
> ConstraintValidator 인터페이스를 구현하고 에러는 ConstraintViolation 객체에 저장합니다.   
> @Valid, @Validated를 이용한 선언적 검증을 수행합니다.   
> 이 때, 개발자 입장에서 어노테이션 사용 시, 스프링 내부에서는 Hibernate Validator 엔진이 돌면서 검증을 수행합니다.   
> Spring Validator는 스프링 프레임워크에서 자체 제공합니다.   
> Validator 인터페이스를 구현하고 에러는 Errors 객체에 저장합니다.   
> 개발자 입장에서 어노테이션 사용 시, 스프링 내부적으로 직접 검증을 수행합니다.   
> 단, 해당 검증 어노테이션을 사용하기 위해서는 컨트롤러나 WebDataBinder에 등록이 필요한 명령형 검증을 수행합니다.   

> 7. 오류 메시지 관리   
> 메시지 같은 내용들을 하드코딩해 소스코드 내에서 사용하는 것은 관리에 어려움을 알고 있습니다.   
> 업무에서는 DB에서 오류 메시지를 관리한 경헙이 있는데, 이는 오류 발생 시 메시지 출력을 위해 DB에 접근이 필요하다는 단점이 있습니다.   
> 일반적으로 애플리케이션에서 표시하는 메시지는 프로그램과 별도로 properties 파일로 관리하는 것이 용이하다는 것을 알았습니다.   
> 스프링 부트에서 메시지 관리를 위해 ValidationMessages.properties, messsages.properties 파일을 사용할 수 있습니다.   
> 하지만 ValidationMessages와 messages를 혼용해서 사용하는 것은 관리 난이도가 높고 메시지 추적이 어렵기 때문에
  Validation, View, MessageSource에서도 사용 가능하고 
  유효성 검증 메시지뿐만 아니라 일반 안내 메시지, 오류 메시지 등 
  애플리케이션 전반의 메시지를 관리하는 데 사용되는 messages.properties만 사용하는 것이 권장될 수 있습니다.   

> 8. 애플리케이션 설계 방식   
> 무의식적으로 사용하고 있던 Layered Architecture와 MVC 패턴에 대해 학습했습니다.    
> 애플리케이션 설계 방식은 애플리케이션을 만드는 다양한 구조적 접근 방법으로
  시스템 전체 구조와 책임 분리 원칙을 정의합니다.    
> 이는 코드의 가독성 향상, 기능 변경 시 영향 범위의 최소화, 협업 시 역할 분리를 가능하게 합니다.
> 또한 테스트의 용이성, 대규모 프로젝트에서 유지보수 및 확장성을 확보하는 것을 목표로 합니다. 
> 계층형 아키텍처는 기능을 역할별 레이어로 나눈 구조입니다.
> MVC 모델은 사용자 인터페이스와 비즈니스 로직을 분리하는 목적의 구조입니다.
> 즉, 화면에 보여지는 부분과 실제 일을 처리하는 부분을 분리합니다.   
> 도메인 주도 설계는 복잡한 비즈니스 문제 해결을 위해, 코드 구조를 비즈니스 도메인의 개념에 맞춰 설계하는 방법입니다.


---
## < 스프링 >
### 1. 스프링 프레임워크
자바 기반 애플리케이션에서 객체 관리와 공통 기능을 대신 처리해 주어 
개발자가 비즈니스 로직에 집중할 수 있게 해주는 프레임워크.
- 프레임워크   
  애플리케이션을 만들 때 기본 구조와 동작 방식을 미리 정해두고 개발자는 그 안에서 기능만 채워 넣게 해주는 틀.
- 라이브러리   
  필요할 때 개발자가 호출해 사용하는 도구 모음.   
<br>

### 2. 자바 의존 관계와 설계 변경
1. 설계 변경 시, 자바에서 클래스가 아닌 인터페이스에 의존 시 이점   
   설계 변경 시, 사용하는 클래스에서 인터페이스 변수에 저장하는 구현체 부분만 변경하면 수행 작업 변경 가능.   
   스프링에서 지원하는 DI 기능을 사용하게 되면 객체 생성 책임조차 스프링에 위임하므로 사용하는 클래스의 변경사항은 없음.   
   <br>

2. ***클래스 의존***    
   설계 변경 시 의존하는 모든 클래스에서 코드 변경 필요.   
   <br>

3. ***인터페이스 의존***   
   다형성 특성을 이용해 인터페이스 객체에 구현체를 저장.
   사용되는 클래스 내부 코드가 변경되어도 인터페이스 변수에 저장하는 구현 객체를 생성하는 부분만 변경 필요.  
   단, 수정이 필요한 코드 양이 줄었을 뿐 여전히 의존하는 모든 클래스를 변경해야함엔 변함 없음.   
   <br>

4. ***스프링 제공 DI 이용***   
   객체 생성 책임을 스프링에 위임하므로 DI 설정 변경만으로 구현체 변경 가능.  
   따라서 호출부 코드 수정없이 구현체 변경.

~~~
// 1. 클래스에 의존
public class Dog {
    public void dogSound() {
        System.out.println("멍멍");
    }
}
   
// 클래스 타입 변수 = 구현체
Dog dog = new Dog();
dog.dogSound();    
~~~
~~~
// 2. 인터페이스에 의존
public interface Animal {
    void sound();
}
public class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("야옹");
    }
}
   
// 인터페이스 타입 변수 = 구현체
Animal animal = new Cat();
animal.sound(); 
~~~
~~~
// 3. 스프링 DI 이용
public interface Animal {
    void sound();
}
// 신규 구현체 (빈 생성)
@Component
public class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("야옹");
    }
}
// 기존 구현체 (빈 생성 제외) 
// @Component 
public class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}

// 자동 생성자 주입
@Service
@RequiredArgsConstructor
public class AnimalService {
    private final Animal animal;
    
    public void sound() {
        animal.sound();   
    }
}
~~~
<br>


### 3. DI (Dependency Injection, 의존성 주입)
1. DI   
   ***프로그램에서 의존하는 부분을 외부에서 주입하는 것.***   
   사용되는 객체 클래스를 사용하는 클래스의 밖에서 인스턴스를 주입.   
   생성된 빈들 중에서 필요한 객체를 찾고 그 객체를 생성자나 필드, 세터 등으로 주입.   
   스프링 프레임워크에서 지원하는 ***의존성 주입을 사용하는 경우, 설계 변경 시 사용하는 객체 클래스의 수정 없이 사용되는 객체 변경가능.***   
   <br>
2. IoC(Inversion of Control, 제어의 역전) 컨테이너 (DI 컨테이너)   
   ***객체를 생성하고, 의존성을 주입하고, 객체의 전체 생명주기를 관리하는 역할 수행.***   
   생성된 객체는 IoC 컨테이너의 빈 저장소에 저장해 객체를 공유해 사용.      
   - 객체 생성   
     스프링은 @Component 또는 @Configuration + @Bean 어노테이션을 보고 클래스를 인스턴스화 수행.   
     컨테이너는 구현 클래스를 직접 new해서 빈 객체 생성.   
   - 의존성 주입   
     스프링은 어떤 객체가 어떤 객체를 필요로 하는지 분석하고 자동으로 연결.   
     생성자 주입(권장), 필드 주입, 세터 주입.   
   - 객체 생명주기 관리   
     초기화, 소멸 메서드를 실행하고 빈 스코프를 관리.   
     <br>
3. 스프링 프레임워크 애플리케이션에서의 인스턴스 생성과정
   1. 컴포넌트 스캔   
      스프링 프레임워크는 실행 시 컴포넌트 스캔을 통해 대상 프로젝트의 모든 패키지 스캔.
   2. 인스턴스 생성할 클래스 추출   
      컴포넌트 스캔 후 인스턴스 생성 어노테이션이 부여된 클래스 추출.
   3. 인스턴스 생성   
      추출한 클래스의 인스턴스 생성.
      스프링 프레임워크를 사용하는 애플리케이션은 인스턴스를 명시적으로 생성하지 않음. (new 키워드 사용 x)   
      @Component 어노테이션을 클래스에 부여하는 것으로 인스턴스를 생성.   
   4. 의존성 주입   
      생성된 인스턴스를 사용하고 싶은 클래스에서 필드를 생성하고 @Autowired 어노테이션을 부여해 인스턴스 주입. (필드주입)   
   5. 설계 변경에 따른 구현체 변경
      인터페이스를 이용해 의존성을 만들고 DI를 생성해 사용되는 객체 클래스를 변경하는 경우, 사용하는 객체 클래스의 수정 없이 변경 가능.   
      <br>

5. 스프링에서의 인스턴스 생성 규칙
   - 특정 클래스 타입으로 선언하지 않고 인터페이스를 이용해 의존성 생성.     
   - 인스턴스를 명시적으로 생성하지 않을 것.    
     (new 키워드를 이용해 인터페이스에 저장하지 않을 것.)
   - 인스턴스를 생성하려는 클래스에 @Component 인스턴스 생성 어노테이션 부여.
   - 스프링 프레임워크에서 인스턴스 생성    
     (스프링 프레임워크는 실행 시 component scan을 통해 대상 프로젝트의 모든 패키지를 스캔해 인스턴스 생성.)
   - 인스턴스를 사용하고 싶은 필드에 @Autowired 어노테이션 부여    
     (스프링 프레임워크에 의해 생성된 인스턴스를 이용하는 클래스에 참조를 받는 필드를 선언하고 필드에 @Autowired 어노테이션 부여.)   
<br>


### 4. AOP (Aspect Oriented Programming 관점 지향 프로그래밍)
1. AOP   
   ***횡단적 관심사를 분리해 깔끔한 구조를 만들려는 방법론.***  
   공통처리 등 횡단적 관심사(품질, 유지보수 관점 반드시 필요한 기능)를 추출해 
   프로그램의 여러 곳에서 호출할 수 있게 설정하는 구조.   
   개발자는 중심적 관심사(실현해야 할 기능)에만 집중 가능.   
   횡단적 관심사를 분리해 기존 코드를 수정하지 않아도 
   프로그램에서 특정 공통 처리 기능을 추가, 제거 가능.   
   <br>

2. AOP 용어
   - Aspect : Advice 작성 클래스   
   - Advice : 횡단적 관심사 메서드   
   - JoinPoint : Advice를 중심적 관심사에 적용하는 타이밍   
   - PointCut : Advice 삽입 가능한 위치
   - Interceptor : 처리의 제어를 인터셉트하기 위한 구조 or 프로그램 / Advice를 중심관심사에 추가한 것처럼 보이게 함 
   - Target : Advice 도입 대상   
   <br>

3. Advice 종류
   1. Before Advice(@Before)   
      메서드(중앙적 관심사) 실행 전 호출됨.
   2. After Advice(@After)   
      메서드 실행 후 호출됨.
   3. Around Advice(@Around)   
      메서드 전후로 호출됨.    
      중앙적 관심사 실행 전에 수행되어야 할 횡단적 관심사 수행 후, 
      중앙적 관심사로 돌아가기위해(호출하기위해) ProceedingJoinPoint.proceed() 실행 필요.   
      반환타입이 필요하다면 Object 사용.
   4. After Returning Advice(@AfterReturning)    
      메서드 정상 종료 후 호출됨. 
   5. After Throwing Advice(@AfterThrowing)    
      메서드 예외 발생 후 호출됨.   
   <br>

4. 포인트컷 식   
   Advice 삽입 대상을 조건으로 지정하는 방법.   
   와일드 카드를 이용해 유연하게 적용범위 지정가능.
   1. 와일드 카드
      - *(애스터리스크) : 임의의 패키지 1계층, 메서드의 인수 1개 
      - ..(점 2개) : 패키지 0개 이상, 메서드의 인수 0개 이상
      - +(플러스) : 클래스명 뒤에 기술 시 하위 서브클래스까지 모두 표현
   2. execution 지시자 사용 
      - execute(반환값 패키지.클래스.메서드(인수))  
   <br>

5. AOP 프록시   
   스프링 프레임워크가 제공하는 AOP 구현을 위한 기술적 수단.   
   ***AOP 프록시는 종단적 관심사를 대신 감싸서 Advice를 실행할 수 있게 
   종단적 관심사(핵심기능)에 횡단적 관심사(부가기능) 적용을 위해 만들어지는 대리 객체.***      
   실제 객체 앞에서 메서드 호출을 가로채, 부가기능 호출 전,후에 실제 객체의 메서드를 호출.
   - 동작 방식
     1. 스프링이 실제 target(종단적 관심사) 객체 참조
     2. target Bean 앞에 프록시 객체 생성.
     3. 프록시가 메서드를 가로채 Advice를 실행.
     4. 실제 메서드 호출.
     5. 결과 반환.

~~~
@Aspect
@Component
public class SampleAspect {

    @Before("execute(* com.example.demo.*Greet.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.printf("메서드 %s \n", joinPoint.getSignature.getName());
    }
    
    @Around("execute(* com.example.demo.*Greet.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        // 중심적 관심사 실행 전 횡단적 관심사 실행
        System.out.println("처리전");
        // 중심적 관심사 실행
        Object result = joinPoint.proceed();
        // 중심적 관심사 실행 후 횡단적 관심사 실행
        System.out.println("처리후");
        return result;
    }
}
~~~
<br>


### 5. 어노테이션
주석을 표현.   
소스파일에 어노테이션을 적용해 외부 소프트웨어에 필요한 처리내용 전달.
에러출력, 프로그램의 동작 변경 등 가능.

1. 어노테이션의 역할
   - @Override : 자바 컴파일러에 오버라이드 메서드의 시그니처 체크 요청
   - @Author : JavaDoc에 도움말 문서 생성 요청
   - @Component : 스프링 프레임워크에 인스턴스 생성 요청
   - @NotEmpty : Validator에 입력단 체크 요청
   - @Test : JUnit에 테스트 실행 요청  
     <br>

2. 커스텀 어노테이션   
   java.lang.Annotation 인터페이스를 상속해 생성 가능.  
   <br>

3. 메타 어노테이션  
   커스텀 어노테이션 생성 시 사용하는 특수 어노테이션. 
   (어노테이션에 붙히는 어노테이션)
   - @Target  
     커스텀 어노테이션이 무엇을 대상으로 하고 있는지 선언.
     어노테이션 부여 대상은 상수로 지정.
     ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD 등.
   - @Retention   
     컴파일, 프로그램 실행 시 어노테이션 정보를 보관, 유지하는 유효범위 결정.
     - 유효 범위별 상수
       - SOURCE : 유효범위는 소스로, 컴파일 시 어노테이션 정보 삭제.
       - CLASS : 클래스 파일은 유효하지만 JVM이 읽어들이지 않음.(기본값)
       - RUNTIME : 실행중일 때 JVM에서 참조가능. 가장 넓은 유효범위.
   - @Documented   
     지정된 어노테이션을 JavaDoc API 문서 출력 시 표시.
   - @Inherited   
     해당 어노테이션을 부여한 클래스 상속 시 
     하위 클래스에도 해당 어노테이션을 부여하도록 설정.   
     <br>

4. 스프링 메타 어노테이션   
   스프링이 제공하는 특정 기능을 담은 메타 어노테이션.   
   스프링에서 빈 등록, 설정, 컴포넌트 스캔 등에 관여하는 핵심 어노테이션을 통칭.
   - @Component   
     클래스를 스프링 빈으로 등록.  
     컴포넌트 스캔에 의해 자동으로 BeanDefinition에 등록.  
     서비스, 리포지토리, 일반 빈 등록 시 사용.  
   - @Configuration   
     스프링 설정 클래스임을 명시.  
     내부의 @Bean 메서드를 프록시 기반으로 관리. (메서드가 호출될 떄 마다 새로운 객체가 계속 생성되는 것을 방지해 싱글톤 유지)  
   - @Bean   
     특정 메서드를 호출해서 반환된 객체를 빈으로 등록.   
     메서드에 적용.  
     메서드의 반환값이 빈으로 등록됨.  
     외부 라이브러리 객체를 스프링 빈으로 등록할 때 필수.   
<br>


### 6. MVC 모델
처리 역할을 나누어 프로그램을 작성하는 방법.
웹 시스템 개발에 자주 사용.
- Model : 비즈니스 로직 담당
- View : 표현 부분 담당
- Controller : 모델, 뷰 제어 담당 
  (사용자가 입력한 내용을 뷰에서 받고, 받은 데이터를 모델에 전달.  
  모델에서 받은 데이터를 뷰에 전달해 화면에 표현.)

1. Spring MVC   
   스프링에서 제공하는 프레임워크.   
   ***Spring MVC는 웹 요청 흐름과 화면 전환을 프레임워크가 관리하고, 
   브라우저와 서버 간 데이터 전달을 객체 중심으로 단순화해주는 웹 프레임워크.***   
   번거로운 처리는 스프링 MVC가 수행하고
   개발자는 Controller, 비즈니스 로직 처리, View 코드만 작성.   
   <br>

2. Spring MVC 구성 요소
   1. ***DispatcherServlet   
      모든 요청을 수신받는 Front Controller.***
      - Front Controller : 모든 요청을 Front Controller가 받고, 
        그 후 담당 컨트롤러에 적절히 할당하는 설계 패턴.
   2. Model   
      Controller에서 View에 넘겨주는 표현 데이터 등 저장 객체. 
      (HttpServletRequest, HttpSession 같은 기능 제공)
   3. Service 처리   
      DB에 접속해 데이터를 취득, 가공 등 여러 작업 실행. 
      스프링 MVC에 관계없이 개발자가 설계하고 구현.
   4. View   
      화면 표시 처리.(JSP 등 처리)
   5. Controller   
      요청에 대응해 처리할 내용이 존재.  
   <br>

3. Spring MVC 요청과 응답 동작방식
   1. DispatcherServlet은 클라이언트로부터 request 수신.
   2. DispatcherServlet은 Controller의 요청 핸들러 메서드(요청에서 보낸 url에 대응하는 메서드)를 찾아 호출.
   3. Controller는 비즈니스 로직 처리를 호출해 처리결과 반환받음.
   4. Controller는 처리결과를 Model로 설정하고 View 이름 반환.
   5. DispatcherServlet은 반환된 View 이름에 대응하는 View에 대한 화면 표시 처리 의뢰.
   6. 클라이언트는 응답을 받고 브라우저에 화면 표시.   
<br>


### 7. 요청 파라미터
서버에 전송되는 값.  
요청 파라미터는 지정한 형식으로 분석, 변환되어 변수로 설정됨.

1.  요청 파라미터 종류
    1. query string  
       GET 요청에서 주로 사용되는 URL 뒤에 붙어서 서버로 전달되는 요청 파라미터 정보.  
       ex) /search?keyword=spring&page=2
    2. request body  
       View의 form 데이터, hidden parameter와 같이 HTTP 요청에서 URL이 아니라 본문(body)에 담겨 서버로 전달되는 데이터.  
       POST/PUT/PATCH 요청에서 사용됨. (form이라도 GET 방식이면 Query String으로 전달됨)  
    3. Path Variable  
       URL path 일부로 보내지는 값.  
       REST 방식에서 매우 중요한 요청 파라미터.  
       ex) /users/10  
    4. view 버튼의 name 속성값  
       여러 버튼 존재 시 버튼 판별을 위해 사용.  
       하지만 결국 form에 포함되므로 Query String 또는 Request Body에 포함됨.  
       ~~~
       // 전송 결과는 action=save 또는 action=delete.
       <button type="submit" name="send" value="buttonA">저장</button>   
       <button type="submit" name="send" value="buttonB">삭제</button>   
       ~~~

2. 요청 파라미터 취득 방법
   1. @RequestParam  
      해당 어노테이션을 이용해 query string, form 파라미터를 하나씩 취득.  
      view 입력값의 name 속성과 동일한 이름으로 변수명 사용.  
      GET/POST 요청 모두에서 사용 가능.
      ~~~
      // @DateTimeFormat(iso=DataeTimeFormat.ISO.DATE)
      // : html <input type=date /> 이면 value는 항상 yyyy-MM-dd이므로 해당 형식으로 지정해 날짜 받음.
      @PostMapping("confirm")
      public String confirmView(Model model,
                                @RequestParam String name,
                                @DateTimeFormat(iso=DataeTimeFormat.ISO.DATE) @RequestParam LocalDate birth) {
          model.attribute("name", name);
          model.attribute("birth", birth);
          reuturn "comfirm";
      }   
      ~~~
   2. Form 클래스 생성해 사용  
      요청 파라미터(query string, form 파라미터)를 모아 하나의 객체로 묶어 취득하는 방법.  
      스프링 MVC가 Form 클래스 내의 필드에 값을 저장.  
      데이터를 받을 때 형변환, 포맷지정 가능.  
      ~~~
      // Model을 제거하고 From을 요청 메서드 인수로 설정 
      @PostMapping("confirm")
      public String confirmView(UserForm UserForm) {
          return "confirm";
      } 
      ~~~
   3. @PathVariable  
      url의 일부로 포함된 값 취득을 위해 사용.  
      요청 핸들러 메서드에 @PathVariable의 자리표시자와 동일한 변수명으로 지정 시, 자리표시자에 저장된 값이 해당 변수에 저장됨.  
      REST API 설계에 필수로, query string과 명확히 분리되므로, 자원의 식별자 전달에 적합.  
      ~~~
      // /{no}  = 자리표시자(placeholder) : URL에 포함된 값 저장.
      @GetMapping("/users/{no}")
      public String selectUser(@PathVariable Long no) {
          // ...
      }
      ~~~
   4. @RequestMapping params 속성으로 요청 식별  
      하나의 뷰에 여러 버튼 존재 시, html에서 버튼의 name 속성 설정 시 어떤 버튼이 클릭되어 보내진 것인 요청 식별 시 사용.  
      주로 form 버튼 구분, 여러 submit 버튼 처리에 사용.
      ~~~
      @PostMapping(value="send", params="buttonA")
      public String showView() {
          //...
      }
      ~~~ 

3. 서버 -> view로 데이터 전달   
   데이터를 view에 표시하고 싶은 경우, 데이터를 넘겨주는 역할을 가진 Model을 인수로 설정 필요.   
   하지만 요청 파라미터를 받은 후 요청 핸들러 메서드의 인수에 Form 클래스가 있는 경우
   자동으로 Model에 저장되므로, 직접 addAttribute() 메서드로 저장하지 않아도 됨.   
<br>


### 8. 유효성 검사
1. 입력체크 어노테이션 생성방식  
   1. Bean Validation  
      Java EE 제공 어노테이션.   
      표준 스펙(규칙이자 인터페이스)으로 구현체 필요.   
      ConstraintValidator 인터페이스 구현체를 생성하고 
      ConstraintViolation 객체에 에러 저장.     
      개발자 입장에서 ***Bean Validation 어노테이션 사용 시, 
      스프링 내부에서는 Hibernate Validator 실행 엔진이 돌면서 검증 수행.***     
      - Hibernate Validator   
        Hibernate 프레임워크 제공 어노테이션으로 ConstraintValidator 인터페이스 구현.
        1. Bean Validation 스펙을 실제로 동작시키는 엔진으로 실제 검증 수행.
        2. Bean Validation 공식 기본 구현체로, Spring Boot가 디폴트로 포함.
        3. @Valid, @Validated를 적용 시 스프링이 자동 발견해 적용하는 어노테이션 기반 검증 수행.
        4. 검증 조건이 정적인 경우 사용.
   
   2. Spring Validator   
      스프링 프레임워크 고유의 별도 검증 기능(검증 추상화)으로 Bean Validation 표준과 관계없음.     
      스프링 내부에서 실행 엔진이 돌면서 검증 수행.  
      Validator 인터페이스 구현체를 생성하고 Errors 객체에 에러 저장.  
      1. @Valid, @Validated 어노테이션 적용하지 않고 
         Controller나 WebDataBinder에 수동 등록을 필요로 하는 명령형 방식의 검증.
      2. 검증 조건이 동적인 경우, 의존성 주입이 필요한 검증인 경우 사용.  
   <br>      

2. 사용자정의 Validator 생성 및 적용   
   Bean Validation을 Hibernate Validator 구현.   
   클래스 단위 검증을 수행.   
   1. 커스텀 검증 어노테이션 생성
      ~~~
      @Target({ElementType.TYPE})
      @Retention(RetentionPolicy.RUNTIME)
      @Constraint(validatedBy=PasswordMatchesValidator.class)
      public @interface PasswordMatches {
          String message() default "비밀번호가 일치하지 않습니다.";
          Class<?>[] groups() default {};
          Class<? extends Payload>[] payload() default {};
      }
      ~~~
   2. 유효성 검사기(Validator) 구현
      ~~~
      public class PasswordMatchesValidator
    			implements ConstraintValidator<PasswordMatches, SignupRquest> {
      
          @Override
          public boolean isValid(SignupRequest value, ConstraintValidator() {
              return value.getPassword().equals(value.getConfirmPassword());
          }
      }
      ~~~
   3. DTO에서 사용하기
      ~~~
      @PasswordMatches
      public class SignupRequest {
          private String password;
          private String confirmPassword;
      }    
      ~~~
   4. Controller에서 적용하기  
      @Valid, @Validated 사용 시, 스프링이 자동으로 Validator 적용.  
   <br>

3. 단일 항목 검사  
   단일 필드에 대해 검증.
   - Bean Validation 주요 어노테이션   
     Bean Validation 주요 어노테이션들은 단순히 어노테이션만 부여해도 검증이 가능.  
     이는 Spring Boot가 기본적으로 Hibernate Validator가 제공하는 구현체를 자동 등록해놓기 떄문.  
     - @NotNull : null값 검증, Integer 타입에 적용 가능.
     - @NotEmpty : null/공백 검증, 문자열/배열/컬렉션에 적용 가능.
     - @NotBlank : null/공백/space/tab 검증, 문자열/배열/컬렉션에 적용 가능.   
     - @Size : 문자열의 길이 or 컬렉션 사이즈가 지정한 범위 내 크기인지 검증.
     - @length : 문자열이 지정된 범위 내 길이 검증
     ...   
   <br>

4. 상관 항목 검사   
   여러 필드에 대해 혼합해 검증.   
   아래의 코드는 From 클래스의 유효성 검증 시, 예외 발생 여부에 따라 조건 분기처리.
   ~~~
  	@Controller
  	public class QuizController {
        //...
        @PostMapping("/insert")
        public String insert(@Validated QuizForm quizForm,
                             BindingResult bindingResult,
                             Model model,
                             RedirectAttributes redirectAttributes) {
            //...
            if(!bindingResult.hasError()) {
                service.insertQuiz(quiz);
                redirectAttributes.addFlashAttribute("complete", "등록이 완료되었습니다.");
                return "redirect:/quiz";
            } else {
                return showList(quizForm, model);
            }
        }
   }
   ~~~
   1. BindingResult 인터페이스   
      유효성 검사 에러 정보가 저장되는 인터페이스.   
      - Controller단에서 @Valid, @Validated를 적용한 검증 대상 파라미터 바로 뒤에 BindingResult를 선언하는 경우   
        -> 검증 실패시 예외가 발생하지 않고, 실행결과(검증에러정보)는 BindingResult 인터페이스에 보관.
      - hasErrors()   
        반환값으로 에러 여부 확인 가능.
        에러가 발생한 경우, 목록 표시.
        ex) bindingResult.hasErrors();   // true/false 반환
   2. RedirectAttributes
      - addFlashAttribute(key, value)   
        리다이렉트 할 화면에 전달할 값 설정.   
        Flash Scope 범위로 한 번의 리다이렉트에서만 유효.   
     <br>

5. 유효성 검증 실행 어노테이션
   - @Valid   
     단순 검증 실행을 위해 사용 권장.
   - @Validated  
     등록/수정 등 상황별 검증 조건이 다를 때 사용.     
     Service 계층 메서드 파라미터 검증 필요 시 사용.     
   <br>

6. 유효성 검증 실행 순서    
   하나의 필드에 유효성 검사 어노테이션이 여러 개인 경우, 
   유효성 검증 순서는 어노테이션을 설정한 순서가 아닌 무작위로 체크됨.  
   따라서 필드에 대해 모든 유효성 검사가 실행되어 여러 에러 메시지가 표시되는 경우, 메시지 표시 순서도 무작위.  
   - 유효성 검사 실행순서 지정   
     인터페이스에 @GroupSequence 어노테이션을 설정해 유효성 검사를 그룹화하고 실행순서 지정 가능.   
     이로 인해 에러 메시지가 순차적으로 출력 가능.   
<br>


### 9. 메시지 관리
일반적으로 애플리케이션에서 표시하는 메시지는 프로그램과 별도로 관리.   
메시지만 properties 파일로 관리 시 유지 및 관리 용이.

1. 스프링 부트에서 메시지 관리
   - src/main/resources 폴더에 properties 파일 생성해 메시지 관리 가능.
   - classpath 루트 바로 아래 ValidationMessages.properties 파일이 여러 개 있는 경우, 그 중 하나만 읽어 들이고 나머지는 무시된다.
     반면, 스프링은 여러 메시지 파일을 의도적으로 지원하므로, messages.properties 파일이 여러 개 있어도 무시되지 않는다.
   - Validation, View, MessageSource에서도 사용 가능한 ***messages.properties만 사용하는 것 권장.***
     ValidationMessages와 messages를 혼용해서 사용하는 것은 관리 난이도가 높고 메시지 추적이 어렵기 때문.
   1. ValidationMessages.properties
      Bean Validation(Jakarta Validation) 전용.
      검증 어노테이션의 message 속성에서 참조되는 기본 메시지 소스.
      검증 실패 시에만 내부적으로 참조되어 사용.
   2. messages.properties
      Spring이 제공하는 MessageSource 구현체가 읽어들이는 메시지 파일.
      MVC(View), Java 코드 모두에서 사용가능.
      유효성 검증 메시지뿐만 아니라 일반 안내 메시지, 오류 메시지 등 애플리케이션 전반의 메시지를 관리하는 데 사용.   
   <br>

2. messages.properties에서 프로퍼티 정의
   1. 일반적 프로퍼티 정의
      - ’key=value’ 형태로 프로퍼티 정의.
        ex) title.entry=입력화면
      - Form 클래스에서는 ‘필드명’ or ‘객체.필드명’으로 정의가능.
        ex) calcForm.leftNum=왼쪽

   2. 어노테이션 메시지 프로퍼티 정의   
      어노테이션과 메시지에 대응하기 위해서는 어노테이션의 FQCN.message가 메시지 취득을 위한 ‘키’가 된다.   
      메시지 프로퍼티 파일의 key-value 설정이 아닌, Bean Validation이 기본으로 사용하는 제약 조건의 메시지 키를 재정의(override)하는 것.   
       ~~~
         # 단일 항목 검사용 메시지
         # - 어노테이션의 'message' 속성 대체
         # @NotNull
         javax.validation.contrains.NotNull.message={0}: 숫자를 입력하세요.
         # @Range(min=1, max=10)
         org.hibernate.validator.constraints.Range.message={0}: {min} ~ {max} 범위의 숫자를 입력해주세요.
       ~~~
       - {숫자} : 자리표시자 / 0부터 시작 / 화면상의 항목 이름이 설정됨.
       - {min} 등의 영어 : 어노테이션 속성에 지정된 값 설정

   3. 형변환 검사 메시지 프로퍼티 정의    
      typeMismatch.클래스의 FQCN를 키로 작성하는 것은 Spring MVC의 데이터 바인딩(형변환) 오류 메시지 규칙이다.   
   <br>

3. messages.properties에서 값 가져오기
   1. view에서 값 가져오기. 
      view에서 ‘#(key}’ 형태로 접근.
      ~~~
        <title th:text=”#{title.entry}”>제목</title>
      ~~~
   
   2. java코드에서 값 가져오기
      java코드에서는 MessageSource 객체의 getMessage() 메서드 호출을 통해 값 가져오기.
      ~~~
        String message = messageSource.getMessage(
           "typeMismatch.java.lang.Integer",
           new Object[]{"age"},
           locale
        );
        // age은 정수를 입력해주세요.
      ~~~
      - 첫번째 전달 인자
        ValidationMessages.properties 또는 messages.properties 에 정의한 key 문자열.
      - 두번째 전달 인자
        {0}, {1} 같은 치환 파라미터.
        파라미터가 없는 경우 null 전달.
      - 세번째 전달 인자
        언어 설정(Locale.KOREA, Locale.getDafault() 등)

   3. 검증 어노테이션 message 속성으로 값 가져오기
      검증 어노테이션 message 속성 value 값으로 '{key}' 형태로 작성해 값 가져오기.
      ~~~
        // message 속성 생략해도 재정의한 메시지로 출력됨.
        @NotNull(message = "{javax.validation.contrains.NotNull}")
        private String name;

        @NotNull(message = "{required.value}")
        private Integer value;
      ~~~
<br>   


### 10. 애플리케이션 설계 방식
1. 계층형 아키텍처(Layered Architecture)   
   기능을 역할별 레이어로 나눈 구조.   
   스프링에서는 Controller, Service, Repository 구조로 나눔.   
   스프링 기본 패턴으로, 현업에서 압도적으로 많이 쓰는 패턴.   
   도메인 규칙이 간단하고 단순한 경우 적합해 단순 CRUD 위주 시스템에서 유용.   
   단, 규모가 커지면 Service 비대화, 도메인 로직이 분산되기 쉬운 구조적 한계 지님.   
   <br>

2. MVC 모델   
   사용자 인터페이스와 비즈니스 로직을 분리하는 목적의 구조.    
   (화면에 보여지는 부분과 실제 일을 처리하는 부분 분리)
   - 문제상황   
     기본 MVC 모델에서는 업무 기능과 데이터 처리 규칙이 복잡해질수록 
     비즈니스 처리를 담당하는 모델의 비대화 문제 발생.
   - 모델 비대화 문제해결   
     MVC는 Model 내부 구조를 규정하지 않으므로, 
     Model 내부를 계층형 아키텍처 또는 DDD 개념을 적용해 
     Model을 Domain, Application, Infrastructure로 세분화해 해결.   
   <br>

3. 도메인 주도 설계(DDD, Domain-Driven Design)   
   복잡한 비즈니스 문제를 해결하기 위해, 
   소프트웨어 구조를 **비즈니스 도메인의 개념과 규칙에 맞춰 설계**하는 방법.   
   - 문제상황   
     비즈니스 로직이 복잡해질수록 MVC의 Model을 계층화한
     계층형 아키텍처의 대표적인 구현 방식인 Controller, Service, DAO 구조만으로는
     규칙의 응집도가 낮아지고 변경 관리가 어려움.   
   - 복잡한 비즈니스로 인한 관리 문제해결   
     애플리케이션 레이어, 도메인 레이어, 인프라스트럭처 레이어로 계층을 분리하는 DDD로 해결가능.
     (Controller, Application Layer, Domain Layer, Repository)   
   <br>
   
   1. DDD 핵심개념
      1. Ubiqutious Language (보편언어)   
         개발자, 기획자, 도메인 전문가 모두가 공유하는 공통 언어를 생성해 단어를 그대로 코드에 반영.   
         ex) 장바구니 담기 - Cart.addItem() / 주문 결제 - Order.pay()   
      2. 도메인 모델   
         도메인(비즈니스)의 상태, 규칙, 행동을 객체로 표현한 것.   
         비즈니스 로직을 Entity, vlaue 객체, Service 같은 형태로 모델링.   
         - Entity : 유일한 ID로 구분되는 객체 (시간에 따라 상태 변화)
         - value 객체 : ID가 없는 의미있는 개념의 캡슐화 (불변)
         - Service : Entity, value Object가 맡기 어려운 도메인 관련 연산
      3. 집합체 (Aggregates)   
         비즈니스 규칙을 지키기 위한 도메인 객체들의 묶음.   
         ex) 집합체 - 도메인들   
             햄버거 세트 - 햄버거, 사이드메뉴(감자튀김 등), 음료(콜라 등)   
   <br>
   
   2. DDD 설계 방식이 적합한 경우   
      도메인 규칙이 복잡한 경우.   
      도메인 모델 변화가 잦은 경우.   
      트랜잭션/유스케이스 중심 중심인 경우.   
      외부 시스템 연동이 많은 경우.   
   <br>
   
   3. DDD 애플리케이션 레이어 분리 필수 규칙   
      - 애플리케이션 레이어, 인프라스트럭처 레이어 모두 도메인 레이어에 존재해야 한다.
        반면, **도메인 레이어는 다른 레이어에 의존해서는 안됨**.   
      - 도메인 레이어의 변경에 의해 애플리케이션 레이어의 변경은 허용.   
        반대로, **애플리케이션 레이어의 변경에 의해 도메인 레이어의 변경이 발생해서는 안됨**.   
   <br>
   
   4. DDD 애플리케이션 레이어별 컴포넌트
      1. 애플리케이션 레이어   
         클라이언트에서 받은 요청 제어. (유스케이스 중심)   
         도메인 레이어를 사용해 애플리케이션 제어.   
         - Controller   
           요청을 처리에 매핑하고 결과를 뷰에 넘기는 제어 역할 담당.   
           주요 처리를 Controller에서 실행하지 않고 도메인 레이어의 Service 호출.   
         - Form   
           화면의 Form 표현.   
           화면에서 입력한 값을 Controller에 전달하거나 Controller에서 화면에 결과 출력 시 사용.   
           도메인 레이어가 애플리케이션 레이어에 의존하지 않도록 **Form ↔ 도메인 객체로 변환 작업은 애플리케이션 레이어에서 수행**.   
         - View   
           화면 표시 담당.   
      2. 도메인 레이어   
         Entity, value 객체, 도메인 서비스, 집합체로 구성됨.   
         도메인 객체에 대해 애플리케이션의 서비스 처리 진행.
         - Domain 객체
           Service 처리 실행 시 필요 자원. (비즈니스 로직을 처리하는 데 필요한 객체)
           ex) Entity (DB에서 테이블의 1행에 대응되는 클래스) …
         - Service
           애플리케이션 서비스 처리 담당.
         - Repository
           DB 데이터 조작 내용만 정의되어 있는 인터페이스. (구현내용작성X)
      3. 인프라스트럭처 레이어   
         O/R Mapper, RepositoryImpl   
         도메인 객체에 대해 CRUD 조작해 데이터의 영속화 담당.   
         도메인 로직 직접 구현 X.   
         도메인이 의존하는 기술적인 기반 요소 담당 계층.   
         ex) Repository 구현체, DB 연결, Redis 캐시, Kafka 메시징, 외부 API 호출 어댑터, 파일업로드, 이메일 전송…   
         - RepositoryImpl   
           도메인 레이어에서 정의한 Repository 구현 클래스.   
           Repository 인터페이스에 스프링 데이터에서 제공하는 CrudRepository를 상속해 RepositoryImpl 생성.   
           O/R Mapper가 Repository 구현 클래스를 생성하는 경우도 있음.   
         - O/R Mapper   
           Object(객체)와 Relational(관계형 DB) 간의 데이터 매핑.   
           스프링 데이터 JDBC 사용.   
<br>


### 11. 트랜잭션(Transaction)
1. 트랜잭션   
   복수 개의 처리를 하나의 그룹으로 모은 것.   
   처리 결과로 실패 시 Rollback, 성공 시 Commit.   
2. 트랜잭션 경계   
   트랜잭션이 시작되고 끝날 때 까지의 범위.   
3. 트랜잭션 관리 방법   
   1. @Transactional   
      클래스나 메서드에 @Transactional 어노테이션을 부여해 
      트랜잭션이 관리되어 트랜잭션의 시작, 커밋, 롤백 자동 실행.   
      - 스프링 프레임워크 제공 어노테이션.   
      - 실수로 인한 버그 등을 방지하는 목적으로 클래스에 @Transactional 어노테이션 부여 권장.   
      - Unchecked Exception인 RuntimeException 혹은 서브클래스가 발생하는 경우 Rollback 발생.   
   2. JDBC 자동 커밋 설정 무효화 후 commit(), rollback() 메서드 호출해 트랜잭션 관리   