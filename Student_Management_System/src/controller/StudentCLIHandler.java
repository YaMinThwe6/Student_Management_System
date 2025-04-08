package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.Student;
import service.StudentManager;

public class StudentCLIHandler {
	private StudentManager manager;
    private Scanner scanner;
    
    public StudentCLIHandler(StudentManager manager) {
    	this.manager = manager;
    	this.scanner = new Scanner(System.in);
    }
    
    public void run() throws IOException {
    	while (true) {
    		System.out.print("\n\nWhat action would you like to do? ");
    		
    		String action = scanner.nextLine();
    		
    		switch(action.toLowerCase()) {
	    		case "add":
	    			handleAdd();
	    			break;
	    		case "read":
	    			handleRead();
	    			break;
	    		case "update":
	    			handleUpdate();
	    			break;
	    		case "remove":
	    			handleRemove();
	    			break;
	    		default:
	    			System.out.print("Please check the menu entered! The menu available are 'add', 'remove', 'update' and 'read'!");
    		}
    	}
    }
    
    private void handleAdd() throws IOException {
    	System.out.print("Sure! We will arrange for adding a student! ");
    	System.out.print("Please provide student's details separated by commas! Here's the order name, age, department, batch, email_id, mobile_number, city, state, pincode! ");
    	String student_detail = scanner.nextLine();
    	String[] student_details_list = student_detail.split(",");
    	Student student = new Student(student_details_list[0].trim(), Integer.parseInt(student_details_list[1].trim()), student_details_list[2].trim(), student_details_list[3].trim(), student_details_list[4].trim(), student_details_list[5].trim(),
    			student_details_list[6].trim(), student_details_list[7].trim(), Integer.parseInt(student_details_list[8].trim()));
    	String result = manager.add_student(student);
    	System.out.println("Student added successfully! \n");
    	System.out.print(result);
    }
    
    private void handleRead() throws FileNotFoundException {
    	System.out.print("Sure! We will arrange for reading all students! \n\n");
    	String all_students = manager.read_students();
    	System.out.print(all_students);
    }
    
    private void handleUpdate() {
    	System.out.print("Sure! We will arrange for updating a student! Please provide student register number, email, phne number separated by commas! ");
    	String update_details = scanner.nextLine();
    	String[] update_details_list = update_details.split(",");
    	String updated_result = manager.update_student(update_details_list[0].trim(), update_details_list[1].trim(), update_details_list[2].trim());
    	System.out.println("Student updated successfully! \n");
    	System.out.print(updated_result);
    }
    
    private void handleRemove() {
    	System.out.print("Sure! We will arrange for removing a student! Please provide Student register number: ");
    	String reg_number = scanner.nextLine();
    	manager.remove_student(reg_number);
    }
}
