package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import log.Log;

public class Config {
	// todo: load from db or wherever...

	public static String BASEURL = " http://vz.example.com/middleware.php/data/";

	public static boolean ENABLELOG = true;

	public static String CONFIGFILE = "/etc/jvzlogger.conf";

	public static int Samplersleeptimeinseconds = 5;
	public static String LOGFILE = " /var/log/jvzlogger.log";
	public static String OnewireDir = "/sys/bus/w1/devices";

	public static void load() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			System.out.println("reading config from " + CONFIGFILE);
			input = new FileInputStream(CONFIGFILE);

			// load a properties file
			prop.load(input);

			Samplersleeptimeinseconds = Integer.parseInt((prop
					.getProperty("Samplersleeptimeinseconds")));
			LOGFILE = (prop.getProperty("LOGFILE"));
			OnewireDir = (prop.getProperty("OnewireDir"));
			ENABLELOG = Boolean.parseBoolean((prop.getProperty("ENABLELOG")));
			System.out.println("ENABLELOG: " + ENABLELOG);
			System.out.println("LOGFILE: " + LOGFILE);

			Log.info("Samplersleeptimeinseconds: " + Samplersleeptimeinseconds);
			Log.info("OnewireDir: " + OnewireDir);

		} catch (Exception ex) {
			Log.info("could not load properties: " + ex.toString());
		}
	}
}
