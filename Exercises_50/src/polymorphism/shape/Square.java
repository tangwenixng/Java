//: polymorphism/shape/Square.java
package polymorphism.shape;

import static net.mindview.util.Print.*;

public class Square extends Shape {
	public void draw() {
		print("Square.draw()");
	}

	public void erase() {
		print("Square.erase()");
	}
	@Override
	public void printShape() {
		System.out.println("This is Square.java");
	}
} /// :~
