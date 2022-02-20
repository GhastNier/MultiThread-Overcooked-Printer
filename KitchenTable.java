//A work table which for chefs to place Burgers or Fries.
//You need to handle race condition here.
public class KitchenTable {
	public static int limit = 5;
	private static int now;

	public static boolean isNotFull(){
		return limit != now;
	}
	public static boolean mealReady(){
		return FriesChef.fries > 0 && BurgerChef.burgers > 0;
	}
	public synchronized static void add(){
		now++;
	}
	public synchronized static void remove(){
		now--;
	}
}
