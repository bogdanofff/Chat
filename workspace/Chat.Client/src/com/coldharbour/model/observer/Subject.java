package com.coldharbour.model.observer;

public interface Subject {
//	public void registerObserver(Observer o);
//	public void removeObserver(Observer o);
	public void notifyObserver(String msg);

}
