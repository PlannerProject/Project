package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChangeMember extends JPanel {
	File flTeam = new File("src/project/Team.txt");
	JButton btnChangeMember;
	JTextField txtChangeMember;
	JTextArea txtMembers;
	JLabel lblChangeMember;

	// JPanel for adding new members to the team - consists of 2 boxes (left and
	// right)
	public ChangeMember(JDialog dlg) {
		super();
		Font font_plain = new Font(Font.SERIF, Font.PLAIN, 18);
		Font font_bold = new Font(Font.SERIF, Font.BOLD, 18);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		Box boxLeft = Box.createVerticalBox();
		Box boxRight = Box.createVerticalBox();
		JPanel pnlRight = new JPanel();
		pnlRight.setLayout(new BorderLayout());

		// Left box
		boxLeft.add(Box.createVerticalGlue()); // add vertical glue
		// JLabel - "Current members"
		JLabel lblMembers = new JLabel("Current members");
		lblMembers.setFont(font_bold);
		boxLeft.add(lblMembers);
		// JTextArea - members of the team
		txtMembers = new JTextArea();
		txtMembers.setText(Team.fileToString());
		txtMembers.setEditable(false);
		txtMembers.setFont(font_plain);
		txtMembers.setBorder(BorderFactory.createLineBorder(Color.black));
		boxLeft.add(new JScrollPane(txtMembers)); // adding scroll pane
		boxLeft.add(Box.createVerticalGlue()); // add vertical glue

		// Right box
		boxRight.add(Box.createVerticalGlue()); // add vertical glue
		// JLabel - entering the name of a new member
		lblChangeMember = new JLabel();
		lblChangeMember.setFont(font_bold);
		boxRight.add(lblChangeMember);
		// JTextField for typing the name of a new member
		txtChangeMember = new JTextField();
		txtChangeMember.setMaximumSize(new Dimension(700, 30));
		txtChangeMember.setFont(font_plain);
		boxRight.add(txtChangeMember);
		boxRight.add(Box.createVerticalGlue()); // add vertical glue
		// JButton for adding a new member after typing the name
		btnChangeMember = new JButton();
		btnChangeMember.setFont(font_bold);
		
		boxRight.add(btnChangeMember);
		boxRight.add(Box.createVerticalGlue()); // add vertical glue

		// Adding the boxes to the panel
		add(boxLeft, BorderLayout.CENTER);
		add(boxRight, BorderLayout.EAST);
	}

}
