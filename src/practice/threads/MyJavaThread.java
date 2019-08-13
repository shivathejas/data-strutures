package practice.threads;

public class MyJavaThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("thread is running");
		
			
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(i);
			}
		
		
		
	}
	public static void main(String[] args) {
		MyJavaThread myJavaThread1 = new MyJavaThread();
		MyJavaThread myJavaThread2 = new MyJavaThread();
		myJavaThread1.start();
		System.out.println(Thread.currentThread());
		Thread.currentThread().setName("myjavaThread 1");
		System.out.println(myJavaThread1.getName());
		
	}
}
