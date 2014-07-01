import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ChatClient extends Frame{
	
	TextField tf = new TextField();
	TextArea ta = new TextArea();
	Socket s;
	DataOutputStream out =null;
	DataInputStream in = null;
	boolean bConnected =false;
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
				diconnect();
				System.exit(0);
			}
			
		});
		setVisible(true);
		connect();
		new Thread(new PrvThread()).start();
	}
	
	public void connect(){
		try{
			 s = new Socket("127.0.0.1",3385);
			 out =new DataOutputStream(s.getOutputStream());
			 in = new DataInputStream(s.getInputStream());
			 bConnected = true;
//System.out.println("connect");
		}catch(Exception e){
			System.out.println("error"+e);
		}
	}
	

	public void diconnect(){
		try {
			out.close();
			bConnected =false;
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private class tfActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ta.setText(tf.getText().trim());
			
			try {
				out= new DataOutputStream(s.getOutputStream());
				out.writeUTF(tf.getText().trim());
				out.flush();
				} catch (IOException e) {
				e.printStackTrace();
			}
			tf.setText("");
		} 
		
	}
	
	class PrvThread implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				while(bConnected){
					String str = in.readUTF();
					ta.setText(ta.getText() + str +"\n");
				}
			}catch(SocketException e){
				System.out.println("Quit");
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
}

