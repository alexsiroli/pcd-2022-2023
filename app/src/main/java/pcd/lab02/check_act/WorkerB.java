package pcd.lab02.check_act;

public class WorkerB extends Thread{
	
	private final Counter counter;
	private final int ntimes;
	
	public WorkerB(Counter c, int ntimes){
		this.counter = c;
		this.ntimes = ntimes;
	}
	
	public void run(){
		try {
			for (int i = 0; i < this.ntimes; i++){
				synchronized (this.counter) {
					if (this.counter.getValue() < 1) {
						this.counter.inc();
					}
				}
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
