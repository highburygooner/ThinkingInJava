package net.yunxi.dwl.concurrent;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class TaskWithResult implements Callable{

	private int id;
	
	public TaskWithResult(int id) {
		super();
		this.id = id;
	}

	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println();
		return "Result of Task "+id;
	}
	
	
}

public class CallableDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exex=Executors.newCachedThreadPool();
		List<Future<String>> results=new ArrayList<Future<String>>();
		for(int i=0;i<10;i++){
			
			Future<String> result=exex.submit(new TaskWithResult(i));
			results.add(result);
		}
		for(Future<String> fs:results){
			try {
				System.out.println(fs.get());
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				exex.shutdown();
			}
			
		}
		
	}

}
