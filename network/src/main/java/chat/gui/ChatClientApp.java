package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {
	private static final int PORT = 8000; 

	public static void main(String[] args) {
		
		String name = null;
		Scanner sc = new Scanner(System.in);
		Socket socket = null;
		
		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = sc.nextLine();
			
			if (name != null && !name.isEmpty()) {
				break;
			}	
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
			
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("0.0.0.0",PORT));
		
			// 서버로부터 데이터를 받아오는 BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
			// 서버에 데이터를 보내는 PrintWriter
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			
			String request = "join:ok:" + name;
			pw.println(request);
			
			while (true) {
				String response = br.readLine();
				if(response == null) {
					log("연결이 끊어졌습니다.");
					break;
				}
				ChatServer.log(response);
			//	if("join".equals(response)) {
					System.out.println(name + "채팅방에 입장하셨습니다.");
					new ChatWindow(name, socket, br, pw).show();
					break;
				//}
				
			}
			
		} catch(SocketException e) {
			log(e.getMessage());
		} catch(IOException e) {
			log(e.getMessage());
		} finally {
			sc.close();
		}
		
	
	}
	public static void log(String message) {
		System.out.println("[ChatClientApp] " + message);
	}

}
