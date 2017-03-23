package neroao.demobox.fegin;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Feign;

public class Test {
	
	/*interface TestApi {
		
		//@RequestLine("GET /test")
		@NeroOperation(value="/test",method = RequestMethod.GET)
		public String testHello();

	}
	
	public static void main(String[] args) {
		TestApi testApi = Feign.builder().target(TestApi.class,
                "http://localhost:9090");
		System.out.println(testApi.testHello());
	}*/

}
