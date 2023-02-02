import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SwitchWithString {
    public static void main(String[] args) {
        int num = new Random().nextInt(7) + 1;

        String day = switch (num) {
            case 1 -> {
                yield "Saturday";
            }
            case 2 -> {
                yield "Sunday";
            }
            case 3 -> {
                yield "Monday";
            }
            case 4 -> {
                yield "Tuesday";
            }
            case 5 -> {
                yield "Wednesday";
            }
            case 6 -> {
                yield "Thursday";
            }
            case 7 -> {
                yield "Friday";
            }
            default -> {
                yield "ERROR";
            }
        };
        System.out.println("your random day is : " + day);
    }
}
