package Farzan;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception {
        CustomArrList<Teacher> teacher_list = new CustomArrList<>();
        CustomArrList<Student> student_list = new CustomArrList<>();
        int white_flag = 0;
        int black_flag = 0;
        boolean quit = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n_________School Management System_________\n");
            System.out.println("""
                    1. Register Teacher to database
                    2. Register Student to database
                    3. Pay Salary to teacher
                    4. Login Student
                    5. Show Teachers Database
                    6. Show Students Database
                    7. Exit Application
                    """);
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the registration id of teacher: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name of teacher: ");
                    String name = sc.nextLine();
                    System.out.println("Enter the name of the subject: ");
                    String subject = sc.nextLine();
                    System.out.println("Enter the amount of salary fixed for " + name + ": ");
                    float salary = sc.nextFloat();
                    teacher_list.add(new Teacher(id, name, subject, salary));
                    ++white_flag;
                    System.out.println("Information has been Successfully Registered\n\n");
                    break;

                case 2:

                    System.out.println("""
                            Registration of Student in Process....
                            Note: Name will act as Username and Roll number will act as Password for Student Login!
                            Enter information below -->
                            
                            Enter Roll number of student:\s""");
                    int roll_no = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name of Student: ");
                    String Name = sc.nextLine();
                    System.out.println("Enter the grade/class of student: ");
                    int grade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter " + Name + "'s parent/guardian name: ");
                    String Guardian_name = sc.nextLine();
                    System.out.println("Enter " + Name + "'s contact number: ");
                    long contact = sc.nextLong();
                    student_list.add(new Student(roll_no, Name, grade, Guardian_name, contact));
                    ++black_flag;
                    System.out.println("Information has been Successfully Registered\n\n");
                    break;

                case 3:
                    System.out.println("Enter the registration id of the teacher: ");
                    int ID = sc.nextInt();
                    int i;
                    for (i = 0; i < teacher_list.Size(); i++) {
                        if (ID == teacher_list.get_num(i).getId()) {
                            System.out.println("Teacher found with registration ID: " + ID);
                            teacher_list.get_num(i).receive_salary(teacher_list.get_num(i).getSalary());
                        }
                        if (ID == 0) {
                            System.out.println("Teacher details not found! Enter a valid ID");
                        }
                    }
                    break;

                case 4:
                    Scanner scan = new Scanner(System.in);
                    boolean exit = false;
                    System.out.println("username: ");
                    String username = scan.nextLine();
                    System.out.println("password");
                    int password = scan.nextInt();
                    for (int j = 0; j < student_list.Size(); j++) {
                        if(username.equals(student_list.get_num(j).getName()) && password == (student_list
                                .get_num(j).getRoll_no()))
                        {
                            System.out.println("Access Granted!\n Welcome "+ student_list.get_num(j).getName()
                                    +" to Student Login Page");
                            do{
                                System.out.println("""
                                    1) Pay fees
                                    2) Edit Student Information
                                    3) Show Result
                                    4) Logout of this page
                                    """);
                                int ch = scan.nextInt();
                                switch (ch) {
                                    case 1 -> {
                                        System.out.println("Total fees to pay is $" + student_list.get_num(j).getTotal_fees());
                                        System.out.println("Amount you want to pay right now is $");
                                        float fees = scan.nextFloat();
                                        student_list.get_num(j).updateFees(fees);
                                        System.out.println("Fees paid successfully!");
                                        System.out.println("Fees paid in this session is $" + student_list.get_num(j).getFees_paid());
                                        System.out.println("Amount left to pay is $" + student_list.get_num(j).getRemainingFees());
                                    }
                                    case 2 -> {
                                        System.out.println("You are only allowed to modify Guardian name and Contact number.");
                                        System.out.println("Enter new Guardian name --> ");
                                        String new_guardian = scan.nextLine();
                                        System.out.println("Enter new contact number --> ");
                                        long new_contact_no = sc.nextLong();
                                        student_list.get_num(j).setPhone_no(new_contact_no);
                                        student_list.get_num(j).setGuardian_name(new_guardian);
                                        System.out.println("Information saved successfully!");
                                    }
                                    case 3 -> {
                                        System.out.println("Enter the marks from the score sheet:- ");
                                        StudentResult result = new StudentResult();
                                        System.out.println("Total marks out of 600 are: " + result.getSum());
                                        System.out.println("Student percentage: " + result.getPercent());
                                    }
                                    case 4 -> exit = true;
                                }
                            }while(!exit);
                        }
                    }
                    scan.close();
                    break;

                case 5:
                    for (int j = 0; j < white_flag; j++) {
                        System.out.println(teacher_list.get_num(j).toString());
                    }
                    break;

                case 6:
                    for(int j = 0; j< black_flag; j++)
                    {
                        System.out.println(student_list.get_num(j).toString());
                    }

                case 7:
                        quit = true;
                        System.out.println("Successfully exited the application!\nYour records have been saved.");
                        break;

                default:
                    break;
            }
        }while(!quit);
        sc.close();
    }


    public static void SaveToFile(String filename, String text, boolean append) throws IOException {
        File file = new File(filename);
        FileWriter fileWriter = new FileWriter(file, append);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(text);
        printWriter.close();
    }

}
