import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(binaryGapLength(scanner.nextInt()));
    }

    private static int binaryGapLength(int num) {
        String s = Integer.toBinaryString(num);
        System.out.println(s);
        int gapSize = 0, maxSize = 0;

        for (int i = 0, j; i < s.length()-1; gapSize= 0 ) {
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') {
                for (j = i + 1; j < s.length() && s.charAt(j) == '0'; j++) {
                    gapSize++;
                }

                if (gapSize > maxSize && j != s.length()) {
                    maxSize = gapSize;
                }
                i = j;
                continue;
            }
            i++;
        }
        return maxSize;
    }
}
