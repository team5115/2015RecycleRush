
package org.usfirst.frc.team5115.robot.subsystems;

import org.usfirst.frc.team5115.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Winch extends Subsystem {
	
	private Victor winchMotor;
	private DigitalInput limitTop;
	private DigitalInput limitBottom;
	private Ultrasonic ultra;
	public int dir = 1;
	
	public Winch() {
		winchMotor = new Victor(RobotMap.winch);
		limitTop = new DigitalInput(RobotMap.limitTop);
		limitBottom = new DigitalInput(RobotMap.limitBottom);
		ultra = new Ultrasonic(RobotMap.ultrasonicTrigger, RobotMap.ultrasonicEcho);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	// returns a boolean for if it has hit the limit switch in its direction of travel
	public boolean hitLimit() {
		return !limitTop.get() && dir == 1 || !limitBottom.get() && dir == -1;
	}
	
	// starts moving if there is room and updates the direction of travel
	public void move(int d) {
		dir = d;
		if (!hitLimit() && dir == 1) { winchMotor.set(RobotMap.winchSpeed * dir); }
		if (!hitLimit() && dir == -1) { winchMotor.set(RobotMap.winchSpeed * dir * 0.5); }
	}
	
	// reverses until the limit switch is no longer pressed and stops the motor
	public void hold() {
		while (hitLimit()) { winchMotor.set(-0.5 * RobotMap.winchSpeed * dir); }
		winchMotor.set(0);
	}
	
	public double heightFromTop() {
		return ultra.getRangeInches();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

