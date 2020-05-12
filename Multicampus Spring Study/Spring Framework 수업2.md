1. Vendor에서 제공하는 Driver 클래스를 생성
   Class.forName("oracle.jdbc.OracleDriver");


   import oracle.jdbc.OracleDriver;

   Driver driver = new OracleDriver(); 하고 같은 의미

2. Connectio 생성

   : Connection은 DB와 연결을 담당하는 객체

   url:"jdbc:oracle:thin:@IP:port:SID"

   user="scott"

   pass="tiger"

   Connection con = DriverManager.getConnection(url.user,pass);

3. Statement 생성
   :statement는 SQL문을 DB에 전송하는 역할을 담당하는 객체
   Statement stmt = con.createStatement();

4. SQL 실행
   excuteQuery() : ResultSet
   :SELECT문
   extureUpdate(): int
   :INSERT, UPDATE, DELETE 문

   ResultSet  rs = stmt.excuteQuery("select * from users");

   while(rs.next()){
   	String userid = rs.getString("userid");

   ​	String addr = rs.getString(2);

   }

   