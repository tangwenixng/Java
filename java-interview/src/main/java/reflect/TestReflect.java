package reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class TestReflect {
	public static void main(String[] args) {
		TestReflect tr = new TestReflect();
		try {
			Class<?> cl = Class.forName("reflect.Person");
			tr.getConstruts(cl);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 给name属性 设值为 val
	 * @param cl
	 * @param name  属性/域
	 * @param val   值
	 */
	public void getField(Class<?> cl,String name,Object val){
		try {
			Field field = cl.getDeclaredField(name);
			field.setAccessible(true);
			Object object = cl.newInstance();
			field.set(object,val);
			System.out.println(field.get(object));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取所有域
	 * @param cl
	 */
	public void getFields(Class<?> cl){
		Field[] fields = cl.getDeclaredFields();
		for(Field field : fields){
			System.out.print(field.getName()+" ");
		}
	}
	
	public void getConstruts(Class<?> cl){
		Constructor<?>[] cs = cl.getDeclaredConstructors();
		try {
			Person person1 = (Person) cs[0].newInstance();
			Person person2 = (Person) cs[1].newInstance("twx",23);
			System.out.println(person1);
			System.out.println(person2);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		}
}
