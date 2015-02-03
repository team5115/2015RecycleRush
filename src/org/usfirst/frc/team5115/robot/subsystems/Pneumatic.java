
package org.usfirst.frc.team5115.robot.subsystems;

import org.usfirst.frc.team5115.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatic extends Subsystem {
	
	DoubleSolenoid sol1;
	private boolean grabbing = false;
	
	public Pneumatic() {
		sol1 = new DoubleSolenoid(RobotMap.solForward, RobotMap.solReverse);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void out() {
		sol1.set(DoubleSolenoid.Value.kForward);
	}
	
	public void in() {
		sol1.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void close() {
		sol1.set(DoubleSolenoid.Value.kOff);
	}
	public void toggle() {
		if (grabbing) out();
		else in();
		grabbing = !grabbing;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

