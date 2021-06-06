package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")

public class AddNewMember extends ChangeMember { // AddNewMember class extends ChangeMember

	public AddNewMember(JDialog dlg) { // A JDialog parameter is passed to the public constructor of the class
		super(dlg);
		// TODO Auto-generated constructor stub
		super.lblChangeMember.setText("Enter the name of a new member         ");
		super.btnChangeMember.setText("Add Member");
		// Setting text to the labels
		super.btnChangeMember.addActionListener(new ActionListener() { // Adding Action Listener to the
																		// ChangeMember("Add new Member") button
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = AddNewMember.super.txtChangeMember.getText(); // Getting the information entered by the
																			// user
				Team.addMember(name); // Adding the new member to the team
				dlg.dispose(); // Closes the dialog window
				Planner.setTeam(); // Invokes the setTeam method of the Planner class
			}
		});
	}

}