# Spring Framework 정리

1. ## framework란?

   : 비기능적인 요소(로깅, 인증, Tx처리, 성능......)등등을 구현해 놓은 라이브러리(구현체) - (Semi Completed)

   : 개발의 생산성을 높여보자.

2. ## Library와 Framework의 차이점

   : 제어 흐름의 주도권을 누가 가지고 있느냐?(IoC: Inversion of Control)

   Library: 개발자가 제어의 흐름의 주도권을 가지고 있다.

   Framework: 프레임워크(Container)가 제어 흐름의 주도권을 가진다 - IoC

3. ## 프레임 워크의 구성요소

   :Library + Design Pattern + Container

4. #### IoC(Inversion of Control)

   :제어의 역전

   * 기존에 개발자가 가지고 있던 주도권을 가져와서 개발자가 작성한 클래스의 객체를 생성하고, 매서드를 호출해 준다.
   * Spring Bean Container를 제공한다.
   * IoC를 구현하는 방법
     * DL(Dependency Lookup)  - 의존하는 객체를 Look up , JNDI(Java Naming Directory Interface) Library
     * DI(Dependency Injection) - 의존하는 객체를 주입(Injection)을 받겠다

5. DI

   * Setter Injection
     : setter Method의 아규먼트로 의존하는 객체의 레퍼런스를 한개씩 주입 받는 방식

   * Constructor Injection

     : 객체가 생성될 때 생성자의 아규먼트로 의존하는 객체의 레퍼런스 한꺼번에 여러개를 주입받는 방식

     * 빈 생성 전략

       1. Bean에 설정을 모두 XML에 하겠다

          ```xml
          <bean><!-- 빈 생성 -->    
          </bean>
          
          <property><!-- 전달 인수 -->
          </property>
          
          <constructor-arg><!-- 생성시 생성자에 전달할 인수 -->
          </constructor-arg>
          <!-- https://gmlwjd9405.github.io/2018/11/10/spring-beans.html-->
          ```

       2. Bean 설정을 어노테이션과 XML을 혼용하겠다.

          ```java
          //컴포넌트 Annotation
          @Component
          @Repository
          @Service
          @Controller
          
          //값전달 Annotation
          @utowired
          @Qualifier
          @Value
          ```

          +

          ```xml
          <context:component-scan base-packages="" />
          ```

       3. Bean설정을 어노테이션과 Java 설정 클래스를 사용하겠다 (No XML)

          ```java
          @Configuration
          @Bean
          @Component
          ```

   

   6. Spring MVC 관련 Annotation

      ```java
      @Controller
      @RestController = @Controller + @ResponseBody
      
      @RequestParam
      ?key=value
      @PathVariable
      users/gildong
      @ModelAttribute
          
      public String method(){
          return "userList"		-> suffix와 prefix가 설정되고 @controller가 붙어있으면 jsp 전송
      }
      ```

      

   