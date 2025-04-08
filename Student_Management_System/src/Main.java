import java.io.IOException;

import controller.StudentCLIHandler;
import service.StudentManager;
public class Main {

	public static void main(String[] args) throws IOException {
		StudentManager studentManager = new StudentManager();
		StudentCLIHandler studentCliHandler = new StudentCLIHandler(studentManager);
		studentCliHandler.run();
	}

}
