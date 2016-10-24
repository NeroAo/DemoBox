package neroao.demobox.rpc.test;

import neroao.demobox.rpcframework.RpcFramework;

public class RpcProvider {
	
	public static void main(String[] args) throws Exception{
		IHelloService service = new HelloServiceImpl();
		RpcFramework.export(service, 1234);
	}
}
