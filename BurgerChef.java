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
                Main.wait(MAKE_TIME);
                KitchenTable.add();
                System.out.println("[Action] " + Thread.currentThread().getName() + " add a Burger on the kitchen table");
                System.out.println("[Status] Burgers left: " + KitchenTable.burgers);
            }
            Main.wait(WAIT_TIME);
            if (KitchenTable.readyToCombine() && ReadyTable.isNotFull()) {
                KitchenTable.remove();
                ReadyTable.add();
            }else {
                Main.wait(WAIT_TIME);
            }
        }
    }

    public boolean isNotFull() {
        return KitchenTable.burgers < KitchenTable.limit;
    }
}
