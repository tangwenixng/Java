//: polymorphism/shape/Triangle.java
package polymorphism.shape;

import static net.mindview.util.Print.*;

public class Triangle extends Shape {
	public void draw() {
		print("Triangle.draw()");
	}

	public void erase() {
		print("Triangle.erase()");
	}
	@Override
	public void printShape() {
		System.out.println("This is Triangle.java");
	}
} /// :~
