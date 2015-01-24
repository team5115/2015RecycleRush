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
	public static final int leftMotor = 0;
	public static final int rightMotor = 1;
	public static final double autoSpeed = 0.3;
	public static final double speedFactor = .75;
	public static final int leftEncoder1 = 0;
	public static final int leftEncoder2 = 1;
	public static final int rightEncoder1 = 2;
	public static final int rightEncoder2 = 3;
	public static final int toteDetector = 4;
	public static final double circumference = 84.371;
	
	//Winch
	public static final int winch = 2;
	public static final int limitTop = 5;
	public static final int limitBottom = 6;
	public static final int ultrasonicTrigger = 7;
	public static final int ultrasonicEcho = 8;
	public static final double winchSpeed = 1;
	
	//Pneumatics
	public static final int solForward = 7;
	public static final int solReverse = 0;
	public static final int armLength = 20;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
