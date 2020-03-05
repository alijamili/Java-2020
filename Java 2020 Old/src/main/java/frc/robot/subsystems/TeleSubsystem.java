/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TeleSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Talon tele_motor = new Talon(RobotMap.tele_motor_pwm);

  public void tele_set(double speed){
    this.tele_motor.set(speed);
  }
  public double tele_get(){
    return this.tele_motor.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  }
}
