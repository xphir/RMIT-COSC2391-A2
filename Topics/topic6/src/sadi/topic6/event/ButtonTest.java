package sadi.topic6.event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class ButtonTest extends SimpleJFrame
{
   public ButtonTest()
   {
      // Event Source
      JButton button = new JButton("Press Me");
      // register a mouse listener
      ButtonMouseListener buttonMouseListener = new ButtonMouseListener();
      button.addMouseListener(buttonMouseListener);
      //button.addMouseMotionListener(buttonMouseListener);

      // register an action listener
      button.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            System.out.println("Action Event");
         }
      });
      add(button, BorderLayout.CENTER);
      super.showFrame();
   }

   public static void main(String[] args)
   {
      new ButtonTest();
   }
}

// if we make this implement MouseListener we must uncomment all the methods
//class ButtonMouseListener implements MouseListener
class ButtonMouseListener extends MouseAdapter
{
   // event handler method
   @Override
   public void mouseEntered(MouseEvent event) // Event object parameter (event)
   {
      System.out.println("Mouse Entered Button");
   }

   // event handler method
   @Override
   public void mouseExited(MouseEvent event)
   {
      System.out.println("Mouse Exited Button");
   }

   @Override
   public void mousePressed(MouseEvent event)
   {
      System.out.println("Mouse Pressed Button");
      System.out.println(event.getXOnScreen());
   }

   @Override
   public void mouseClicked(MouseEvent event)
   {
      System.out.println("Mouse Clicked Button");
   }

   @Override
   public void mouseReleased(MouseEvent event)
   {
      System.out.println("Mouse Released Button");
   }

   @Override
   public void mouseDragged(MouseEvent e)
   {
      System.out.println("Mouse Dragged");
   }
}
