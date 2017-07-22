package typeinfo;

//: typeinfo/ShowMethods.java
// Using reflection to show all the methods of a class,
// even if the methods are defined in the base class.
// {Args: ShowMethods}
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import net.mindview.util.Print;
/**
 * ����
 * @author twx
 *
 */
public class ShowMethods {
	private static String usage = "usage:\n" + "ShowMethods qualified.class.name\n"
			+ "To show all methods in class or:\n" + "ShowMethods qualified.class.name word\n"
			+ "To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.|(native)|(final)");

	public static void main(String[] args) {
		if (args.length < 1) {
			Print.print(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if (args.length == 1) {
				for (Method method : methods){
//					System.out.println(method.toString());
					Print.print(p.matcher(method.toString()).replaceAll("").replaceAll("\\s{1,}", " "));
				}
				for (Constructor ctor : ctors)
					Print.print(p.matcher(ctor.toString()).replaceAll(""));
				lines = methods.length + ctors.length;
			} else {
				for (Method method : methods)
					if (method.toString().indexOf(args[1]) != -1) {
						Print.print(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				for (Constructor ctor : ctors)
					if (ctor.toString().indexOf(args[1]) != -1) {
						Print.print(p.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
			}
		} catch (ClassNotFoundException e) {
			Print.print("No such class: " + e);
		}
	}
} 
