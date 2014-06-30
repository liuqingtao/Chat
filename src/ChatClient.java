import java.awt.*;
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
		add(tf,BorderLayout.SOUTH);
		add(ta,BorderLayout.NORTH);
		tf.setBackground(Color.WHITE);
		ta.setBackground(Color.WHITE);
		pack();
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
			
		});
		setVisible(true);
	}

}


