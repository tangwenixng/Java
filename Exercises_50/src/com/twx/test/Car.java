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
		���汣��       ����BUG
*/
//��Ի:    
//   д��¥��д�ּ䣬д�ּ������Ա��    
//   ������Աд�������ó��򻻾�Ǯ��    
//   ����ֻ���������������������ߣ�    
//   ��������ո��գ����������긴�ꡣ    
//   ��Ը�������Լ䣬��Ը�Ϲ��ϰ�ǰ��    
//   ���۱������Ȥ���������г���Ա��    
//   ����Ц��߯��񲣬��Ц�Լ���̫����    
//   ��������Ư���ã��ĸ���ó���Ա��
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
