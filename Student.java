package Farzan;

import java.io.IOException;
import java.util.Scanner;

import static Farzan.Main.SaveToFile;

public class Student
{
    private final int roll_no;
    private final String name;
    private int grade;
    private float fees_paid;
    final private float total_fees;
    public String guardian_name;
    public long phone_no;

    /**
     * roll_no id for the student
     * name of the student
     * grade of the student
     * guardian_name-Parent/guardian name
     *  hone_no-contact number
     *  total fees is set to be 100000$
     */


    public Student(int roll_no, String name, int grade, String guardian_name, long phone_no) throws IOException {
        this.roll_no = roll_no;
        this.name = name;
        this.grade = grade;
        this.guardian_name = guardian_name;
        this.phone_no = phone_no;
        this.total_fees = 100000;
        this.fees_paid = 0;

        String output = "Roll no = "+getRoll_no()+"\nStudent Name = "+
                getName()+"\nStudent Class = "+getGrade()+
                "th\nParent/Guardian Name = "+getGuardian_name()+"\nContact Number = "+
                getPhone_no()+"\n\n";
        SaveToFile("StudentDatabase.txt", output, true);
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }
    public void updateFees(float fees_paid) {
        this.fees_paid += fees_paid;
        School.UpdateTotal_funds_Earned((long) this.fees_paid);
    }
    public void setGuardian_name(String guardian_name) {
        this.guardian_name = guardian_name;
    }

    public int getRoll_no() {
        return roll_no;
    }
    public String getName() {
        return name;
    }
    public int getGrade() {
        return grade;
    }
    public float getFees_paid() {
        return fees_paid;
    }
    public float getTotal_fees() {
        return total_fees;
    }
    public String getGuardian_name() {
        return guardian_name;
    }
    public long getPhone_no() {
        return phone_no;
    }
    public float getRemainingFees() {
        return total_fees-fees_paid;
    }


    @Override
    public String toString() {
        System.out.println("Student's Database -->\n");
        return "Roll_no = "+roll_no+
                "\nName = "+name+
                "\nGrade = "+grade+
                "\nFees paid = " + fees_paid +
                "\nTotal fees = " + total_fees +
                "\nGuardian name = " + guardian_name+
                "\nPhone_no = " + phone_no;
    }

}
