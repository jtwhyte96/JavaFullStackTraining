
package com.training.student;

public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        // Add students
        System.out.println( "Added Ada: " + manager.addStudent(new Student(1, "Ada", 85.5))   );
            
     

        System.out.println("Added David: " + manager.addStudent(new Student(2, "David", 72.0)));

        System.out.println("Added Mary: " + manager.addStudent(new Student(3, "Mary", 91.0)));

        // Display all students
        System.out.println("\nAll students:"); manager.displayStudents();

        // Search
        System.out.println("\nSearching for ID 2:");
        Student found = manager.findStudentById(2);

        if (found != null) {
            System.out.println(found.getDetails());
        } else {
            System.out.println("Student not found.");
        }

        // Update
        System.out.println("\nUpdating David's grade:");
        System.out.println(manager.updateGrade(2, 88.5));

        // Display updated list
        manager.displayStudents();

        // Average
        System.out.println("\nClass average: " + manager.calculateAverageGrade() );


        // Delete
        System.out.println("\nDeleting student ID 1:");
        System.out.println(manager.deleteStudent(1));

        // Final list
        System.out.println("\nStudents after deletion:");
        manager.displayStudents();
    }
}
