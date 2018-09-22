package mvc.view;

import javax.swing.JLabel;

import mvc.view.factory.ImageIconFactory;

public class CircleView extends JLabel
{
	public CircleView(int i)
	{
		// center the icon in the label
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);

		// get color from the ImageIconFactory
		setIcon(ImageIconFactory.getImageIcon(i));
	}
}
