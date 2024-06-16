import java.util.Scanner;

/*
 * 
 * @author Ruvimbo Machekano 
 */


public class StudentGradeCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of subjects: ");
        int numOfSubjects = scanner.nextInt();

        // Marks for every subject
        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.printf("Enter marks for subject (out of 100): ", i + 1);
            marks[i] = scanner.nextInt();
        }

        // Calculating total marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        // Calculating average percentage with 2 decimals
        double averagePercentage = (double) totalMarks / numSubjects;
        char grade = calculateGrade(averagePercentage);

        // Calculating Grade
        char grade; 
        if (averagePercentage >= 90) {
          return  grade = 'A';
        } else if (averagePercentage >= 80) {
           return grade = 'B';
        } else if (averagePercentage >= 70) {
           return grade = 'C';
        } else if (averagePercentage >= 60) {
           return grade = 'D';
        } else {
           return grade = 'F';
        }

        // Display the results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}