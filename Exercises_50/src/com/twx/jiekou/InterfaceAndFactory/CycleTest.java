package com.twx.jiekou.InterfaceAndFactory;
/**
 * 
 * @author twx
 *
 */
public class CycleTest {
	public void process(CycleFactory cf){
		Cycle cycle = cf.getCycle();
		cycle.getSpeed();
	}
	public static void main(String[] args) {
		/*CycleFactory cf=new CycleFactory();
		Cycle cycle=cf.getCycle("Trycycle");
		System.out.println(cycle.getSpeed());*/
		CycleTest cycleTest=new CycleTest();
		cycleTest.process(new UniCycleFactory());
		cycleTest.process(new TrycycleFactory());
		cycleTest.process(new BicycleFactory());
	}
}
