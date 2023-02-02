import java.util.Scanner;

public class SwitchYield {
    /// simple calculator using switch yield
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter fires number:" );
        int num1 = scanner.nextInt();
        System.out.println("Enter operation (- + / x) :" );
        char op = scanner.next().charAt(0);
        System.out.println("Enter second number:" );
        int num2 = scanner.nextInt();
        double ans = switch (op){
            case '+'-> {
                yield num1 + num2;
            }
            case '-' -> {
                yield num1 -num2;
            }
            case '/' -> {
                yield (double) num1 / num2;
            }
            case 'x' -> {
                yield (double) num1 * num2;
            }
            default -> {yield 0;}
        };
        System.out.println("result is : " + ans );
    }
}
