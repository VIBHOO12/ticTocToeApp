import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ticTocToe2 {
	
	private JFrame frame;
	private JPanel[] panel = new JPanel[9];
	private JLabel label;
	private JButton[] buttons=new JButton[9];
	private JButton reset=new JButton("RESET");
	private JButton exit=new JButton("EXIT");
	private int player  =1;
	private boolean winner = false;
	private int count =0;
	public ticTocToe2() {
		frame = new JFrame("TIC TOC TOE");
		frame.setSize(550, 630);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
	private class TicListener implements ActionListener {
		
		private ImageIcon icon1 = new ImageIcon(getClass().getResource("images/user1.png"));
		private ImageIcon icon2 = new ImageIcon(getClass().getResource("images/user2.png"));
		public void actionPerformed(ActionEvent e) {
			
//			JOptionPane.showMessageDialog(null, "button clicked..");
			JButton bbButton = (JButton)e.getSource();
//			bbButton.setIcon(icon1);
			
			if(bbButton.getIcon()!=null || winner)
				return;
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
			findWinner();
			
			count++;
			if(count==9 && !winner)
			{
				gameOver();
				panel[0].setBackground(Color.red);
				label.setText("Game dran");
				label.setForeground(Color.white);
				JOptionPane.showMessageDialog(frame,"No Result");
				panel[1].setBackground(Color.yellow);
				
			}
		}
		
//		find winner
		private void findWinner() {
//			conditions for first player
			if(buttons[0].getIcon()==icon1 && buttons[1].getIcon()==icon1 && buttons[2].getIcon()==icon1 ) {
				callwinner(0, 1, 2);
			}
			if(buttons[3].getIcon()==icon1 && buttons[4].getIcon()==icon1 && buttons[5].getIcon()==icon1 ) {
				callwinner(3,4,5);
			}
			if(buttons[6].getIcon()==icon1 && buttons[7].getIcon()==icon1 && buttons[8].getIcon()==icon1 ) {
				callwinner(6,7,8);
			}
			
			if(buttons[0].getIcon()==icon1 && buttons[3].getIcon()==icon1 && buttons[6].getIcon()==icon1 ) {
				callwinner(0,3,6);
			}
			if(buttons[1].getIcon()==icon1 && buttons[4].getIcon()==icon1 && buttons[7].getIcon()==icon1 ) {
				callwinner(1,4,7);
			}
			if(buttons[2].getIcon()==icon1 && buttons[5].getIcon()==icon1 && buttons[8].getIcon()==icon1 ) {
				callwinner(2,5,8);
			}
			
//			diagonal
			if(buttons[0].getIcon()==icon1 && buttons[4].getIcon()==icon1 && buttons[8].getIcon()==icon1 ) {
				callwinner(0,4,8);
			}
			if(buttons[2].getIcon()==icon1 && buttons[4].getIcon()==icon1 && buttons[6].getIcon()==icon1 ) {
				callwinner(2,4,6);
			}
			
			
			
//		conditions for second player
			if(buttons[0].getIcon()==icon2 && buttons[1].getIcon()==icon2 && buttons[2].getIcon()==icon2 ) {
				callwinner(0, 1, 2);
			}
			if(buttons[3].getIcon()==icon2 && buttons[4].getIcon()==icon2 && buttons[5].getIcon()==icon2 ) {
				callwinner(3,4,5);
			}
			if(buttons[6].getIcon()==icon2 && buttons[7].getIcon()==icon2 && buttons[8].getIcon()==icon2 ) {
				callwinner(6,7,8);
			}
			
			if(buttons[0].getIcon()==icon2 && buttons[3].getIcon()==icon2 && buttons[6].getIcon()==icon2 ) {
				callwinner(0,3,6);
			}
			if(buttons[1].getIcon()==icon2 && buttons[4].getIcon()==icon2 && buttons[7].getIcon()==icon2 ) {
				callwinner(1,4,7);
			}
			if(buttons[2].getIcon()==icon2 && buttons[5].getIcon()==icon2 && buttons[8].getIcon()==icon2 ) {
				callwinner(2,5,8);
			}
			
//			diagonal
			if(buttons[0].getIcon()==icon2 && buttons[4].getIcon()==icon2 && buttons[8].getIcon()==icon2 ) {
				callwinner(0,4,8);
			}
			if(buttons[2].getIcon()==icon2 && buttons[4].getIcon()==icon2 && buttons[6].getIcon()==icon2 ) {
				callwinner(2,4,6);
			}

	} //end of find winner
		
		private void callwinner(int i, int j, int k) {
			
			winner = true;
			buttons[i].setBackground(Color.green);
			buttons[j].setBackground(Color.green);
			buttons[k].setBackground(Color.green);
			
			gameOver();
			if(player==2)
				JOptionPane.showMessageDialog(frame,"First player has won the game");
			else
				JOptionPane.showMessageDialog(frame,"Second player has won the game");
		}
		
		private void gameOver() {
			label.setText("Game is Over");
			panel[0].setBackground(Color.magenta);
			label.setForeground(Color.white);
			reset.setEnabled(true);
		}
			
			
	}// end of ticListener
	
	private class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			for(JButton button:buttons)
			{
				button.setIcon(null);
				button.setBackground(Color.yellow);
			}
			label.setText("First player turn...");
			label.setForeground(Color.blue);
			panel[0].setBackground(Color.cyan);
			player=1;
			count=0;
			winner=false;
			reset.setEnabled(false);
		}
	} // end of restetListener
	
	
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			int ch=JOptionPane.showConfirmDialog(frame,"Are to sure to exit?");
			if(ch==JOptionPane.YES_OPTION)
				System.exit(0);
		}
	}// end of exitListener



	private void addResetAndExitButton() 
	{
		panel[2].add(reset);
		panel[2].add(exit);
		Font font=new Font("arial",Font.PLAIN,20);
		reset.setFont(font);
		exit.setFont(font);
		exit.setForeground(Color.red);
		reset.setEnabled(false);
		reset.addActionListener(new ResetListener());
		exit.addActionListener(new ExitListener());
	}

	public static void main(String[] args) {
		new ticTocToe2();

	}

}




