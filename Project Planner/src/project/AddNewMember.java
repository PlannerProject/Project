package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")

public class AddNewMember extends ChangeMember{ //Klasut AddNewMember nasledqva ChangeMember

	public AddNewMember(JDialog dlg) { //Priema parametur ot tip JDialog
		super(dlg);
		// TODO Auto-generated constructor stub
		super.lblChangeMember.setText("Enter the name of a new member         "); 
		super.btnChangeMember.setText("Add Member");
		//zadava tekst na JLabel-ite 
		super.btnChangeMember.addActionListener(new ActionListener() { //Dobawqme funkcionalnost na butona AddMember
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = AddNewMember.super.txtChangeMember.getText(); //String sus stoinostta, vuvedena ot potrebitelq
				Team.addMember(name); //Dobavq imeto na noviq uchastnik kum ekipa
				dlg.dispose(); //Zatvarq dialogoviq prozorec
				Planner.setTeam(); //Izvikva metoda setTeam na klasa Planner
			}
		});
	}
	
}