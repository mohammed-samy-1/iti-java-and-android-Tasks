public class AmbiguousErrorExample {


    public static void main(String[] args) {
        int i = 10;
        fun((Integer) i);
    }
    public static void fun(Object o) {
        System.out.println("Object: " + o);
    }
    public static void fun(Integer i) {
        System.out.println("Integer: " + i);
    }
}
