//A table which the meals are put as soon as they become ready
//You need to handle race condition here.
public class ReadyTable {
    public final static int limit = 3;
    static int mealsLeft = 0;

    public static boolean isNotFull() {
        return limit > mealsLeft;
    }

    public static boolean serveReady() {
        return mealsLeft >= 1;
    }

    public static synchronized void add() {
        mealsLeft++;
        System.out.println("[Action] " + Thread.currentThread().getName() + " combines a Burger and Fries and place it on the ready table.");
        System.out.println("[Status] Burgers left: " + KitchenTable.burgers + ", Fries left: " + KitchenTable.fries + " , Meals left: " + mealsLeft);
        System.out.println("===================================================================================");
    }

    public static synchronized void remove() {
        mealsLeft--;
    }
}
