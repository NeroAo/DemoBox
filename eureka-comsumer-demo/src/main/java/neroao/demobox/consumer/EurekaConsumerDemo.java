package neroao.demobox.consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableEurekaClient
@RestController
@EnableAutoConfiguration
public class EurekaConsumerDemo {

	private static final String SERVER_NAME = "eureka.client";

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/test")
	public String home() {
		String result = "";
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances(SERVER_NAME);
		if (!CollectionUtils.isEmpty(serviceInstances)) {
			ServiceInstance si = serviceInstances.get(0);
			try {
				result += getHttpResponse(si.getUri() + "/hello");
				return result;
			} catch (Exception e) {
				result += getHttpResponse(si.getUri() + "/cancel");
				e.printStackTrace();
			}
		}

		return result;
	}

	String getHttpResponse(String url) {
		String rtn = "";
		try {
			URL restServiceURL = new URL(url);

			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("Accept", "application/json");

			// if (httpConnection.getResponseCode() != 200) {
			// throw new RuntimeException(
			// "HTTP GET Request Failed with Error code : " +
			// httpConnection.getResponseCode());
			// }

			BufferedReader responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream())));

			String output;
			System.out.println("Output from Server:  \n");

			while ((output = responseBuffer.readLine()) != null) {
				System.out.println(output);
				rtn += output;
			}

			httpConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rtn;

	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaConsumerDemo.class).web(true).run(args);
	}
}
