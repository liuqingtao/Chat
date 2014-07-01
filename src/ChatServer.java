import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.*;
public class ChatServer {

	
	boolean bsCoonect = false;
	ServerSocket ss = null;
	Socket s = null;
	public static void main(String[] args) {
		new ChatServer().start();
	}

	public void start(){
try {
			
			ss= new ServerSocket(3385);
		}catch(BindException e){
			System.out.println("The port is using");
			System.out.println("Please close correlation procedure and return the server ");
			System.exit(0);
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			bsCoonect =true;
			while(bsCoonect){
				 s= ss.accept();
				 Client client = new Client(s);
				 new Thread(client).start();
					
			//in.close();
			}
				
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private class Client implements Runnable{
		Socket s;
		DataInputStream in;
		private boolean bconnected =false;
		Client(Socket s){
			this.s = s;
			try {
				in = new DataInputStream(s.getInputStream());
				bconnected =true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
		try {
			while(bconnected){
				String str;
					str = in.readUTF();
					System.out.println(str);
				}
			}catch(EOFException e){
				
				System.out.println("Cleint is closed");
			}
			catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(in != null) in.close();
					if(s!=null) s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
				
				
		}
		
	}
}
