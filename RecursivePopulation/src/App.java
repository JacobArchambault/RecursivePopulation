import java.util.Scanner;

/**
 * This program demonstrates a solution to the* Recursive Population Class
 * programming challenge.
 */
public class App {

	/**
	 * The displayPopulation method displays the* population table header and then
	 * calls the recursive show Population method to display the daily populations.
	 *
	 * @param startingOrganisms The number of starting organisms in the population.
	 * @param increase          The daily increase percentage.
	 * @param days              The number of days the organisms will be left to
	 *                          multiply.
	 */
	public static void displayPopulation(final double startingOrganisms, final double increase, final int days) {
		System.out.println("Day\t\tOrganisms");
		System.out.println("-----------------------------");
		App.showPopulation(1, days, startingOrganisms, increase);
	}

	public static void main(final String[] args) {
		final var keyboard = new Scanner(System.in);
		App.displayPopulation(startingNumber(keyboard), dailyIncrease(keyboard), days(keyboard));
		keyboard.close();
	}

	private static int days(final Scanner keyboard) {
		System.out.print("Enter the number of days the organisms will multiply: ");
		int days = keyboard.nextInt();
		// Validate the input.
		while (days < 1) {
			System.out.print("Invalid. Enter 1 or more: ");
			days = keyboard.nextInt();
		}
		return days;
	}

	private static double dailyIncrease(final Scanner keyboard) {
		System.out.print("Enter the daily increase: ");
		double increase = keyboard.nextDouble();
		// Validate the input.
		while (increase < 0) {
			System.out.print("Invalid. Enter a non-negative number: ");
			increase = keyboard.nextDouble();
		}
		return increase;
	}

	private static double startingNumber(final Scanner keyboard) {
		System.out.print("Enter the starting number " + "organisms: ");
		double starting = keyboard.nextDouble();
		// Validate the input.
		while (starting < 2) {
			System.out.print("Invalid. Must be at least 2. " + "Re-enter: ");
			starting = keyboard.nextDouble();
		}
		return starting;
	}

	/**
	 * The showPopulation method displays the daily populations for a group of
	 * organisms for a specified day, and then calls itself to display the data for
	 * the rest of the days in a time period.
	 *
	 * @param dayNum        The day number.
	 * @param days          The number of days in the time period.
	 * @param organisms     The current number of organisms.
	 * @param dailyIncrease The daily increase percentage.
	 */
	private static void showPopulation(final int dayNum, final int days, double organisms, final double dailyIncrease) {
		if (dayNum < days) {
			System.out.println(dayNum + "\t\t" + organisms);
			organisms += organisms * dailyIncrease;
			App.showPopulation(dayNum + 1, days, organisms, dailyIncrease);
		} else {
			System.out.println(dayNum + "\t\t" + organisms);
		}
	}
}
