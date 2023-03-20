package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

public class Pinger extends Thread {

	Semaphore pingMutex;
	Semaphore pongMutex;

	public Pinger(Semaphore ping, Semaphore pong) {
		this.pingMutex = ping;
		this.pongMutex = pong;
	}	
	
	public void run() {
		while (true) {
			try {
				this.pingMutex.acquire();
				System.out.println("ping!");
				sleep(500);
				this.pongMutex.release();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}