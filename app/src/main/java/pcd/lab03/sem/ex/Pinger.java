package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

public class Pinger extends Thread {

	Semaphore mutex;

	public Pinger(Semaphore mutex) {
		this.mutex = mutex;
	}	
	
	public void run() {
		while (true) {
			try {
				this.mutex.acquire();
				System.out.println("ping!");
				Thread.sleep(500);
				this.mutex.release();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}