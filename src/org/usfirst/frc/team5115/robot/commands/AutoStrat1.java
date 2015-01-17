package org.usfirst.frc.team5115.robot.commands;

import org.usfirst.frc.team5115.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStrat1 extends CommandGroup {
    
    public AutoStrat1() {
    	requires(Robot.chassis);
    	requires(Robot.winch);
    	requires(Robot.pneumatic);
    	
    	addSequential(new AutoDrive(10));
    	addSequential(new AutoLift(4));
    	addSequential(new AutoTurn(-90));
    	addSequential(new AutoDrive(132));
    	addSequential(new AutoTurn(90));	//if on left, 90; if on right, -90
    	addSequential(new AutoEnd(10000));
    	addSequential(new AutoDrop(-3));
    	addSequential(new AutoDrive(-24));
    	addSequential(new AutoTurn(-90));    //if on left, -90; if on right, 90
    	
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
