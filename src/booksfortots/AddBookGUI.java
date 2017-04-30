package booksfortots;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.DatabaseConnect;

public class AddBookGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private static GridBagLayout layout;
	private static GridBagConstraints constraints;

	public static JTextField authortext, titletext, releasetext;

	public AddBookGUI() {
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
		JTextField authortext = new JTextField(30);
		JTextField releasetext = new JTextField(30);
		JTextField loantext = new JTextField(30);
		JTextField returntext = new JTextField(30);

		String[] conditionOptions = { "Excellent", "Good", "Poor" };
		JComboBox<String> conditionbox = new JComboBox<String>(conditionOptions);

		JButton addBtn = new JButton("Add Book");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String bookTitle, bookAuthor, bookPublisher, bookCondition, bookReleaseDate;
				bookTitle = titletext.getText();
				bookAuthor = authortext.getText();
				bookPublisher = releasetext.getText();
				bookCondition = "Excellent";
				bookReleaseDate = releasetext.getText();
				Book b = new Book();
				if(b.checkTitleExists(bookTitle)){
					b.addNewBook(bookTitle, bookAuthor, bookPublisher, bookCondition, bookReleaseDate);
					JOptionPane.showMessageDialog(mainPanel, "Book added", "Book Added", JOptionPane.PLAIN_MESSAGE);
					BooksForTotsGUI gui = new BooksForTotsGUI();
					gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dispose();
				} else {
					JOptionPane.showMessageDialog(mainPanel, "Book not added. Title already exists", "Book not Added", JOptionPane.PLAIN_MESSAGE);
				}
			}

		});

		JMenuBar menuBar;
		JMenu fileMenu, helpMenu;
		JMenuItem closeItem, aboutItem, logoutItem;

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		logoutItem = new JMenuItem("Logout");
		logoutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Book b = new Book();
				b.emptyBookList();
				Login logingui = new Login();
				logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		fileMenu.add(logoutItem);

		closeItem = new JMenuItem("Close");
		closeItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BooksForTotsGUI gui = new BooksForTotsGUI();
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}

		});
		fileMenu.add(closeItem);

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
		mainPanel.add(conditionbox, constraints);
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
		mainPanel.add(addBtn, constraints);

		this.add(mainPanel);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

}
