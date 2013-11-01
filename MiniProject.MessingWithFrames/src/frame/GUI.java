package frame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class GUI {
	JLabel label1;
	
	
	public GUI(){
		JFrame frame = new JFrame();
		label1 = new JLabel();
		label1.setFocusable(true);
		label1.setPreferredSize(new Dimension(480,640));
		label1.setVerticalAlignment(SwingConstants.TOP);
		frame.add(label1);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public void setLabel(){
		
		label1.addKeyListener(new KeyListener(){
			String text="";
			Random n = new Random();
			int x;
			@Override
			public void keyPressed(KeyEvent e) {
				x = n.nextInt()%10+1;
				if(x<7&&x>3)
					text = text +"<br>";
				for(int i = 0;i<x;i++){
					text = text + " blah";
				}
				label1.setText("<html>"+text+"</html>");
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
