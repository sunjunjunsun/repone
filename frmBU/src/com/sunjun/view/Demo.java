package com.sunjun.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Demo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JButton btnBu;
	private JButton btnClear;
	private JButton btnClear_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo frame = new Demo();
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
	public Demo() {
		setTitle("PU9 SMT bu station 20200719");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		textField = new JTextField();
		textField.setColumns(10);
		textArea = new JTextArea();
		textField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			  if(e.getKeyChar()==KeyEvent.VK_ENTER){
					String snStr = textField.getText();
					if (snStr == null || "".equals(snStr)) {
						JOptionPane.showMessageDialog(null, "«Î ‰»ÎSN");
						return;
					}
					System.out.println(snStr);
					String strNumber = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
							+ "<ns1:BoardTestXMLExport xmlns:ns1=\"http://tempuri.org/BoardTestXMLExport.xsd\" testTime=\"2020-04-20T00:02:01.000+08:00\" testerTestStartTime=\"2020-04-20T00:02:01.000+08:00\" testerTestEndTime=\"2020-04-20T00:02:14.000+08:00\" numberOfComponentsTested=\"1\" numberOfJointsTested=\"1667\" numberOfIndictedComponents=\"0\" numberOfIndictedPins=\"0\" numberOfDefects=\"0\" testStatus=\"Passed\" repairStatus=\"Repair None\" repairStationId=\"3328-VVTS\">\r\n"
							+ "    <ns1:BoardXML serialNumber=\"" + snStr
							+ "\" imageId=\"1\" boardType=\"F20-MB-00Y0-E3N-DD-02\" boardRevision=\"1587312134000\" assemblyRevision=\"F20-MB-00Y0-E3N-DD-02\"/>\r\n"
							+ "    <ns1:StationXML testerName=\"V810-8086S2\" stage=\"v810\"/>\r\n"
							+ "    <ns1:RepairEventXML repairStartTime=\"2020-04-20T00:02:16.000+08:00\" repairEndTime=\"2020-04-20T00:03:59.000+08:00\" repairOperator=\"c_admin\" numberOfActiveDefects=\"0\" numberOfActiveComponents=\"0\" numberOfActivePins=\"0\" numberOfFalseCalledDefects=\"0\" numberOfFalseCalledComponents=\"0\" numberOfFalseCalledPins=\"0\" numberOfRepairedDefects=\"0\" numberOfRepairedComponents=\"0\" numberOfRepairedPins=\"0\" numberOfRepairLaterDefects=\"0\" numberOfRepairLaterComponents=\"0\" numberOfRepairLaterPins=\"0\" numberOfVariationOkDefects=\"0\" numberOfVariationOkComponents=\"0\" numberOfVariationOkPins=\"0\"/>\r\n"
							+ "</ns1:BoardTestXMLExport>\r\n" + "";
					 textArea.append(snStr +"\n");
					String fileName = UUID.randomUUID().toString().replace("-", "") + ".xml";
					try {
						File file = new File("C:\\ITF\\XMLCEXPORT\\" + fileName);
						FileOutputStream fos = new FileOutputStream(file);
						fos.write(strNumber.getBytes());
						fos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				 
				  
			  }
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		lblNewLabel = new JLabel("New label");
	    
		Timer timerAction = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 long timeMillis = System.currentTimeMillis();
				 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				 lblNewLabel.setText(df.format(new Date(timeMillis)));
				
				
				
			}
		});
		
		timerAction.start();
		
		btnBu = new JButton("bu");
		btnBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BUActionPerformed(e);
				
				
			}
		});
		
		btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				
			}
		});
		
		btnClear_1 = new JButton("clear2");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addComponent(btnClear_1)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnClear)
								.addComponent(btnBu))))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(48)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnBu)
					.addGap(2)
					.addComponent(btnClear)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(btnClear_1)
					.addGap(33))
		);
		

		textArea.setColumns(10);
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}

	private void BUActionPerformed(ActionEvent e) {
		String snStr = textField.getText();
		if (snStr == null || "".equals(snStr)) {
			JOptionPane.showMessageDialog(null, "«Î ‰»ÎSN");
			return;
		}
		System.out.println(snStr);
		String strNumber = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<ns1:BoardTestXMLExport xmlns:ns1=\"http://tempuri.org/BoardTestXMLExport.xsd\" testTime=\"2020-04-20T00:02:01.000+08:00\" testerTestStartTime=\"2020-04-20T00:02:01.000+08:00\" testerTestEndTime=\"2020-04-20T00:02:14.000+08:00\" numberOfComponentsTested=\"1\" numberOfJointsTested=\"1667\" numberOfIndictedComponents=\"0\" numberOfIndictedPins=\"0\" numberOfDefects=\"0\" testStatus=\"Passed\" repairStatus=\"Repair None\" repairStationId=\"3328-VVTS\">\r\n"
				+ "    <ns1:BoardXML serialNumber=\"" + snStr
				+ "\" imageId=\"1\" boardType=\"F20-MB-00Y0-E3N-DD-02\" boardRevision=\"1587312134000\" assemblyRevision=\"F20-MB-00Y0-E3N-DD-02\"/>\r\n"
				+ "    <ns1:StationXML testerName=\"V810-8086S2\" stage=\"v810\"/>\r\n"
				+ "    <ns1:RepairEventXML repairStartTime=\"2020-04-20T00:02:16.000+08:00\" repairEndTime=\"2020-04-20T00:03:59.000+08:00\" repairOperator=\"c_admin\" numberOfActiveDefects=\"0\" numberOfActiveComponents=\"0\" numberOfActivePins=\"0\" numberOfFalseCalledDefects=\"0\" numberOfFalseCalledComponents=\"0\" numberOfFalseCalledPins=\"0\" numberOfRepairedDefects=\"0\" numberOfRepairedComponents=\"0\" numberOfRepairedPins=\"0\" numberOfRepairLaterDefects=\"0\" numberOfRepairLaterComponents=\"0\" numberOfRepairLaterPins=\"0\" numberOfVariationOkDefects=\"0\" numberOfVariationOkComponents=\"0\" numberOfVariationOkPins=\"0\"/>\r\n"
				+ "</ns1:BoardTestXMLExport>\r\n" + "";
		 textArea.append(snStr +"\n");
		String fileName = UUID.randomUUID().toString().replace("-", "") + ".xml";
		try {
			File file = new File("C:\\ITF\\XMLCEXPORT\\" + fileName);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(strNumber.getBytes());
			fos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	


}
