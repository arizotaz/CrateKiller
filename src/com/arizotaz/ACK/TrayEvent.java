package com.arizotaz.ACK;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class TrayEvent implements ActionListener {
	String text = "Untitled";
	
	public TrayEvent(String text) {
		this.text = text;
	}
	
	public abstract void actionPerformed(ActionEvent e);
	

}
