package jdbc;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CollectionTest {
	/* @SuppressWarnings({ "rawtypes", "unchecked" }) */
	@Test
	public void TestFunc() {
		/* 1.4버젼의 경우
		 * List list = new ArrayList();
		 * 
		 * list.add(new String("하이 나는 문자열")); list.add(new Integer(10)); list.add(new
		 * Float(1000));
		 * 
		 * for(int i=0;i<list.size();++i) { System.out.println((String) list.get(i)); }
		 * 타입에 대한 검사가 없기 떄문에 런타임 오류가 발생할 오류가 매우 있음.
		 */
		
		//1.4 그 이후부터의 상태.
		List<String> list = new ArrayList<String>();
		list.add("문자열");
		list.add("입니다");
		/* list.add(123); */
		list.add("숫자는");
		list.add("불가능합니다.");
		
		for(int i=0;i<list.size();++i) {
			System.out.println(list.get(i));
		}
		
		//Generic이 생기게 되었고 지정된 형태의 객체들만 받아들일 수 있는 형태가 되었음
		//Generic의 <E>는 해당 collection에 들어가는 객체에 대한 형태를 지정하는 것.
		//따라서 E에 따라서 모든 list(또는 그외의 collection)에서의 매소드들이 E의 타입에 대응된다.
		
		//1.7 이후 의 새로운 문법
		for (String string : list) {
			System.out.println(string);
		}
	}
}