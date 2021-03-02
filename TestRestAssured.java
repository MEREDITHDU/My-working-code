package test1;

import org.junit.Test;

public class Test1{
	@Test
	public void restTest() {
		Response response = RestAssured.get("https://httpbin.org/get");
	}
}

