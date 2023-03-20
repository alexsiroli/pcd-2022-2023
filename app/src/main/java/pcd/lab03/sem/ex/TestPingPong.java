package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

/**
 * Unsynchronized version
 *
 * @author aricci
 *
 */
public class TestPingPong {
	private static final Semaphore mutex = new Semaphore(1, true);
	public static void main(String[] args) {
		new Pinger(mutex).start();
		new Ponger(mutex).start();
	}

}
