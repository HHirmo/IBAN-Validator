package main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI implements ActionListener {

	Iban iban = new Iban();

	private JPanel panel;
	private JFrame frame;
	private JLabel labelSingle;
	private JLabel response;
	private JLabel labelMultiple;
	private JLabel labelMultipleExample;
	private JLabel fileResponse;
	private JTextField ibanText;
	private JButton submitBtn;
	private JButton uploadBtn;
	private JFileChooser fileChooser;

	public GUI() {
		panel = new JPanel();
		frame = new JFrame();

		frame.setSize(650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("IBAN validator");
		frame.add(panel);

		panel.setLayout(null);

		labelSingle = new JLabel("Enter IBAN to validate");
		labelSingle.setBounds(10, 20, 180, 25);
		panel.add(labelSingle);

		ibanText = new JTextField(20);
		ibanText.setBounds(10, 45, 230, 25);
		panel.add(ibanText);

		submitBtn = new JButton("Validate");
		submitBtn.addActionListener(this);
		submitBtn.setBounds(250, 45, 100, 25);
		panel.add(submitBtn);

		response = new JLabel();
		response.setBounds(10, 70, 200, 25);
		panel.add(response);

		labelMultiple = new JLabel(
				"Upload a .txt file of IBANs separated by commas. All other non-alphanumeric characters will be ignored.");
		labelMultiple.setBounds(10, 110, 600, 15);
		panel.add(labelMultiple);

		labelMultipleExample = new JLabel("Example format: AA11111, AA22222, AA33333");
		labelMultipleExample.setBounds(10, 125, 300, 25);
		panel.add(labelMultipleExample);

		uploadBtn = new JButton("Upload");
		uploadBtn.addActionListener(this);
		uploadBtn.setBounds(10, 150, 100, 25);
		panel.add(uploadBtn);

		fileResponse = new JLabel();
		fileResponse.setBounds(10, 180, 600, 1000);
		fileResponse.setVerticalAlignment(SwingConstants.TOP);
		panel.add(fileResponse);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submitBtn) {
			if (iban.validate(ibanText.getText())) {
				response.setText("IBAN is possibly valid");
			} else {
				response.setText("IBAN is invalid");
			}
		}

		if (e.getSource() == uploadBtn) {
			fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt Files", "txt");
			fileChooser.setFileFilter(filter);
			int result = fileChooser.showOpenDialog(panel);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				fileResponse.setText(iban.validateFile(selectedFile));
			}
		}

	}

}
