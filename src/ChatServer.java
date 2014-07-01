import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
public class ChatServer {

	public static void main(String[] args) {
		boolean bCoonect;
		boolean bsCoonect = false;
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream in =null;
		try {
			
			ss= new ServerSocket(3385);
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			bsCoonect =true;
			while(bsCoonect){
				 bCoonect=false;
				 s= ss.accept();
				 in= new DataInputStream(s.getInputStream());
				bCoonect =true;
				while(bCoonect){
				String str = in.readUTF();
				System.out.println(str);
				}
				//in.close();
			}
				
		} catch (IOException e) {
			System.out.println("Cleint is closed");
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
