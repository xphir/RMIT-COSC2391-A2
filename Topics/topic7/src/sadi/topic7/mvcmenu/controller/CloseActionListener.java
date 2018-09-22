package sadi.topic7.mvcmenu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sadi.topic7.mvcmenu.view.MainAppFrame;

public class CloseActionListener implements ActionListener
{
   MainAppFrame frame;

   public CloseActionListener(MainAppFrame frame)
   {
      this.frame = frame;
   }

   @Override
   public void actionPerformed(ActionEvent arg0)
   {
      frame.closeDocument();
   }
}
