package frame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
	
	
	public ArrayList<String> readFile(){
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("Files/letter.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("\\s");
				for(String s : parts){
					list.add(s);
				}
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void setLabel(){
		final ArrayList<String> letter = readFile();
		label1.addKeyListener(new KeyListener(){
			String text="";
			String text1;
			Random n = new Random();
			int x;
			@Override
			public void keyPressed(KeyEvent e) {
					x = n.nextInt()%5+1;
				for(int i = 0;i<=x;i++){
					text = text + letter.toString();
					text1 = text.replace(',' ,' ');
					if(text1.contains("\n")){
						System.out.println("foundit");
					}
				}
				//System.out.println(text1);
				label1.setText("<html>"+text1+"</html>");
				
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
