package com.arizotaz.ACK;

public class Main {
	public static ArmouryCrateKiller app;
	public static void main(String[] args) {
		app = new ArmouryCrateKiller();
		app.Setup();
		System.out.println("Setup");
		app.Run();
		System.out.println("Closing");
		app.Quit();
		System.out.println("Done");
		System.exit(0);
		//TASKLIST /FI "imagename eq armourycrate.exe"
	}
}
