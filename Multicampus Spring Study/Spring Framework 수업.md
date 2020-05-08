# Spring Framework 수업 1일차

* 공부할 것
  * Java 연습문제 2개
  * Spring DI(Dependency Injection) 이란?
  * JUnit 이란?

* 앞으로 배울 것
  * DI, Spring-Test, jdbc, MyBatis, AOP, Servlet/JSP Spring MVC (JSP, JSTL)
  * REST Service (JSON, XML)

### Spring Boot

* JPA, Spring MVC(Thymeleaf)

kbstart.cms.dao (Data access object, db 연결)
                  .service (biz logic)
	              .controller(front end,  back end를 연결)
                  .vo (Value Object) 값을 담아주는 것 / entity / dto(data transfer object)/ java beans
	              .exception
                  .mapper

등등 룰은 그 집단, 회사에 따라서 다르게 감

### Eclipse 단축기

* Ctrl + S  저장하기
* 



## Interface 클래스

##### 모든 클래스의 함수들은 앞에 public abstract 가 생략되어 있다고 생각한다.



## abstract 클래스

##### 추상 클래스는 추상 매서드를  반드시 하나 가져야 할까? (x) 아님  없을 수도 있다. 

Animal ani = new Animal(); (x) 불가능

Animal fish = new Fish(); (x) 가능

Multiple markers at this line

- the type Spider must implement the ingerited abstract method Animal.eat() -> abstract 클래스에서 받아온 abstract 매소드는 반드시 구현을 해야한다고 경고를 하는 것.
- implicit super constructor Animal() is undefined for default constructor
  Animal 에서 기본 생성될 수 있거나 기본 생성자가 없기 때문에 명시적으로 부모의 생성자를 호출하여야 한다고 함.



### Interface 를 사용하는 이유 : 예시 JDBC

답: JDBC는 인터페이스인데 인터페이스의 구현체는 DB Vendor들이 구현을 한다.

-> 특정 Vendor에 종속됨을 방지한다.

-> interface를 명세 해놓고 그것에 따라서 구현클래스를 DB Vendor들이  또는 다른 모듈 개발자들이 접근해서 만들게 함.



##### (Interface) Connection conn = OracleConnection.getConnection(); //이런방식으로 접근을 한다.

오른쪽에 있는 Oracle 객체는 외부에서 받은 Connection Interface의 구현체가 담겨있는 jar 파일을 가져와야 쓸 수 있다.

이런식으로 표현하였을 때 어떤 밴더가 만든 Connection 이더라도 옆에만 다르게 하면 되기 떄문에 다른 벤더에 종속 되지 않는다.



* CreateStatement() 같은 구현체 = Factory Method.

  private 아무도 접근 불가능함
  protected 같은 패키지와 상속 관계에서 접근 가능함.
  default 같은 패키지의 상속관계까지만 접근 가능함
  public 모두 접근 가능

Spring의 등장배경
: EJB를 사용하지 않고(WAS가 없이도) 자바 기반 엔터프라이즈 어플리케이션을 POJO(Plain Old Java Object)를 기반으로 작성할 수 있도록 해주겠다.

WSA(Web Application Server)
:Web Container + EJB Container
:J2EE API 구현체, 미들웨어

* Web Container + EJB Container

* Tomcat 은 Web Container / Web Server?
  * Web Container이 정답
* Apache, NginX에서 JSP 실행은 불가능 -> Web Server 이기 때문에 불가능하다.
* Spring framework는 EJB 없이 (WSA) 없어도 돌리기 위한 것.





