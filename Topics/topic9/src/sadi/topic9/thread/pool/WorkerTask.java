package sadi.topic9.thread.pool;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class WorkerTask implements Callable<Boolean>
{
	// use the Java system logger instead of println
	private Logger logger = Logger.getLogger(this.getClass().getName());

	private JTextArea textArea;

	public WorkerTask(JTextArea textArea)
	{
		this.textArea = textArea;
	}

	@Override
	public Boolean call()
	{
		Thread thisThread = Thread.currentThread();

		try
		{
			while (true)
			{
				// check to quit if we have called interrupted on this Thread
				if (thisThread != null && thisThread.isInterrupted())
				{
					// do tidy up first if necessary
					logger.log(Level.INFO, String.format(
							"Thread: %s isInterrupted()==%b", thisThread
									.getName(), thisThread.isInterrupted()));
					return false;
				}

				long start = System.nanoTime();
				// simulate complex calculation
				for (long l = 0; l < 1000000; l++)
					;
				long stop = System.nanoTime();

				// needs to be final to be visible to Runnable inner class below
				final String msg = "Calculation took: " + (stop - start)
						/ 1000000.0 + "ms";

				// the method as a Runnable that will update the UI
				Runnable uiUpdateRunnable = new Runnable()
				{
					public void run()
					{
						textArea.setText(msg);
					}

				};

				// setText() documented as thread safe in Java 6 but not Java 7!
				// seems to work but safest to invoke on UI thread as done below
				// textArea.setText(msg);

				// invoke on the original (UI) thread
				SwingUtilities.invokeLater(uiUpdateRunnable);

				logger.log(Level.INFO, "1");

				start = System.nanoTime();
				Thread.sleep(100);
				stop = System.nanoTime();
				logger.log(Level.INFO, String.format(
						"Thread: %s Slept: %.3f ms", thisThread.getName(), (stop
								- start) / 1000000.0));
			}
		}
		// exit if we are interrupted
		catch (InterruptedException ie)
		{
			// do tidy up first if necessary
			logger.log(Level.INFO, String.format(
					"Thread: %s caught InterruptedException", thisThread
							.getName()));
			return false;
		}
	}

}
