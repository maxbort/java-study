package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatWindow {

	private static final int SERVER_PORT = 8000;

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	private final Socket socket;
	private final PrintWriter pw;
	private final BufferedReader br;

	public ChatWindow(String name, Socket socket, BufferedReader br, PrintWriter pw) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
		this.br = br;
		this.pw = pw;
		
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				//System.out.println("click!!");
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(100); // 100자 까지 입력 가능
		// 단순 1회성 함수 호출을 위해선 이름 없이 클래스 생성(익명 클래스)활용
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
				//System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		new ChatClientThread().start();
		
	}
	
	private void sendMessage() {
		String message = textField.getText();
		if(message == null || "".equals(message)) {
			return;
		}
		
		ChatClientApp.log("SEND: " +message);
		
		if("quit".equals(message)) {
			finish();
			return;
		}
		
		if(message.startsWith("/passadmin")) {
			String[] input = message.split(" ");
			if(input != null && input.length >= 2) {
				pw.println("passadmin:" + input[1]);
				
				textField.setText("");
				textField.requestFocus();
		
				return;
			}
		}
		
		pw.println("message:" + message);
		
		textField.setText("");
		textField.requestFocus();
		
		
	}
	
	private void updateTextArea(String msg) {
		textArea.append(msg);
		textArea.append("\n");
		
	}
	
	//public void updateJoinList(String )
	private void finish() {
		System.exit(0);
	}
	

	private class ChatClientThread extends Thread{
		public void run() {
			try {
				while(true) {
					String res = br.readLine();
					ChatClientApp.log("RESPONSE : " + res);
					
					if(res == null) {
						System.out.println("서버와의 연결이 끊어졌습니다.");
						break;
					}
					
					String [] tokens = res.split(":", 2);
					if(tokens == null || tokens.length == 0) {
						continue;
					}
					
					if ("message".equals(tokens[0]) && tokens.length >= 2) {
						updateTextArea(tokens[1]);
					} else if ("join:ok".equals(res)) {
						updateTextArea("입장하였습니다. 즐거운 채팅 되세요~!");
					}
				}
			} catch(IOException e) {
				System.out.println(e.getMessage());
			}
	}	
	
}
}
