package booksfortots;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.DatabaseConnect;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

	JLabel userlbl = new JLabel("Username");
	JLabel passlbl = new JLabel("Password");
	JTextField usertxt = new JTextField();
	JTextField passtxt = new JTextField();
	JButton logbtn = new JButton("Login");
	JButton cancelbtn = new JButton("Cancel");
	JPanel myPanel = new JPanel();
	public GridBagConstraints constraints;
	public GridBagLayout grid;
	public static Login myFrame;
	// add a menu
	JMenuBar menuBar;
	JMenu fileMenu, helpMenu;
	JMenuItem menuItem1, menuItem2;

	public Login() {

		Container c = getContentPane();
		grid = new GridBagLayout();

		constraints = new GridBagConstraints();

		DatabaseConnect.connect("login");

		// set default constraints
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 10;
		constraints.weighty = 20;
		constraints.insets = new Insets(3, 3, 3, 3);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.BOTH;

		// set layout
		myPanel.setLayout(grid);

		myPanel.add(userlbl, constraints);
		constraints.gridwidth = 10;
		constraints.gridx = 5;
		myPanel.add(usertxt, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 2;
		myPanel.add(passlbl, constraints);
		constraints.gridwidth = 10;
		constraints.gridx = 5;
		myPanel.add(passtxt, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 3;
		myPanel.add(logbtn, constraints);
		constraints.gridwidth = 10;
		constraints.gridx = 5;
		myPanel.add(cancelbtn, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 4;

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		menuItem1 = new JMenuItem("Exit");
		fileMenu.add(menuItem1);

		menuItem2 = new JMenuItem("About");
		helpMenu.add(menuItem2);

		menuItem1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(myPanel, "Are you sure you want to exit?", "Exit",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					System.exit(0);
				} else if (n == 1) {
				}
			}

		});

		menuItem2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(myPanel, "Created by:\nJoseph Tierney\nNikos Vourdanos\nEoghan de Bhal",
						"About", JOptionPane.PLAIN_MESSAGE);
			}

		});

		this.setJMenuBar(menuBar);

		Font font1 = new Font("Verdana", Font.BOLD, 30);
		userlbl.setFont(font1);
		userlbl.setForeground(Color.CYAN);

		Font font2 = new Font("Verdana", Font.BOLD, 30);
		passlbl.setFont(font2);
		passlbl.setForeground(Color.CYAN);

		Font font3 = new Font("Verdana", Font.BOLD, 25);
		logbtn.setFont(font3);
		logbtn.setForeground(Color.CYAN);
		logbtn.setBackground(Color.BLACK);

		Font font4 = new Font("Verdana", Font.BOLD, 25);
		cancelbtn.setFont(font4);
		cancelbtn.setForeground(Color.CYAN);
		cancelbtn.setBackground(Color.BLACK);

		menuBar.setBackground(Color.BLACK);
		menuBar.setForeground(Color.CYAN);
		fileMenu.setForeground(Color.CYAN);
		helpMenu.setForeground(Color.CYAN);

		myPanel.setBackground(Color.darkGray);

		logbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userIn = usertxt.getText();
				String passIn = passtxt.getText();

				User u = new User();
				boolean loginCheck = u.checkLoginDetails(userIn, passIn);

				if (loginCheck == true) {
					if (userIn.equals("admin")) {
						dispose();
						AdminGUI gui = new AdminGUI();
						gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					} else {
						dispose();
						BooksForTotsGUI gui = new BooksForTotsGUI();
						gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}

				}
			}

		});

		c.add(myPanel);

		setTitle("Login");
		setSize(600, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
