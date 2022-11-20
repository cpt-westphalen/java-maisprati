public class App {
    public static void main(String[] args) throws Exception {
        Student student = new Student("Nullo", 30, 48, 25);
        System.out.println(
                "Student is " + student.name() + "; The average is " + student.average() + "; Highest grade was "
                        + student.highestGrade() + "; and lowest grade was " + student.lowestGrade() + ".");
    }
}
