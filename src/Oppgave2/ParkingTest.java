public class ParkingTest{
	public static void main(String[] args) {
		//Creates the counter
		Counter counter = new Counter(500);
		
		//Creates all the windows
		RoadGUI r1 = new RoadGUI(counter);
		RoadGUI r2 = new RoadGUI(counter);
		GuardGUI g1 = new GuardGUI(counter);
		GuardGUI g2 = new GuardGUI(counter);
		
		//Adding the RoadGUI as ChangeListeners to the Counter
		counter.addChangeListener(r1);
		counter.addChangeListener(r2);
	}
}