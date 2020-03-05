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

public class ShootAutoTo extends Command {
  double speed, balls;
  Timer timer = new Timer();

  public ShootAutoTo(double speed_in, double balls_in) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.shooter_subsystem);
    requires(Robot.compressor_subsystem);
    this.speed = speed_in;
    this.balls = balls_in;
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
    Robot.shooter_subsystem.set(this.speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (timer.get() >= 1) {
      return true;
    } else {
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.compressor_subsystem.ball_block_set(true);
    timer.delay(this.balls);
    Robot.compressor_subsystem.ball_block_set(false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
