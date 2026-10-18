package com.training.student;

public class Main {
	
	public static void main(String[] args) {
		
		Student student1 = new Student(001, "Kunle", 80);
		student1.setGrade(70);
		System.out.println(student1.getDetails());
		
		
	}

}
