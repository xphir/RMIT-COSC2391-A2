package mvc.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StatusBarPanel extends JPanel
{
	private JLabel statusLabel1 = new JLabel("status 1", JLabel.LEFT);
	private JLabel statusLabel2 = new JLabel("status 2", JLabel.CENTER);
	private JLabel statusLabel3 = new JLabel("status 3", JLabel.RIGHT);

	public StatusBarPanel()
	{
		setLayout(new GridLayout(1, 3));
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		statusLabel1.setBorder(blackBorder);
		statusLabel2.setBorder(blackBorder);
		statusLabel3.setBorder(blackBorder);

		add(statusLabel1);
		add(statusLabel2);
		add(statusLabel3);
	}
}
