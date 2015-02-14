
package org.usfirst.frc.team5115.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5115.robot.Robot;

/**
 *
 */
public class AutoDrop extends Command {
	
	//private double initHeight;
	//private double height;
	private double time;

    public AutoDrop(double h) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.pneumatic);
        requires(Robot.winch);
        
        //initHeight = Robot.winch.height();
        //height = h;
        time = h / 4;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.winch.move(-1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return Robot.winch.height() - initHeight >= height;
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Timer.delay(time);
    	Robot.winch.hold();
    	Robot.pneumatic.out();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
