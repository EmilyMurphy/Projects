package testcodeass;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import testcodeass.AllFiles;

public class MyGui extends JFrame implements ActionListener{
	/*
	JAVA First Draft - My Search Engine
	Emily Murphy
	*/
	
	JButton Choice1;
	JButton Choice2;
	
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	static JTextField f1;
	static JTextField f2;
	static JTextField f3;
	static JTextArea textArea;
	JFrame frame;
	
	MyGui(String title) 
	{
		super(title);
		setSize(400,300);
		setLayout(new FlowLayout());
		
		/*
		Choice1 = new JButton("Default Directory");
		add(Choice1);
		Choice1.addActionListener(this);
		setVisible(true);
		
		Choice2 = new JButton("Choose Directory");
		add(Choice2);
		Choice2.addActionListener(this);
		setVisible(true);
		*/
		
		//for default directory search
		button1 = new JButton("Search Default");
		add(button1);	
		button1.addActionListener(this);		
		setVisible(true);
	
		
		f1 = new JTextField("Enter words");
		add(f1);
		f1.addActionListener(this);
		f1.setToolTipText("Please enter term here");
		setVisible(true);

		
		button2 = new JButton("Delete Search");
		add(button2);
		button2.addActionListener(this);
		setVisible(true);

		
		/*
		//for choose directory search
		button4 = new JButton("Search");
		add(button4);	
		button4.addActionListener(this);		
		//setVisible(true);
		
		
		f3 = new JTextField("Enter words");
		add(f3);
		f3.addActionListener(this);
		f3.setToolTipText("Please enter term here");
		//setVisible(true);
		*/
		
		
		//text area box
		frame = new JFrame ("Test");
		frame.setSize(500,500);
		frame.setResizable(false);
		
		textArea = new JTextArea();
		textArea.setSize(400,400);    

		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setVisible(true);
		
		//add scroll function 
		JScrollPane scroll = new JScrollPane (textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		frame.add(scroll);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		 
		
		button3 = new JButton("Search New Directory");
		button3.addActionListener(this);
		add(button3);
		setVisible(true);
		
		
		f2 = new JTextField("/Users/default/Desktop/test");
		f2.addActionListener(this);
		f2.setToolTipText("Please enter term here");
		add(f2);
		setVisible(true);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//if (e.getSource() == Choice1)
		//{

			if(e.getSource() == button1)
			{


				AllFiles defaultdir = new AllFiles();				
				defaultdir.listFiles();
				

			}
			
			if(e.getSource() == button2)
			{
				textArea.selectAll();
				textArea.replaceSelection(null);
			}
		
		
		
		//}

			
		//if (e.getSource() == Choice2)
		//{
			
		
			if(e.getSource() == button3)
			{
			
				SelectFile test = new SelectFile();			
				test.StrongFiles();
			}
		
		
		//}
		
		
	}
		
		
	

}
