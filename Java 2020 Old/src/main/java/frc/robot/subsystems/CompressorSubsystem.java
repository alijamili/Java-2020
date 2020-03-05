/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * CompressorSubsystem is where the code for all solenoids goes. 
 */
public class CompressorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem here. Call these from Commands.
  Compressor compressor = new Compressor(RobotMap.compressor_default);
  private Solenoid winch_solenoid = new Solenoid(RobotMap.winch_solenoid_port);
  private Solenoid intake_solenoid = new Solenoid(RobotMap.intake_solenoid_port);
  private Solenoid ball_block_solenoid = new Solenoid(RobotMap.ball_block_solenoid_port);
  private Solenoid color_wheel_solenoid_actuator = new Solenoid(RobotMap.color_wheel_solenoid_actuator);

  public boolean winch_get(){
    return this.winch_solenoid.get();
  }
  public void winch_set(boolean input){
  this.winch_solenoid.set(input);
  }
  public void compressor_on(){
    this.compressor.setClosedLoopControl(true);
  }
  public boolean intake_get(){
    return this.intake_solenoid.get();
  }
  
  public void intake_set(boolean input){
    this.intake_solenoid.set(input);
  }
  public boolean ball_block_get(){
    return this.ball_block_solenoid.get();
  }
  public void ball_block_set(boolean input){
    this.ball_block_solenoid.set(input);
  }
  public boolean wheel_get(){
    return this.color_wheel_solenoid_actuator.get();
  }
   public void wheel_set(boolean input){
    this.color_wheel_solenoid_actuator.set(input);
   }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
