package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {
	private final Socket socket; // 클라이언트와 연결할 소켓
	private final List<Writer> list; // 연결된 모든 클라이언트의 출력 스트림 목록

	private String nickname; // 클라이언트 닉네임

	public ChatServerThread(Socket socket, List<Writer> list) {
		this.socket = socket;
		this.list = list;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			// 클라이언트 주소랑 포트 얻어오고
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			ChatServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			// 입출력 스트림 세팅
			// 클라이언트로 부터 데이터 받아오는 br
			// 클라이언트에게 데이터를 보내는 pw
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			while (true) {
				String request = br.readLine();
				if (request == null) {
					ChatServer.log("Closed by Client");
					doQuit(pw);
					break;
				}

				// 프로토콜 분석 : 기준
				String[] tokens = request.split(":");
				String protocol = tokens[0];
				String status = tokens[1];
				String name = tokens[2];
				ChatServer.log(request);
				switch (protocol) {
				case "join":
					if (status.equals("ok")){
						doJoin(name, pw);
					}
					else {
						ChatServer.log("서버에 참가하지 못했습니다.");
						ChatClient.log("서버에 참가하지 못했습니다.");
					}
					break;
				case "message":
					if(status.equals("ok")) {
						doMessage(tokens[3]);
					}
					else {
						ChatServer.log("메시지 전송에 싪패하였습니다.");
					}
					break;
					
				case "quit":
					doQuit(pw);
					break;
				default:
					break;
				}
			}
		}catch (SocketException e){
			doQuit(pw);
			ChatServer.log(e.getMessage());
		}
		catch (IOException e) {
			doQuit(pw);
			ChatServer.log(e.getMessage());
		} catch (Exception e) {
			doQuit(pw);
			ChatServer.log(e.getMessage());
		}
		finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 클라이언트 종료 시 처리
	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = nickname +":님이 나가셨습니다..";
		ChatServer.log(data);
		broadcast(data);
	}

	// 클라이언트 나가면 제거
	private void removeWriter(Writer writer) {
		synchronized (list) {
			list.remove(writer);
		}
	}

	private void doMessage(String message) {
		String data = nickname + ":" + message;
		ChatServer.log(data);
		broadcast(data);
	}

	private void doJoin(String nickname, Writer writer) {
		this.nickname = nickname;

		
		ChatServer.log(nickname+"님이 참여");
		broadcast(nickname);

		addWriter(writer);
		

	}

	private void addWriter(Writer writer) {
		synchronized (list) {
			list.add(writer);
		}
	}

	private void broadcast(String data) {
		synchronized (list) {
			for (Writer writer : list) {
				PrintWriter printWriter = (PrintWriter) writer;
				String[] tokens = data.split(":");
				if(tokens.length <=1) {
					
					printWriter.println("join:ok:" + data);
				}
				else {
					if ("quit".equals(tokens[0])) {
						printWriter.println("quit:ok:" + data);

					}
					printWriter.println("message:ok:" + data);

				}
				printWriter.flush();
			}
		}
	}
}