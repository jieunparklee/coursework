package Main;

import java.io.StringReader;
import java.util.Scanner;

import CCFinder.CCFinder;

public class Main {
	private static final int ADD = 0;
	private static final int PRINT = 1;
	private static final int NUMBER = 2;
	private static final int SIZE = 3;
	private static final int DIFFER = 4;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CCFinder Finder = new CCFinder();

		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			Scanner i_scanner = new Scanner(new StringReader(line));
			String cmd = i_scanner.next();
			int Node1 = 0;
			int Node2 = 0;

			switch (getCommandNum(cmd)) {
			case ADD:
				Node1 = i_scanner.nextInt();
				Node2 = i_scanner.nextInt();
				Finder.addedge(Node1, Node2);
				System.out.println("ADD: " + Node1 + " " + Node2);
				break;
			case PRINT:
				Node1 = i_scanner.nextInt();
				System.out.print("PRINT: ");
				Finder.CCprint(Node1);
				break;
			case NUMBER:
				System.out.println("NUMBER: " + Finder.CCnumber());			
				break;
			case SIZE:
				Node1 = i_scanner.nextInt();
				System.out.println("SIZE: " + Finder.CCsize(Node1));
				break;
			case DIFFER:
				Node1 = i_scanner.nextInt();
				Node2 = i_scanner.nextInt();
				System.out.print("DIFFER: ");
				if (Finder.CCdiffer(Node1, Node2))
					System.out.println("YES");
				else System.out.println("NO");
				break;
			}

			i_scanner.close();
		}

		scanner.close();
	}

	private static int getCommandNum(String cmd) {
		// System.out.println(cmd);
		if (cmd.equals("add"))
			return ADD;
		else if (cmd.equals("print"))
			return PRINT;
		else if (cmd.equals("number"))
			return NUMBER;
		else if (cmd.equals("size"))
			return SIZE;
		else
			return DIFFER;
	}
}
