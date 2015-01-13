
package org.usfirst.frc.team5115.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5115.robot.Robot;
import org.usfirst.frc.team5115.robot.RobotMap;

/**
 *
 */
public class Throttle extends Command {
	
	private int dir;

    public Throttle(int d) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        dir = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.throttleShift(dir);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
