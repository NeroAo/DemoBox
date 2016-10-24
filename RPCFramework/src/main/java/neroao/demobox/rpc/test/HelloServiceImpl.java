package neroao.demobox.rpc.test;

public class HelloServiceImpl implements IHelloService {

	@Override
	public String hello(String name) {
		return "hello "+name;
	}

}
