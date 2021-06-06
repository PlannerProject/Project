package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Progress extends JPanel {

	public Progress() {
		
		JPanel panel = new JPanel();
		setBackground(Color.WHITE);
		setLayout(null);
	
		Border blackline = BorderFactory.createLineBorder(Color.BLACK);
		
		JLabel nameLabel = new JLabel("Name of Assignment", SwingConstants.CENTER);
		nameLabel.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f));
		nameLabel.setBorder(blackline);
		nameLabel.setBounds(170, 50, 160, 50);
		add(nameLabel);
		
		JLabel inChargeLabel = new JLabel("Person in Charge", SwingConstants.CENTER);
		inChargeLabel.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f));
		inChargeLabel.setBorder(blackline);
		inChargeLabel.setBounds(330, 50, 140, 50);
		add(inChargeLabel);
		
		
		JLabel dueDateLabel = new JLabel("Due Date", SwingConstants.CENTER);
		dueDateLabel.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f));
		dueDateLabel.setBorder(blackline);
		dueDateLabel.setBounds(470, 50, 150, 50);
		add(dueDateLabel);
		
		JLabel timeLabel = new JLabel("Time remaining", SwingConstants.CENTER);
		timeLabel.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f));
		timeLabel.setBorder(blackline);
		timeLabel.setBounds(620, 50, 150, 50);
		add(timeLabel);
		
		JLabel none = new JLabel();
		none.setBorder(blackline);
		none.setBounds(40, 50, 130, 50);
		add(none);
		
		JLabel completedLabel = new JLabel("Completed", SwingConstants.CENTER);
		completedLabel.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f));
		completedLabel.setBorder(blackline);
		completedLabel.setBounds(40, 100, 130, 80);
		add(completedLabel);
		
		JLabel uncompletedLabel = new JLabel("Uncompleted", SwingConstants.CENTER);
		uncompletedLabel.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f));
		uncompletedLabel.setBorder(blackline);
		uncompletedLabel.setBounds(40, 180, 130, 80);
		add(uncompletedLabel);
		
		JLabel infoCompletedLabel = new JLabel("Info on Completed Assignments",  SwingConstants.CENTER);
		infoCompletedLabel.setFont(panel.getFont().deriveFont(Font.ITALIC, 15.0f));
		infoCompletedLabel.setBorder(blackline);
		infoCompletedLabel.setBounds(170, 100, 450, 80);
		add(infoCompletedLabel);
		
		JLabel infoUncompletedLabel = new JLabel("Info on Uncompleted Assignments",  SwingConstants.CENTER);
		infoUncompletedLabel.setFont(panel.getFont().deriveFont(Font.ITALIC, 15.0f));
		infoUncompletedLabel.setBorder(blackline);
		infoUncompletedLabel.setBounds(170, 180, 450, 80);
		add(infoUncompletedLabel);
		
		String completed = "All done! "; 
		completed += new String(Character.toChars(0x1F349));
		JLabel timeCompleteLabel = new JLabel(completed, SwingConstants.CENTER);
		timeCompleteLabel.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f));
		timeCompleteLabel.setBorder(blackline);
		timeCompleteLabel.setBounds(620, 100, 150, 80);
		add(timeCompleteLabel);
		
		JLabel timeUncompleteLabel = new JLabel();
		timeUncompleteLabel.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f));
		timeUncompleteLabel.setBorder(blackline);
		timeUncompleteLabel.setBounds(620, 180, 150, 80);
		add(timeUncompleteLabel);
		
		
	}
}