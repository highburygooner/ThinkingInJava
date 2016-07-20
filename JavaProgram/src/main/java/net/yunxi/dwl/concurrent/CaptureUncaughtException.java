package net.yunxi.dwl.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class CaptureUncaughtException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec=Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread());
		
		try {
			TimeUnit.MILLISECONDS.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			//exec.shutdownNow();
		}
	}

}

class HandlerThreadFactory implements ThreadFactory{

	public Thread newThread(Runnable r) {
		Thread t=new Thread(r);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		return t;
	}
	
}

class MyUncaughtExceptionHandler implements UncaughtExceptionHandler{

	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.println("caught:"+e);
	}
	
}


class ExceptionThread implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		Thread t=Thread.currentThread();
		System.out.println("run() by "+t);
		System.out.println("eh= "+t.getUncaughtExceptionHandler());
		//throw new RuntimeException();
		int i=0;
		System.out.println(10/i);
	}
	
	
}