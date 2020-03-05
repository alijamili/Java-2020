/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutoTest;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.CompressorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.WinchSubsystem;
import frc.robot.subsystems.TeleSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveSubsystem drive_subsystem = new DriveSubsystem();
  public static ShooterSubsystem shooter_subsystem = new ShooterSubsystem();
  public static CompressorSubsystem compressor_subsystem = new CompressorSubsystem();
  public static RollerSubsystem roller_subsystem = new RollerSubsystem();
  public static WinchSubsystem winch_subsystem = new WinchSubsystem();
  public static TeleSubsystem tele_subsystem = new TeleSubsystem();
  public static ColorWheelSubsystem colorwheel_subsystem = new ColorWheelSubsystem();
  public static OI m_oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();

    //Autonomous Dashboard chooser
    SmartDashboard.putData("Auto Mode", m_chooser);
    m_chooser.setDefaultOption("Default Auto", new DriveCommand());
    m_chooser.addOption("AutoTest", new AutoTest());
    
    Robot.compressor_subsystem.compressor_on();
    Robot.compressor_subsystem.intake_set(true);

    //Camera
    UsbCamera server = CameraServer.getInstance().startAutomaticCapture();
    server.setResolution(160, 120);
    server.setExposureAuto();

    //Safety features
    Robot.drive_subsystem.safety_off();
    Robot.shooter_subsystem.safety_off();
    Robot.roller_subsystem.safety_off();

    //Gyro
    Robot.drive_subsystem.gyro_reset();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    //Encoders
    SmartDashboard.putNumber("Shooter encoder", Robot.shooter_subsystem.encoder_rate());
    SmartDashboard.putNumber("Drivencoder dis", Math.abs(Robot.drive_subsystem.average(Math.abs(Robot.drive_subsystem.left_encoder_rate()), Math.abs(Robot.drive_subsystem.right_encoder_rate()))));
    SmartDashboard.putNumber("Rencoder dis", Robot.drive_subsystem.right_encoder_distance());
    SmartDashboard.putNumber("Lencoder dis", Robot.drive_subsystem.left_encoder_distance());
    //Solenoid
    SmartDashboard.putBoolean("Winch Solenoid Current Value", Robot.compressor_subsystem.winch_get());
    //Gyro
    SmartDashboard.putNumber("Gyro angle", Robot.drive_subsystem.gyro_get());
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    Robot.compressor_subsystem.intake_set(true);
    Robot.compressor_subsystem.winch_set(false);
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    Command chosenAuto = m_chooser.getSelected();
    // schedule the autonomous command (example)
    if (chosenAuto != null) {
      chosenAuto.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    //SmartDashboard.putNumber("Shooter encoder", Robot.shooter_subsystem.encoder_rate());
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("Shooter Speed", Robot.shooter_subsystem.shooter_speed_modification(Robot.m_oi.op_stick.getZ()));
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
