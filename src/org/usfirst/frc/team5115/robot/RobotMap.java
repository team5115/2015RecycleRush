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
	public static final double throttleInterval = 0.1;
	
	//Winch
	public static final int winch = 2;
	public static final int limitTop = 0;
	public static final int limitBottom = 1;
	public static final double winchSpeed = 0.1;
	
	//Pneumatics
	public static final int solForward = 0;
	public static final int solReverse = 1;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
