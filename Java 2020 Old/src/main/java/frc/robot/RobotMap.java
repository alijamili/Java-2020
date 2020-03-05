/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  
  //PWM constants
  public static final int left_motor_pwm = 0;
  public static final int right_motor_pwm = 1;
  public static final int roller_motor_pwm = 2;
  public static final int shooter_motor_pwm = 3;
  public static final int tele_motor_pwm = 4;
  public static final int winch_motor_pwm = 5;
  public static final int wheel_motor_pwm= 6;

  //Joystick constants
  public static final int right_drivestick_port = 0;
  public static final int left_drivestick_port = 1;
  public static final int op_stick_port = 2;
  public static final int station_stick_port = 3;

  //Joystick Button constants

  //op Stick Buttons
  public static final int op_stick_shooter_button_int = 1;
  public static final int op_stick_wheel_turner = 2; //new addition
  public static final int op_stick_ball_block_button_int = 3;
  public static final int op_roller_out_button_int = 4;
  public static final int op_roller_weird_bands = 5;
  public static final int op_tele_up_button_int = 6;
  public static final int op_tele_down_button_int = 7;
  public static final int op_stick_winch_button_int = 8;
  public static final int op_stick_color_spinner = 9;
  public static final int op_stick_color_actuator_in = 10;
  public static final int op_stick_color_actuator_out = 11;

  //Diver Stick Buttons
  //1 unused
  public static final int right_drivestick_stick_shooter_intake_down = 2;
  public static final int right_drivestick_stick_shooter_intake = 3;
  public static final int left_drivestick_winch_unlock = 2; //Same as below
  public static final int left_drivestick_winch_lock = 3; // Going to replace with a toggle
  
  //Limiting constants
  public static final double roller_limit = 0.75;
  public static final double tele_limit = 1;
  public static final double auto_driving_limit = 0.7;
  public static final double kP = 0.03;
  public static final double angle_threshold = 3;

  //DIO ports
  public static final int left_drive_encoder0 = 0;
  public static final int left_drive_encoder1 = 1;
  public static final int right_drive_encoder0 = 2;
  public static final int right_drive_encoder1 = 3;
  public static final int shooter_encoder0 = 4;
  public static final int shooter_encoder1 = 5;

  //Compressor
  public static final int compressor_default = 0;
  
  //Solenoid constants
  public static final int winch_solenoid_port = 0;
  public static final int intake_solenoid_port = 1;
  public static final int ball_block_solenoid_port = 2;
  public static final int color_wheel_solenoid_actuator = 3;

  //Gyro
  public static final int gyro_port = 1;
}
