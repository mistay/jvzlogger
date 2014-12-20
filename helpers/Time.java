package helpers;

public class Time {
	public int _hour;
	public int _minute;

	public Time(int hour, int minute) {
		_hour = hour;
		_minute = minute;
	}

	@Override
	public String toString() {
		return "Time [_hour=" + _hour + ", _minute=" + _minute + "]";
	}

}
