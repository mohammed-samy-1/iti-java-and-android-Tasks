import java.lang.reflect.Array;
import java.util.Arrays;

public class FunctionParameters {

    public static void main(String[] args) {

        int[] arr = {3, 33, 5, 22, 6, 99, 87, 28, 26};
        System.out.println("before passing by reference : " + Arrays.toString(arr));
        bubbleSort(arr);// pass by reference
        System.out.println("after passing by reference : " + Arrays.toString(arr));

        int num = 10;
        System.out.println("before passing by value : " + num);
        increaseByOne(num);// passing by value
        System.out.println("after passing by value : " + num);
    }


    /***
     * @param arr is passed by reference
     *            so that it updates the actual value of the variable was passed to the function
     *            this works only with reference types like String Arrays and Objects
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // pass by value

    /**
     * @param num passed by value
     *            do that it doesn't affect on the actual value of the passed variable
     *            and any edit happens is only accessible in this function's scope
     */
    public static void increaseByOne(int num) {
        System.out.println("from the function :" + ++num);
    }
}
