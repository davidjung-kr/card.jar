package unit;


import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static card.Utils.*;
import org.junit.Test;

import card.Utils;

public class UtilsFeature {

	@Test
	public void testSumForModulus() throws	NoSuchMethodException,
											SecurityException,
											IllegalAccessException,
											IllegalArgumentException,
											InvocationTargetException {
		Utils utilsClass = new Utils();
		Method method = utilsClass.getClass().getDeclaredMethod("sumForModulus", int.class);
		method.setAccessible(true);

		int x = (int) method.invoke(utilsClass, 12);
		assertEquals(x, 3);

		x = (int) method.invoke(utilsClass, 3);
		assertEquals(x, 3);
		
		x = (int) method.invoke(utilsClass, 10);
		assertEquals(x, 1);
		
		x = (int) method.invoke(utilsClass, 03);
		assertEquals(x, 3);

		x = (int) method.invoke(utilsClass, 4*2);
		assertEquals(x, 8);
		
		x = (int) method.invoke(utilsClass, 6*2);
		assertEquals(x, 3);
		
		x = (int) method.invoke(utilsClass, 0);
		assertEquals(x, 0);
	}
	
	@Test
	public void testEvenCheck() throws	NoSuchMethodException,
										SecurityException,
										IllegalAccessException,
										IllegalArgumentException,
										InvocationTargetException {
		Utils utilsClass = new Utils();
		Method method = utilsClass.getClass().getDeclaredMethod("evenCheck", int.class);
		method.setAccessible(true);

		boolean bool = (boolean) method.invoke(utilsClass, 12);
		assertEquals(true, bool);
		
		bool = (boolean) method.invoke(utilsClass, 3);
		assertEquals(false, bool);
	}
}
