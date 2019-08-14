package practice.threads;

public class WorkThread implements Runnable{

	String message;
	public WorkThread(String message) {
		this.message=message;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName()+" (start) message= "+message);
		processMessage();
		System.out.println(Thread.currentThread().getName()+" (end)");
	}
	public void processMessage() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
