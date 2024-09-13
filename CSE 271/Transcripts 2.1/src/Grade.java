/**
 * Defines a grade in a course, including
 * the course, number of credit hours, and
 * letter grade (A, B, C, D, or F)
 * @author Jack Dina
 * @version 2.0
 */

public class Grade {
	
	private String course;
	private int hours;
	private String letterGrade;
	
	/**
	 * Constructs a new grade from a specified course,
	 * number of hours and letter grade.
	 * @param course the name of the course such as CSE 271
	 * @param hours the number of credit hours of the course
	 * @param letterGrade the letter grade of the course
	 */
	
	public Grade (String course, int hours, String letterGrade) {
		this.course = course;
		this.hours = hours;
		this.letterGrade = letterGrade;
	}

	/**
	 * Returns the name of this course
	 * @return the course name
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * Returns the number of credit hours
	 * @return the credit hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * Returns the letter grade
	 * @return the letter grade
	 */
	public String getLetterGrade() {
		return letterGrade;
	}
	
	/**
	 * Returns a string representation of 
	 * this grade in the form:
	 * CSE 174(3), grade = A
	 */
	public String toString() {
		
		return course + "(" + hours + "), grade=" + letterGrade;
	}
}