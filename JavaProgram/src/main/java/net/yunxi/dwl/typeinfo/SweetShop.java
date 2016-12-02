package net.yunxi.dwl.typeinfo;
import static net.yunxi.dwl.util.Print.*;

class Candy{
	static{print("Loading Candy");}
}

class Gum{
	
	static{print("Loading Gum");}
}

class cookie{
	static {print("Loading Cookie");}
}

public class SweetShop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("inside main");
		new Candy();
		print("After creating Candy");
		try {
			Class.forName("net.yunxi.dwl.typeinfo.Gum");
		} catch (Exception e) {
			// TODO: handle exception
			print("could not found Gum");
		}
		print("After Class.forName(\"Gum\")");
		new cookie();
		print("After creating cookie");
	}

}
