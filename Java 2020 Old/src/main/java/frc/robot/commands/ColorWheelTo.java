/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ColorWheelTo extends Command {
  int spin;
  double seconds_to_spin_for;
  Timer timer = new Timer();
  
  public ColorWheelTo(int spin_amount) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.colorwheel_subsystem);
    this.spin = spin_amount;
    this.seconds_to_spin_for = this.spin * 2;
    
    //the multiplyer can be tweaked
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (Robot.compressor_subsystem.wheel_get()){
      Robot.compressor_subsystem.wheel_set(false); //change this if false is not extending this
    }
    timer.reset();
    timer.start();
  }



  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.colorwheel_subsystem.wheel_set(0.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(timer.get() >= this.seconds_to_spin_for){
      return true;
    }
    else{
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.colorwheel_subsystem.wheel_set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
