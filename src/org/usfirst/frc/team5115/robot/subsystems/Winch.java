
package org.usfirst.frc.team5115.robot.subsystems;

import org.usfirst.frc.team5115.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
	
	private Victor winchMotor;
	private DigitalInput limitBottom;
	private AnalogInput ultra;
	public int dir = 1;
	
	public Winch() {
		winchMotor = new Victor(RobotMap.winch);
		limitBottom = new DigitalInput(RobotMap.limitBottom);
		ultra = new AnalogInput(RobotMap.ultrasonic);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	// returns a boolean for if it has hit the limit switch in its direction of travel
	public boolean hitLimit() {
		return height() >= 40 && dir == 1 || !limitBottom.get() && dir == -1;
	}
	
	// starts moving if there is room and updates the direction of travel
	public void move(int d) {
		dir = d;
		winchMotor.set(RobotMap.winchSpeed * dir);
	}
	
	// reverses until the limit switch is no longer pressed and stops the motor
	public void hold() {
		while (hitLimit()) { winchMotor.set(-0.5 * RobotMap.winchSpeed * dir); }
		winchMotor.set(0);
	}
	
	public double height() {
		return ultra.getAverageVoltage() * 87.736 + 0.362;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

