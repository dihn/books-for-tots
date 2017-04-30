package booksfortots;

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

public class BooksForTotsGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private static GridBagLayout layout;
	private static GridBagConstraints constraints;

	public static JTextField authortext, titletext, releasetext, conditionText;
	public static Book b = new Book();

	public int currentBookNum = 0;

	public BooksForTotsGUI() {
		this.setTitle("Books For Tots");
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		layout = new GridBagLayout();
		constraints = new GridBagConstraints();

		DatabaseConnect.connect("book");

		// set default constraints
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 50;
		constraints.weighty = 100;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.BOTH;

		// create GUI components
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(layout);

		JLabel titlelbl = new JLabel("Title");
		JLabel authorlbl = new JLabel("Author");
		JLabel conditionlbl = new JLabel("Condition");
		JLabel releaselbl = new JLabel("Release Date");
		JLabel loanlbl = new JLabel("Loan Date");
		JLabel returnlbl = new JLabel("Return Date");

		JTextField titletext = new JTextField(30);
		titletext.setText(b.getBookTitleAtIndex(currentBookNum));
		JTextField authortext = new JTextField(30);
		authortext.setText(b.getBookAuthorAtIndex(currentBookNum));
		JTextField releasetext = new JTextField(30);
		releasetext.setText(b.getBookReleaseDateAtIndex(currentBookNum));
		JTextField loantext = new JTextField(30);
		JTextField returntext = new JTextField(30);
		JTextField conditionText = new JTextField(30);
		conditionText.setText(b.getBookConditionAtIndex(currentBookNum));

		JButton prevbtn = new JButton("<");
		prevbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentBookNum > 0) {
					currentBookNum--;
					titletext.setText(b.getBookTitleAtIndex(currentBookNum));
					authortext.setText(b.getBookAuthorAtIndex(currentBookNum));
					releasetext.setText(b.getBookReleaseDateAtIndex(currentBookNum));
					conditionText.setText(b.getBookConditionAtIndex(currentBookNum));
				} else {
					JOptionPane.showMessageDialog(mainPanel, "Reached the lowest number of books", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});

		JButton nextbtn = new JButton(">");
		nextbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentBookNum < b.getNumBooks() - 1) {
					currentBookNum++;
					titletext.setText(b.getBookTitleAtIndex(currentBookNum));
					authortext.setText(b.getBookAuthorAtIndex(currentBookNum));
					releasetext.setText(b.getBookReleaseDateAtIndex(currentBookNum));
					conditionText.setText(b.getBookConditionAtIndex(currentBookNum));
				} else {
					JOptionPane.showMessageDialog(mainPanel, "Reached the highest number of books", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});

		JMenuBar menuBar;
		JMenu fileMenu, helpMenu;
		JMenuItem exitItem, addBookItem, aboutItem, deleteBookItem, logoutItem;

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		addBookItem = new JMenuItem("Add Book");
		addBookItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddBookGUI gui = new AddBookGUI();
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				b.emptyBookList();
				dispose();
			}

		});
		fileMenu.add(addBookItem);

		deleteBookItem = new JMenuItem("Delete Book");
		deleteBookItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titleToDelete = titletext.getText();
				b.deleteBook(titleToDelete);
				b.emptyBookList();
				BooksForTotsGUI gui = new BooksForTotsGUI();
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}

		});
		fileMenu.add(deleteBookItem);

		logoutItem = new JMenuItem("Logout");
		logoutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				b.emptyBookList();
				Login logingui = new Login();
				logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		fileMenu.add(logoutItem);

		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(mainPanel, "Are you sure you want to exit?", "Exit",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					System.exit(0);
				} else if (n == 1) {
				}
			}

		});
		fileMenu.add(exitItem);

		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		aboutItem = new JMenuItem("About");
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainPanel, "Created by:\nJoseph Tierney\nNikos Vourdanos\nEoghan de Bhal",
						"About", JOptionPane.PLAIN_MESSAGE);
			}

		});

		this.setJMenuBar(menuBar);

		mainPanel.add(titlelbl, constraints);
		constraints.gridwidth = 20;
		constraints.gridx = 5;
		mainPanel.add(titletext, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 2;
		mainPanel.add(authorlbl, constraints);
		constraints.gridwidth = 20;
		constraints.gridx = 5;
		mainPanel.add(authortext, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 3;
		mainPanel.add(conditionlbl, constraints);
		constraints.gridwidth = 20;
		constraints.gridx = 5;
		mainPanel.add(conditionText, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 4;
		mainPanel.add(releaselbl, constraints);
		constraints.gridwidth = 20;
		constraints.gridx = 5;
		mainPanel.add(releasetext, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 5;
		mainPanel.add(loanlbl, constraints);
		constraints.gridwidth = 20;
		constraints.gridx = 5;
		mainPanel.add(loantext, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 6;
		mainPanel.add(returnlbl, constraints);
		constraints.gridwidth = 20;
		constraints.gridx = 5;
		mainPanel.add(returntext, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 7;
		mainPanel.add(prevbtn, constraints);
		constraints.gridwidth = 20;
		constraints.gridx = 5;
		mainPanel.add(nextbtn, constraints);
		constraints.gridwidth = 1;
		constraints.gridx = 2;
		constraints.gridy = 8;

		this.add(mainPanel);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
