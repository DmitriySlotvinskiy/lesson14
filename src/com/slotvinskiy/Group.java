package com.slotvinskiy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Group {

    //Написать класс "Группа", для отображения учебной группы в Hillel, который содержит поля:
    //- название курса
    //- дата старта занятий
    //- суммарное количество занятий
    //- количество занятий в неделю
    //- список учащихся типа Person
    private Title course;
    private LocalDate startDate;
    private int lessonsTotal;
    private int lessonsPerWeek;
    private List<Student> studentList = new ArrayList<>();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Group(Title course, LocalDate startDate, int lessonsTotal, int lessonsPerWeek) {
        this.course = course;
        this.startDate = startDate;
        this.lessonsTotal = lessonsTotal;
        this.lessonsPerWeek = lessonsPerWeek;
    }

    public Title getCourse() {
        return course;
    }

    //Написать методы:
    //- метод который выдает название группы на основе даты старта и названия курса
    public String getGroupName() {
        return this.course + " " + startDate.format(FORMATTER);
    }

    //- метод который выдает дату старта последней недели курса
    public String getStartDateOfLastWeek() {
        TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        long daysToLastWeek = (this.lessonsTotal / this.lessonsPerWeek) * 7 - 7;
        LocalDate mondayOfLastWeek = this.startDate.plusDays(daysToLastWeek).with(fieldISO, 1);
        return mondayOfLastWeek.format(FORMATTER);
    }

    //- печатает список студентов с порядковыми номерами
    public void printStudents() {
        int id = 1;
        for (Student student : studentList) {
            System.out.println(id + " - " + student);
            id++;
        }
    }

    //- добавить студента
    public void addStudent(Student student) {
        studentList.add(studentList.size(), student);
        student.addCourse(this);
    }

    //- узнать если ли студент с такой фамилией в группе
    public boolean isStudentInGroup(String studentName) {

        for (Student student : studentList) {
            if (student.getName().equals(studentName)) {
                return true;
            }
        }
        return false;
    }

    //- удалить студента по фамилии или по номеру
    public void deleteStudent(String studentName) {
        for (Student student : studentList) {
            if (student.getName().equals(studentName)) {
                student.deleteCourse(this);
                studentList.remove(student);
                break;
            }
        }
    }


    public void deleteStudent(int position) {
        this.studentList.get(position - 1).deleteCourse(this);
        studentList.remove(position - 1);
    }


    @Override
    public String toString() {
        return "Group{" +
                "course=" + course +
                ", startDate=" + startDate +
                ", lessonsTotal=" + lessonsTotal +
                ", lessonsPerWeek=" + lessonsPerWeek +
                ", studentList=" + studentList +
                '}';
    }
}
