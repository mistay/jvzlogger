package samplers;

import java.io.File;

import log.Log;
import helpers.Volkszaehler;
import config.Config;

public class Sampler extends Thread {

	@Override
	public void run() {

		while (true) {
			try {

				if (new File(Config.OnewireDir).exists()) {
					File[] files = new File(Config.OnewireDir).listFiles();

					for (File file : files) {
						if (new File(file + "/w1_slave").isFile()) {
							String filecontents = helpers.Easyfile
									.getFileContents(file + "/w1_slave");

							Float ret = null;
							if (filecontents.contains("YES")) {
								String SEARCHFOR = "t=";
								int start = filecontents.indexOf(SEARCHFOR);
								String value = filecontents.substring(start
										+ SEARCHFOR.length());

								ret = Float.parseFloat(value);
								ret /= 1000;

							}
							Log.info("sending sensor: " + file.getName()
									+ " with vz-uuid: f81d4fae-7dec-11d0-a7"
									+ file.getName() + " with value: "
									+ ret.toString());
							Volkszaehler.send(
									"f81d4fae-7dec-11d0-a7" + file.getName(),
									ret.toString());
						}
					}
				} else {
					Log.info("configured dir: " + Config.OnewireDir
							+ "does not exist.");
				}

			} catch (Exception e) {
				Log.debug("could not log value to vz: " + e.getMessage());
			}
			try {
				Thread.sleep(Config.Samplersleeptimeinseconds * 1000);
			} catch (Exception e) {
				Log.debug("could not sleep SamplerThread: " + e.getMessage());
			}
		}
	}
}
