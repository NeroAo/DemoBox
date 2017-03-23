package neroao.demobox.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableAutoConfiguration
public class EurekaClientDemo {

	private static final String SERVER_NAME = "server-registry";

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/hello/{name}")
	public String home(@PathVariable String name) {
		return "Hello world"+name;
		/*String rtn = "";
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances(SERVER_NAME);
		if (!CollectionUtils.isEmpty(serviceInstances)) {
			ServiceInstance si = serviceInstances.get(0);
			try {
				rtn += getHttpResponse(si.getUri() + "/try");
				rtn += "</br>";
				rtn += getHttpResponse(si.getUri() + "/confirm");
				return rtn;
			} catch (Exception e) {
				rtn += getHttpResponse(si.getUri() + "/cancel");
				e.printStackTrace();
			}
		}

		return rtn;*/
	}

	/*String getHttpResponse(String url) {
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

	}*/

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaClientDemo.class).web(true).run(args);
	}
}
