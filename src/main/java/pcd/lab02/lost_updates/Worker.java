package pcd.lab02.lost_updates;


public class Worker extends Thread {
	
	private UnsafeCounter counter;
	private Object lock;
	private int ntimes;
	
	public Worker(String name, UnsafeCounter counter, int ntimes, Object lock){
		super(name);
		this.counter = counter;
		this.ntimes = ntimes;
		this.lock = lock;
	}
	
	public void run(){
		log("started");
		for (int i = 0; i < ntimes; i++){
			synchronized(lock) {
				counter.inc();
			}
		}
		log("completed");
	}
	
	private void log(String msg) {
		System.out.println("[ " + this.getName() + "] " + msg);
	}
	
}
