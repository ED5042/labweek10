package ie.ul.android.lab_week10;

public class CalculationThread extends Thread {

	private String fileLocation;
	
	public CalculationThread(String url) {
		fileLocation = url;
	}
	
	@Override
	public void run() {
		
		Calculation.calc();
	}

	
}
