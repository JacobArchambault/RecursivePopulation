import java.util.Scanner;

/**
 * This program demonstrates a solution to the* Recursive Population Class
 * programming challenge.
 */
public class App {


	public static void main(final String[] args) {
		final var keyboard = new Scanner(System.in);
		Population.displayPopulation(Population.startingNumber(keyboard), Population.dailyIncrease(keyboard), Population.days(keyboard));
		keyboard.close();
	}

}
