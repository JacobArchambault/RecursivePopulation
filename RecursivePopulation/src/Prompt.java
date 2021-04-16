import java.util.Scanner;

public class Prompt {
	Scanner keyboard;

	Prompt(final Scanner keyboard) {
		this.keyboard = keyboard;
	}

	double forDouble(final String initialPrompt, final String errorPrompt, final double minValue) {
		System.out.print(initialPrompt);
		var starting = keyboard.nextDouble();
		// Validate the input.
		while (starting < minValue) {
			System.out.print(errorPrompt);
			starting = keyboard.nextDouble();
		}
		return starting;
	}
}
