package project;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class Team {

	private static File flTeam = new File("src/project/Team.txt");

	public static void addMember(String name) {
		if(name.length() == 0) return;
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

	public static void removeMember(String name) {
		if(name.length() == 0) return;
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

	public static TreeSet<String> returnTeam() {
		TreeSet<String> set = new TreeSet<String>(); // TreeSet for collecting the names sorted alphabetically
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
