import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ChatClient extends Frame{
	
	TextField tf = new TextField();
	TextArea ta = new TextArea();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient().launchFrame();
		
	}
	
	public void launchFrame(){
		setLocation(400, 300);
		setSize(300,400);
		tf.addActionListener(new tfActionListener());
		add(tf,BorderLayout.SOUTH);
		add(ta,BorderLayout.NORTH);
		tf.setBackground(Color.WHITE);
		ta.setBackground(Color.WHITE);
		pack();
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		setVisible(true);
		connect();
	}
	
	public void connect(){
		try{
			Socket s = new Socket("127.0.0.1",3385);
System.out.println("connect");
		}catch(Exception e){
			System.out.println("error"+e);
		}
	}
	
	private class tfActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ta.setText(tf.getText().trim());
			tf.setText("");
		}
		
	}

}


