import java.util.UUID;

public class Student {
	private String name;
	private String register_number = UUID.randomUUID().toString();
	private int age;
	private String department;
	private String batch;
	private String email_id;
	private String mobile_number;
	private String city;
	private String state;
	private int pincode;
	public Student(String name, int age, String department, String batch, String email_id, String mobile_number,
			String city, String state, int pincode) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
		this.batch = batch;
		this.email_id = email_id;
		this.mobile_number = mobile_number;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public String getRegisterNumber() {
		return this.register_number;
	}
	
	public String toCSV() {
		return name + "," + register_number + "," + age + "," + department + "," + batch + "," + email_id + "," + 
		            mobile_number + "," + city + "," + state + "," + pincode;
	}
	
	public void setEmail(String email) {
		this.email_id = email;
	}
	
	public void setPhone(String phone) {
		this.mobile_number = phone;
	}
	
	public String toString() {
        return "Student Details:\n" +
                "Name: " + name + "\n" +
        		"Register Number: " + register_number + "\n" + 
                "Age: " + age + "\n" +
                "Department: " + department + "\n" +
                "Batch: " + batch + "\n" +
                "Email: " + email_id + "\n" +
                "Mobile: " + mobile_number + "\n" +
                "City: " + city + "\n" +
                "State: " + state + "\n" +
                "Pincode: " + pincode;
    }
	
}

