package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

/**
 * Unsynchronized version
 *
 * @author aricci
 *
 */
public class TestPingPong {
	private static final Semaphore pingMutex = new Semaphore(0);
	private static final Semaphore pongMutex = new Semaphore(1);
	public static void main(String[] args) {
		new Pinger(pingMutex, pongMutex).start();
		new Ponger(pingMutex, pongMutex).start();
	}

}
