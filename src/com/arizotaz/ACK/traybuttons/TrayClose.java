package com.arizotaz.ACK.traybuttons;

import java.awt.event.ActionEvent;

import com.arizotaz.ACK.Main;
import com.arizotaz.ACK.TrayEvent;

public class TrayClose extends TrayEvent {

	public TrayClose() {
		super("Quit");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Main.app.RequestClose();
	}

}
