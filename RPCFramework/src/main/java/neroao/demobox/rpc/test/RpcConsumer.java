package neroao.demobox.rpc.test;

import neroao.demobox.rpcframework.RpcFramework;

public class RpcConsumer {
	public static void main(String[] args)throws Exception{
		IHelloService helloService = RpcFramework.refer(IHelloService.class, "127.0.0.1", 1234);
		for(int i=0 ; i <Integer.MAX_VALUE;i++){
			String hello = helloService.hello("World "+i);
			System.out.println(hello);
			Thread.sleep(1000);
		}
	}
}
