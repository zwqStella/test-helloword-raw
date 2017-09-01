package junit;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class TestHelloWorld {
	
	@Test
	public void test(){
		try {
			String result = sendGet("http://127.0.0.1:9080/test/hello");
			assertEquals(result, "hello world");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String sendGet(String url) throws IOException{
		URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.connect();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String result = "";
        String line;
        while ((line = in .readLine()) != null) {  
            result += line;  
        }
        return result;
	}
}
