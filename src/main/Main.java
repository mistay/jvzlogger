package main;

import config.Config;
import samplers.Sampler;
import log.Log;

public class Main {
	public static String VERSION = "20150203";

	private Main() {
		System.out.println("starting jheating v" + VERSION
				+ ". logging to logfile: " + Log.LOGFILE);

		Config.load();

		Log.info("starting jvzlogger.");

		Sampler s = new Sampler();
		s.start();
	}

	public static void main(String args[]) {
		new Main();
	}
}
