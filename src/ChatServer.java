import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(3385);
			while(true){
				Socket s = ss.accept();
				DataInputStream in = new DataInputStream(s.getInputStream());
				String str = in.readUTF();
				System.out.println(str);
				in.close();
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
