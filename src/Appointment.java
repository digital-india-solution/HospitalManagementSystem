import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;


public class Appointment extends JFrame {

	private JPanel contentPane;
	private ButtonGroup bg =new ButtonGroup();
	private ButtonGroup bg1 =new ButtonGroup();
	private ButtonGroup bg2 =new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel panel_1;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment frame = new Appointment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Appointment() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPersonRequestingAppointment = new JLabel("Person Requesting Appointment");
		lblPersonRequestingAppointment.setBounds(39, 51, 196, 14);
		contentPane.add(lblPersonRequestingAppointment);
		
	    panel = new JPanel();
		panel.setBounds(30, 76, 435, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel.setVisible(false);
		
		JLabel lblRelationshipToPatient = new JLabel("RelationShip To Patient");
		lblRelationshipToPatient.setBounds(10, 55, 162, 14);
		panel.add(lblRelationshipToPatient);
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 52, 162, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRequestingPersonName = new JLabel("Requesting Person Name");
		lblRequestingPersonName.setBounds(10, 11, 181, 14);
		panel.add(lblRequestingPersonName);
		
		textField = new JTextField();
		textField.setBounds(209, 8, 161, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setBounds(39, 167, 135, 14);
		contentPane.add(lblPatientName);
		
		JRadioButton rdbtnSelf = new JRadioButton("Self");
		rdbtnSelf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
			}
		});
		rdbtnSelf.setBounds(241, 42, 83, 23);
		contentPane.add(rdbtnSelf);
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
			}
		});
		rdbtnOther.setBounds(327, 42, 75, 23);
		contentPane.add(rdbtnOther);
		
		bg.add(rdbtnSelf);
		bg.add(rdbtnOther);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(39, 218, 75, 14);
		contentPane.add(lblAddress);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(39, 276, 57, 14);
		contentPane.add(lblMobile);
		
		JLabel lblTypeOfPatient = new JLabel("Type Of Patient");
		lblTypeOfPatient.setBounds(37, 309, 115, 14);
		contentPane.add(lblTypeOfPatient);
		
		panel_1 = new JPanel();
		panel_1.setBounds(30, 334, 435, 37);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JLabel lblTypeOfAppiontment = new JLabel("Type Of Appiontment");
		lblTypeOfAppiontment.setBounds(10, 11, 156, 14);
		panel_1.add(lblTypeOfAppiontment);
		
		JRadioButton rdbtnFollowUp = new JRadioButton("Follow up");
		rdbtnFollowUp.setBounds(210, 7, 80, 23);
		panel_1.add(rdbtnFollowUp);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New Problem");
		rdbtnNewRadioButton.setBounds(297, 7, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNew = new JRadioButton("New");
		rdbtnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(false);
			}
		});
		rdbtnNew.setBounds(241, 300, 67, 23);
		contentPane.add(rdbtnNew);
		
		JRadioButton rdbtnExisiting = new JRadioButton("Exisiting");
		rdbtnExisiting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
			}
		});
		rdbtnExisiting.setBounds(327, 300, 109, 23);
		contentPane.add(rdbtnExisiting);
		
		bg1.add(rdbtnNew);
		bg1.add(rdbtnExisiting);
		
		bg2.add(rdbtnFollowUp);
		bg2.add(rdbtnNewRadioButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(241, 164, 161, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(241, 273, 161, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(241, 198, 161, 64);
		contentPane.add(textPane);
		
		JLabel lblDesired = new JLabel("Desired Date");
		lblDesired.setBounds(40, 392, 112, 14);
		contentPane.add(lblDesired);
		
		JLabel lblDesiredTime = new JLabel("Desired Time");
		lblDesiredTime.setBounds(39, 428, 100, 14);
		contentPane.add(lblDesiredTime);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(241, 386, 161, 20);
		contentPane.add(dateChooser);
		
		textField_4 = new JTextField();
		textField_4.setBounds(241, 425, 161, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Request Appointment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(241, 511, 161, 23);
		contentPane.add(btnNewButton);
	}
}
