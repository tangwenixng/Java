package com.twx.observer;
/**
 * 被观察对象
 * @author twx
 *
 */
public interface Subject {
	public void add(Observer observer);
	public void remove(Observer observer);
	public void notifyObserver();
	public String getStatus();
	public void setStatus(String status);
}
