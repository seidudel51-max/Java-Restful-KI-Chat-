package RESTFULKICHAT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.ScrollPane;


public class View extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private ScrollPane scrollPane;
	private JButton btnNewButton;
	private ScrollPane scrollPane_1;
	private ScrollPane scrollPane_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try {
					View frame = new View();
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
	public View()
	{

		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getComboBox());
		contentPane.add(getLblNewLabel());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnNewButton());
		contentPane.add(getScrollPane_1());
		contentPane.add(getScrollPane_2());
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(50, 49, 208, 32);
		}
		return comboBox;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Verlauf:");
			lblNewLabel.setBounds(54, 32, 46, 14);
		}
		return lblNewLabel;
	}
	private ScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new ScrollPane();
			scrollPane.setBounds(325, 10, 386, 341);
		}
		return scrollPane;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.setBounds(665, 357, 46, 39);
		}
		return btnNewButton;
	}
	private ScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new ScrollPane();
			scrollPane_1.setBounds(363, 378, 334, 40);
		}
		return scrollPane_1;
	}
	private ScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new ScrollPane();
			scrollPane_2.setBounds(121, 200, 247, 116);
		}
		return scrollPane_2;
	}
}
