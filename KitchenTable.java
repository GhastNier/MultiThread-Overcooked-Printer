//A work table which for chefs to place Burgers or Fries.
//You need to handle race condition here.
public class KitchenTable {
    public final static int limit = 5;
    static int burgers = 0;
    static int fries = 0;

    public static boolean readyToCombine() {
        return fries > 0 && burgers > 0;
    }

    static synchronized void add() {
        if (Thread.currentThread().getName().equals("Burger Chef")) {
            burgers++;
        }
        if (Thread.currentThread().getName().equals("Fries Chef")) {
            fries++;
        }
    }

    static synchronized void remove() {
        fries--;
        burgers--;
    }
}

