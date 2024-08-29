import java.util.Scanner;

class QuizApp {

    public static void main(String[] args) {
        // Array of questions
        String[] questions
                = {
                "1. What is the capital of France?\nA. Berlin\nB. Madrid\nC. Paris\nD. Rome",
                "2. What is the largest planet in our solar system?\nA. Earth\nB. Jupiter\nC. Mars\nD. Saturn",
                "3. Which language is used for Android development?\nA. Swift\nB. Kotlin\nC. Python\nD. JavaScript",
                "4. Who wrote 'To Kill a Mockingbird'?\nA. J.K. Rowling\nB. Harper Lee\nC. Mark Twain\nD. Ernest Hemingway",
                "5. What is the boiling point of water?\nA. 90°C\nB. 100°C\nC. 110°C\nD. 120°C"
        };
// Array of correct answers
        char[] answers = {'C', 'B', 'B', 'B', 'B'};

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Variable to keep track of correct answers
        int correctAnswers = 0;

        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Enter your answer (A, B, C, or D): ");
            char userAnswer = scanner.next().charAt(0);
            userAnswer = Character.toUpperCase(userAnswer); // Convert input to upper case to avoid case mismatch

            // Input validation
            while (userAnswer != 'A' && userAnswer != 'B' && userAnswer != 'C' && userAnswer != 'D') {
                System.out.print("Invalid input. Please enter A, B, C, or D: ");
                userAnswer = scanner.next().charAt(0);
                userAnswer = Character.toUpperCase(userAnswer);
            }

            // Compare user answer with correct answer
            if (userAnswer == answers[i]) {
                correctAnswers++;
            }
        }

        // Calculate and display the final score
        double scorePercentage = (correctAnswers / 5.0) * 100;
        System.out.printf("Your final score is: %.2f%%\n", scorePercentage);

        // Close the scanner
        scanner.close();
    }
}
