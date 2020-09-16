package main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import original.BoxInterface;

public class Application {

	public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		  BoxInterface b;
		  b =  (BoxInterface)tool.ClassTransformer.transform().getConstructor().newInstance();  	
		  System.out.println( b.getId() );
	}

}
