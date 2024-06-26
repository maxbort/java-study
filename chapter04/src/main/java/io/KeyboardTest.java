package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		
		try {
			// 1. 기반 스트림(표준 입력, stdin, System.in)
			// 2. 보조 스트림(byte|byte|byte -> char)
			InputStreamReader is = new InputStreamReader(System.in, "utf-8");
			
			// 3. 보조스트림02(char1|char2|char3 -> "char1char2char3")
			br = new BufferedReader(is);
			
			// 4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				if("quit".equals(line)) {
					break;
				}
				System.out.println(line);
			}
		} catch(IOException e) {
			System.out.println("error: " + e);
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
