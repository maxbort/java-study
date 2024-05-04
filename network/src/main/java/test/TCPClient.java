package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	private static String SERVER_IP = "127.0.0.1";
	private static int SERVER_PORT = 5000;
	public static void main(String[] args) {
		
		
		// 1. socket 생성
		Socket socket = null;
		
		try {
			socket = new Socket();
		
			
			int rcvBufferSize = socket.getSendBufferSize();
			int sndBufferSize = socket.getReceiveBufferSize();
			System.out.println(rcvBufferSize + ":" + sndBufferSize);
			
			// 1-2. 소켓 버퍼 사이즈 변경 (변경 가능하나 변경하지 않는 것 권장)(변경 주의깊게)
			socket.setReceiveBufferSize(1024 * 10);
			socket.setSendBufferSize(1024 * 10);;
			
		
			rcvBufferSize = socket.getSendBufferSize();
			sndBufferSize = socket.getReceiveBufferSize();
			System.out.println(rcvBufferSize + ":" + sndBufferSize);

			
			// 1-3. SO_NODELAY(Nagle 알고리즘 off)
			socket.setTcpNoDelay(true);
			
			// 1-4. SO_TIMEOUT
			socket.setSoTimeout(3000);

			
			// 2. 서버연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			// 3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			// 4. 쓰기
			String data = "Hello World";
			os.write(data.getBytes("utf-8"));
			
			// 5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if(readByteCount == -1) {
				System.out.println("[client] closed by server");
				return;
			}
			
//			socket.setSoTimeout(3000); // 읽기만 가능
			
			data = new String(buffer, 0, readByteCount, "utf-8"); 
			System.out.println("[client] received: " + data);
			
		} catch (SocketException e) {
			System.out.println("[client] timeout!!! "+ e);
		}
		catch (IOException e) {
			System.out.println("[client] error : " + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
