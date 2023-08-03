public class Student {
    private String name;
    private int rollNumber;
    private String dept;

    public Student(String name, int rollNumber, String dept) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getDept() {
        return dept;
    }
}