
package org.usfirst.frc.team5115.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5115.robot.Robot;
import org.usfirst.frc.team5115.robot.RobotMap;

/**
 *
 */
public class AutoTurn extends Command {

	private double degrees = 0;

    public AutoTurn(int d) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        
        degrees = d;
        if (degrees > 0) degrees -= 13;
        if (degrees < 0) degrees += 13;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.startEncoders();
    	if (degrees > 0) { Robot.chassis.drive(RobotMap.autoSpeed, -RobotMap.autoSpeed); }
    	if (degrees < 0) { Robot.chassis.drive(-RobotMap.autoSpeed, RobotMap.autoSpeed); }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("turning");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.chassis.rightDist() / RobotMap.circumference) >= Math.abs(degrees / 360);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
