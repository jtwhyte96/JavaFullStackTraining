
package com.training.student;

// Imports ArrayList, a Java collection that can store multiple objects
// and grow or shrink as items are added or removed.
import java.util.ArrayList;

// Declares a public class named StudentManager.
// This class manages a collection of Student objects.
public class StudentManager {

    // private: Only this class can directly access this field.
    // final: The students variable cannot be reassigned to another list.
    // ArrayList<Student>: This list is designed to store Student objects.
    // new ArrayList<>(): Creates an empty list. Java infers Student
    // from the type written on the left side.
    //
    // Important: final does not mean the list is unchangeable.
    // We can still add and remove students from it.
    private final ArrayList<Student> students = new ArrayList<>();


    // A public method that allows other classes to add a student.
    // boolean means the method returns either true or false.
    // The parameter Student student receives the Student object
    // that the caller wants to add.
    public boolean addStudent(Student student) {

        // Checks whether the caller passed null instead of a Student object.
        // null means that no object is being referenced.
        if (student == null) {

            // Rejects the operation and tells the caller it failed.
            return false;
        }

        // Calls findStudentById() to check whether a student
        // with this student's ID already exists.
        //
        // If the result is not null, a student with that ID was found.
        if (findStudentById(student.getId()) != null) {

            // Rejects the new student to prevent duplicate IDs.
            return false;
        }

        // Adds the Student object to the ArrayList.
        students.add(student);

        // Reports that the student was added successfully.
        return true;
    }


    // A public method that displays all students in the list.
    // void means this method does not return a value.
    public void displayStudents() {

        // Checks whether the list contains zero students.
        if (students.isEmpty()) {

            // Prints a message if there are no students to display.
            System.out.println("No students found");

            // Stops this method here so the loop below does not run.
            return;
        }

        // Enhanced for loop: visits each Student object in the list.
        // For each iteration, the variable student refers to the
        // current Student object.
        for (Student student : students) {

            // Calls getDetails() to get the student's information.
            // Calls getLetterGrade() to get the student's letter grade.
            // The + operator joins these pieces of text together.
            // println() prints the combined text and moves to a new line.
            System.out.println( student.getDetails() + ", Letter Grade: " + student.getLetterGrade());
            
        }
    }


    // Searches for a student using their ID.
    // int id is the ID supplied by the caller.
    // Student is the return type because the method returns a Student object.
    public Student findStudentById(int id) {

        // Loops through every Student object in the list.
        for (Student student : students) {

            // Calls getId() to retrieve this student's ID.
            // == compares the two integer values.
            if (student.getId() == id) {

                // Returns the matching Student object immediately.
                // The method stops searching after finding a match.
                return student;
            }
        }

        // If the loop finishes without finding a match,
        // return null to indicate that no student was found.
        return null;
    }


    // Updates the grade of an existing student.
    // int id identifies the student.
    // double newGrade is the new grade to assign.
    // boolean tells the caller whether the update succeeded.
    public boolean updateGrade(int id, double newGrade) {

        // Searches for the student using the supplied ID.
        // Stores the returned Student object in the student variable.
        Student student = findStudentById(id);

        // If no student was found, the variable contains null.
        if (student == null) {

            // Reports failure because there is no student to update.
            return false;
        }

        // Calls the Student object's setGrade() method.
        // If setGrade() validates the grade, invalid grades may be rejected.
        student.setGrade(newGrade);

        // Reports that the update completed.
        return true;
    }


    // Deletes a student using their ID.
    // Returns true if deletion succeeds, or false if the student is absent.
    public boolean deleteStudent(int id) {

        // Finds the Student object with the specified ID.
        Student student = findStudentById(id);

        // Checks whether the search failed.
        if (student == null) {

            // Nothing can be deleted, so report failure.
            return false;
        }

        // Removes that Student object from the list.
        // ArrayList.remove(Object) returns true if it was removed.
        return students.remove(student);
    }


    // Calculates and returns the average grade of all students.
    // double allows the result to include a decimal part.
    public double calculateAverageGrade() {

        // An empty list has no grades to average.
        if (students.isEmpty()) {

            // Returns 0.0 as this method's chosen result for an empty list.
            return 0.0;
        }

        // Creates a variable to accumulate the grades.
        // It starts at zero before any grades are added.
        double total = 0;

        // Visits every Student object in the list.
        for (Student student : students) {

            // Gets the student's grade and adds it to total.
            // The updated total is stored back in total.
            total += student.getGrade();
        }

        // Divides the sum of the grades by the number of students.
        // students.size() gives the number of items in the list.
        return total / students.size();
    }

    // The closing brace marks the end of the StudentManager class.
}
