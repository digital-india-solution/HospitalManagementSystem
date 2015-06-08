import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;

import java.awt.Label;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1051, 645);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSetting = new JMenu("Settings");
		menuBar.add(mnSetting);
		
		JMenuItem mntmFitnessCertificate = new JMenuItem("Fitness Certificate");
		mntmFitnessCertificate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FitnessForm fi=new FitnessForm();
				fi.setVisible(true);
			}
		});
		mnSetting.add(mntmFitnessCertificate);
		
		JSeparator separator = new JSeparator();
		mnSetting.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnSetting.add(mntmExit);
		
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHospitalManagmentSystem = new JLabel("Hospital Managment System");
		lblHospitalManagmentSystem.setBounds(381, 27, 420, 71);
		lblHospitalManagmentSystem.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHospitalManagmentSystem.setForeground(new Color(50, 205, 50));
		contentPane.add(lblHospitalManagmentSystem);
		
		JLabel label_1 = new JLabel("");
		Image img =new ImageIcon(this.getClass().getResource("doctor.png")).getImage();
		label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(43, 153, 173, 163);
		contentPane.add(label_1);
		
		JLabel lblL = new JLabel("");
		Image img1 =new ImageIcon(this.getClass().getResource("patient.png")).getImage();
		lblL.setIcon(new ImageIcon(img1));
		lblL.setBounds(245, 153, 173, 163);
		contentPane.add(lblL);
		
		JLabel label_2 = new JLabel("");
		Image img2 =new ImageIcon(this.getClass().getResource("search.png")).getImage();
		label_2.setIcon(new ImageIcon(img2));
		label_2.setBounds(442, 153, 173, 163);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		Image img3 =new ImageIcon(this.getClass().getResource("appio.png")).getImage();
		label_3.setIcon(new ImageIcon(img3));
		label_3.setBounds(639, 153, 173, 163);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		Image img4 =new ImageIcon(this.getClass().getResource("login.png")).getImage();
		label_4.setIcon(new ImageIcon(img4));
		label_4.setBounds(836, 153, 173, 177);
		contentPane.add(label_4);
		
		JButton btnDoctor = new JButton("Doctor");
		btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor_page d=new Doctor_page();
				d.setVisible(true);
			}
		});
		btnDoctor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDoctor.setBounds(73, 357, 124, 23);
		contentPane.add(btnDoctor);
		
		JButton btnNewButton = new JButton("Patient Info Form");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Patient_form pf= new Patient_form();
				pf.setVisible(true);
			}
		});
		btnNewButton.setBounds(264, 357, 137, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Search_page s=new Search_page();
				s.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(461, 357, 124, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Appointment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Appointment ap=new Appointment();
				ap.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(666, 357, 124, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Login Form");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginForm lf=new LoginForm();
				lf.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(851, 357, 124, 23);
		contentPane.add(btnNewButton_3);
		
		
	}
}
