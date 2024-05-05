package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 8000;
	// 연결된 클라이언트의 writer 객체들 관리 리스트
	private static List<Writer> list = new ArrayList<>();

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			// 서버 소켓 설정
			serverSocket = new ServerSocket();
			// 로컬 호스트 주소 가져옴
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			// 서버 소켓 바인드
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("연결 대기중.. " + hostAddress + ":" + PORT);

			while (true) {
				// 클라이언트 연결시 소켓 받아옴. blocking -> 클라이언트가 연결을 요청 시 까지 대기.
				Socket socket = serverSocket.accept(); 
				// 받아온 소켓으로 새 스레드 시작
				new ChatServerThread(socket, list).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String message) {
		System.out.println("[ChatServer]: " + message);
	}
}