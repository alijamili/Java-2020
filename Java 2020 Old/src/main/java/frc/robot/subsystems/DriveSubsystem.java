/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem here. Call these from Commands.
  private Talon left_motor = new Talon(RobotMap.left_motor_pwm);
  private Talon right_motor = new Talon(RobotMap.right_motor_pwm);
  private DifferentialDrive drive = new DifferentialDrive(left_motor, right_motor);

  private Encoder left_encoder = new Encoder(RobotMap.left_drive_encoder0, RobotMap.left_drive_encoder1);
  private Encoder right_encoder = new Encoder(RobotMap.right_drive_encoder0, RobotMap.right_drive_encoder1);

  //Gyro
  private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  //private Gyro gyro;
  public void tank_drive_squared(double left_speed, double right_speed){
    this.drive.tankDrive(-left_speed, -right_speed, true);
  }

  public void set(double speed){
    this.drive.tankDrive(speed, speed);
  }

  public double left_encoder_rate(){
    return this.left_encoder.getRate();
  }
  public double left_encoder_distance(){
    return this.left_encoder.getDistance();
  }
  public double left_encoder_raw(){
    return this.left_encoder.getRate();
  }
  public double right_encoder_rate(){
    return this.right_encoder.getRate();
  } //}
  public double right_encoder_distance(){
    return this.right_encoder.getDistance();
  }
  public double right_encoder_raw(){
    return this.right_encoder.getRate();
  }
  public void encoders_reset(){
    this.left_encoder.reset();
    this.right_encoder.reset();
  }
  public double gyro_get(){
    return gyro.getAngle();
  }
  public void gyro_reset(){
    this.gyro.reset();
  }
  /*/public void drive_straight(double speed){
    this.drive.arcadeDrive(-speed, -this.gyro.getAngle()*RobotMap.kP);
  }
  /*/
  public void drive_straight(double speed){
    this.drive.arcadeDrive(speed, 0);
  }
  public double average(double average_part_one, double average_part_two){
    return ((average_part_one + average_part_two)/2);
  }
  public void safety_off(){
    this.drive.setSafetyEnabled(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }
}
