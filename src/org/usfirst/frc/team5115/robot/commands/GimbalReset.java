
package org.usfirst.frc.team5115.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5115.robot.Robot;

/**
 *
 */
public class GimbalReset extends Command {

    public GimbalReset() {
       // Use requires() here to declare subsystem dependencies
       requires(Robot.gimbal);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gimbal.xServo.setAngle(90);
    	Robot.gimbal.yServo.setAngle(150);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gc.start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
