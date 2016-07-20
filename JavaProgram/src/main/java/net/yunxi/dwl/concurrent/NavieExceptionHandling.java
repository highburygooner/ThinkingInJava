package net.yunxi.dwl.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class ExecptionThread implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		System.out.println(10/i);
	}
	
}

public class NavieExceptionHandling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec=Executors.newCachedThreadPool();
		try {
			exec.execute(new ExecptionThread());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			exec.shutdownNow();			
		}							
	}

}
