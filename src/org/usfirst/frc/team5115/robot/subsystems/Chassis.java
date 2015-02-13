package org.usfirst.frc.team5115.robot.subsystems;

import org.usfirst.frc.team5115.robot.Robot;
import org.usfirst.frc.team5115.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Chassis extends Subsystem {
	
	public double leftSpeed = 0;
	public double rightSpeed = 0;
	public double leftOffset = 0;
	public double rightOffset = 0;
	public double throttle;
    private Victor rightMotor;
    private Victor leftMotor;
    private Encoder leftEncoder;
    private Encoder rightEncoder;
    private DigitalInput toteDetector;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Chassis() {
        rightMotor = new Victor(RobotMap.rightMotor);
        leftMotor = new Victor(RobotMap.leftMotor);
        
        leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2, true, EncodingType.k4X);
        rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2, true, EncodingType.k4X);
        leftEncoder.setDistancePerPulse(12.566 / 250);	// 250 CPR, 4 pulses per cycle, 12.566 inches circumference on wheel
        rightEncoder.setDistancePerPulse(12.566 / 250);
        
        toteDetector = new DigitalInput(RobotMap.toteDetector);
        
        leftEncoder.reset();
        rightEncoder.reset();
    }

 
    public void drive(double left, double right) {
    	leftSpeed = left;
    	rightSpeed = right;
    	drive();
    }
    
    public void drive() {
    	if (Robot.mode == 1) throttle = Robot.oi.throttle();
    	
    	if (leftSpeed > 0) {
            leftMotor.set(leftSpeed * throttle * RobotMap.speedFactor - leftOffset);
    	} else {
    		leftMotor.set(leftSpeed * throttle * RobotMap.speedFactor + leftOffset);
    	}
        rightMotor.set(rightSpeed * throttle * RobotMap.speedFactor);
        if (leftSpeed * throttle > 1) { leftMotor.set(-1); }
        if (leftSpeed * throttle < -1) { leftMotor.set(1); }
        if (rightSpeed * throttle > 1) { rightMotor.set(-1); }
        if (rightSpeed * throttle < -1) { rightMotor.set(1); }
        
        SmartDashboard.putString("DB/String 0", "Throttle: " + String.format("%2f", throttle));
        SmartDashboard.putString("DB/String 1", "Left: " + String.format("%2f", leftMotor.get()));
        SmartDashboard.putString("DB/String 2","Right: " + String.format("%2f", rightMotor.get()));
        SmartDashboard.putString("DB/String 6", "Left: " + String.format("%2f", leftRate()));
        SmartDashboard.putString("DB/String 7","Right: " + String.format("%2f", rightRate()));
    }
    
    public void startEncoders() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public double leftDist() {
    	return leftEncoder.getDistance();
    }
    
    public double rightDist() {
    	return rightEncoder.getDistance();
    }
    
    public double leftRate() {
    	return leftEncoder.getRate();
    }
    
    public double rightRate() {
    	return rightEncoder.getRate();
    }
    public boolean hitTote() {
    	return toteDetector.get();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }  
}
    