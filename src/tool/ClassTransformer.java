package tool;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtNewConstructor;
import javassist.NotFoundException;

public class ClassTransformer {
	
	
	public static Class<?> transform() throws NotFoundException, IOException, CannotCompileException {
		
		// Get the class manipulation tool = pool
		ClassPool pool = ClassPool.getDefault();
    
    // in case the classes are not found
		pool.appendClassPath("/Users/alexander/eclipse-workspace/CodeTransform/bin");
		
		// load the desired class
		CtClass cc = pool.get("original.Box");
    
    // find the default constructor
		CtConstructor ccon= cc.getDeclaredConstructor(null);
    // remove it
		cc.removeConstructor(ccon);

    // create a new default constructor
		CtConstructor cstructor = CtNewConstructor.defaultConstructor( cc	) ;
    // modify the constructor behaviour
		cstructor.setBody( "this.id = 100;");
		// add the constructor to the class
		cc.addConstructor(cstructor);
    // return the modified class
		return cc.toClass();
		
	}
	
}

