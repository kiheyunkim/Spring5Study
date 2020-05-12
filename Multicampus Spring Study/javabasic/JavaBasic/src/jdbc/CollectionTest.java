package jdbc;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CollectionTest {
	/* @SuppressWarnings({ "rawtypes", "unchecked" }) */
	@Test
	public void TestFunc() {
		/* 1.4������ ���
		 * List list = new ArrayList();
		 * 
		 * list.add(new String("���� ���� ���ڿ�")); list.add(new Integer(10)); list.add(new
		 * Float(1000));
		 * 
		 * for(int i=0;i<list.size();++i) { System.out.println((String) list.get(i)); }
		 * Ÿ�Կ� ���� �˻簡 ���� ������ ��Ÿ�� ������ �߻��� ������ �ſ� ����.
		 */
		
		//1.4 �� ���ĺ����� ����.
		List<String> list = new ArrayList<String>();
		list.add("���ڿ�");
		list.add("�Դϴ�");
		/* list.add(123); */
		list.add("���ڴ�");
		list.add("�Ұ����մϴ�.");
		
		for(int i=0;i<list.size();++i) {
			System.out.println(list.get(i));
		}
		
		//Generic�� ����� �Ǿ��� ������ ������ ��ü�鸸 �޾Ƶ��� �� �ִ� ���°� �Ǿ���
		//Generic�� <E>�� �ش� collection�� ���� ��ü�� ���� ���¸� �����ϴ� ��.
		//���� E�� ���� ��� list(�Ǵ� �׿��� collection)������ �żҵ���� E�� Ÿ�Կ� �����ȴ�.
		
		//1.7 ���� �� ���ο� ����
		for (String string : list) {
			System.out.println(string);
		}
	}
}