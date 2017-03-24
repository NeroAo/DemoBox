package neroao.demobox.eurekaclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControl implements TestApi {

	public String testHello(@PathVariable("name")String name) {
		return "Hello world,"+name;
	}

}
