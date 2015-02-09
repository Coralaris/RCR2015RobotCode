package org.usfirst.frc.team4849.robot.subsystems;

import org.usfirst.frc.team4849.robot.RobotMap;
import org.usfirst.frc.team4849.robot.commands.LifterState;
import org.usfirst.frc.team4849.robot.commands.MoveTote;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	private static CANJaguar beltRight = new CANJaguar(RobotMap.LIFTER_RIGHT);
	private static CANJaguar beltLeft = new CANJaguar(RobotMap.LIFTER_LEFT);
	
	private static double beltSpeed = 0.5;
	private static LifterState state = LifterState.BOTTOM;
	
	public Lifter() {
		beltRight.setPercentMode();
		beltLeft.setPercentMode();
		
		beltRight.enableControl();
		beltLeft.enableControl();
		
		setDefaultCommand(new MoveTote(this, LifterState.TOP));
		
	}
	
	public void up() {
		beltRight.set(beltSpeed);
		beltLeft.set(beltSpeed);
		
	}
	
	public void down() {
		beltRight.set(-beltSpeed);
		beltLeft.set(-beltSpeed);
		
	}
	
	public void stop() {
		beltRight.set(0);
		beltLeft.set(0);
		
	}
	
	@Override
	protected void initDefaultCommand() {

	}

}