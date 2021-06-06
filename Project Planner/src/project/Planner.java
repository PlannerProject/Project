package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Planner extends JFrame { // The Planner class extends JFrame

	static JTextArea txtPeopleInTeam = new JTextArea();
	static JPanel pnl = new JPanel();
	AssignmentTableModel tblModel;
	// Parameters of the Planner class

	public Planner() { // Public constructor

		super("Planner");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnl.setLayout(null);
		pnl.setBackground(Color.white);
		// Setting layout and background to the panel

		JLabel lblTeam = new JLabel("<html> <font color='red'>Team: </font></html>");
		lblTeam.setFont(lblTeam.getFont().deriveFont(16.0f));
		lblTeam.setBounds(30, 25, 50, 50);
		pnl.add(lblTeam);
		// Creating a label with the name "Team", colored red, setting its font and
		// bounds, and adding it to the panel

		Border blackline = BorderFactory.createLineBorder(Color.black);

		setTeam(); // Invoking the setTeam method
		txtPeopleInTeam.setEditable(false);
		txtPeopleInTeam.setLineWrap(true);
		txtPeopleInTeam.setWrapStyleWord(true);
		txtPeopleInTeam.setFont(txtPeopleInTeam.getFont().deriveFont(16.0f));
		txtPeopleInTeam.setBorder(blackline);
		// Setting editability, LineWrap, WrapStyleWord, font and border to the
		// txtPeopleInTeam TextArea

		JScrollPane scrp = new JScrollPane(txtPeopleInTeam);
		scrp.setBounds(90, 26, 500, 50);
		pnl.add(scrp);
		// Creating a JScrollPane, setting its bounds, and adding it to the panel

		JButton btnAddNewMember = new JButton("Add New Member");
		btnAddNewMember.setFont(txtPeopleInTeam.getFont().deriveFont(16.0f));
		btnAddNewMember.setBackground(Color.ORANGE);
		btnAddNewMember.setBorder(blackline);
		btnAddNewMember.setBounds(600, 25, 175, 50);
		// Creating a button for adding new member, setting its font, background,
		// border, and bounds
		btnAddNewMember.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog dlgAddNewMember = new JDialog(Planner.this, "Add new member", true);
				dlgAddNewMember.setSize(600, 300);
				dlgAddNewMember.setLocationRelativeTo(null);
				dlgAddNewMember.add(new AddNewMember(dlgAddNewMember));
				dlgAddNewMember.setVisible(true);
			}
		});
		pnl.add(btnAddNewMember);
		// Adding ActionListener to the btnAddNewMember button. The button creates a
		// JDialog, of which we set the size, location and visibility. To the dialog
		// window is then passed an AddNewMember-type Object.
		// The button is then added to the panel.

		// Creating a button for removing a member, setting its font, background,
		// border, and bounds
		JButton btnRemoveMember = new JButton("Remove Member");
		btnRemoveMember.setFont(txtPeopleInTeam.getFont().deriveFont(16.0f));
		btnRemoveMember.setBackground(Color.ORANGE);
		btnRemoveMember.setBorder(blackline);
		btnRemoveMember.setBounds(790, 25, 175, 50);
		btnRemoveMember.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog dlgRemoveMember = new JDialog(Planner.this, "Remove member", true);
				dlgRemoveMember.setSize(700, 300);
				dlgRemoveMember.setLocationRelativeTo(null);
				dlgRemoveMember.add(new RemoveMember(dlgRemoveMember));
				dlgRemoveMember.setVisible(true);
			}
		});
		pnl.add(btnRemoveMember);
		// Adding ActionListener to the btnRemoveMember button. The button creates a
		// JDialog, of which we set the size, location and visibility. To the dialog
		// window is then passed an RemoveMember-type Object.
		// The button is then added to the panel.

		tblModel = new AssignmentTableModel(loadFromFile());
		JTable table = new JTable(tblModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 100, 960, 100);
		table.setFillsViewportHeight(true);
		add(scrollPane);
		// Creating a new table using the TableModel interface.

		JButton addAssignment = new JButton("Add New Assignment");
		addAssignment.setFont(txtPeopleInTeam.getFont().deriveFont(16.0f));
		addAssignment.setBackground(Color.ORANGE);
		addAssignment.setBorder(blackline);
		addAssignment.setBounds(205, 230, 175, 50);
		addAssignment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AddNewAssignment(Planner.this);
			}
		});
		pnl.add(addAssignment);
		// Creating the addAssignment button for adding new assignments, setting its
		// font, background, border, and bounds. Adding an action listener to it, which
		// executes a AddNewAssignment-type dialog window, and then adding it to the
		// panel.

		JButton btnRemoveAss = new JButton("Remove Assignment");
		btnRemoveAss.setFont(txtPeopleInTeam.getFont().deriveFont(16.0f));
		btnRemoveAss.setBackground(Color.ORANGE);
		btnRemoveAss.setBorder(blackline);
		btnRemoveAss.setBounds(400, 230, 175, 50);
		btnRemoveAss.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[] selected = table.getSelectedRows();
				for (int i = 0; i < selected.length; i++) {
					tblModel.list.remove(selected[i] - i);
				}
				tblModel.fireTableDataChanged();
				save(tblModel.list);
			}
		});
		pnl.add(btnRemoveAss);
		// Creating the btnRemoveAss button for removing assignments, setting its
		// font, background, border, and bounds. Adding an action listener to it, which
		// removes from the table the selected from the user row, and then adding it to
		// the
		// panel.

		JButton btnChangeStatus = new JButton("Change Status");
		btnChangeStatus.setFont(txtPeopleInTeam.getFont().deriveFont(16.0f));
		btnChangeStatus.setBackground(Color.ORANGE);
		btnChangeStatus.setBorder(blackline);
		btnChangeStatus.setBounds(595, 230, 175, 50);
		btnChangeStatus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[] selected = table.getSelectedRows();
				for (int i = 0; i < selected.length; i++) {
					boolean status = tblModel.list.get(selected[i]).isStatus();
					tblModel.list.get(selected[i]).setStatus(!status);
				}
				tblModel.fireTableDataChanged();
				save(tblModel.list);
			}
		});
		pnl.add(btnChangeStatus);

		// Creating the btnChangeStatus button for changing status of an assignment,
		// setting its
		// font, background, border, and bounds. Adding an action listener to it, which
		// changes the status of the chosen by the user assignment, and then adding it
		// to the panel.

		this.add(pnl);
		this.setSize(1000, 350);
		this.setVisible(true);
		// Adding the panel to the Planner, setting the size of the frame and its
		// visibility.
	}

	// The setTeam method creates an empty string and concatenates each name from
	// the set with the names to it. It then sets the text to the TextArea to be
	// this string.
	public static void setTeam() {
		String team = "";
		TreeSet<String> set = Team.returnTeam();
		for (String str : set) {
			team += str + ", ";
		}
		if (team.length() > 2) {
			team = team.substring(0, team.length() - 2);
		}
		txtPeopleInTeam.setText(team);
	}

	public void makeTable() {

	}

	// The AssignmentTableModel class extends AbstractTableModel. It contains two
	// arrays, used for creating the column names in the table. We than have a
	// couple of methods for getting the number of rows and columns in a table,
	// getting a name of a column, getting an object in a given place in the table.
	class AssignmentTableModel extends AbstractTableModel {
		Class<?>[] columnClass = new Class[] { String.class, String.class, LocalDate.class, LocalDate.class,
				Boolean.class };
		String[] columnNames = { "Name of Assignment", "Person in charge", "Initial Date", "Due Date",
				"Status of Assignment" };
		List<Assignment> list;

		AssignmentTableModel(List<Assignment> list) {
			this.list = list;
		}

		@Override
		public int getRowCount() {
			return list.size();
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public String getColumnName(int columnIndex) {
			return columnNames[columnIndex];
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return String.class;// columnClass[columnIndex];
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch (columnIndex) {
			case 0:
				return list.get(rowIndex).getName();
			case 1:
				return list.get(rowIndex).getPerson();
			case 2:
				return list.get(rowIndex).getInitialDate();
			case 3:
				return list.get(rowIndex).getDueDate();
			case 4:
				return list.get(rowIndex).isStatus() ? "Completed" : "Uncompleted";
			}
			return "";
		}

	}

	// To the addToTable method is passed an Assignment-type object, which is added
	// to the table. The table is then saved.
	public void addToTable(Assignment a) {
		tblModel.list.add(a);
		tblModel.fireTableDataChanged();
		save(tblModel.list);
	}

	// The loadFromFile method uses a file with the list of assignments to create an
	// ArrayList<String>, which is then returned.
	public static List<Assignment> loadFromFile() {
		ArrayList<Assignment> list = new ArrayList<Assignment>();
		DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");
		try {
			try (Scanner input = new Scanner(new File("src/project/Assignments.txt"));) {
				while (input.hasNext()) {
					try {
						String[] ass = input.nextLine().split("\t");
						Assignment assignment = new Assignment(ass[0], ass[1], convert(DF.parse(ass[2])),
								convert(DF.parse(ass[3])), ass[4].equals("true") ? true : false);
						list.add(assignment);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// The convert method converts a given Data-type object to a Local-type object.
	public static LocalDate convert(Date dateToConvert) {
		return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}

	// To the save method is passed a List of assignments. The list is then printed
	// with a for-each statement into a file.
	public void save(List<Assignment> list) {
		File flAssignments = new File("src/project/Assignments.txt");

		try {
			try (PrintWriter p = new PrintWriter(new FileWriter(flAssignments, false));) {
				for (Assignment assignment : list) {
					p.print(assignment.toString() + "\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}