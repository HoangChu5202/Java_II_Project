package final_exam;

import java1refresher.Person;

import java.time.LocalDateTime;

public class Student extends Person implements Comparable<Student>{

    private String studentID;
    private double gpa;

    public Student() {
        super();
        this.studentID = "k0000000";
        this.gpa = 0;
    }

    public Student(String studentID, double gpa){
        super();
        setStudentID(studentID);
        setGpa(gpa);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        if(studentID.equals("") || studentID.length() < 8 || !studentID.startsWith("k")){
            throw new IllegalArgumentException("Invalid K ID please enter again");
        }
        else {
            this.studentID = studentID;
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if(gpa < 0 || gpa > 4){
            throw new IllegalArgumentException("Invalid GPA");
        }
        else {
            this.gpa = gpa;
        }
    }

    @Override
    public int compareTo(Student o) {
        if((this.gpa - o.gpa) * -1 < 0){
            return -1;
        } else if((this.gpa - o.gpa) * -1 > 0){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "StudentID = " + studentID +
                ", GPA = " + gpa;
    }
}
