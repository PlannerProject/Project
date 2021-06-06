package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class AddNewAssignment extends JDialog { //� ����� AddNewAssignment ��������� �������� ��������

	private static final long serialVersionUID = 2466213780045701241L; //���������� ����� �� �����
	Planner planner; //����-���������� �� ��� Planner

	public AddNewAssignment(Planner planner) { //���� ����������� ������ ��������� �� ��� Planner
		super(planner, "Add new assignment", true); 
		this.planner = planner; //planner �� ������ �� ��� AddNewAssignment ������ ���������� �� ��������� planner
		this.setSize(815, 375); //�������� ������� �� ���������� ���������
		this.setLocationRelativeTo(planner); //�������� ��������� �� ��������� ������ ����������

		JPanel panel = new JPanel(); //��������� �����
		panel.setBackground(Color.WHITE); //�������� ���� �� ������
		panel.setLayout(null); //�������� ����� layout ��� ������
		add(panel); //�������� ������ ��� ���������� ��������
		
		Border blackline = BorderFactory.createLineBorder(Color.BLACK); //��������� ����� Border

		JButton btnCancel = new JButton("Cancel"); //��������� ����� Cancel
		btnCancel.setFont(panel.getFont().deriveFont(Font.BOLD, 16.0f)); //�������� ������ � ������� �� ������ �� ������ � ������
		btnCancel.setBackground(Color.RED); //�������� ������ ���� �� ������
		btnCancel.setBorder(blackline); //��������� ������ Cancel � Border
		btnCancel.setBounds(400, 250, 125, 50); //�������� ���������� �� ������ 
		btnCancel.addActionListener(new ActionListener() { //�������� �������������� �� ������

			@Override
			public void actionPerformed(ActionEvent e) {
				AddNewAssignment.this.dispose(); //��� ��������� �� ������ ����������� �������� �� �������
			}
		});
		panel.add(btnCancel); //�������� ������ Cancel ��� ������

		JLabel lblNameOfAssignment = new JLabel("Assignment", SwingConstants.CENTER); //��������� JLabel � ��������� ������ "Assignment"
		lblNameOfAssignment.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblNameOfAssignment.setBorder(blackline); //��������� ������� � Border
		lblNameOfAssignment.setBounds(30, 50, 160, 50); //�������� ���������� �� �������
		panel.add(lblNameOfAssignment); //�������� ������� ��� ������

		JLabel lblPerson = new JLabel("Person in Charge", SwingConstants.CENTER); //��������� JLabel � ��������� ������ "Person in Charge"
		lblPerson.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblPerson.setBorder(blackline); //��������� ������� � Border
		lblPerson.setBounds(190, 50, 140, 50); //�������� ���������� �� �������
		panel.add(lblPerson); //�������� ������� ��� ������

		JLabel lblInitialDate = new JLabel("Initial Date", SwingConstants.CENTER); //��������� JLabel � ��������� ������ "Initial Date"
		lblInitialDate.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblInitialDate.setBorder(blackline); //��������� ������� � Border
		lblInitialDate.setBounds(330, 50, 110, 50); //�������� ���������� �� �������
		panel.add(lblInitialDate); //�������� ������� ��� ������

		JLabel lblDueDate = new JLabel("Due Date", SwingConstants.CENTER); //��������� JLabel � ��������� ������ "Due Date"
		lblDueDate.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblDueDate.setBorder(blackline); //��������� ������� � Border
		lblDueDate.setBounds(440, 50, 150, 50); //�������� ���������� �� �������
		panel.add(lblDueDate); //�������� ������� ��� ������

		JLabel lblStatus = new JLabel("Status of Assignment", SwingConstants.CENTER); //��������� JLabel � ��������� ������ "Status of Assignment"
		lblStatus.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblStatus.setBorder(blackline); //��������� ������� � Border
		lblStatus.setBounds(590, 50, 175, 50); //�������� ���������� �� �������
		panel.add(lblStatus); //�������� ������� ��� ������

		JTextArea txtAssignment = new JTextArea(); //��������� JTextArea �� ��������� ����� �� ���������
		txtAssignment.setLineWrap(true); //��� ����� �� ��������� � ������ �����, �� �� ������� �� ������� ����
		txtAssignment.setToolTipText("Enter description of the assignment"); //��� ��������� �� ������� ����� ������ �� ����� �� ������� �������� "Enter description of the assignment"
		txtAssignment.setFont(panel.getFont().deriveFont(Font.ITALIC, 14.0f)); //�������� ������ � ������� �� ������ �� ������ � ������ �� �����
		txtAssignment.setBorder(blackline); //���������� ������ �� ����� � Border
		txtAssignment.setBounds(30, 100, 160, 100); //�������� ���������� �� ������ �� �����
		panel.add(txtAssignment); //�������� ������ �� ����� ��� ������

		JComboBox comboNames = new JComboBox(Team.returnTeam().toArray()); //��������� ������ ���� � ������� �� ��������� �� �����
		((JLabel) comboNames.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //���������� ������� � �������� ����
		comboNames.setBackground(Color.WHITE); //�������� ��� �� �������� ����
		comboNames.setFont(panel.getFont().deriveFont(Font.ITALIC, 16.0f)); //�������� ������ � ������� �� ������ �� ������ � �������� ����
		comboNames.setBorder(blackline); //���������� �������� ���� � Border
		comboNames.setBounds(190, 100, 140, 100); //�������� ���������� �� �������� ����
		panel.add(comboNames); //�������� �������� ���� ��� ������

		LocalDate initialDate = LocalDate.now(); //���������� �� ��� Date � �������� ����
		JLabel lblInitialDateValue = new JLabel(
				initialDate.getDayOfMonth() + " " + initialDate.getMonth() + " " + initialDate.getYear(),
				SwingConstants.CENTER); //��������� JLabel, ����� �� ������� �������� ����
		lblInitialDateValue.setFont(panel.getFont().deriveFont(Font.ITALIC, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblInitialDateValue.setBorder(blackline); //��������� ������� � Border
		lblInitialDateValue.setBounds(330, 100, 110, 100); //��������� ������� � Border
		panel.add(lblInitialDateValue); //�������� ������� ��� ������

		JLabel lblDay = new JLabel("D", SwingConstants.CENTER); //��������� JLabel, ��� ����� �� ���� �������� ���� �� ����
		lblDay.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblDay.setBorder(blackline); //��������� ������� � Border
		lblDay.setBounds(440, 100, 50, 40); //��������� ������� � Border
		panel.add(lblDay); //�������� ������� ��� ������

		JLabel lblMonth = new JLabel("M", SwingConstants.CENTER); //��������� JLabel, ��� ����� �� ���� �������� ���� �� �����
		lblMonth.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblMonth.setBorder(blackline); //��������� ������� � Border
		lblMonth.setBounds(490, 100, 50, 40); //��������� ������� � Border
		panel.add(lblMonth); //�������� ������� ��� ������

		JLabel lblYear = new JLabel("Y", SwingConstants.CENTER); //��������� JLabel, ��� ����� �� ���� �������� ���� �� ������
		lblYear.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblYear.setBorder(blackline); //��������� ������� � Border
		lblYear.setBounds(540, 100, 50, 40); //��������� ������� � Border
		panel.add(lblYear); //�������� ������� ��� ������

		String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }; //����� � ����
		JComboBox comboDays = new JComboBox(days); //������ ���� � ���������� ����
		comboDays.setSelectedIndex(initialDate.getDayOfMonth() - 1); //��� �� � ������� ���� �� ������� ���������� �������� ����
		((JLabel) comboDays.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //���������� ����� � �������� ����
		comboDays.setBackground(Color.WHITE); //�������� ���� �� �������� ����
		comboDays.setFont(panel.getFont().deriveFont(Font.ITALIC, 16.0f)); //�������� ������ � ������� �� ������ �� ������ � �������� ����
		comboDays.setBorder(blackline); //���������� �������� ���� � Border
		comboDays.setBounds(440, 140, 50, 60); //�������� ���������� �� �������� ����
		panel.add(comboDays); //�������� �������� ���� ��� ������

		String[] months = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }; //����� � ������
		JComboBox comboMonths = new JComboBox(months); //������ ���� � ���������� ������
		comboMonths.setSelectedIndex(initialDate.getMonthValue() - 1); //��� �� � ������� ���� �� ������� ���������� ��������� �����
		((JLabel) comboMonths.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //���������� �������� � �������� ����
		comboMonths.setBackground(Color.WHITE); //�������� ���� �� �������� ����
		comboMonths.setFont(panel.getFont().deriveFont(Font.ITALIC, 16.0f)); //�������� ������ � ������� �� ������ �� ������ � �������� ����
		comboMonths.setBorder(blackline); //���������� �������� ���� � Border
		comboMonths.setBounds(490, 140, 50, 60); //�������� ���������� �� �������� ����
		panel.add(comboMonths); //�������� �������� ���� ��� ������

		String[] years = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24" }; //����� � ������
		JComboBox comboYears = new JComboBox(years); //������ ���� � ���������� ������
		comboYears.setSelectedIndex(initialDate.getYear() - 2001); //��� �� � ������� ���� �� �������� ���������� ���������� 2 ����� �� ��������� ������
		((JLabel) comboYears.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //���������� �������� � �������� ����
		comboYears.setBackground(Color.WHITE); //�������� ���� �� �������� ����
		comboYears.setFont(panel.getFont().deriveFont(Font.ITALIC, 16.0f)); //�������� ������ � ������� �� ������ �� ������ � �������� ����
		comboYears.setBorder(blackline); //���������� �������� ���� � Border
		comboYears.setBounds(540, 140, 50, 60); //�������� ���������� �� �������� ����
		panel.add(comboYears); //�������� �������� ���� ��� ������

		String[] status = { "Uncompleted", "Completed" }; //����� � ���������� ������� �� ���������
		JComboBox comboStatus = new JComboBox(status); //������ ���� �� ����������� �� ���������
		((JLabel) comboStatus.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //���������� ������ � �������� ����
		comboStatus.setBackground(Color.WHITE); //�������� ���� �� �������� ����
		comboStatus.setFont(panel.getFont().deriveFont(Font.ITALIC, 16.0f)); //�������� ������ � ������� �� ������ �� ������ � �������� ����
		comboStatus.setBorder(blackline); //���������� �������� ���� � Border
		comboStatus.setBounds(590, 100, 175, 100); //�������� ���������� �� �������� ����
		panel.add(comboStatus); //�������� �������� ���� ��� ������

		JButton btnSubmit = new JButton("Submit"); //��������� ����� Submit 
		btnSubmit.setFont(panel.getFont().deriveFont(Font.BOLD, 16.0f)); //�������� ������ � ������� �� ������ �� ������ � ������
		btnSubmit.setBackground(Color.GREEN); //�������� ����� ���� �� ������
		btnSubmit.setBorder(blackline); //��������� ������ Cancel � Border
		btnSubmit.setBounds(550, 250, 125, 50); //�������� ���������� �� ������ 
		btnSubmit.addActionListener(new ActionListener() { //�������� �������������� �� ������
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LocalDate dueDate = LocalDate.of(comboYears.getSelectedIndex() + 2001,
						comboMonths.getSelectedIndex() + 1, comboDays.getSelectedIndex() + 1); //��������� ���������� �� ��� Date �� ���� ������ �� ����������� �� �������� ����
				boolean status = comboStatus.getSelectedItem().equals("Completed") ? true : false; //��������� ���������� �� ��� boolean �� ���� ������ �� ����������� �� ������ �� ���������
				Assignment newAssignment = new Assignment(txtAssignment.getText(),
						(String) comboNames.getSelectedItem(), initialDate, dueDate, status); //��������� ����� �� ��� Assignment � ��������� �� ���� ������ �� �����������
				AddNewAssignment.this.dispose(); //������� ���������� ��������
				planner.addToTable(newAssignment); //������ ���������� Assignment ��� ��������� ��� �������
			}
		});
		panel.add(btnSubmit); //�������� ������ ��� ������

		this.setVisible(true); //��������� �� ���������� �������� �� �� ������
	}
}