package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reader in = null;
		InputStream is = null;
		
		try {
			in = new FileReader("test.txt");
			is = new FileInputStream("test.txt");
			
			int cnt = 0;
			int data = -1;
		
			
			while((data = in.read()) != -1) {
				System.out.print((char) data);
				cnt++;
			}
			System.out.println();
			System.out.println(cnt);
			System.out.println("==========================");
			
			cnt = 0;
			data = -1;
			while((data = is.read()) != -1) {
				System.out.println(is.toString());
				System.out.print((char) data);
				cnt++;
			}
			System.out.println();
			System.out.println(cnt);
			
		}catch (FileNotFoundException e) {
			System.out.println("file not found: " + e);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
