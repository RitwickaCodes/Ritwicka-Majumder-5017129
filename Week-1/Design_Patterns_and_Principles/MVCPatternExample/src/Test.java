
public class Test {
	public static void main(String[] args) {
        Student student = new Student("Ram Das", "12345", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();
        controller.setStudentName("Shyam Das");
        controller.setStudentId("54321");
        controller.setStudentGrade("B");
        controller.updateView();
    }
}
