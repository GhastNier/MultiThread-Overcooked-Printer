// You are free to add any attributes or methods you need.
public class BurgerChef implements Runnable {
    private final String name = "BurgerChef";
    private final int WAIT_TIME = 1000;
    private final int MAKE_TIME = 3000;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            if (isNotFull()) {
                try {
                    Thread.sleep(MAKE_TIME);
                } catch (InterruptedException ignore) {
                }
                KitchenTable.add();
                System.out.println("[Action] " + Thread.currentThread().getName() + " add a Burger on the kitchen table");
                System.out.println("[Status] Burgers left: " + KitchenTable.burgers);
            }
            if (KitchenTable.readyToCombine() && ReadyTable.isNotFull()) {
                KitchenTable.remove();
                ReadyTable.add();
            }else {
                try {
                    Thread.sleep(WAIT_TIME);
                } catch (InterruptedException ignore) {
                }
            }
        }
    }

    public boolean isNotFull() {
        return KitchenTable.burgers < KitchenTable.limit;
    }
}
