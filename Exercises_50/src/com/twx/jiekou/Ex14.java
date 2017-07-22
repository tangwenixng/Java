package com.twx.jiekou;

interface Basketball{
	public void jump();
	void shot();
}
interface History{
	void read();
	void write();
}
interface Food{
	void eat();
	void cut();
}
interface Peple extends Basketball,History,Food{
	void sex();
}

class Book{
	private String name;
	private float price;
	public Book() {}
	public Book(String name) {
		this.name=name;
	}
	public float setPrice(float price){
		return this.price=price;
	}
	public void printMessage(){
		System.out.println("This book'name is"+name+" , price is :"+price);
	}
}
class Superman extends Book implements Peple{

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sex() {
		// TODO Auto-generated method stub
		
	}
	
}
public class Ex14 {
	public static void m1(Basketball btk) {
		
	}
	public static void m2(Food food) {
		food.eat();
	}
	public static void m3(History h) {
		
	}
	public static void m4(Peple peple) {
		
	}
	public static void main(String[] args) {
		Superman superman=new Superman();
		m1(superman);
		m2(superman);
		m3(superman);
		m4(superman);
	}
}

