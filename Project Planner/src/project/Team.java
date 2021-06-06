package project;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class Team {

	private static File flTeam = new File("src/project/Team.txt"); // File-type static parameter

	// The addMember method creates a TreeSet with names. A String is passed to the
	// method and is later added to the set.
	// All the stored names in the set are then written into a file by a
	// PrintWriter.
	public static void addMember(String name) {
		if (name.length() == 0)
			return;
		TreeSet<String> set = returnTeam();
		set.add(name);

		try {
			try (PrintWriter p = new PrintWriter(flTeam);) {
				for (String str : set) {
					p.print(str + "\n");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// The removeMember method creates a TreeSet with names. A string name is passed
	// to the method.
	// All the stored names in the set, which do not equal name, are then written
	// into a file by a PrintWriter.
	public static void removeMember(String name) {
		if (name.length() == 0)
			return;
		TreeSet<String> set = returnTeam();

		try {
			try (PrintWriter p = new PrintWriter(flTeam);) {
				for (String str : set) {
					if (!str.equals(name)) {
						p.print(str + "\n");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// The returnTeam method uses a TreeSet to store the names alphabetically. The
	// file is crawled with a while and each new line is added to the set.
	public static TreeSet<String> returnTeam() {
		TreeSet<String> set = new TreeSet<String>(); //
		try {
			try (Scanner sc = new Scanner(flTeam);) {
				while (sc.hasNext()) {
					set.add(sc.nextLine());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return set;
	}

	// The fileToString method creates a string, goes through the file and
	// concatenates each new line to the string. The resulting string is then
	// returned.
	public static String fileToString() {
		String s = "";
		try {
			try (Scanner sc = new Scanner(flTeam);) {
				while (sc.hasNext()) {
					s += sc.nextLine() + "\n";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s;
	}
}