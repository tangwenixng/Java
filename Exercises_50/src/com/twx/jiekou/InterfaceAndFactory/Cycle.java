package com.twx.jiekou.InterfaceAndFactory;

public interface Cycle {
	int getSpeed();
}
interface CycleFactory{
	Cycle getCycle();
}

class UniCycle implements Cycle{
	int speed=8;
	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		System.out.println("unicycle'speed is: "+speed);
		return this.speed;
	}
}
class Bicycle implements Cycle{
	int speed=20;
	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		System.out.println("bicycle is: "+speed);
		return this.speed;
	}
}
class Trycycle implements Cycle{
	int speed=31;
	@Override
	public int getSpeed() {
		System.out.println("trycycle is: "+speed);
		// TODO Auto-generated method stub
		return this.speed;
	}
}
class UniCycleFactory implements CycleFactory{
	@Override
	public Cycle getCycle() {
		return new UniCycle();
	}
}
class BicycleFactory implements CycleFactory{
	@Override
	public Cycle getCycle() {
		return new Bicycle();
	}
}
class TrycycleFactory implements CycleFactory{
	@Override
	public Cycle getCycle() {
		return new Trycycle();
	}
}

/*class CycleFactory{
	public Cycle getCycle(String str){
		if(str.equals("Unicycle")){
			return new UniCycle();
		}else if(str.equals("Bicycle")){
			return new Bicycle();
		}else if (str.equals("Trycycle")) {
			return new Trycycle();
		}else {
			return null;
		}
	}
}*/
