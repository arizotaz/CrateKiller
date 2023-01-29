package com.arizotaz.ACK;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.net.URL;

public class TrayInterface {	
	public TrayInterface() {
		if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            System.exit(0);
        }
	}
	
	private final PopupMenu popup = new PopupMenu();
	private SystemTray tray = null;
	
	public void Setup() {
		if (tray != null) {
			System.out.println("Tray already exists");
			return;
		}
		if (!SystemTray.isSupported()) {
			System.out.println("SystemTray is not supported");
            return;
        }
        
        URL url = Options.class.getResource("/com/arizotaz/lumonality_tray.png");
        Image img = Toolkit.getDefaultToolkit().getImage(url);
        final TrayIcon trayIcon = new TrayIcon(img,"Armoury Crate Killer");
        tray = SystemTray.getSystemTray();
       
       
        trayIcon.setPopupMenu(popup);
       
        try {
            tray.add(trayIcon);
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("TrayIcon could not be added.");
        }
	}
	
	public void Add(TrayEvent trayButton) {
		Insert(trayButton, 0);
	}
	public void Insert(TrayEvent trayButton, int index) {
		MenuItem button = new MenuItem(trayButton.text);
		button.addActionListener(trayButton);
		popup.insert(button, index);
	}
	
	public void Seperate() {
		Seperate(0);
	}
	public void Seperate(int index) {
		popup.insertSeparator(index);
	}
}
