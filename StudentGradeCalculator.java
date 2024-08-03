import java.util.Scanner; // Correctly import the Scanner class

public class StudentGradeCalculator { // Start of class definition
    public static void main(String[] args) { // Start of main method
        Scanner scanner = new Scanner(System.in);
        int numberOfSubjects;
        
        System.out.print("Enter the number of subjects: ");
        numberOfSubjects = scanner.nextInt();

        double[] marks = new double[numberOfSubjects];
        double totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextDouble();
            
            // Validate input
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
                marks[i] = scanner.nextDouble();
            }
            totalMarks += marks[i];
        }

        // Calculate total marks, average percentage, and grade
        double averagePercentage = totalMarks / numberOfSubjects;
        char grade = calculateGrade(averagePercentage);

        // Display the results
        System.out.println("\nSTUDENT GRADE CALCULATOR RESULTS");
        System.out.println("---------------------------------");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numberOfSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Method to calculate grade based on average percentage
    private static char calculateGrade(double averagePercentage) {
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        return grade;
    }
}
