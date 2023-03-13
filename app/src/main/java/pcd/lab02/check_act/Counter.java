package pcd.lab02.check_act;

public class Counter {

	private int cont;
	private final int min;
	private final int max;
	
	public Counter(int min, int max){
		this.cont = this.min = min;
		this.max = max;
	}
	
	public synchronized void inc() throws OverflowException {
		if (this.cont + 1 > this.max){
			throw new OverflowException();
		}
		this.cont++;
	}

	public synchronized void dec() throws UnderflowException {
		if (this.cont - 1 < this.min){
			throw new UnderflowException();
		}
		this.cont--;
	}
	
	public synchronized int getValue(){
		return this.cont;
	}
}
