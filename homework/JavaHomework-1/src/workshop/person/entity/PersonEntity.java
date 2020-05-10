package workshop.person.entity;

public class PersonEntity {
	private String name;
	private char gender;
	private String ssn;
	private String address;
	private String phone;
	
	public PersonEntity() {
		
	}
	
	public PersonEntity(String name, String ssn, String address, String phone) {
		this.setName(name);
		this.setSsn(ssn);
		this.setAddress(address);
		this.setPhone(phone);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return this.gender;
	}
	
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
		
		char identifiedNum = ssn.charAt(6);
		if(identifiedNum == '1' ||identifiedNum == '3') {
			this.gender = '남';
		}else if(identifiedNum == '2' ||identifiedNum == '4') {
			this.gender = '여';
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
