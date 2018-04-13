package ie.ul.android.lab_week10;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button guiCalculateButton;
	Button threadCalculateButton;
	EditText ioField;
	ProgressBar myProgress;
	ProgressBar calcProgress;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		guiCalculateButton = (Button) findViewById(R.id.gui_calc_button);
		threadCalculateButton = (Button) findViewById(R.id.thread_calc_button);
		myProgress = (ProgressBar) findViewById(R.id.progressBar);
		calcProgress = (ProgressBar) findViewById(R.id.calculationProgress);
		guiCalculateButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), R.string.calcStarted, Toast.LENGTH_SHORT).show();
				for (int i = 0; i < 50; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						//do nothing
					}
				}
				Toast.makeText(getApplicationContext(), R.string.calcCompleted, Toast.LENGTH_SHORT).show();

			}

		});

		threadCalculateButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Calculation calculation = new Calculation();
				calculation.execute();
				
				/*
				 * Alternative method: using a new class which extends the Thread class.
				 */
				//CalculationThread calcThread = new CalculationThread();
				//calcThread.start();
				
				/*
				 * Alternative method: instantiate a new Thread object by passing a runnable object 
				 */
				/*
				new Thread(new Runnable() {

					@Override
					public void run() {
						Calculation.calc();
						
					}
					
				}).start();
				*/
			}

		});

		
		myProgress.setIndeterminate(true);
	}
	
	
	private class Calculation extends AsyncTask<> {
	    

		/**
		 * Dummy calculation (thread sleep) to demonstrate behaviour during processor intensive operations
		 * @param v
		 * @return
		 */
		@Override
	    protected Void doInBackground(Void... v) {

			publishProgress(50);
			return null;
	    }

		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}


		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result );
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			calcProgress.setProgress(values[0 ]);
		}
		
		
	}
	
	
}
