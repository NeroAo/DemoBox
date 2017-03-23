package neroao.demobox.fegin;

import neroao.demobox.eurekaclient.TestApi;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import feign.Feign;
import feign.Feign.Builder;
import feign.httpclient.ApacheHttpClient;
@RestController
public class TestService {
	//@Autowired
    private TestApi computeClient;
    
    private static final String SERVER_NAME = "eureka.client";

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping(value = "/gethello/{name}", method = RequestMethod.GET)
    public String getHello(@PathVariable("name") String name) {
		/*computeClient = Feign.builder().
				contract(new HystrixDelegatingContract(new SpringMvcContract())).target(TestServiceApi.class,"http://eureka.client");*/
		Builder feignBuilder= Feign.builder().decoder(new ResponseEntityDecoder(new SpringDecoder(new ObjectFactory<HttpMessageConverters>(){
			public HttpMessageConverters getObject() throws BeansException {
				return new HttpMessageConverters();
			}
		}))).client(new ApacheHttpClient()).contract(new SpringMvcContract());
		computeClient = feignBuilder.target(TestApi.class,discoveryClient.getInstances(SERVER_NAME).get(0).getUri().toString());
        return computeClient.testHello(name);
    }
}
