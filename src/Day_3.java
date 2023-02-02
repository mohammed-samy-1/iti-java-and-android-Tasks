import java.util.Arrays;

public class Day_3 {
    public static void main(String[] args) {
        String name = " Mohammed samy ali Sharaf el-din ";
        byte age = 20;
        short height = 180;
        byte weight = 80;
        float salary = 8000.00f;
        System.out.println("name "+ name);
        System.out.println("age "+ height);
        System.out.println("height "+ weight);
        System.out.println("salary "+ salary);
        // 10 String methods
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());
        System.out.println("my name is ".concat(name.trim()));
        System.out.println(Arrays.toString(name.split(" ")));
        System.out.println(name.indexOf('a'));
        System.out.println(name.charAt(20));
        System.out.println(name.replace('y', 'i'));
        System.out.println(name.repeat(2));
        System.out.println(name.length());
        System.out.println(name.trim());// remove spaces

        // integer types ranges
        System.out.println("byte range is: "+ (byte) Math.pow(-2,8-1)+" to "+ (byte) (Math.pow(2, 8-1)-1));
        System.out.println("short range is: "+ (short) Math.pow(-2,16-1)+" to "+ (short) (Math.pow(2, 16-1)-1));
        System.out.println("int range is: "+ (int) Math.pow(-2,32-1)+" to "+ (int) (Math.pow(2, 32-1)-1));
        System.out.println("int range is: "+ (long) Math.pow(-2,64-1)+" to "+ (long) (Math.pow(2, 64-1)-1));

        // data types size in memory
        // boolean -> 1 bit
        // byte -> 1 byte
        // short -> 2 byte
        // int -> 4 byte
        // long -> 8 byte
        // float -> 4 byte
        // double -> 8 byte
        // char -> 2 byte
        // String -> referencer data type

        // did i finish the tasks ?
        System.out.println("yes i did");
    }
}