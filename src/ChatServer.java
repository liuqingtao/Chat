import java.io.*;
import java.net.*;
import java.util.*;
public class ChatServer {

	boolean bsCoonect = false;
	ServerSocket ss = null;
	 Client client = null;
	List<Client> clients = new ArrayList<Client>();
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
				 Socket s= ss.accept();
				 client = new Client(s);
				 clients.add(client);
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
		DataOutputStream out;
		private boolean bconnected =false;
		
		Client(Socket s){
			this.s = s;
			try {
				in = new DataInputStream(s.getInputStream());
				out = new DataOutputStream(s.getOutputStream());
				bconnected = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void send(String str) throws SocketException{
			try {
				out.writeUTF(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				clients.remove(this);
				System.out.println("对方退出了，我从List中删除了");
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
		try {
			while(bconnected){
				String str;
					str = in.readUTF();
//System.out.println(str);
					for(int i =0;i<clients.size();i++){
						Client c = clients.get(i);
						c.send(str);
					}
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
