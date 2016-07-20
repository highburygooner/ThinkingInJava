package net.yunxi.dwl.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService exec=Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<10;i++){
			exec.execute(new DaemonFromFactory());
		}
		System.out.println("All deamons started");
		TimeUnit.MILLISECONDS.sleep(500);
		
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
	}

}
