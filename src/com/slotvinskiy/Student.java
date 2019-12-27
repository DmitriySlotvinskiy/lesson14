package com.slotvinskiy;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private int age;
    private List<Group> group = new ArrayList<>();

    public Student(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getStudentsCourses() {
        if (group.size() == 0) {
            return "no courses";
        }
        StringBuilder coursesList = new StringBuilder();
        for (Group group : group) {
            coursesList.append(group.getGroupName()).append("; ");
        }
        coursesList.delete(coursesList.length() - 2, coursesList.length());
        return coursesList.toString();
    }

    public String getName() {
        return firstName;
    }

    public void addCourse(Group group) {
        this.group.add(group);
    }

    public void deleteCourse(Group group) {
        this.group.remove(group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name: '" + firstName + '\'' +
                ", age: " + age +
                ", courses list: " + getStudentsCourses() +
                '}';
    }
}

