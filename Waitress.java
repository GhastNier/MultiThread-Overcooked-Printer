// You are free to add any attributes or methods you need.
public class Waitress implements Runnable {
    private String name = "Waitress";
    private int WAIT_TIME = 1000;
    private int SERVE_TIME = 10000; // 10 second

    @Override
    public void run() {
        while (true) {
            if (ReadyTable.serveReady()) {
                System.out.println("[Action] " + name + " serves a meal");
                ReadyTable.remove();
                System.out.println("[Status] Meals left: " + ReadyTable.mealsLeft);
                System.out.println("-----------------------------------------------------------------------------------");
                try {
                    Thread.sleep(SERVE_TIME);
                } catch (InterruptedException ignored) {
                }
            } else {
                try {
                    Thread.sleep(WAIT_TIME);
                } catch (InterruptedException ignored) {
                }
            }
        }

    }

}
