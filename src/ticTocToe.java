import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ticTocToe {
	
	private JFrame frame;
	private JPanel[] panel = new JPanel[9];
	private JLabel label;
	private JButton[] buttons=new JButton[9];
	private JButton reset=new JButton("RESET");
	private JButton exit=new JButton("EXIT");
	private int player  =1;
	public ticTocToe() {
		frame = new JFrame("TIC TOC TOE");
		frame.setSize(550, 630);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addPanel();
		frame.setVisible(true);
	}
	
	
	private void addPanel() {
		frame.setLayout(null);
		for(int i=0; i<panel.length; i++) {
			panel[i] = new JPanel();
			frame.add(panel[i]);
		}
		panel[0].setBounds(40,50,450,40);
		panel[0].setBackground(Color.blue);
		
		panel[1].setBounds(40,120,450,380);
		panel[1].setBackground(Color.yellow);
		
		
		panel[2].setBounds(40,530,450,40);
//		panel[2].setBackground(Color.blue);
		panel[2].setOpaque(false);
		addLabel();
	}
	
	
	private void addLabel() {
		label = new JLabel("First Player Turn...");
		panel[0].add(label);
		label.setFont(new Font("elephant", Font.PLAIN,30));
		label.setForeground(Color.cyan);
		addButtons();
		
	}
	private void addButtons() {
		panel[1].setLayout(new GridLayout(3,3));
		TicListener ticListener = new TicListener();
		for(int i=0;i<buttons.length;i++)
		{
			
			buttons[i]=new JButton();
			buttons[i].addActionListener(ticListener);
			buttons[i].setBackground(Color.yellow);
			panel[1].add(buttons[i]);
		}
		addResetAndExitButton();
	}
	
//	add listener
	public class TicListener implements ActionListener {
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("images/user1.png"));
		ImageIcon icon2 = new ImageIcon(getClass().getResource("images/user2.png"));
		public void actionPerformed(ActionEvent e) {
			
//			JOptionPane.showMessageDialog(null, "button clicked..");
			JButton bbButton = (JButton)e.getSource();
//			bbButton.setIcon(icon1);
			if(player == 1) {
				bbButton.setIcon(icon1);
				label.setText("Second Player Turn...");
				label.setForeground(Color.black);
				panel[0].setBackground(Color.white);
				player = 2;
			} 
			else if(player == 2) {
				bbButton.setIcon(icon2);
				label.setText("First Player Turn...");
				label.setForeground(Color.cyan);
				panel[0].setBackground(Color.blue);
				player = 1;
			} 
			
		}
	}

	private void addResetAndExitButton() 
	{
		panel[2].add(reset);
		panel[2].add(exit);
		Font font=new Font("arial",Font.PLAIN,20);
		reset.setFont(font);
		exit.setFont(font);
		exit.setForeground(Color.red);
		reset.setEnabled(false);
	}

	public static void main(String[] args) {
		new ticTocToe();

	}

}




