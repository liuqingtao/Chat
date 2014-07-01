import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
public class ChatServer {

	public static void main(String[] args) {
		boolean bCoonect;
		boolean bsCoonect = false;
		try {
			
			ServerSocket ss = new ServerSocket(3385);
			bsCoonect =true;
			while(bsCoonect){
				 bCoonect=false;
				Socket s = ss.accept();
				DataInputStream in = new DataInputStream(s.getInputStream());
				bCoonect =true;
				while(bCoonect){
				String str = in.readUTF();
				System.out.println(str);
				}
				in.close();
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
