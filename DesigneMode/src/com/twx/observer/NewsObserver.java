package com.twx.observer;

public class NewsObserver implements Observer {
	private Subject subject;
    public NewsObserver(Subject subject) {
    	this.subject = subject;
	}
	@Override
	public void update() {
		System.out.println(subject.getStatus()+",看新闻的同志请工作");
	}

}
