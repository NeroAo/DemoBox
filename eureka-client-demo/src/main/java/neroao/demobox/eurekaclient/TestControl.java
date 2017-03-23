package neroao.demobox.eurekaclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControl implements TestApi {

	//@RequestMapping(value="/testhello/{name}", method=RequestMethod.GET)
	public String testHello(@PathVariable("name")String name) {
		// TODO Auto-generated method stub
		return "Hello world,"+name;
	}

}
