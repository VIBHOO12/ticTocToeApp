import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TicListener implements ActionListener {
	
	ImageIcon icon1 = new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2 = new ImageIcon(getClass().getResource("images/user2.png"));
	public void actionPerformed(ActionEvent e) {
		
//		JOptionPane.showMessageDialog(null, "button clicked..");
		JButton bbButton = (JButton)e.getSource();
//		bbButton.setIcon(icon1);
		
	}
}
