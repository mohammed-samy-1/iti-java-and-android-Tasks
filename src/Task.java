import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter day char");
        int dayOfWeek = scanner.nextInt();
        String x = switch (dayOfWeek) {
            case 1:
                yield "Sat";
            case 2:
                yield "sun";
            case 3:
                yield "mon";
            case 4:
                yield "thu";
            case 5:
                yield "wed";
            case 6:
                yield "thr";
            default:
                yield "fri";

        };
        System.out.println(x);
    }
}
