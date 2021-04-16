
public class Population {

	private static void printRows(final int dayNum, final double days, double organisms,
			final double dailyIncrease) {
		System.out.println(dayNum + "\t\t" + organisms);
		if (dayNum < days) {
			Population.printRows(dayNum + 1, days, organisms + (organisms * dailyIncrease), dailyIncrease);
		}
	}

	Prompt prompt;

	Population(final Prompt prompt) {
		this.prompt = prompt;
	}

	private double dailyIncrease() {
		return prompt.forDouble("Enter the daily percentage increase: ", "Invalid. Enter a non-negative number: ", 0);
	}

	private double days() {
		return prompt.forDouble("Enter the number of days the organisms will multiply: ", "Invalid. Enter 1 or more: ",
				1);
	}

	void display() {
		var startingNumberOfOrganisms = startingNumberOfOrganisms();
		var days = days();
		var dailyIncrease = dailyIncrease();
		System.out.println("Day\t\tOrganisms");
		System.out.println("-----------------------------");
		Population.printRows(1, days, startingNumberOfOrganisms, dailyIncrease);
	}

	private double startingNumberOfOrganisms() {
		return prompt.forDouble("Enter the starting number of organisms: ", "Invalid. Must be at least 2. Re-enter: ",
				2);
	}

}
