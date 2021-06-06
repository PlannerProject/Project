package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class RemoveMember extends ChangeMember {

	public RemoveMember(JDialog dlg) {
		super(dlg);
		// TODO Auto-generated constructor stub
		super.lblChangeMember.setText("<html>Enter the name of the member you want to remove</html>");
		super.btnChangeMember.setText("Remove Member");
		super.btnChangeMember.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = RemoveMember.super.txtChangeMember.getText();
				dlg.dispose();
				Team.removeMember(name);
				Planner.setTeam();
			}
		});
	}

}
