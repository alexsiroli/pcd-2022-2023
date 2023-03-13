package pcd.lab02.lost_updates;


public class Worker extends Thread {
	
	private final UnsafeCounter counter;
	private final int ntimes;
	private final Object lock;
	
	public Worker(UnsafeCounter c, int ntimes, Object lock){
		this.counter = c;
		this.ntimes = ntimes;
		this.lock = lock;
	}
	
	public void run(){
		for (int i = 0; i < this.ntimes; i++){
			synchronized (this.lock) {
				this.counter.inc();
			}
		}
	}
}
