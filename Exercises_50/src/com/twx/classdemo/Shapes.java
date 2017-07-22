package com.twx.classdemo;

abstract class Shape {
	void draw() {
		System.out.println(this + ".draw()");
	}

	abstract public String toString();
}

class Circle extends Shape {
	public String toString() {
		return "Circle";
	}
}

class Square extends Shape {
	public String toString() {
		return "Square";
	}
}

class Triangle extends Shape {
	@Override
	public String toString() {
		return "Triangle";
	}
}

class Rhombus extends Shape {
	@Override
	public String toString() {
		return "Rhombus";
	}
}
/**
 * 第14章：练习3、4 <p>
 * 向上向下转型
 * @author twx
 *
 */
public class Shapes {
	public static void main(String[] args) {
		/*List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
		for (Shape shape : shapeList)
			shape.draw();*/
		Shape shape=new Circle();
		Object r=null;
		if(shape  instanceof Rhombus){
			r=(Rhombus) shape;
			
		}else if (shape instanceof Circle) {
			r=(Circle)shape;
		}
		System.out.println(r);
		
		/*Circle circle=(Circle) shape;
		System.out.println(circle);*/
	}
}