package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class RemoveMember extends ChangeMember { // Extends the ChangeMember class

	public RemoveMember(JDialog dlg) { // Public constructor
		super(dlg);
		// TODO Auto-generated constructor stub
		super.lblChangeMember.setText("<html>Enter the name of the member you want to remove</html>");
		super.btnChangeMember.setText("Remove Member");
		// Setting text to the label and button of the ChangeMember class
		super.btnChangeMember.addActionListener(new ActionListener() { // Adding Action Listener to the
			// ChangeMember("Add new Member") button

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = RemoveMember.super.txtChangeMember.getText(); // Getting the information entered by the
				// user
				dlg.dispose(); // Closes the dialog window
				Team.removeMember(name); // Removing the member from the team
				Planner.setTeam(); // Invokes the setTeam method of the Planner class
			}
		});
	}

}