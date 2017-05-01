package booksfortots;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.DatabaseConnect;

public class AdminGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GridBagLayout layout;
	private static GridBagConstraints constraints;

	JLabel userLabel;
	JLabel passLabel;
	JTextField userText;
	JTextField passText;
	JButton saveButton;
	JButton cancelButton;

	public AdminGUI() {
		this.setTitle("Books for Tots - Admin");
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		layout = new GridBagLayout();
		constraints = new GridBagConstraints();

		DatabaseConnect.connect("user");

		// set default constraints
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 10;
		constraints.weighty = 20;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.BOTH;

		// GUI components
		final JPanel adminPanel = new JPanel();
		adminPanel.setLayout(layout);
		// create labels
		userLabel = new JLabel("Username: ");
		passLabel = new JLabel("Password: ");
		// create text fields
		userText = new JTextField(20);
		passText = new JPasswordField();
		// create buttons
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);

		JMenuBar menuBar;
		JMenu fileMenu, helpMenu;
		JMenuItem menuItem, logoutItem;

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		menuItem = new JMenuItem("Change User Details");
		fileMenu.add(menuItem);
		menuItem.addActionListener(this);

		logoutItem = new JMenuItem("Logout");
		logoutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login logingui = new Login();
				logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		fileMenu.add(logoutItem);

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(adminPanel, "Are you sure you want to exit?", "Exit",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					System.exit(0);
				} else if (n == 1) {
				}
			}

		});
		fileMenu.add(menuItem);

		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		menuItem = new JMenuItem("About");
		helpMenu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(adminPanel,
						"Created by:\nJoseph Tierney\nNikos Vourdanos\nEoghan de Bhal", "About",
						JOptionPane.PLAIN_MESSAGE);
			}

		});

		this.setJMenuBar(menuBar);

		adminPanel.add(userLabel, constraints);
		constraints.gridwidth = 10;
		constraints.gridx = 5;
		adminPanel.add(userText, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 2;

		adminPanel.add(passLabel, constraints);
		constraints.gridwidth = 10;
		constraints.gridx = 5;
		adminPanel.add(passText, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 3;

		adminPanel.add(saveButton, constraints);
		constraints.gridwidth = 10;
		constraints.gridx = 5;
		adminPanel.add(cancelButton, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;

		this.add(adminPanel);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

		userText.setEnabled(false);
		passText.setEnabled(false);
		saveButton.setEnabled(false);
		cancelButton.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Change User Details")) {
			userText.setEnabled(true);
			saveButton.setEnabled(true);
			cancelButton.setEnabled(true);
			passText.setEnabled(true);
		}

		if (e.getSource() == saveButton) {
			updateUser(userText.getText(), passText.getText());
			userText.setEnabled(false);
			passText.setEnabled(false);
			saveButton.setEnabled(false);
			cancelButton.setEnabled(false);
		}

		if (e.getSource() == cancelButton) {
			userText.setEnabled(false);
			passText.setEnabled(false);
			saveButton.setEnabled(false);
			cancelButton.setEnabled(false);
			userText.setText("");
			passText.setText("");
		}

	}

	/**
	 * Update the users details
	 * 
	 * @param Username
	 * @param Password
	 */
	public void updateUser(String u_name, String u_pass) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/booksfortots", "root", "");
			String query = "UPDATE users SET Username = ?, Password = ? WHERE UserID = 2";

			// create the mysql update prepared statement
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			prepareStmt.setString(1, u_name);
			prepareStmt.setString(2, u_pass);

			prepareStmt.executeUpdate();

			conn.close();
		} catch (Exception e) {
			System.err.println("Exception!");
			System.err.println(e.getMessage());
		}
	}

}