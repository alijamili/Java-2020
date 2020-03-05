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

class DriveTo extends Command {
  //double distance;
  double speed, time;
  Timer timer = new Timer();

  public DriveTo(double speed_in, double time_in) {
    //enter distance in inches
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drive_subsystem);
    this.speed = speed_in;
    this.time = time_in;
    //this.distance = distance_in/(Math.PI*6);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.reset();
    timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drive_subsystem.drive_straight(this.speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(timer.get() >= this.time){
      return true;
    } else{
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drive_subsystem.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.drive_subsystem.set(0);
  }
}
