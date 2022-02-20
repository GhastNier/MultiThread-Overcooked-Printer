// You are free to add any attributes or methods you need.
public class FriesChef implements Runnable {
    static String name = "FriesChef";
    private int WAIT_TIME = 1000;
    private int MAKE_TIME = 2000;
    static int fries;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(WAIT_TIME);
        } catch (InterruptedException ignored) {
        }
        while (KitchenTable.isNotFull() && ReadyTable.isNotFull()) {
            try {
                Thread.sleep(MAKE_TIME);
            } catch (InterruptedException ignored) {
            }
            fries++;
            KitchenTable.add();
            System.out.println("[Action] " + name + " add Fries on the kitchen table");
            System.out.println("[Status] Fries left: " + fries);
            if (KitchenTable.mealReady() && ReadyTable.isNotFull()) {
                System.out.println("[Action] " + name + " combines Burger and Fries and place it on the ready table");
                KitchenTable.remove();
                ReadyTable.add();
                System.out.println("[Status] Burgers left: " + BurgerChef.burgers + ", Fries left: " + fries + " , Meals left: " + ReadyTable.mealsLeft);
                System.out.println("===================================================================================");
            }
        }
    }
}