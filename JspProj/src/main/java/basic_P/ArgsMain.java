package basic_P;

import java.util.Arrays;

public class ArgsMain {

	public static void main(String[] args) {
		System.out.println("내가 argsMain " + args.length);
		
		System.out.println(Arrays.toString(args));
		
		for(String arg : args) System.out.println(arg);
		
		System.out.println("argsMain 끝");
	}

}
