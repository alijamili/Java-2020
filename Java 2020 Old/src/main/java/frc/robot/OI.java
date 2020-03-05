/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.BallBlockCommand;
import frc.robot.commands.ColorWheelActuatorInCommand;
import frc.robot.commands.ColorWheelActuatorOutCommand;
import frc.robot.commands.ColorWheelCommand;
import frc.robot.commands.ColorWheelTo;
import frc.robot.commands.RollerCommand;
import frc.robot.commands.RollerCommandAlt;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.TeleDownCommand;
import frc.robot.commands.TeleUpCommand;
import frc.robot.commands.UptakeDown;
import frc.robot.commands.UptakeUp;
import frc.robot.commands.WinchCommand;
import frc.robot.commands.WinchLockCommand;
import frc.robot.commands.WinchUnlockCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways: cybersecurity

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  //Joysticks
  public Joystick op_stick = new Joystick(RobotMap.op_stick_port);
  public Joystick station_stick = new Joystick(RobotMap.station_stick_port);
  public Joystick left_drivestick = new Joystick(RobotMap.left_drivestick_port);
  public Joystick right_drivestick = new Joystick(RobotMap.right_drivestick_port);

  //Joystick Buttons
  
  //Op Stick Buttons
  public JoystickButton op_stick_shooter_button = new JoystickButton(op_stick, RobotMap.op_stick_shooter_button_int);
  public JoystickButton op_stick_wheel_turner = new JoystickButton(op_stick, RobotMap.op_stick_wheel_turner);
  public JoystickButton rollerBandsButton = new JoystickButton(op_stick, RobotMap.op_roller_weird_bands);
  public JoystickButton ballBlockSolenoid = new JoystickButton(op_stick, RobotMap.op_stick_ball_block_button_int);
  public JoystickButton tele_up_button = new JoystickButton(op_stick, RobotMap.op_tele_up_button_int);
  public JoystickButton tele_down_button = new JoystickButton(op_stick, RobotMap.op_tele_down_button_int);
  public JoystickButton op_roller_out_button = new JoystickButton(op_stick, RobotMap.op_roller_out_button_int);
  public JoystickButton op_stick_winchButton = new JoystickButton(op_stick, RobotMap.op_stick_winch_button_int);
  public JoystickButton op_stick_color_spinner = new JoystickButton(op_stick, RobotMap.op_stick_color_spinner);
  public JoystickButton op_stick_color_actuator_out = new JoystickButton(op_stick, RobotMap.op_stick_color_actuator_out);
  public JoystickButton op_stick_color_actuator_in = new JoystickButton(op_stick, RobotMap.op_stick_color_actuator_in);

  //Driver Stick Buttons
  public JoystickButton intakeUpButton = new JoystickButton(right_drivestick, RobotMap.right_drivestick_stick_shooter_intake);
  public JoystickButton intakeDownButton = new JoystickButton(right_drivestick, RobotMap.right_drivestick_stick_shooter_intake_down);
  public JoystickButton WinchUnlock = new JoystickButton(left_drivestick, RobotMap.left_drivestick_winch_unlock);
  public JoystickButton WinchLock = new JoystickButton(left_drivestick, RobotMap.left_drivestick_winch_lock);


  public OI(){
    this.op_stick_shooter_button.whileHeld(new ShooterCommand());
    this.op_stick_wheel_turner.whenPressed(new ColorWheelTo(4));
    this.intakeUpButton.whenPressed(new UptakeUp());
    this.intakeDownButton.whenPressed(new UptakeDown());
    this.rollerBandsButton.whileHeld(new RollerCommand());
    this.ballBlockSolenoid.whileHeld(new BallBlockCommand());
    this.tele_up_button.whileHeld(new TeleUpCommand());
    this.tele_down_button.whileHeld(new TeleDownCommand());
    this.op_roller_out_button.whileHeld(new RollerCommandAlt());
    this.op_stick_winchButton.whileHeld(new WinchCommand());
    this.op_stick_color_spinner.whileHeld(new ColorWheelCommand());
    this.op_stick_color_actuator_in.whenPressed(new ColorWheelActuatorInCommand());
    this.op_stick_color_actuator_out.whenPressed(new ColorWheelActuatorOutCommand());
    this.WinchLock.whenPressed(new WinchLockCommand());
    this.WinchUnlock.whenPressed(new WinchUnlockCommand());
}
}
