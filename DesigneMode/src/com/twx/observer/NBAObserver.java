package com.twx.observer;

public class NBAObserver implements Observer {
	private Subject subject;
    public NBAObserver(Subject subject) {
    	this.subject = subject;
	}
	@Override
	public void update() {
		System.out.println(subject.getStatus()+",看NBA的同志请工作");
	}

}
