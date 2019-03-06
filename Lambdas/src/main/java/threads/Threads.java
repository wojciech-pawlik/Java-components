package threads;

public class Threads {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Running...");
            System.out.println("Line 2");
        }).start();
    }
}
