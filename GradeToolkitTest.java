/**
 * This class includes test cases for all the GradeToolKit methods to check correctness.
 * @author Daniah Abbas
 */

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeToolkitTest {
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	/**
	 * Tests calculateGPA() with normal grades input.
	 * Ensures that the GPA is calculated correctly.
	 */
	@Test
	void testCalculateGPA_basicInput() {
		// the user input: 90, 80, 70, and -1 to stop
		String userInput = "90\n80\n70\n-1\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		Scanner input = new Scanner(bais);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		double gpa = GradeToolkit.calculateGPA(input);
		
		input.close();
		
		assertEquals(80.0, gpa);
	}
	
	/**
	 * Tests calculateGPA() when no grades are entered. There shouldn't be "GPA = NaN" printed.
	 */
	@Test
	void testCalculateGPA_noGradesEntered() {
		String userInput = "-1\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		Scanner input = new Scanner(bais);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
				
		GradeToolkit.calculateGPA(input);
		
		input.close();
		
		assertFalse(baos.toString().contains("NaN"));
	}
	
	@Test
	void testCalculateGPA_outOfBounds() {
		String userInput = "90\n80\n70\n30\n40\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		Scanner input = new Scanner(bais);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    
	    assertDoesNotThrow(() -> GradeToolkit.calculateGPA(input));
	    
	    input.close();
	}

	/**
	 * Tests passOrFail() with the right number of inputs (5).
	 * ArrayIndexOutOfBoundsException would be triggered if it's too many inputs.
	 */
	@Test
	void testPassOrFail_arrayOutOfBounds() {
		// user input is 80, 70, 60, 50, 40
		String userInput = "80\n70\n60\n50\n40\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		Scanner input = new Scanner(bais);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
		
		assertDoesNotThrow(() -> GradeToolkit.PassOrFail(input));
		
		input.close();
	}
	
	/**
	 * Tests grade_To_Letter() to ensure "A" is the correct grade for a high score.
	 */
	@Test
	void testGradeToLetter_A() {
		String userInput = "95\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		Scanner input = new Scanner(bais);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		GradeToolkit.grade_To_letter(input);
		
		input.close();
		
		assertTrue(baos.toString().contains("A"));
	}
	
	/**
	 * Tests grade_To_Letter() to ensure "F" is the correct grade for a low score.
	 */
	@Test
	void testGradeToLetter_F() {
		String userInput = "50\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		Scanner input = new Scanner(bais);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		GradeToolkit.grade_To_letter(input);
		
		input.close();
		
		assertTrue(baos.toString().contains("F"));
	}
	
	/**
	 * tests calculate_weighted_grade the total grade is printed given an input.
	 */
	@Test
	void testCalculateWeightedGrade_missingCategory0 () {
		// user input: 0.5, 0.5, 80, 90
		String userInput = "0.5\n0.5\n80\n90\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		Scanner input = new Scanner(bais);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		GradeToolkit.calculate_weighted_grade(input);
		
		input.close();
		
		assertTrue(baos.toString().contains("Your total grade"));
	}
	
	/**
	 * Tests that in calculate_weighted_grade, the first weight (index 0) isn't being skipped.
	 */
	@Test
	void testCalculateWeightedGrade_indexingCorrectness() {
		String userInput = "0.25\n0.75\n100\n0\n";
	    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
	    Scanner input = new Scanner(bais);
	    
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    
	    GradeToolkit.calculate_weighted_grade(input);
	    
	    input.close();
	    
	    assertTrue(baos.toString().contains("25.0"));
	}
	
	/**
	 * tests calculate_qpa with valid input and checks that it prints QPA without exceptions.
	 */
	@Test
	void testCalculateQPA_invalidInput() {
		String userInput = "1\nA\n3\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		Scanner input = new Scanner(bais);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		assertDoesNotThrow(() -> GradeToolkit.calculate_qpa(input));
		
		input.close();
		
		assertFalse(baos.toString().contains("Grade entered is invalid"));
		assertTrue(baos.toString().contains("1.3333334"));
	}
	
	/**
	 * Tests calculate_finals_grade_needed to ensure final exam grade  is printed without exceptions.
	 * InputMismatchException shouldn't occur when calculating decimals.
	 */
	@Test
	void testCalculateFinalsGradeNeeded_correctness() {
		// user input: current grade, final weight %, desired grade
		String userInput = "87.5\n50\n90\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		Scanner input = new Scanner(bais);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		assertDoesNotThrow(() -> GradeToolkit.calculate_finals_grade_needed(input));
		
		input.close();
	}
	
}
