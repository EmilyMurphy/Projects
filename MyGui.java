package AssignmentJava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyGui extends JFrame implements ActionListener{
	
	/*
	JAVA Assignment - My Search Engine
	Author: Emily Murphy
	OS: MAC OSX
	Compiler: eclipse
	Due Date: 16-04-2018
	 */
	

	JButton Close;//for exit program
	JButton CloseBox;//to close search box
	JButton button1;//search
	JButton button2;//search new directory
	JButton button3;//delete search
	static JTextField f1;//take search parameters
	static JTextField f2;//specify directory to search
	static JTextArea textArea;//display results
	JFrame frame;//display textarea
	
	//GUI
	MyGui(String title) 
	{
		super(title);
		setSize(400,300);
		setLayout(new FlowLayout());
		

		
		//for default directory search
		button1 = new JButton("Search Default");
		add(button1);	
		button1.addActionListener(this);		
		setVisible(true);
	
		
		f1 = new JTextField("Enter Search Words ",15);
		add(f1);
		f1.addActionListener(this);
		f1.setToolTipText("Please enter term here");
		setVisible(true);

	
		//text area box
		frame = new JFrame ("Search");
		frame.setSize(500,500);
		frame.setResizable(false);
		
		textArea = new JTextArea();

		textArea.setSize(200,200);    

		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		
		//add scroll function 
		JScrollPane scroll = new JScrollPane (textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		frame.add(scroll);

		
		button3 = new JButton("Search New Directory");
		button3.addActionListener(this);
		add(button3);
		setVisible(true);
		
		
		f2 = new JTextField("/Users/default/Desktop/test");
		f2.addActionListener(this);
		f2.setToolTipText("Please enter term here");
		add(f2);
		setVisible(true);
		
		Close = new JButton("Exit Program");
		add(Close);
		Close.addActionListener(this);
		setVisible(true);
		
		button2 = new JButton("Delete Search");
		add(button2);
		button2.addActionListener(this);
		setVisible(true);
		
		CloseBox = new JButton("Close Search Results");
		add(CloseBox);
		CloseBox.addActionListener(this);
		setVisible(true);

			
	}

	@Override
	public void actionPerformed(ActionEvent e) {


			if(e.getSource() == button1)
			{
				//open textArea
				textArea.setVisible(true);
				frame.setVisible(true);
				//run the search with default directory
				AllFiles defaultdir = new AllFiles();				
				defaultdir.listFiles();
				

			}
			
			if(e.getSource() == button2)
			{
				//delete previous searches
				textArea.selectAll();
				textArea.replaceSelection(null);
			}
		
		

			
		
			if(e.getSource() == button3)
			{
				//open textArea
				textArea.setVisible(true);
				frame.setVisible(true);
				//run the search using new directory
				SelectFile test = new SelectFile();			
				test.StrongFiles();
			}
		
		
	
		
		
			if(e.getSource() == Close)
			{
			
				System.exit(0); //closes the Program
			}
			
			if(e.getSource() == CloseBox)
			{
			
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); //closes the TextArea Box
			}
			
	}
		
		
	

}
