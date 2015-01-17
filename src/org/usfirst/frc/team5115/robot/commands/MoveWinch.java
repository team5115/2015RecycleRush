
package org.usfirst.frc.team5115.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5115.robot.Robot;

/**
 *
 */
public class MoveWinch extends Command {
	
	private int dir;

    public MoveWinch(int d) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.winch);
        dir = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.winch.move(dir);
    	System.out.println("Started moving winch");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.winch.hitLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.winch.hold();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
