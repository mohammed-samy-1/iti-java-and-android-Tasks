import java.util.Scanner;

public class SwapWithoutTemp {
    public static void main(String[] args) {

        int i = 5,i2 = 9;
        System.out.println("i = " + i);
        System.out.println("i2 = " + i2);
        System.out.println("Swap without temp");
        swapNoTemp(i,i2);
        System.out.println("Swap with temp");
        swapWithTemp(i, i2);
        Scanner scanner = new Scanner(System.in);

        // including oop
        System.out.print("please enter 2 numbers to be swapped : ");
        Swap swap = new Swap(scanner.nextInt() , scanner.nextInt());
        System.out.println(swap);
        System.out.println();

        swap.swapNoTemp();
        System.out.println("after swap without temp");
        System.out.println(swap);
        System.out.println();

        swap.swapWithTemp();
        System.out.println("after swap again with temp");
        System.out.println(swap);
    }

    private static void swapNoTemp(int i, int i2) {
        i = i+ i2;
        i2 = i - i2;
        i = i - i2;
        System.out.println("i = " + i);
        System.out.println("i2 = " + i2);
    }
    private static void swapWithTemp(int i , int i2){
        int temp = i;
        i = i2;
        i2 = temp;
        System.out.println("i = " + i);
        System.out.println("i2 = " + i2);
    }

}
 class Swap{
    private int first;
    private int second;

     public Swap(int first, int second) {
         this.first = first;
         this.second = second;
     }

     public int getFirst() {
         return first;
     }

     public void setFirst(int first) {
         this.first = first;
     }
     public void swapNoTemp() {
         first = first+ second;
         second = first - second;
         first = first - second;
     }
     public void swapWithTemp() {
         int temp = first;
         first = second;
         second = temp;
     }

     @Override
     public String toString() {
         return "Swap{" +
                 "first=" + first +
                 ", second=" + second +
                 '}';
     }
 }
