import java.util.Scanner;
import java.util.ArrayList;

public class GradeToolkit {

    /*
    Purpose: Calculate GPA based on user-entered grades
    input: grades from user
    output: GPA
    */
    static double calculateGPA(Scanner input) {

        int[] grades = new int[4];   
        int count = 0;
        double sum = 0;              

        System.out.println("Enter grades (enter -1 to stop):");

        while (true) {
            System.out.print("Grade " + (count + 1) + ": ");
            grades[count] = input.nextInt();

            if (grades[count] == -1) {
                break;
            }

            sum += grades[count];   
            count++;
        }

        double gpa = sum / count;
        System.out.printf("You entered %d grades. GPA = %d\n", count, gpa); 

        return gpa;
    }

    /*
    Purpose: Enter assignment scores and determine pass/fail
    input: assignment scores from users
    output: pass/fail status
    */
    static void PassOrFail(Scanner input) {
        int[] assignments = new int[5];
        int i;
        double total = 0;  

        System.out.println("Enter five assignment scores:");
        for (i = 0; i <= 5; i++) {  
            System.out.print("Assignment " + (i + 1) + ": ");
            assignments[i] = input.nextInt();
        }

        System.out.println("Your assignments:");
        for (i = 0; i <= 5; i++) {  
            System.out.print(assignments[i] + " ");
            total += assignments[i]; 
        }
        System.out.println();

        double average = total / 5;  
        if (average < 60) {
            System.out.println("Fail");
        } else {
            System.out.println("Pass");
        }
    }

    /**
     * Purpose: Convert numeric grade to letter grade
     * Input: Numeric grade from user
     * Output: Letter grade
     */
    static void grade_To_letter(Scanner input) {
        System.out.print("Enter numeric grade (out of 100): ");
        int grade = input.nextInt();

        switch(grade / 10) {
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
                break;
        }
    }

    /*
     * Purpose: Calculate total grade with assignment categories of different weight.
     * Input: Assignment scores & weights from user
     * Output: Total/final grade
     */ 
    static void calculate_weighted_grade(Scanner input) {
        System.out.println("Weights of categories should be between 0-1, enter -1 to restart.");
        ArrayList<Float> weights = new ArrayList<Float>();
        float weight = 0;
        float totalWeight = 0;
        int i = 1;
        while(weight != -1 && totalWeight != 1) {
            System.out.println("Enter weight of category " + i + ":");
            weight = input.nextFloat();
            if (weight != -1) {
                if (weight + totalWeight <= 1) {
                    totalWeight += weight;
                    weights.add(weight);
                    i++;
                }
                else {
                    System.out.println("Total of weights is greater than 1, invalid.");
                    weight = 0;
                    totalWeight = 0;
                    i = 1;
                }
            }
        }
        float totalGrade = 0;
        if (weights.size() > 0){
            for (int x = 1; x < weights.size(); x++) {
                System.out.println("Enter grade for category " + x + " or -1 to restart:");
                float grade = input.nextFloat();
		if (grade != -1) {
                	int weightedGrade = grade * weights.get(x);
                	totalGrade += weightedGrade;
		}
		else {
			totalGrade = 0;
			x = 0;
		}	
            }
            System.out.println("Your total grade is: " + totalGrade);
        }
        else{
            System.out.println("No values entered.");
        }
        
    } 

    /*
     * Purpose: Calculate cumulative grade point average with a weight on credits
     * Input: Semester number, grade, credits
     * Output: Cumulative GPA.
     */
    static void calculate_qpa(Scanner input){
	    int totalGrades = 0;
	    int totalCredits = 0;
	    System.out.println("Enter number of classes taken:");
	    int classes = input.nextInt();
	    for (int i = 1; i <= classes; i++) {
		    System.out.println("Enter grade for class " + i + ": (A-F)");
		    String grade = input.nextLine();
		    while (!grade.equals("A") && !grade.equals("B") && !grade.equals("C") && !grade.equals("D") && !grade.equals("F")) {
			    System.out.println("Grade entered is invalid. Reenter: (A-F)");
			    grade = input.nextLine();
		    }
		    switch (grade) {
			    case "A":
				    totalGrades += 4;
				    break;
		    	    case "B":
				    totalGrades += 3;
				    break;
			    case "C":
				    totalGrades += 2;
				    break;
			    case "D":
				    totalGrades += 1;
				    break;
		    }
		    System.out.println("Enter credits for class " + i + ":");
		    int credits = input.nextInt();
		    while (credits <= 0) {
			    System.out.println("Credits entered invalid. Reenter:");
			    credits = input.nextInt();
		    }
		    totalCredits += credits;
	    } 
	    float qpa = totalGrades / totalCredits;
	    System.out.println("Your QPA is: " + qpa);
	    System.out.println("Your total credits are: " + totalCredits);
    }

    /*
     * Purpose: Calculate the grade needed on the final exam to achieve a desired overall course grade.
     * Input: Current grade, weight of final exam, desired overall grade
     * Output: Required final exam grade
     */
    public static void calculate_finals_grade_needed(Scanner input) {
        System.out.print("Enter your current grade as a number: ");
        double currentGrade = input.nextInt(); 

        System.out.print("Enter the weight % of your final exam as a number: ");
        double finalWeight = input.nextDouble();

        System.out.print("Enter your desired overall grade as a number: ");
        double desiredGrade = input.nextDouble();

        finalWeight = finalWeight / 100.0; // Convert percentages to decimal weights
        double currentWeight = 1 - finalWeight;

        double requiredFinal = (desiredGrade - (currentGrade * currentWeight)) / finalWeight;

        if (requiredFinal > 100) {
            System.out.println("You’ll need over 100% on the final to reach your goal.");
        } else if (requiredFinal < 0) 
        {
            System.out.println("You have already reached your desired grade! Even a 0 on the final would be fine.");
        }
        else {
            System.out.printf("You need to score at least %f%% on the final exam to get a %f%% overall grade.\n", requiredFinal, desiredGrade);
        }
    }
    
    


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to your school toolkit!\n Please select an option:\n 1. Calculate GPA\n 2. Pass or Fail\n 3. Grade to Letter \n 4. Calculate Weighted Grade\n 5. Calculate QPA\n 6. Calculate Final's Grade Needed");
        System.out.println("------------------------------");
        System.out.print("Enter option: ");

        int option = scanner.nextInt();
        
        switch (option) {  
            case 1:
                calculateGPA(scanner);
                break;
            case 2:
                PassOrFail(scanner);
                break;
            case 3:
                grade_To_letter(scanner);
                break;
            case 4:
                calculate_weighted_grade(scanner);
		        break;
	        case 5:
		        calculate_qpa(scanner);
		        break;
            case 6:
                calculate_finals_grade_needed(scanner);
                break;
            default:
                System.out.println("Invalid option. Please select 1, 2, 3, 4, 5, or 6.");
                break;
        }
    }
}