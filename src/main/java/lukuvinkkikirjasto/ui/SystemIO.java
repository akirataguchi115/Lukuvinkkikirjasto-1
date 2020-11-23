package lukuvinkkikirjasto.ui;

import java.util.Scanner;

public class SystemIO implements IO {
	private Scanner scanner = new Scanner(System.in);

	public String input() {
		return scanner.nextLine();
	}

	public void output(String text) {
		System.out.println(text);
	}
}
