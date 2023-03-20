package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

public class Ponger extends Thread {

	Semaphore mutex;

	public Ponger(Semaphore mutex) {
		this.mutex = mutex;
	}

	public void run() {
		while (true) {
			try {
				this.mutex.acquire();
				System.out.println("pong!");
				sleep(500);
				this.mutex.release();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}