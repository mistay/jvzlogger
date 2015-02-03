package helpers;

import config.Config;
import log.Log;

public class Volkszaehler {

	public static void send(String VZ_UUID, String value) {
		String result = Easyhttp.executeGet(Config.BASEURL + VZ_UUID
				+ ".json?operation=add&value=" + value);
	}
}
