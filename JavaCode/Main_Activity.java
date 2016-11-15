package floor1;

public class Main_Activity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Thread thread1 = new Thread(new GarageDoor1_Simulation());
		Thread thread2 = new Thread(new BackDoorLock_Simulation());
		Thread thread3 = new Thread(new FrontDoorLock_Simulation());
		Thread thread4 = new Thread(new GarageDoor2_Simulation());
		Thread thread5 = new Thread(new GarageDoorLock_Simulation());
		Thread thread6 = new Thread(new MotionDetectorMain_Simulation());
		Thread thread7 = new Thread(new MotionDetectorUp_Simulation());
		Thread thread8 = new Thread(new SecuritySystem_Simulation());
		Thread thread9 = new Thread(new DoorWindowMain_Simulation());
		Thread thread11 = new Thread(new SecuritySystem_Simulation());
		Thread thread10 = new Thread(new DoorWindowUp_Simulation());
		Thread thread12 = new Thread(new Thermostat());
		
		
		thread1.start();
		thread12.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		thread9.start();
		thread10.start();
		thread11.start();
		
		
		
		

	}

}
