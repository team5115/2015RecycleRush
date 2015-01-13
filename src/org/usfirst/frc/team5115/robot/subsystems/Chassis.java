package org.usfirst.frc.team5115.robot.subsystems;

import org.usfirst.frc.team5115.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis extends Subsystem {
	
	public double throttle = 0.5;
    public Victor rightMotor;
    public Victor leftMotor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Chassis() {
        rightMotor = new Victor(RobotMap.rightMotor);
        leftMotor = new Victor(RobotMap.leftMotor);
    }

	public void throttleShift(int dir) {
		throttle += RobotMap.throttleInterval * dir;		
	} 
    
    public void drive(double left, double right) {
        leftMotor.set(left / 2 * throttle);
        rightMotor.set(right / 2 * throttle);
        
        SmartDashboard.putNumber("Throttle", throttle);
        SmartDashboard.putNumber("Left Speed", left);
        SmartDashboard.putNumber("Right Speed", right);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }  
}