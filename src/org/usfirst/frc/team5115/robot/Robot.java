
package org.usfirst.frc.team5115.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5115.robot.commands.AutoStrat1;
import org.usfirst.frc.team5115.robot.commands.AutoStrat2;
import org.usfirst.frc.team5115.robot.commands.AutoStratTest;
import org.usfirst.frc.team5115.robot.commands.DriveComp;
import org.usfirst.frc.team5115.robot.commands.GimbalControl;
import org.usfirst.frc.team5115.robot.commands.GimbalReset;
import org.usfirst.frc.team5115.robot.commands.Grab;
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

	public static StickDrive sd;
	public static WinchChecker wc;
	public static DriveComp dc;
	public static AutoStrat1 a1;
	public static AutoStrat2 a2;
	public static AutoStratTest at;
    public static GimbalReset gr;
    public static GimbalControl gc;
    public static Grab g;
    
    public static int mode = 0; // 0 for off; 1 for tele; 2 for auto
    
   // private int strategy = 3;
    
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
        at = new AutoStratTest();
        gr = new GimbalReset();
        gc = new GimbalControl();
        g = new Grab();
        
        System.out.println("Started robot");
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	mode = 2;
        wc.start();
        dc.start();
        gr.start();
        Robot.chassis.throttle = 1;
        at.start();
        SmartDashboard.putString("DB/String 5", "Mode: " + mode);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putBoolean("DB/LED 0", Robot.chassis.hitTote());
        
        Timer.delay(0.005);
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	mode = 1;
    	a1.cancel();
    	a2.cancel();
    	at.cancel();
    	dc.cancel();
        sd.start();	// start driving
        wc.start();
        //dc.start();
        gc.start();
        g.start();
        
        System.out.println("Entered Teleop mode");
        SmartDashboard.putString("DB/String 5", "Mode: " + mode);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	mode = 0;
        SmartDashboard.putString("DB/String 5", "Mode: " + mode);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putBoolean("DB/LED 0", chassis.hitTote());
        SmartDashboard.putBoolean("DB/LED 1", winch.hitLimit());
        
        Timer.delay(0.005);     
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
