// You are free to add any attributes or methods you need.
public class FriesChef implements Runnable {
    private String name = "FriesChef";
    private int WAIT_TIME = 1000;
    private int MAKE_TIME = 2000;

    @Override
    public void run() {
        while (true) {
            if (isNotFull()) {
                try {
                    Thread.sleep(MAKE_TIME);
                } catch (InterruptedException ignore) {
                }
                KitchenTable.add();
                System.out.println("[Action] " + Thread.currentThread().getName() + " add Fries on the kitchen table");
                System.out.println("[Status] Fries left: " + KitchenTable.fries);

            }if (KitchenTable.readyToCombine() && ReadyTable.isNotFull()) {
                KitchenTable.remove();
                ReadyTable.add();
            } else {
                try {
                    Thread.sleep(WAIT_TIME);
                } catch (InterruptedException ignore) {
                }
            }
        }
    }

    public boolean isNotFull() {
        return KitchenTable.fries < KitchenTable.limit;
    }
}
