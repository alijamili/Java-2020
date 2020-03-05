/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class GyroTo extends Command {
  double angle, speed;
  double threshold = RobotMap.angle_threshold;

  
    public GyroTo(double angle_in, double speed_in) {
    // Use requires() here to declare subsystem dependencies
    this.angle = angle_in;
    this.speed = speed_in;
    //requires(Robot.drive_subsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.drive_subsystem.gyro_reset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (this.angle < 0) {
      //Right
      Robot.drive_subsystem.tank_drive_squared(-this.speed, this.speed);
    }
    else {
      Robot.drive_subsystem.tank_drive_squared(this.speed, -this.speed);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //double offset = Math.abs(this.angle - Robot.drive_subsystem.gyro_get());
    //return (offset<threshold);
    return false;
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
