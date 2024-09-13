import java.util.ArrayList;

/**
 * Implements a transcript that lets a student
 * keep track of their courses and grades, and
 * computes overall GPA as well as GPA and 
 * subject
 * @author Jack Dina
 * @version 1.2
 */



public class Transcript {
	
	public static void main(String[] args) {
		Grade g = new Grade("CSE 174", 3, "A");
		System.out.println(g.getCourse());
		System.out.println(g);
		
		Transcript test = new Transcript("Mark");
		System.out.println(test.getName());
		
		
	}
	//Instance Variables
	private String name;
	private ArrayList<Grade> grades;
	
	/**
	 * creates a transcript that includes the name
	 * and an empty list of grades that can be 
	 * added to.
	 * @param name name of the student
	 */
	public Transcript(String name) {
		this.name = name;
		grades = new ArrayList<Grade>();
	}
	
	/**
	 * returns the name on the transcript
	 * @return the name on the transcript
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * adds a specific grade to the transcript.
	 */
	public void addGrade(String course, int hours, String grade) {
		grades.add(new Grade(course, hours, grade));
	}
	
	/**
	 * Returns the total of all the credit hours 
	 * for all courses on the transcript.
	 * @return the total number of attempted hours
	 */
	public int getAttemptedHours() {
		int total = 0;
		for (Grade t: grades) {
			total += t.getHours();
		}
		return total;
	}
	
	/**
	 * Returns the total of all the credit
	 * hours for all the courses that the 
	 * student has passed (a grade of D or
	 * better). So, courses with a grade of
	 * F are not included in this total.
	 * @return the total number of earned hours
	 */
	public int getEarnedHours() {
		int total = 0;
		for (Grade t: grades) {
			if (!(t.getLetterGrade().equals("F"))) {
				total += t.getHours();
			}
		}
		return total;
	}
	
	/**
	 * Calculates the GPA by computing a weighted
	 * average based on the number of credit hours
	 * (A=4.0, B=3.0, and so on). If there are no
	 * grades on the transcript, returns -1.0.
	 * @return gives back the GPA on the transcript
	 */
	public double getGpa() {
		double gpa = -1.0;
		double temp = 1.0;
		double part = 0.0;
		if (grades.isEmpty()) {
			return gpa;
		} else {
			for (Grade t: grades) {
				temp = "FDCBA".indexOf(t.getLetterGrade());
				part += t.getHours() * temp;
			}
			gpa = part/getAttemptedHours();
			return gpa;
		}
	}
	
	/**
	 * same as getGpa(), but only counts grades that
	 * begin with the specified prefix (such as "CSE").
	 * If there are no grades with that prefix, returns
	 * -1.0.
	 * @return the gpa of a specific category.
	 */
	public double getGpa(String prefix) {
		double gpa = -1.0;
		double temp = 1.0;
		double part = 0.0;
		int hours = 0;
		for (Grade t: grades) {
			String course = t.getCourse();
			String tested = course.substring(0,3);
			if(tested.equals(prefix)) {
				temp = "FDCBA".indexOf(t.getLetterGrade());
				part += t.getHours() * temp;
				hours += t.getHours();
				gpa = part/hours;
			}
		}
		
		return gpa;
	}
	
	/**
	 * Returns a string representation of the transcript,
	 * as shown in the samples below. Notice that this 
	 * toString() will include detailed information for
	 * each course. The toString() in the grade class 
	 * already does this part for you. So, your 
	 * Transcript toString() should actually call on your 
	 * Grade toString() method.
	 */
	
	public String toString() {
		String classes = "";
		for (Grade t: grades) {
			classes += t + "\n";
		}
		if (grades.isEmpty()) {
			return getName() +  ": no grades yet";
		} else {
			return getName() + ": gpa=" + getGpa() + "\n" + classes;
		}
	}
	
}
