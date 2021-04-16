import java.util.Scanner;

public class Prompt {
	Scanner keyboard;
	Prompt(Scanner keyboard){
		this.keyboard = keyboard;
	}
	double forDouble(String initialPrompt, String errorPrompt, double minValue) {
		System.out.print(initialPrompt);
		double starting = keyboard.nextDouble();
		// Validate the input.
		while (starting < minValue) {
			System.out.print(errorPrompt);
			starting = keyboard.nextDouble();
		}
		return starting;
	}

}
