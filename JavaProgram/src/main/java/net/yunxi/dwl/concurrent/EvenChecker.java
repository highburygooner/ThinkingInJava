package net.yunxi.dwl.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class EvenChecker implements Runnable{

	private IntGenerator generator;
	private final int id;
	public EvenChecker(IntGenerator g,int ident){
		this.generator=g;
		this.id=ident;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(!generator.isCanceled()){
			
			int val=generator.next();
			if(val%2!=0){
				System.out.println(val+" not even!");
				generator.cancel();
			}
					
		}	
	}
	
	
	public static void test(IntGenerator gp,int count){
		System.out.println("Press Control-C to exit");
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			exec.execute(new EvenChecker(gp, count));
		}
		exec.shutdown();
	}
	
	public static void test(IntGenerator gp){
		test(gp,10);
	}
	
	

}
