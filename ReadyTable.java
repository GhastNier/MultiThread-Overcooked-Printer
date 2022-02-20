//A table which the meals are put as soon as they become ready
//You need to handle race condition here.
public class ReadyTable{
	public static int limit = 3;
	protected static int mealsLeft;
	public static boolean isNotFull(){
		return limit != mealsLeft;
	}
	public static boolean serveReady(){
		return mealsLeft >= 1;
	}
	public static synchronized void add(){
		FriesChef.fries--;
		BurgerChef.burgers--;
		mealsLeft++;
	}
	public static synchronized void remove(){
		mealsLeft--;
	}
}
