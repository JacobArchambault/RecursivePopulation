import java.util.Scanner;

/**
 * This program demonstrates a solution to the* Recursive Population Class
 * programming challenge.
 */
public class Ch15Lab3 {

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
		Ch15Lab3.showPopulation(1, days, startingOrganisms, increase);
	}

	public static void main(final String[] args) {
		double starting; // Starting number of organisms
		double increase; // Daily increase percentage
		int days; // Number of days to multiply
		// Create a Scanner object for keyboard input.
		final var keyboard = new Scanner(System.in);
		// Get the starting number of organisms.
		System.out.print("Enter the starting number " + "organisms: ");
		starting = keyboard.nextDouble();
		// Validate the input.
		while (starting < 2) {
			System.out.print("Invalid. Must be at least 2. " + "Re-enter: ");
			starting = keyboard.nextDouble();
		}
		// Get the daily increase.
		System.out.print("Enter the daily increase: ");
		increase = keyboard.nextDouble();
		// Validate the input.
		while (increase < 0) {
			System.out.print("Invalid. Enter a non-negative number: ");
			increase = keyboard.nextDouble();
		}
		// Get the number of days to multiply.
		System.out.print("Enter the number of days the organisms will multiply: ");
		days = keyboard.nextInt();
		// Validate the input.
		while (days < 1) {
			System.out.print("Invalid. Enter 1 or more: ");
			days = keyboard.nextInt();
		}
		keyboard.close();
		// Calculate and display the daily population.
		Ch15Lab3.displayPopulation(starting, increase, days);
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
			Ch15Lab3.showPopulation(dayNum + 1, days, organisms, dailyIncrease);
		} else {
			System.out.println(dayNum + "\t\t" + organisms);
		}
	}
}
