package com.niit;

import com.niit.config.MyBatisUtil;
import com.niit.mapper.StudentMapper;
import com.niit.model.Gender;
import com.niit.model.Student;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SqlSession session= MyBatisUtil.getSession().openSession(true);
        StudentMapper mapper=session.getMapper(StudentMapper.class);
        while(true)
        {
            System.out.println("====Student Management System====");
            System.out.println("1. Add new Student");
            System.out.println("2. View Student by Roll number");
            System.out.println("3. Exit");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice)
                {
                case 1:
                    Student s=new Student();
                    System.out.println("Enter Name: ");
                    s.setName(sc.nextLine());
                    System.out.println("Enter address: ");
                    s.setAddress(sc.nextLine());
                    System.out.println("Enter dob (yyyy-mm-dd): ");
                    s.setDob(LocalDate.parse(sc.nextLine()));
                    System.out.println("Enter grade: ");
                    s.setGrade(sc.nextLine());
                    System.out.println("Enter gender (Male/Female): ");
                    s.setGender(Gender.valueOf(sc.nextLine().toUpperCase()));
                    mapper.insertStudent(s);
                    waitForBack(sc);
                    break;
                    case 2:
                        System.out.println("Enter Roll number to view Student: ");
                        int roll=sc.nextInt();
                        sc.nextLine();
                        Student stu=mapper.getStudentByRollNumber(roll);
                        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n",
                                "Roll No.", "Name", "Address", "Dob", "Grade", "Gender");
                        System.out.println("---------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-15d %-15s %-15s %-15s %-15s %-15s%n",
                                stu.getRoll_no(),stu.getName(),stu.getAddress(),
                                stu.getDob(),stu.getGrade(), stu.getGender());
                        waitForBack(sc);
                        break;
                        case 3:
                            System.out.println("Existing now.......");
                            return;
                    default:
                        System.out.println("Invalid choice");
                }
        }
    }
    private static void waitForBack(Scanner sc)
    {
        System.out.println("Press any key to continue...");
        sc.nextLine();
    }
}