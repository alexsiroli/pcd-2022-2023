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
				sleep(500);
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				this.mutex.release();
			}
		}
	}
}