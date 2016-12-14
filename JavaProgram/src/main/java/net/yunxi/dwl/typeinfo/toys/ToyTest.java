package net.yunxi.dwl.typeinfo.toys;
import static net.yunxi.dwl.util.Print.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
	
//	public Toy() {
//		// TODO Auto-generated constructor stub
//	}
	
	public Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
	
	
	public FancyToy() {
		super(1);
		// TODO Auto-generated constructor stub
	}
	
}

public class ToyTest {

	
	static void printInfo(Class cc){
		print("class name: "+cc.getName()+" is interface?["+cc.isInterface()+"]");
		print("Simple name: "+ cc.getSimpleName());
		print("Canonical name: "+cc.getCanonicalName());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class c=null;
		try {
			c=Class.forName("net.yunxi.dwl.typeinfo.toys.FancyToy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			print("Can not find FancyToy");
			e.printStackTrace();
		}
		printInfo(c);
		for(Class face:c.getInterfaces()){
			printInfo(face);
		}
		Class up=c.getSuperclass();
		printInfo(up);
		try {
			Constructor constructor=up.getConstructor(int.class);
			try {
				Object o=constructor.newInstance(1);
				printInfo(o.getClass());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Object o=up.newInstance();
			printInfo(o.getClass());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
