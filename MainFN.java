package com.fortnitemaincheats;

import java.awt.AWTException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFN {

	private JFrame frame;
	private boolean isTurnedOn = false;
	private boolean isAIOn = false;
	private Timer t;
	private KeyHandler kh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFN window = new MainFN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws AWTException 
	 */
	// System.out.println("X:"+arr[0]+", Y:"+arr[1]);
	public MainFN() throws AWTException {
		initialize();
		kh = new KeyHandler();
		t = new Timer(250,(ActionEvent e)->{

		});
//		t.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fortnite Menu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 434, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Open Crosshair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crosshair.main(null);
			}
		});
		btnNewButton.setBounds(155, 93, 157, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Start Keylog");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isTurnedOn) {
					try {
						KeyHandler.main(null);
						JNativeHookMouse.run();
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					isTurnedOn=true;
					System.out.println("Turned on Key Handler");
				}
			}
		});
		btnNewButton_1.setBounds(10, 16, 111, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Start AI");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAIOn) {
					
					
					isAIOn=true;
					System.out.println("AIM Turned on");
					
				}
				
			}
		});
		btnNewButton_2.setBounds(10, 214, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Start AutoDrum");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AutoDrum a = new AutoDrum();
//				a.main(null);
			}
		});
		btnNewButton_3.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
	}
}

