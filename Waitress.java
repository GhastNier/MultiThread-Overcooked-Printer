// You are free to add any attributes or methods you need.
public class Waitress implements Runnable {
    static String name = "Waitress";
    private int WAIT_TIME = 1000;
    private int SERVE_TIME = 10000; // 10 second

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (ReadyTable.serveReady()) {
            try {
                Thread.sleep(SERVE_TIME);
            } catch (InterruptedException ignored) {
            }
            System.out.println("[Action] " + name + " serves a meal");
            ReadyTable.remove();
            System.out.println("[Status] Meals left: " + ReadyTable.mealsLeft);
            System.out.println("-----------------------------------------------------------------------------------");
        }
        while (!ReadyTable.serveReady()) {
            try {
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
