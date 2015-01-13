
package org.usfirst.frc.team5115.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5115.robot.Robot;

/**
 *
 */
public class Grab extends Command {

    public Grab() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.pneumatic);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.pneumatic.in();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pneumatic.out();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
