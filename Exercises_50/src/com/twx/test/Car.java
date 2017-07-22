package com.twx.test;

//: reusing/Car.java
// Composition with public objects.


class Engine {
/*
		    _ooOoo_
		   o8888888o
		   88" . "88
		   (| -_- |)
		   O\  =  /O
		____/`---'\____
		.'  \\|     |//  `.
		/  \\|||  :  |||//  \
		/  _||||| -:- |||||-  \
		|   | \\\  -  /// |   |
		| \_|  ''\---/''  |   |
		\  .-\__  `-`  ___/-. /
		___`. .'  /--.--\  `. . __
		."" '<  `.___\_<|>_/___.'  >'"".
		| | :  `- \`.;`\ _ /`;.`/ - ` : | |
		\  \ `-.   \_ __\ /__ _/   .-` /  /
		======`-.____`-.___\_____/___.-`____.-'======
		    `=---='
		^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		佛祖保佑       永无BUG
*/
//佛曰:    
//   写字楼里写字间，写字间里程序员；    
//   程序人员写程序，又拿程序换酒钱。    
//   酒醒只在网上坐，酒醉还来网下眠；    
//   酒醉酒醒日复日，网上网下年复年。    
//   但愿老死电脑间，不愿鞠躬老板前；    
//   奔驰宝马贵者趣，公交自行程序员。    
//   别人笑我忒疯癫，我笑自己命太贱；    
//   不见满街漂亮妹，哪个归得程序员？
	public void start() {
	}

	public void rev() {
	}

	public void stop() {
	}
	public void service(){System.out.println("this is service method");}
}

class Wheel {
	public void inflate(int psi) {
	}
}

class Window {
	public void rollup() {
	}

	public void rolldown() {
	}
}

class Door {
	public Window window = new Window();

	public void open() {
	}

	public void close() {
	}
}

public class Car {
	private Engine engine = new Engine();
	private Wheel[] wheel = new Wheel[4];
	private Door left = new Door(), right = new Door(); // 2-door

	public Car() {
		for (int i = 0; i < 4; i++)
			wheel[i] = new Wheel();
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		car.left.window.rollup();
		car.wheel[0].inflate(72);
		car.engine.service();
	}
} /// :~
