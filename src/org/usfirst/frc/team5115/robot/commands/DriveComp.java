package org.usfirst.frc.team5115.robot.commands;

import org.usfirst.frc.team5115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveComp extends Command {
	
	private double speedLeft = 0;
	private double speedRight = 0;
	private double leftIn;
	private double rightIn = 1;

    public DriveComp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		speedLeft = Robot.chassis.leftRate();
		speedRight = Robot.chassis.rightRate();
		leftIn = Robot.chassis.leftSpeed;
		rightIn = Robot.chassis.rightSpeed;
		
		if (speedLeft != 0 && leftIn != 0) {
			if (speedRight / speedLeft > rightIn / leftIn)
				Robot.chassis.leftOffset += 0.01;
			if (speedRight / speedLeft < rightIn / leftIn)
				Robot.chassis.leftOffset -= 0.01;
			Robot.chassis.drive();
		}
		if (leftIn == 0 && rightIn == 0)
			Robot.chassis.leftOffset = 0;
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
