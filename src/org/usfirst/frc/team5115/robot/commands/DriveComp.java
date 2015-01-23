package org.usfirst.frc.team5115.robot.commands;

import org.usfirst.frc.team5115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveComp extends Command {
	
	private int speed = 20;
	private int checkFrame = 0;
	private double distInitLeft = 0;
	private double distInitRight = 0;
	private double distFinLeft = 0;
	private double distFinRight = 0;
	private double speedLeft = 0;
	private double speedRight = 0;
	private double speedFactorLeft = 1;
	private double speedFactorRight = 1;

    public DriveComp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	distInitLeft = Robot.chassis.leftDist();
    	distInitRight = Robot.chassis.rightDist();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (checkFrame == speed) {
    		distFinLeft = Robot.chassis.leftDist();
    		distFinRight = Robot.chassis.rightDist();
    		speedLeft = distFinLeft - distInitLeft;
    		speedRight = distFinRight - distInitRight;
    		speedFactorLeft = speedLeft / Robot.chassis.leftSpeed;
    		speedFactorRight = speedRight / Robot.chassis.rightSpeed;
    		
    		if (speedFactorLeft > speedFactorRight)
    			Robot.chassis.leftOffset += (speedFactorLeft - speedFactorRight) / speedFactorLeft;
    		if (speedFactorLeft < speedFactorRight)
    			Robot.chassis.rightOffset += (speedFactorRight - speedFactorLeft) / speedFactorRight;
    		
        	distInitLeft = Robot.chassis.leftDist();
        	distInitRight = Robot.chassis.rightDist();
    		
    		checkFrame = 0;
    	} else {
    		checkFrame ++;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
