package org.usfirst.frc.team4849.robot.controller;

import org.usfirst.frc.team4849.robot.Robot;
import org.usfirst.frc.team4849.robot.commands.LifterState;
import org.usfirst.frc.team4849.robot.commands.MoveRoller;
import org.usfirst.frc.team4849.robot.commands.MoveTote;
import org.usfirst.frc.team4849.robot.commands.ResetGyro;
import org.usfirst.frc.team4849.robot.commands.ResetToteCount;
import org.usfirst.frc.team4849.robot.commands.RollerState;
import org.usfirst.frc.team4849.robot.commands.ToggleDrivingMode;

public class Extreme3D extends Controller {
	
	public Extreme3D(Robot robot) {
		super(robot);
		
		TOGGLE_DRIVETYPE = 11;
		RESET_GYRO = 12;
		
		TOTE_UP = 6;
		TOTE_DOWN = 4;
		RESET_TOTE_COUNT = 7;
		
		TOTE_IN = 5;
		TOTE_OUT = 3;
		
	}

	@Override
	public void bindKeys() {
		/*
		 * DriveTrain
		 */
		createButton(TOGGLE_DRIVETYPE).whenPressed(new ToggleDrivingMode(getRobot().getDriveTrain()));
		createButton(RESET_GYRO).whenPressed(new ResetGyro(getRobot().getDriveTrain()));
		
		/*
		 * Lifter
		 */
		createButton(TOTE_UP).whenPressed(new MoveTote(getRobot().getLifter(), LifterState.TOP));
		createButton(TOTE_DOWN).whenPressed(new MoveTote(getRobot().getLifter(), LifterState.BOTTOM));
		createButton(RESET_TOTE_COUNT).whenPressed(new ResetToteCount(getRobot().getLifter()));
		
		/*
		 * Rollers
		 */
		createButton(TOTE_IN).whenPressed(new MoveRoller(getRobot().getRoller(), RollerState.IN));
		getButton(TOTE_IN).whenReleased(new MoveRoller(getRobot().getRoller(), RollerState.STOP));
		
		createButton(TOTE_OUT).whenPressed(new MoveRoller(getRobot().getRoller(), RollerState.OUT));
		getButton(TOTE_OUT).whenReleased(new MoveRoller(getRobot().getRoller(), RollerState.STOP));
	}
	
}
