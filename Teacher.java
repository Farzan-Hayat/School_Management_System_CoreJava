package Farzan;

import java.io.IOException;

import static Farzan.Main.SaveToFile;

public class Teacher
{
    public int id;
    private String name, subject;
    private float salary;
    private float earned_salary;


    public Teacher(int id, String name, String subject, float salary) throws IOException {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.salary = salary;

        String teacher_data = "Teacher ID - "+getId() +
                "\nTeacher Name - "+getName()+"\nTeacher's Subject - "+
                getSubject()+"\nSalary of "+getName()+
                " is "+getSalary()+"\n\n";
        SaveToFile("TeacherDatabase.txt", teacher_data, true);
    }

    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public float getSalary() {
        return salary;
    }
    public String getSubject(){ return subject;}

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void receive_salary(float salary){
        earned_salary += salary;
        School.UpdateTotal_funds_Spent((long) salary);
        System.out.println("Salary has been to credited to "+this.name);
    }



    @Override
    public String toString() {
        System.out.println("Teacher database -->\n");
        return "ID = " + id +
                "\nName = " +name+
                "\nSubject = " +subject+
                "\nSalary = " +salary;
    }
}
