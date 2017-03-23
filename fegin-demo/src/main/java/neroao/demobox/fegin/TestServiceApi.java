package neroao.demobox.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient("eureka.client")
public interface TestServiceApi {
	
	@RequestMapping(method = RequestMethod.GET, value = "/test")
	String testHello();
}
