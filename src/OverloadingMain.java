public class OverloadingMain {
    public static void main(String[] args) {
        System.out.println("main 1");
        main();
        main(0);
    }

    public static void main() {
        System.out.println("main 2");
    }
    public static void main(int i) {
        System.out.println("main 3");
    }
}

