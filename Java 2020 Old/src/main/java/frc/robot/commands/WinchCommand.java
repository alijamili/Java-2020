/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class WinchCommand extends Command {
  public WinchCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.winch_subsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  Robot.compressor_subsystem.winch_set(false); //assuming false is retracted
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.winch_subsystem.WinchSet(Robot.m_oi.op_stick.getY());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.m_oi.op_stick_winchButton.get()==false){
      return true;
    } else {
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.compressor_subsystem.winch_set(true); //assuming true is solenoid out
    Robot.winch_subsystem.WinchSet(0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.winch_subsystem.WinchSet(0);
    
  }
}
