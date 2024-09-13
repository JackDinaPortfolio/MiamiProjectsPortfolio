import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
	
	//Our counter
	private int count = 0;
	private JLabel counterLabel;
	private long startTime;
	
	// Constructor creates the GUi elements and displays them
	public GUI() {
		startTime = System.nanoTime();
		
		//One JFrame to hold everything:
		JFrame frame = new JFrame("Hello World!");
		
		//This says quit the program when the frame is closed.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200,300,500,500);
		
		//This panel will allow us to organize some GUI elements:
		JPanel mainPanel = new JPanel(new GridLayout(0,1));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		
		//Create some buttons and a label and add them to the panel (not the frame)
		JButton increase = new JButton("Increase");
		increase.addActionListener(new MyListener());
		mainPanel.add(increase);
				
		JButton decrease = new JButton("Decrease");
		decrease.addActionListener(new MyListener());
		mainPanel.add(decrease);
				
		counterLabel = new JLabel ("count = 0");
		mainPanel.add(counterLabel);
				
		//Panel now has two buttons and a label
				
				
		//for(int i = 1; i <= 50; i++) {
		//	mainPanel.add(new JButton("hi! (" + i + ")"));
		//}
				
		frame.add(mainPanel, BorderLayout.CENTER);
				
		//frame.add(new JColorChooser(), BorderLayout.EAST);
				
		//At this point all items have been added to the frame or panel(s)
		frame.pack();
		int x = (int) (500 * Math.random());
		int y = (int) (500 * Math.random());
		frame.setBounds(x, y, 200,200);
				
		//GridLayout allows you to specify rows OR columns
		//JPanel junk = new JPanel(new GridLayout(0,45));
		//for(int i = 1; i <= 16; i ++) {
		//	junk.add(new JButton(i + ""));
		//}
		//
		//frame.add(junk, BorderLayout.CENTER);
				
		frame.setVisible(true); //Do this part after all the setup is done
	}
	
	//This is an inner class. It is only needed by my GUI class so there is
	//no reason to make a separate class.
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//Code that should happen when button is clicked
			//Figure out which button was clicked
			if (e.getActionCommand().equals("Increase")) {
				System.out.println("Increase");
				//increase counter by one
				count++;
			} else {
				System.out.println("Decrease");
				//decrease counter by one
				count--;
			}
			
			//System.out.println(count);
			counterLabel.setText("Counter = " + count);
			
			if (count == 20) {
				System.out.println(System.nanoTime() - (startTime/1E9));
				System.exit(0);
			}
		}

	}
	
} // end class here
