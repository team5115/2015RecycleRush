
package org.usfirst.frc.team5115.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5115.robot.commands.ExampleCommand;
import org.usfirst.frc.team5115.robot.commands.HoldWinch;
import org.usfirst.frc.team5115.robot.commands.StickDrive;
import org.usfirst.frc.team5115.robot.commands.WinchChecker;
import org.usfirst.frc.team5115.robot.subsystems.Chassis;
import org.usfirst.frc.team5115.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team5115.robot.subsystems.Pneumatic;
import org.usfirst.frc.team5115.robot.subsystems.Winch;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Winch winch = new Winch();
	public static final Pneumatic pneumatic = new Pneumatic();
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

    Command autonomousCommand;
    StickDrive sd;
    WinchChecker wc;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
        sd = new StickDrive();
        wc = new WinchChecker();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        sd.start();	// start driving
        
        System.out.println("Entered Teleop mode");
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        System.out.println("teleop running");
        
        SmartDashboard.putBoolean("Winch switch", winch.hitLimit());
        SmartDashboard.putNumber("Winch dir", winch.dir);
        
        Timer.delay(0.005);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
