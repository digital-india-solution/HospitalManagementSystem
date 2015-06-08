import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FitnessForm extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField fname;
	private JTextField address;
	private JTextField blood_g;
	private JTextField mark;
	private JLabel date_1;
	
	private String n;
	private String f;
	private String a;
	private String b;
	private String m;
	private String d;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FitnessForm frame = new FitnessForm();
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
	public FitnessForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 
				
				try {
					
					File file = new File("D:/evision/bin/myfile.doc");
				

					FileWriter w = new FileWriter(file);
					w.write("Dated On: "+d);
					w.write("\n\nMEDICAL FITNESS CERTIFICATE\n\n");
					w.write("I Dr Gurpreet Singh certify that I have carefully examined Mr./ Mrs '"+n+"' Son/Daughter of '"+f+"' Address '"+a+"' whose signature is given below. Based on the examination, I certify that he is in a good mental and physical health and is free from any physical defects which may interfere with his professional work including the active outdoor duties required for a professional purpose.");
					w.write("\n\n\nBlood Group: '"+b+"'");
					w.write("\n\nMark of Identification: '"+m+"'");
					w.write("\n\nSignature: ");
					w.write("\t\t\t\t\t\t\tSincerely");
					w.write("\n\n\t\t\t\t\t\t\t\tDr Name: Gurpreet Singh\n\n\t\t\t\t\t\t\t\tDegree Achieved: MBBS\n\n\t\t\t\t\t\t\t\tDesignation: \n\n\t\t\t\t\t\t\t\tInstitute: Gnim\n\n\t\t\t\t\t\t\t\tCell: AIIMS HOSPITAL");
					
					w.flush();
					w.close();
					 if (Desktop.isDesktopSupported()) {
					       Desktop.getDesktop().open(new File("D:/evision/bin/myfile.doc"));
					     }
					 
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} 

			}
		});
		btnNewButton.setBounds(252, 353, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(60, 51, 46, 14);
		contentPane.add(lblDate);
		
		JLabel date_1 = new JLabel("");
		date_1.setBounds(183, 51, 102, 14);
		contentPane.add(date_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(60, 90, 46, 14);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(183, 84, 122, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblF = new JLabel("Father Name");
		lblF.setBounds(60, 132, 77, 14);
		contentPane.add(lblF);
		
		fname = new JTextField();
		fname.setBounds(183, 126, 122, 20);
		contentPane.add(fname);
		fname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(60, 176, 77, 14);
		contentPane.add(lblAddress);
		
		address = new JTextField();
		address.setBounds(183, 170, 247, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setBounds(60, 217, 77, 14);
		contentPane.add(lblBloodGroup);
		
		blood_g = new JTextField();
		blood_g.setBounds(183, 211, 122, 20);
		contentPane.add(blood_g);
		blood_g.setColumns(10);
		
		JLabel lblMarkOfIdentification = new JLabel("Mark of Identification");
		lblMarkOfIdentification.setBounds(60, 255, 122, 14);
		contentPane.add(lblMarkOfIdentification);
		
		mark = new JTextField();
		mark.setBounds(183, 252, 122, 20);
		contentPane.add(mark);
		mark.setColumns(10);
		


		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 n=name.getText();
				 f=fname.getText();
				 a=address.getText();
				 b=blood_g.getText();
				 m=mark.getText();
				 d=date_1.getText();
			}
		});
		btnSubmit.setBounds(123, 353, 89, 23);
		contentPane.add(btnSubmit);
		
		
		DateFormat d=new SimpleDateFormat("dd/MM/yyyy");
		Date d2=new Date();
		String d3=d.format(d2);
		date_1.setText(d3);
	}

}
