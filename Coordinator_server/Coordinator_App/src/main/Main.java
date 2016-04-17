package main;

import threads.ClientServer;
import threads.DriverServer;

public class Main {

	public static void main(String[] args) {
		ClientServer cs = new ClientServer();
		DriverServer ds = new DriverServer();
		
		cs.run();
		ds.run();

	}

}
