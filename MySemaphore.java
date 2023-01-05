//Talia yarin bar zohar Id: 318257060  
//Sagi stav Id: 316584622
package assig3_2;
public class MySemaphore {
	
	private int tickets;
	
	public MySemaphore(int tickets) {
		this.tickets = tickets;
	}
	
	public synchronized void up() {
		tickets++;
		notifyAll();
	}
	
	public synchronized void down() { 
		while (tickets <= 0) {
			try {
				wait();
			} catch (Exception e) {}		
		}
		tickets--;
	}
}

    
	

