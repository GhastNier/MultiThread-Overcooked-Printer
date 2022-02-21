// You are free to add any attributes or methods you need.
public class FriesChef implements Runnable {
    private final String name = "FriesChef";
    private final int WAIT_TIME = 1000;
    private final int MAKE_TIME = 2000;

    @Override
    public void run() {
        while (true) {
            if (isNotFull()) {
                Main.wait(MAKE_TIME);
                KitchenTable.add();
                System.out.println("[Action] " + Thread.currentThread().getName() + " add some Fries on the kitchen table");
                System.out.println("[Status] Fries left: " + KitchenTable.fries);

            }
            if (KitchenTable.readyToCombine() && ReadyTable.isNotFull()) {
                KitchenTable.remove();
                ReadyTable.add();
            } else {
                Main.wait(WAIT_TIME);
            }
        }
    }

    public boolean isNotFull() {
        return KitchenTable.fries < KitchenTable.limit;
    }
}
