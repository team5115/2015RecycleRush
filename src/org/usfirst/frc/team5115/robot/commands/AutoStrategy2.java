package org.usfirst.frc.team5115.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStrategy2 extends CommandGroup {
    
    public  AutoStrategy2() {
    	
    	addSequential(new AutoDrive(10));
    	addSequential(new AutoLift(14));	// tote is 13 inches tall
    	addSequential(new AutoDrive(24));	// diameter of bin is 18in, plus a few for dist between tote and bin
    	addSequential(new AutoDrop(0));
    	addSequential(new AutoDrive(-4));
    	addSequential(new AutoDrive(10));
    	addSequential(new AutoLift(4));
    	addSequential(new AutoTurn(90));
    	addSequential(new AutoDrive(8 * 12 + 11));
    	addSequential(new AutoTurn(90));	// if on left, 90; if on right, -90
    	addSequential(new AutoEnd(10000));
    	addSequential(new AutoDrop(-3));
    	addSequential(new AutoTurn(-90));	// if on left, -90; if on right, 90
    	
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
