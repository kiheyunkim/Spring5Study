package workshop.person.entity;

public class PersonManager {
	public PersonManager() {
		// TODO Auto-generated constructor stub
	}
	
	static public void main(String[] args) {
		PersonManager personManager = new PersonManager();
		personManager.printTitle("@@@ 인물 정보 조회 시스템 @@@");
		personManager.printTitleLine();
		
		PersonEntity[] personEntities = new PersonEntity[10];
		personManager.fillPersons(personEntities);
		personManager.showPerson(personEntities);
		System.out.println("성별 : \'여\'(은)는 "+personManager.findbyGender(personEntities, '여') +"명 입니다.");
		
		personManager.showPerson(personEntities, "김하늘");
	}
	
	public void fillPersons(PersonEntity[] persons) {
		persons[0] = new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932");
		persons[1] = new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932");
		persons[2] = new PersonEntity("박영수","7503111233201", "서울 성북구", "02-887-1542");
		persons[3] = new PersonEntity("나인수","7312041038988", "대전 유성구", "032-384-2223");
		persons[4] = new PersonEntity("홍정수","7606221021341", "서울 양천구", "02-158-7333");
		persons[5] = new PersonEntity("이미숙","7502142021321", "서울 강서구", "02-323-1934");
		persons[6] = new PersonEntity("박성구","7402061023101", "서울 종로구", "02-308-0932");
		persons[7] = new PersonEntity("유성미","7103282025101", "서울 은평구", "02-452-0939");
		persons[8] = new PersonEntity("황재현","7806231031101", "인천 중구", "032-327-2202");
		persons[9] = new PersonEntity("최철수","7601211025101", "인천 계양구", "032-122-7832");
	}
	
	public void showPerson(PersonEntity[] persons) {
		int length = persons.length;
		for(int i=0;i<length;++i) {
			System.out.println("[이름] " + persons[i].getName() + "\t[성별] "+ persons[i].getGender() +"\t\t[전화번호] "+ persons[i].getPhone());
			printItemLine();
		}
	}
	
	public int findbyGender(PersonEntity[] persons, char gender) {
		int length = persons.length;
		int count = 0;
		for(int i=0;i<length;++i) {
			if(persons[i].getGender() == gender) {
				++count;
			}
		}
		
		return count;
	}
	
	public void showPerson(PersonEntity[] person, String name) {
		printTitleLine();
		printTitle("-- 이름 : \'"+ name+ "\'(으)로 찾기 결과입니다. --");
		printItemLine();
		
		int length = person.length;
		for(int i=0;i<length;++i) {
			if(person[i].getName().equals(name)) {
				System.out.println("[이름] " + person[i].getName());
				System.out.println("[성별] " + person[i].getGender());
				System.out.println("[전화번호] " + person[i].getPhone());
				System.out.println("[주소] " + person[i].getAddress());
				return;
			}
		}
	}
	
	public void printTitle(String title) {
		System.out.println("\n"+ title +"\n");
	}
	
	public void printTitleLine() {
		System.out.println("============================================================");
	}
	
	public void printItemLine() {
		System.out.println("------------------------------------------------------------");
	}
}
