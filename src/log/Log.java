package log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import config.Config;

public class Log {

	public static String LOGFILE = Config.LOGFILE;

	public static void info(String message) {
		if (Config.ENABLELOG) {
			try {
				FileWriter fileWritter = new FileWriter(Log.LOGFILE, true);
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

				DateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
				Date dateobj = new Date();

				bufferWritter.write(df.format(dateobj) + " " + message + "\n");
				bufferWritter.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void debug(String message) {
		info(message);
	}

}
