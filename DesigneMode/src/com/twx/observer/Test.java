package com.twx.observer;

public class Test {
    	public static void main(String[] args) {
		Subject boss = new BossSubject();
		
		NBAObserver nbaObserver = new NBAObserver(boss);
		boss.add(new NewsObserver(boss));
		boss.add(nbaObserver);
		
		boss.setStatus("老板回来了");
		
		boss.notifyObserver();
		/*boss.remove(nbaObserver);
		System.out.println("------------------");
		
		boss.notifyObserver();*/
	}
}
