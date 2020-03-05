/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ShooterCommand;

/**
 * Add your docs here.
 */
public class ShooterSubsystem extends Subsystem {
  // Put methods for controlling this subsystem here. Call these from Commands.
  private Talon shooter_motor = new Talon(RobotMap.shooter_motor_pwm);
  private Encoder shooter_encoder = new Encoder(RobotMap.shooter_encoder0, RobotMap.shooter_encoder1);

  public void set(double speed){
    this.shooter_motor.set(speed);
  }

  public double get(){
    return this.shooter_motor.get();
  }
  public double encoder_rate(){
    return (this.shooter_encoder.getRate());
  }
  public double encoder_distance(){
    return this.shooter_encoder.getDistance();
  }
  public double shooter_speed_modification(double speed){
    return ((2-speed)/2);
  }
  public void ResetEncoder(){
    this.shooter_encoder.reset();
  }
  public void safety_off(){
    this.shooter_motor.setSafetyEnabled(false);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ShooterCommand());
  }
}
