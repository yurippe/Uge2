package Oppgave2;

import java.util.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Counter {
	private int value;
	
	private ArrayList<ChangeListener> listeners;
	
	public Counter(int initialValue) {
		value = initialValue;
		listeners = new ArrayList<ChangeListener>();
	}
	
	public void change(int diff) {
		value += diff;
		for(ChangeListener listener : listeners) {
			listener.stateChanged(new ChangeEvent(this));
		}
	}
	
	public int getValue() {
		return value;
	}
	
	public void addChangeListener(ChangeListener l) {
		listeners.add(l);
	}
	
	public void removeChangeListener(ChangeListener l) {
		listeners.remove(l);
	}
}