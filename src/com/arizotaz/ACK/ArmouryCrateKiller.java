package com.arizotaz.ACK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.arizotaz.ACK.traybuttons.TrayClose;

public class ArmouryCrateKiller {
	
	TrayInterface tray;
	boolean runApp = true;
	public void RequestClose() {runApp = false;}
	
	boolean armouryOpened = false;
	boolean armouryWasOpen = false;
	
	public ArmouryCrateKiller() {
		
	}
	public void Setup() {
		CreateTray();
		tray.Add(new TrayClose());
	}
	public void Run() {
		while(runApp) {
			try {
				Thread.sleep(5000);
				armouryOpened = CheckForArmoury();
				System.out.println("Armoury Control Panel Open: " + armouryOpened);
				System.out.println("Armoury Control Panel Open on Last Check: " + armouryWasOpen);
				if (armouryOpened != armouryWasOpen) {
					armouryWasOpen = armouryOpened;
					if (!armouryOpened) {
						KillArmourySession();
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void Quit() {
		
	}
	
	private void CreateTray() {
		tray = new TrayInterface();
		tray.Setup();
	}
	private boolean CheckForArmoury() {
		boolean result = false;
		
		System.out.println("Checking for Armoury Crate Control Panel");
		String command="powershell -command \"TASKLIST /FI 'imagename eq armourycrate.exe'\"";
        try {
            @SuppressWarnings("deprecation")
			Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            
            String resultFromApp = "";
            String line;
            while ((line = reader.readLine()) != null) {
            	resultFromApp += line;
            }
            reader.close();

            result = resultFromApp.contains("ArmouryCrate.exe");

            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
		return result;
	}
	private void KillArmourySession() {
		System.out.println("Killing Armoury Session");
		
		String command="powershell -command \"TASKKILL /F /IM ArmouryCrate.UserSessionHelper.exe\"";
        try {
            @SuppressWarnings("deprecation")
			Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            
            String resultFromApp = "";
            String line;
            while ((line = reader.readLine()) != null) {
            	resultFromApp += line;
            }
            reader.close();

            System.out.println(resultFromApp);

            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}
}
