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

public class BooksForTotsGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GridBagLayout layout;
	private static GridBagConstraints constraints;

	public static JTextField authortext, titletext, releasetext;
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

		String[] conditionOptions = { "Excellent", "Good", "Poor" };
		JComboBox<String> conditionbox = new JComboBox<String>(conditionOptions);
		String item = b.getBookConditionAtIndex(currentBookNum);
		conditionbox.setSelectedItem(item);

		JButton prevbtn = new JButton("<");
		prevbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentBookNum > 0) {
					currentBookNum--;
					titletext.setText(b.getBookTitleAtIndex(currentBookNum));
					authortext.setText(b.getBookAuthorAtIndex(currentBookNum));
					releasetext.setText(b.getBookReleaseDateAtIndex(currentBookNum));
					String item = b.getBookConditionAtIndex(currentBookNum);
					conditionbox.setSelectedItem(item);
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
					String item = b.getBookConditionAtIndex(currentBookNum);
					conditionbox.setSelectedItem(item);
				} else {
					JOptionPane.showMessageDialog(mainPanel, "Reached the highest number of books", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});

		JMenuBar menuBar;
		JMenu fileMenu, helpMenu;
		JMenuItem menuItem;

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		menuItem = new JMenuItem("Add Book");
		fileMenu.add(menuItem);

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {

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
		fileMenu.add(menuItem);

		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		menuItem = new JMenuItem("About");
		helpMenu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
