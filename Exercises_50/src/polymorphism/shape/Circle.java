//: polymorphism/shape/Circle.java
package polymorphism.shape;

import static net.mindview.util.Print.*;

public class Circle extends Shape {
	@Override
	public void draw() {
		print("Circle.draw()");
	}
	@Override
	public void erase() {
		print("Circle.erase()");
	}
	@Override
	public void printShape() {
		System.out.println("This is Circle.java");
	}
} /// :~
