
package org.usfirst.frc.team5115.robot.subsystems;

import org.usfirst.frc.team5115.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gimbal extends Subsystem {
    
    public Servo xServo;
    public Servo yServo;
    
    public Gimbal() {
    	xServo = new Servo (RobotMap.gimbalX);
    	yServo = new Servo (RobotMap.gimbalY);
    	xServo.setAngle(90);
    	yServo.setAngle(135);
    }
    



    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

