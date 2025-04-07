import java.io.IOException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		Student_Manager student_manager = new Student_Manager();

        while(true) {
        	System.out.print("\n\nWhat action would you like to do? ");

            String action = scanner.nextLine();
            
            switch(action.toLowerCase()) {
    	        case "add":
    	        	System.out.print("Sure! We will arrange for adding a student! ");
    	        	System.out.print("Please provide student's details separated by commas! Here's the order name, age, department, batch, email_id, mobile_number, city, state, pincode! ");
    	        	String student_detail = scanner.nextLine();
    	        	String[] student_details_list = student_detail.split(",");
    	        	Student student = new Student(student_details_list[0].trim(), Integer.parseInt(student_details_list[1].trim()), student_details_list[2].trim(), student_details_list[3].trim(), student_details_list[4].trim(), student_details_list[5].trim(),
    	        			student_details_list[6].trim(), student_details_list[7].trim(), Integer.parseInt(student_details_list[8].trim()));
    	        	String result = student_manager.add_student(student);
    	        	System.out.println("Student added successfully! \n");
    	        	System.out.print(result);
    	        	break;
    	        case "remove":
    	        	System.out.print("Sure! We will arrange for removing a student! Please provide Student register number: ");
    	        	String reg_number = scanner.nextLine();
    	        	student_manager.remove_student(reg_number);
    	        	break;
    	        case "update":
    	        	System.out.print("Sure! We will arrange for updating a student! Please provide student register number, email, phne number separated by commas! ");
    	        	String update_details = scanner.nextLine();
    	        	String[] update_details_list = update_details.split(",");
    	        	String updated_result = student_manager.update_student(update_details_list[0].trim(), update_details_list[1].trim(), update_details_list[2].trim());
    	        	System.out.println("Student updated successfully! \n");
    	        	System.out.print(updated_result);
    	        	break;
    	        case "read":
    	        	System.out.print("Sure! We will arrange for reading all students! \n\n");
    	        	String all_students = student_manager.read_students();
    	        	System.out.print(all_students);
    	        	break;
    	        default:
    	        	System.out.print("Please check the menu entered! The menu available are 'add', 'remove', 'delete' and 'read'!");
            }
        }

	}

}
