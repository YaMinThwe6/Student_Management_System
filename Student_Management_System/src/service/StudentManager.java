package service;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import model.Student;
public class StudentManager {
	// Ya Min, 27, ECE, J, premaymt@gmail.com, 7823970202, chennai, tamilnadu,600040
	private ArrayList<Student> students = new ArrayList<Student>();
	File file = new File("student_manager_db.csv");
	Scanner scan;
	
	public String add_student(Student student) throws IOException {
		// ArrayList - in memory management
		this.students.add(student);
		// File management
		if (!file.exists()) {
			FileWriter writer = new FileWriter(file);
			writer.write("Name,Register_Number,Age,Department,Batch,Email,Phone,City,State,Pincode\n");
            writer.close();
		}
		FileWriter writer = new FileWriter(file, true);
		writer.write(student.toCSV() + "\n");
		writer.close();
		return student.toString();
	}
	
	public void remove_student(String register_number) {
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getRegisterNumber().equals(register_number)) {
				students.remove(i);
				break;
			}
		}
	}
	
	public String update_student(String register_number, String email, String phone_number) {
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getRegisterNumber().equals(register_number)) {
				students.get(i).setEmail(email);
				students.get(i).setPhone(phone_number);
				return students.get(i).toString();
			}
		}
		
		return "Students with given register number not found";
	}
	
	public String read_students() throws FileNotFoundException {
		StringBuilder allStudents = new StringBuilder();
		// ArrayList - in memory management
		for (Student student: students) {
			allStudents.append(student.toString()).append("\n\n");
		}
		
		// File Management
		scan = new Scanner(file);
		while(scan.hasNextLine()) {
			allStudents.append(scan.nextLine().toString()).append("\n");
		}
		
		return allStudents.toString();
	}

}
