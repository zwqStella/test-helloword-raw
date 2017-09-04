package test;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

import main.helloWorld.HelloWorld;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestHelloWorld extends TestCase{
	
	protected void setUp() throws Exception {
		super.setUp();
	}
		 
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testHelloWorld() {
		  try {
			  ServletRunner sr = new ServletRunner();
			  sr.registerServlet("HelloWorld", HelloWorld.class.getName());
			  ServletUnitClient sc = sr.newClient();
			  WebRequest request = new GetMethodWebRequest("http://localhost/HelloWorld");
			  WebResponse response = sc.getResponse(request);
			  Assert.assertTrue("hello world".equals(response.getText().trim()));
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
	}
	
}
