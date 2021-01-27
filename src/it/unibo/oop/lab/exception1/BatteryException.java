package it.unibo.oop.lab.exception1;

public class BatteryException extends IllegalStateException {

	private static final long serialVersionUID = 1L;
	private final double batteryLevel;
	private final double batteryRequired;
	
	public BatteryException(double blevel, double brequired) {
		super();
		this.batteryLevel = blevel;
		this.batteryRequired = brequired;
	}
	
	public String toString() {
		return "Can not move, battery level: " + batteryLevel + "\tbattery required: " + batteryRequired;
	}

	public String getMessage() {
		return this.toString();
	}

}
