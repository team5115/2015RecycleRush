
package org.usfirst.frc.team5115.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5115.robot.commands.AutoStrat1;
import org.usfirst.frc.team5115.robot.commands.AutoStrat2;
import org.usfirst.frc.team5115.robot.commands.DriveComp;
import org.usfirst.frc.team5115.robot.commands.StickDrive;
import org.usfirst.frc.team5115.robot.commands.WinchChecker;
import org.usfirst.frc.team5115.robot.subsystems.Chassis;
import org.usfirst.frc.team5115.robot.subsystems.Gimbal;
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

	public static Chassis chassis = new Chassis();
	public static Winch winch = new Winch();
	public static Pneumatic pneumatic = new Pneumatic();
	public static Gimbal gimbal = new Gimbal();
	public static OI oi;

    StickDrive sd;
    WinchChecker wc;
    DriveComp dc;
    AutoStrat1 a1;
    AutoStrat2 a2;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        sd = new StickDrive();
        wc = new WinchChecker();
        dc = new DriveComp();
        a1 = new AutoStrat1();
        a2 = new AutoStrat2();
        
        System.out.println("Started robot");
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        wc.start();
        dc.start();
        a1.start();	// replace a1/a2 with a2/a1 for strategy 2/1
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putBoolean("Winch switch", winch.hitLimit());
        SmartDashboard.putNumber("Winch dir", winch.dir);
        
        Timer.delay(0.005);
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	a1.cancel();
    	a2.cancel();
        sd.start();	// start driving
        wc.start();
        //dc.start();
        
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
        
        SmartDashboard.putBoolean("Winch switch", winch.hitLimit());
        SmartDashboard.putNumber("Winch dir", winch.dir);
        SmartDashboard.putNumber("Gimbal X", oi.cameraX());
        SmartDashboard.putNumber("Gimbal Y", oi.cameraY());
        
        Timer.delay(0.005);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
