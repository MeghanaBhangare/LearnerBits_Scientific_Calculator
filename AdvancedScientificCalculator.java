import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class AdvancedScientificCalculator {
    private static final Map<String, Double> memory = new HashMap<>();
    private static final Stack<String> history = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Advanced Scientific Calculator");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Exponentiation");
            System.out.println("7. Sin");
            System.out.println("8. Cos");
            System.out.println("9. Tan");
            System.out.println("10. Logarithm (base 10)");
            System.out.println("11. Natural Logarithm (ln)");
            System.out.println("12. Factorial");
            System.out.println("13. Memory Store");
            System.out.println("14. Memory Recall");
            System.out.println("15. Show History");
            System.out.println("16. Clear Memory");
            System.out.println("17. Clear History");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            double result = 0.0;

            switch (choice) {
                case 1:
                    result = add();
                    break;
                case 2:
                    result = subtract();
                    break;
                case 3:
                    result = multiply();
                    break;
                case 4:
                    result = divide();
                    break;
                case 5:
                    result = squareRoot();
                    break;
                case 6:
                    result = exponentiation();
                    break;
                case 7:
                    result = sin();
                    break;
                case 8:
                    result = cos();
                    break;
                case 9:
                    result = tan();
                    break;
                case 10:
                    result = logarithm();
                    break;
                case 11:
                    result = naturalLogarithm();
                    break;
                case 12:
                    result = factorial();
                    break;
                case 13:
                    memoryStore(result);
                    continue;
                case 14:
                    result = memoryRecall();
                    break;
                case 15:
                    showHistory();
                    continue;
                case 16:
                    clearMemory();
                    continue;
                case 17:
                    clearHistory();
                    continue;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    continue;
            }

            history.push(result + "");
            System.out.println("Result: " + result);
        }

        scanner.close();
    }

    private static double add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        return num1 + num2;
    }

    private static double subtract() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        return num1 - num2;
    }

    private static double multiply() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        return num1 * num2;
    }

    private static double divide() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        double numerator = scanner.nextDouble();
        System.out.print("Enter denominator: ");
        double denominator = scanner.nextDouble();

        if (denominator == 0) {
            System.out.println("Cannot divide by zero. Please enter a non-zero denominator.");
            return 0;
        }

        return numerator / denominator;
    }

    private static double squareRoot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        return Math.sqrt(num);
    }

    private static double exponentiation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base: ");
        double base = scanner.nextDouble();
        System.out.print("Enter exponent: ");
        double exponent = scanner.nextDouble();
        return Math.pow(base, exponent);
    }

    private static double sin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();
        return Math.sin(Math.toRadians(angle));
    }

    private static double cos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();
        return Math.cos(Math.toRadians(angle));
    }

    private static double tan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();
        return Math.tan(Math.toRadians(angle));
    }

    private static double logarithm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();
        return Math.log10(num);
    }

    private static double naturalLogarithm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();
        return Math.log(num);
    }

    private static double factorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return 0;
        }

        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    private static void memoryStore(double value) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a variable name to store the result: ");
        String variableName = scanner.next();
        memory.put(variableName, value);
        System.out.println("Result stored in memory as " + variableName);
    }

    private static double memoryRecall() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter variable name to recall: ");
        String variableName = scanner.next();
        if (memory.containsKey(variableName)) {
            return memory.get(variableName);
        } else {
            System.out.println("Variable not found in memory.");
            return 0;
        }
    }

    private static void showHistory() {
        System.out.println("Recent calculations history:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }

    private static void clearMemory() {
        memory.clear();
        System.out.println("Memory cleared.");
    }

    private static void clearHistory() {
        history.clear();
        System.out.println("History cleared.");
    }
}
