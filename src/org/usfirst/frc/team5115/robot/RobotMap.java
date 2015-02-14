package org.usfirst.frc.team5115.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	
	//Chassis
	public static int leftMotor = 0;
	public static int rightMotor = 1;
	public static double autoSpeedShort = 0.3;
	public static double autoSpeedFar = 0.5;
	public static double speedFactor = .75;
	public static int leftEncoder1 = 0;
	public static int leftEncoder2 = 1;
	public static int rightEncoder1 = 2;
	public static int rightEncoder2 = 3;
	public static int toteDetector = 9;
	public static double circumference = 84.371;
	
	//Winch
	public static int winch = 2;
	public static int limitBottom = 6;
	//public static int ultrasonicTrigger = 7;
	//public static int ultrasonicEcho = 8;
	public static int ultrasonic = 7;
	public static double winchSpeed = 1;
	
	//Pneumatics
	public static int solForward = 7;
	public static int solReverse = 0;
	public static int armLength = 20;
	
	//Camera
	public static int gimbalX = 3;
	public static int gimbalY = 4;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
