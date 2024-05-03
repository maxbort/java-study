package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient {
	private static final int SERVER_PORT = 8088;

	public static void main(String[] args) {
		Scanner sc = null;
		Socket socket = null;

		try {
			sc = new Scanner(System.in);
			socket = new Socket();
			socket.connect(new InetSocketAddress("127.0.0.1", SERVER_PORT));

			// 서버로부터 데이터를 받아오는 BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
			// 서버에 데이터를 보내는 PrintWriter
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			System.out.print("닉네임>>");
			String nickname = sc.nextLine();
			pw.println("join:" + nickname);

			// 서버로 메시지 받아 처리하는 스레드 start
			new ChatClientThread(br).start();

			// 소켓 받고 대기
			Thread.sleep(1000);
			while (true) {
				String input = sc.nextLine();

				if ("quit".equals(input)) {
					System.out.println("채팅을 종료.");
					break;
				} else {
					pw.println("message:" + input);
				}
			}
		} catch (IOException e) {
			log("errer : " + e);
		} catch (InterruptedException e) {
			log("error : " + e);
		} finally {
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
		System.out.println("[ChatClient] " + message);
	}
}