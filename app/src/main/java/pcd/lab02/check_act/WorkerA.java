package pcd.lab02.check_act;

public class WorkerA extends Thread{
	
	private final Counter counter;
	private final int ntimes;
	
	public WorkerA(Counter c, int ntimes){
		this.counter = c;
		this.ntimes = ntimes;
	}
	
	public void run(){
		try {
			for (int i = 0; i < this.ntimes; i++){
				synchronized (this.counter) {
					if (this.counter.getValue() > 0) {
						this.counter.dec();
					}
				}
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
