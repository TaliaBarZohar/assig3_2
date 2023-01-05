//Talia yarin bar zohar Id: 318257060  
//Sagi stav Id: 316584622

package assig3_2;

public class HeavyWorker {
	//Semaphore with 3 permits
	MySemaphore mySemaphore1 = new MySemaphore (3);
	//Semaphore with 1 permit
	MySemaphore mySemaphore2 = new MySemaphore (1);
	//Semaphore with 0 permit
	MySemaphore mySemaphore3 = new MySemaphore (0);
	
	
	public void section1() {
		
		System.out.println(Thread.currentThread().getName() + " is in section1");
		try {
			/* sleep to simulate some work... */
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + " leaving section1");
	}
	
	public void section2() {
		System.out.println(Thread.currentThread().getName() + " is in section2");
		try {
			/* sleep to simulate some work... */
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + " leaving section2");
	}
	
	public void workA() {
		System.out.println(Thread.currentThread().getName() + " doing workA");
		
		/* section1() can be called from up to 3 threads at the same time */
		mySemaphore1.down();
		section1();
		/* section2() can be called from one thread out of the 3 above    */	
		mySemaphore2.down();
		section2();
		mySemaphore2.up();
		mySemaphore1.up();
		mySemaphore3.up();
		
	}
	
	public void workB() {

		/* this will be printed only after workA() done at least once */
		mySemaphore3.down();
		System.out.println(Thread.currentThread().getName() + " doing workB");
		mySemaphore3.up();
	}
}
