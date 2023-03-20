package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

public class Ponger extends Thread {

	Semaphore pingMutex;
	Semaphore pongMutex;

	public Ponger(Semaphore ping, Semaphore pong) {
		this.pingMutex = ping;
		this.pongMutex = pong;
	}

	public void run() {
		while (true) {
			try {
				this.pongMutex.acquire();
				System.out.println("pong!");
				sleep(500);
				this.pingMutex.release();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}