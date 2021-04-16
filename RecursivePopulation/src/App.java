import java.util.Scanner;

/**
 * This program demonstrates a solution to the* Recursive Population Class
 * programming challenge.
 */
public class App {

	public static void main(final String[] args) {
		var population = new Population(new Prompt(new Scanner(System.in)));
		Population.displayPopulation(population.startingNumber(), population.dailyIncrease(), population.days());
	}

}
