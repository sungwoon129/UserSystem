package kr.co.otree.model;

public class Member {
	private int code;
	private String name;
	private int birth;
	private String email;
	private String address;
	private String gender;
	private String phone;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public static String getSearch(String search) {
		try {
			if(search.equals("1"))
				return "name";
			else if(search.equals("2"))
				return "birth";
			else if(search.equals("3"))
				return "email";
			else if(search.equals("4"))
				return "address";
			else if(search.equals("5"))
				return "gender";
			else if(search.equals("6"))
				return "phone";
			else
				return null;	
		}catch (NullPointerException e) {
				return null;
		}
	}
}
