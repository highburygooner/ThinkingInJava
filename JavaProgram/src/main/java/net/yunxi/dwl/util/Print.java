package net.yunxi.dwl.util;

import java.io.PrintStream;

public class Print {

	public static void print(Object o){
		System.out.println(o);
	}
	
	public static void print(){
		System.out.println();
	}
	
	public static void printnb(Object o){
		System.out.print(o);
	}
	
	public static PrintStream printf(String format,Object...args){
		
		return System.out.printf(format, args);
	}
	
}
