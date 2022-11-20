public class Student {
    private int[] grades = new int[3];
    private String name;

    public Student(String name, int grade_a, int grade_b, int grade_c) throws Exception {
        this.name = name;
        if (grade_a + grade_b + grade_c > 100) {
            throw new Exception("As notas somadas não podem passar de 100.");
        }
        this.grades[0] = grade_a;
        this.grades[1] = grade_b;
        this.grades[2] = grade_c;
    }

    public String name() {
        return this.name;
    }

    public double average() {
        double avg = 0;
        for (int grade : this.grades) {
            avg += grade;
        }
        avg /= this.grades.length;
        return avg;
    }

    public int highestGrade() {
        int res = this.grades[0];
        for (int i : this.grades) {
            if (i > res)
                res = i;
        }
        return res;
    }

    public int lowestGrade() {
        int res = this.grades[0];
        for (int i : this.grades) {
            if (i < res)
                res = i;
        }
        return res;
    }

}
