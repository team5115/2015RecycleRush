
package org.usfirst.frc.team5115.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5115.robot.Robot;
import org.usfirst.frc.team5115.robot.RobotMap;

/**
 *
 */
public class AutoDrive extends Command {
	
	private double dist;

    public AutoDrive(double d) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        
        dist = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.startEncoders();
    	Robot.chassis.drive(RobotMap.autoSpeed, RobotMap.autoSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("driving");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.chassis.leftDist() + Robot.chassis.rightDist()) / 2 >= dist - 5;
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
