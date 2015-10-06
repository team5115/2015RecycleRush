package org.usfirst.frc.team5115.robot.commands;

import org.usfirst.frc.team5115.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStrat3 extends CommandGroup {
    
    public AutoStrat3() {
    	requires(Robot.chassis);
    	requires(Robot.winch);
    	requires(Robot.pneumatic);

    	addSequential(new AutoInitWinch());
    	addSequential(new AutoDriveToTote());
    	addSequential(new AutoLift(6));
    	addSequential(new AutoDrive(156));
    	addSequential(new AutoTurn(90));
    	addSequential(new AutoDrop(6));
    	addSequential(new AutoDrive(-24));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
