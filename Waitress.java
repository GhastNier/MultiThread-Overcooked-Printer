// You are free to add any attributes or methods you need.
public class Waitress implements Runnable {
    private final String name = "Waitress";
    private final int WAIT_TIME = 1000;
    private final int SERVE_TIME = 10000; // 10 second

    @Override
    public void run() {
        while (true) {
            if (ReadyTable.serveReady()) {
                System.out.println("[Action] " + name + " serves a meal");
                ReadyTable.remove();
                System.out.println("[Status] Meals left: " + ReadyTable.mealsLeft);
                System.out.println("-----------------------------------------------------------------------------------");
                Main.wait(SERVE_TIME);
            } else {
                Main.wait(WAIT_TIME);
            }
        }
    }
}
