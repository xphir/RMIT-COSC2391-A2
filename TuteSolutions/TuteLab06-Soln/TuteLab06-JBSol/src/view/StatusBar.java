package view;


import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class StatusBar extends JPanel
{
	private JLabel status1, status2, status3;
	
	public StatusBar()
	{
		status1 = new JLabel("selected colour", SwingConstants.LEFT);
		status2 = new JLabel("status 2", SwingConstants.CENTER);
		status3 = new JLabel("status 3", SwingConstants.RIGHT);
		Border border = BorderFactory.createRaisedBevelBorder();
		status1.setBorder(border);
		status2.setBorder(border);
		status3.setBorder(border);
		
		
		setLayout(new GridLayout(1, 3));
		// add three labels
		add(status1);
		add(status2);
		add(status3);
	}
}
