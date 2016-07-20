package net.yunxi.dwl.concurrent;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory{

	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread thread=new Thread(r);
		thread.setDaemon(true);
		return thread;
	}

}
