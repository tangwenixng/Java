package com.twx.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者 是  老板
 * @author twx
 *
 */
public class BossSubject implements Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	private String status;
	@Override
	public void add(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for(Observer observer: observers)
			observer.update();
	}
	@Override
	public String getStatus(){
		return status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

}
