
public class TranscriptsTester {
	 public static void main(String[] args) {
			// A transcript with 2 CSE grades and a MTH grade
			Transcript tr1 = new Transcript("Maria");
			tr1.addGrade("CSE 174", 3, "A");
			tr1.addGrade("CSE 271", 3, "B");
			tr1.addGrade("MTH 151", 5, "C");
			tr1.addGrade("ENG 313", 3, "F");

			testTranscript(tr1);

			// A transcript with no grades in it:
			Transcript tr2 = new Transcript("Danielle");
			
			testTranscript(tr2);
		}

		// This will take a Transcript object and run a variety of tests on it.
		public static void testTranscript(Transcript t) {
			System.out.println("------------------------------------");
			System.out.println("name: " + t.getName());
			
			System.out.println("---hour calculations");
			System.out.println("attempted hours: " + t.getAttemptedHours());
			System.out.println("earned hours: " + t.getEarnedHours());
			
			System.out.println("---gpa calculations");
			System.out.println("Overall gpa: " + t.getGpa());
			System.out.println("CSE gpa: " + t.getGpa("CSE"));
			System.out.println("MTH gpa: " + t.getGpa("MTH"));
			System.out.println("ENG gpa: " + t.getGpa("ENG"));
			System.out.println("BIO gpa: " + t.getGpa("BIO"));

			System.out.println("---toString()");
			System.out.println(t);
			System.out.println("------------------------------------");
		}

}
