import java.util.Scanner;

public class Population {

	Scanner keyboard;

	Population(Scanner keyboard) {
		this.keyboard = keyboard;
	}

	/**
	 * The displayPopulation method displays the* population table header and then
	 * calls the recursive show Population method to display the daily populations.
	 *
	 * @param startingOrganisms The number of starting organisms in the population.
	 * @param increase          The daily increase percentage.
	 * @param days              The number of days the organisms will be left to
	 *                          multiply.
	 */
	public static void displayPopulation(final double startingOrganisms, final double increase, final double days) {
		System.out.println("Day\t\tOrganisms");
		System.out.println("-----------------------------");
		Population.showPopulation(1, days, startingOrganisms, increase);
	}

	double days() {
		return whilePrompt("Enter the number of days the organisms will multiply", "Invalid. Enter 1 or more", 1);
	}

	double dailyIncrease() {
		return whilePrompt("Enter the daily percentage increase: ", "Invalid. Enter a non-negative number", 0);
	}

	double startingNumber() {
		return whilePrompt("Enter the starting number of organisms: ", "Invalid. Must be at least 2. Re-enter: ", 2);
	}

	double whilePrompt(String initialPrompt, String errorPrompt, double minValue) {
		System.out.print(initialPrompt);
		double starting = keyboard.nextDouble();
		// Validate the input.
		while (starting < minValue) {
			System.out.print(errorPrompt);
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
	private static void showPopulation(final int dayNum, final double days, double organisms, final double dailyIncrease) {
		if (dayNum < days) {
			System.out.println(dayNum + "\t\t" + organisms);
			organisms += organisms * dailyIncrease;
			Population.showPopulation(dayNum + 1, days, organisms, dailyIncrease);
		} else {
			System.out.println(dayNum + "\t\t" + organisms);
		}
	}

}
