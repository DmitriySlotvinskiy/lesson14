package com.slotvinskiy;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Student st1 = new Student("TJ", 24);
        Student st2 = new Student("Billy", 35);
        Student st3 = new Student("Carl", 21);
        Student st4 = new Student("Helen", 19);
        Student st5 = new Student("Molly", 45);
        Student st6 = new Student("Sam", 23);
        Student st7 = new Student("Ivan", 15);
        Student st8 = new Student("Ray", 29);
        Student st9 = new Student("Nata", 31);
        Student st10 = new Student("Ben", 38);

        Group group1 = new Group(Title.JAVA, LocalDate.of(2019, 11, 6), 16, 2);
        Group group2 = new Group(Title.QA, LocalDate.of(2020, 2, 3), 32, 2);
        Group group3 = new Group(Title.JS, LocalDate.of(2020, 3, 15), 16, 2);

        group1.addStudent(st1);
        group1.addStudent(st2);
        group1.addStudent(st3);
        group1.addStudent(st7);
        group1.addStudent(st8);
        group2.addStudent(st2);
        group2.addStudent(st4);
        group2.addStudent(st5);
        group2.addStudent(st8);
        group2.addStudent(st10);
        group3.addStudent(st1);
        group3.addStudent(st3);
        group3.addStudent(st6);
        group3.addStudent(st9);
        printGroup(group1);
        printGroup(group2);
        printGroup(group3);
        group1.deleteStudent(2);
        group2.deleteStudent(st4.getName());
        group2.deleteStudent(st8.getName());
        printGroup(group1);
        printGroup(group2);
        printGroup(group3);
        System.out.println(st4);

        System.out.println("\nLast week of group " + group1.getGroupName() + " starts " + group1.getStartDateOfLastWeek());

        if (group1.isStudentInGroup(st1.getName())) {
            System.out.println("Student " + st1.getName() + " attends group " + group1.getGroupName());
        } else {
            System.out.println("Student " + st1.getName() + " doesn't attends group(s) " + st1.getStudentsCourses());
        }
    }

    private static void printGroup(Group group1) {
        System.out.println(group1.getGroupName());
        group1.printStudents();
        System.out.println();
    }
}
