package chat;

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

public class ChatClient {
	private static final int PORT = 8000;

	public static void main(String[] args) {
		Scanner sc = null;
		Socket socket = null;

		try {
			sc = new Scanner(System.in);
			socket = new Socket();
			// 서버에 소켓 연결 요청. 서버에서 요청 받고 accept 함수 이후로 과정 넘어감.
			socket.connect(new InetSocketAddress("0.0.0.0", PORT));

			// 서버로부터 데이터를 받아오는 BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
			// 서버에 데이터를 보내는 PrintWriter
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			System.out.print("닉네임>>");
			String nickname = sc.nextLine();
			pw.println("join:ok:" + nickname);

			// 서버로 메시지 받아 처리하는 스레드 start
			new ChatClientThread(br).start();

			while (true) {
				String str = sc.nextLine();

				if ("quit".equals(str)) {
					System.out.println("채팅을 종료합니다.");
					break;
				} else {
					pw.println("message:ok:"+ nickname + ":" + str);
				}
			}
		} catch (IOException e) {
			log(e.getMessage());
		} finally { // 자원 정리
			
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
				if (sc != null) {
					sc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String message) {
		System.out.println("[ChatClient] : " + message);
	}
}