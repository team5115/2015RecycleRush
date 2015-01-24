package org.usfirst.frc.team5115.robot.commands;

import org.usfirst.frc.team5115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveComp extends Command {
	
	private int speed = 20;
	private int checkFrame = 0;
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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (checkFrame == speed) {
    		speedLeft = Robot.chassis.leftSpeed();
    		speedRight = Robot.chassis.rightSpeed();
    		
    		if (Robot.chassis.leftSpeed != 0 && Robot.chassis.rightSpeed != 0) {
	    		speedFactorLeft = speedLeft / Robot.chassis.leftSpeed;
	    		speedFactorRight = speedRight / Robot.chassis.rightSpeed;
	    		
	    		if (speedFactorLeft > speedFactorRight)
	    			Robot.chassis.leftOffset += (speedFactorLeft - speedFactorRight) / speedFactorLeft;
	    		if (speedFactorLeft < speedFactorRight)
	    			Robot.chassis.rightOffset += (speedFactorRight - speedFactorLeft) / speedFactorRight;
    		}
    		if (Robot.chassis.leftSpeed == 0)
    			Robot.chassis.leftOffset = Math.signum(speedLeft) * 0.01;
    		if (Robot.chassis.rightSpeed == 0)
    			Robot.chassis.rightOffset = Math.signum(speedRight) * 0.01;
    		
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
