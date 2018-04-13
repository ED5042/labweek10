package ie.ul.android.lab_week10;

public class Calculation {

    /** Dummy calculation to demonstrate GUI behaviour for long lasting operation
     *
     */
	public static void calc() {
        for (int i=0; i<50; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //do nothing
            }
        }

	}

}
