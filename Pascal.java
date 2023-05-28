import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.Button;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Pascal {

	private JFrame frame;
	private JTextField insertNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pascal window = new Pascal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public static String  generateTriangle(int rows){
		StringBuilder triangleBuilder = new StringBuilder();

		int pascalArray[][] = new int[rows][rows];

		for (int i = 0; i<rows;i++){
			pascalArray[i][0] = 1;
		}

		for (int i = 1; i<rows;i++){
			pascalArray[i][i] = 1;
		}

		for(int i = 2;i<rows;i++){
			for(int j = 1; j<i;j++){
				pascalArray[i][j] = pascalArray[i-1][j-1] + pascalArray[i-1][j];
			}
		}

		for(int i = 0;i<rows;i++){
			for (int k = 0; k<rows-i;k++){
				triangleBuilder.append(" ");
			}


			for(int j = 0;j <= i;j++){
				triangleBuilder.append(pascalArray[i][j]).append(" ");
			}
			triangleBuilder.append("\n");

		}
		return triangleBuilder.toString();

	}



	/**
	 * Create the application.
	 */
	public Pascal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 483, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 459, 592);
		frame.getContentPane().add(layeredPane);
		CardLayout cardLayout = new CardLayout(0,0);
		layeredPane.setLayout(cardLayout);
		
		JPanel panelHome = new JPanel();
		layeredPane.add(panelHome, "1");
		panelHome.setLayout(null);
		
		Label ptgHeader = new Label("PASCAL TRIANGLE GENERATOR");
		ptgHeader.setFont(new Font("Dialog", Font.BOLD, 11));
		ptgHeader.setBounds(22, 10, 265, 22);
		panelHome.add(ptgHeader);
		
		Label defRowOne = new Label("is an arrangement of numbers in a triangular array such that");
		defRowOne.setBounds(38, 38, 385, 22);
		panelHome.add(defRowOne);
		
		Label bgRowOne = new Label("The elements of the nth row of Pascal's triangle");
		bgRowOne.setBounds(38, 125, 404, 22);
		panelHome.add(bgRowOne);
		
		Label bgRowTwo = new Label("are given by, nC0, nC1, nC2, ..., nCn.");
		bgRowTwo.setBounds(38, 153, 233, 22);
		panelHome.add(bgRowTwo);
		
		Label defRowTwo = new Label(" the numbers at the end of each row are 1 and the remaining");
		defRowTwo.setBounds(38, 66, 385, 22);
		panelHome.add(defRowTwo);
		
		Label defRowThree = new Label("numbers are the sum of the nearest two numbers in the above row. ");
		defRowThree.setBounds(38, 94, 385, 22);
		panelHome.add(defRowThree);
		
		Label formulaHeader = new Label("Formula:");
		formulaHeader.setFont(new Font("Dialog", Font.BOLD, 11));
		formulaHeader.setBounds(38, 198, 129, 22);
		panelHome.add(formulaHeader);
		
		Label formula = new Label("nCm = n-1Cm-1 + n-1Cm");
		formula.setFont(new Font("Dialog", Font.BOLD, 11));
		formula.setBounds(38, 226, 171, 22);
		panelHome.add(formula);
		
		Label MeaningOne = new Label("nCm represents the (m+1)th element in the nth row.");
		MeaningOne.setBounds(38, 254, 320, 22);
		panelHome.add(MeaningOne);
		
		Label MeaningTwo = new Label("n is a non-negative integer, and");
		MeaningTwo.setBounds(38, 282, 320, 22);
		panelHome.add(MeaningTwo);
		
		Label MeaningThree = new Label("0 ≤ m ≤ n");
		MeaningThree.setBounds(38, 310, 320, 22);
		panelHome.add(MeaningThree);
		
		insertNum = new JTextField();
		insertNum.setBounds(38, 378, 188, 32);
		panelHome.add(insertNum);
		insertNum.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnGenerate.setBounds(237, 378, 85, 32);
		panelHome.add(btnGenerate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnClear.setBounds(332, 378, 85, 32);
		panelHome.add(btnClear);
		
		JScrollPane scrollPascal = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPascal.setBounds(38, 440, 328, 100);
		panelHome.add(scrollPascal);
		
		JTextArea textArea_Pascal = new JTextArea();
		textArea_Pascal.setWrapStyleWord(true);
		textArea_Pascal.setLineWrap(true);
		textArea_Pascal.setEditable(true);
		textArea_Pascal.setBounds(new Rectangle(0, 0, 415, 400));
		scrollPascal.setViewportView(textArea_Pascal);


		btnGenerate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = insertNum.getText().toString();
				String displayResult = "";


				if(Integer.parseInt(input)<1){
					displayResult = "Input must be a positive integer";

				}
				else {
					displayResult = generateTriangle(Integer.parseInt(input));

				}

				textArea_Pascal.setText(displayResult);
			}
		});

		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textArea_Pascal.setText("");
			}
		});
     

	}
}