package main;

import config.Config;
import samplers.Sampler;
import helpers.Easyfile;
import log.Log;

public class Main {
	private Main() {

		Config.load();

		Log.info("starting jvzlogger.");

		Sampler s = new Sampler();
		s.start();
	}

	public static void main(String args[]) {
		new Main();
	}
}
