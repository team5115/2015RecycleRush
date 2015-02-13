
package org.usfirst.frc.team5115.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5115.robot.Robot;
import org.usfirst.frc.team5115.robot.RobotMap;

/**
 *
 */
public class AutoDriveToTote extends Command {

    public AutoDriveToTote() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.startEncoders();
    	Robot.chassis.drive(RobotMap.autoSpeedShort, RobotMap.autoSpeedShort);
    	System.out.println("started driving");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return (Robot.chassis.leftDist() + Robot.chassis.rightDist()) / 2 >= dist || Robot.chassis.hitTote();
    	return Robot.chassis.hitTote();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Timer.delay(.01);
    	while (Robot.chassis.hitTote()) { Robot.chassis.drive(-1 * RobotMap.autoSpeedShort, -1 * RobotMap.autoSpeedShort); }
    	Robot.chassis.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
