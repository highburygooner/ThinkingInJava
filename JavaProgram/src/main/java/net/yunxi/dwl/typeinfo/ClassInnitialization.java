package net.yunxi.dwl.typeinfo;

import java.util.Random;


class Initable{
	
	
	static final int staticFinal=47;
	static final int staticFinal2=ClassInnitialization.random.nextInt(1000);
	static{
		
		System.out.println("Initializing Initable");
	}
}


class Initable2{
	
	static int staticFinal=147;
	static{
		System.out.println("Initializing Initable2");
	}
	
}

class Initable3{
	
	static int staticFinal=74;
	static{
		
		System.out.println("Initializing Initable3");
	}
}


public class ClassInnitialization {

	static Random random=new Random(47);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class initable=Initable.class;
		System.out.println("After creating Initable ref");
		
		System.out.println(Initable.staticFinal);
		
		System.out.println(Initable.staticFinal2);
		
		System.out.println(Initable2.staticFinal);
		
		try {
			Class initable3=Class.forName("net.yunxi.dwl.typeinfo.Initable3");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After creating Initable3 ref");
		
		System.out.println(Initable3.staticFinal);
	}

}
