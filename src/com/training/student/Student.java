package com.training.student;

public class Student {
	
	private final int id;
	private String name;
	private double grade;
	
	public Student(int id, String name, double grade) {
		this.id = id;
		setName(name);
		setGrade(grade);
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public void setName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		this.name = name;
	}
	
	public void setGrade(double grade) {
		if (!Double.isFinite(grade) || grade< 0 || grade > 100) {
			throw new IllegalArgumentException("Grade must be between 0 and 100");
		}
		this.grade = grade;
	}
	
	public String getDetails() {
		return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
	}
	
	public String getLetterGrade() {
		if (grade >= 90) {
	        return "A";
	    } else if (grade >= 80) {
	        return "B";
	    } else if (grade >= 70) {
	        return "C";
	    } else if (grade >= 60) {
	        return "D";
	    } else {
	        return "F";
	    }
	
	}
	
	
	

}
