import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame frame = new MyFrame();
	}

}

class MyFrame extends Frame{
	MyFrame(){
		setLayout(null);
		setBounds(400,300,300,500) ;
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);				
			}
		});
		Panel p1 = new Panel();
		TextArea ta = new TextArea();
		ta.setBackground(Color.WHITE);
		p1.setBounds(0,0,300,300);
		TextField tf = new TextField("9999231");
		tf.setBounds(0,0,300,200);
		tf.setBackground(Color.WHITE);
		p1.add(ta);
		p1.add(tf);
		add(p1);
	}
	
	
}
