import java.io.DataInputStream;
import java.io.EOFException;
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
