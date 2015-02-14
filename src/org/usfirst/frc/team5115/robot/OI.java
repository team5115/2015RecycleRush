package org.usfirst.frc.team5115.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5115.robot.commands.AutoLift;
import org.usfirst.frc.team5115.robot.commands.GimbalReset;
import org.usfirst.frc.team5115.robot.commands.Grab;
import org.usfirst.frc.team5115.robot.commands.HoldWinch;
import org.usfirst.frc.team5115.robot.commands.MoveWinch;

import java.lang.Math;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Joystick
	Joystick joy;
	Joystick gimbal;
	
	// Buttons
	Button grab;
	Button upWinch;
	Button downWinch;
	Button raiseHeightOfTote;
	Button gimbalReset;
	
	public OI() {
		// Definitions: assign buttons to their numbers on the controller
		joy = new Joystick(0);
		gimbal = new Joystick(1);
		gimbalReset = new JoystickButton(joy, 2);
		grab = new JoystickButton(joy, 1);
		upWinch = new JoystickButton(joy, 5);
		downWinch = new JoystickButton(joy, 3);
		raiseHeightOfTote = new JoystickButton(joy, 12);
		
		// Link the buttons to commands
		grab.whenPressed(new Grab());
		upWinch.whenPressed(new MoveWinch(1));
		downWinch.whenPressed(new MoveWinch(-1));
		upWinch.whenReleased(new HoldWinch());
		downWinch.whenReleased(new HoldWinch());
		gimbalReset.whenPressed(new GimbalReset());
		
		raiseHeightOfTote.whenReleased(new AutoLift(14));
	}
	
	// Return speeds for each side (not including throttle) for the StickDrive command
	public double leftSpeed() {
		SmartDashboard.putString("DB/String 4", "Joystick Y: " + joy.getY());
		SmartDashboard.putString("DB/String 3", "Joystick X: " + joy.getX());
		if (Math.abs(joy.getY()) > 0.11 || Math.abs(joy.getX()) > 0.11) {
			return (-1 * joy.getY() - joy.getX());
		} else {
			return 0;
		}
	}
	public double rightSpeed() {
		if (Math.abs(joy.getY()) > 0.11 || Math.abs(joy.getX()) > 0.11) {
			return (-1 * joy.getY() + joy.getX());
		} else {
			return 0;
		}
	}
	public double throttle() {
		return -0.5 * (joy.getThrottle() - 1);
	}
	public double cameraX() {
		if (joy.getPOV() == -1) { return 0; }
		return Math.sin(Math.toRadians(joy.getPOV()));
	}
	public double cameraY() {
		if (joy.getPOV() == -1) { return 0; }
		return -1 * Math.cos(Math.toRadians(joy.getPOV()));
	}
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

