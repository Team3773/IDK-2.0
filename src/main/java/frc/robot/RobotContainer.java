// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.Constants.driveConstants;
import frc.robot.Constants.usbConstant;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.DriveManuallyCommand;
import frc.robot.commands.TurnToAngle;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ballAnglerSubsystem;
import frc.robot.subsystems.ballBeltSubsystem;
import frc.robot.subsystems.ballIntakeSubsystem;
import frc.robot.subsystems.ballOutakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ballAnglerSubsystem anglerSubsystem = new ballAnglerSubsystem();
  private final ballBeltSubsystem beltSubsystem = new ballBeltSubsystem();
  private final ballIntakeSubsystem intakeSubsystem = new ballIntakeSubsystem();
  private final ballOutakeSubsystem outakeSubsystem = new ballOutakeSubsystem();
  
  //Autonomous Commmands
  private final DriveDistance drive1Units = 
    new DriveDistance(driveSubsystem, 1, 0.5, 0);

  private final DriveDistance drive5Units = 
    new DriveDistance(driveSubsystem, 5, 0.5, 0);

  private final DriveDistance drive10Units = 
    new DriveDistance(driveSubsystem, 10, 0.5, 0);

  // A chooser for autonomous commands
  SendableChooser<Command> chooser = new SendableChooser<>();


  XboxController xbox = new XboxController(usbConstant.xboxPort);
  Joystick stick = new Joystick(usbConstant.joystickPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //Configure default commands
    //going to try using lambdas here...
    driveSubsystem.setDefaultCommand( 
      new DriveManuallyCommand(
        driveSubsystem,
        () -> stick.getY(),
        () -> stick.getX(),
        stick.getRawButtonPressed(driveConstants.reverseButton)
        ));

    
    chooser.setDefaultOption("drive 1 units?", drive1Units);
    chooser.addOption("drive 5 units", drive5Units);
    chooser.addOption("drive 10 units", drive10Units);
    Shuffleboard.getTab("Autonomous").add(chooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
   // new JoystickButton(xbox, Button.kY.value).whenPressed(null);

   //bind left bumber to intake motor
    new JoystickButton(xbox, Button.kBumperLeft.value).whenPressed(
      new RunCommand(
        () -> intakeSubsystem.setmotor(1),intakeSubsystem)
    ).whenReleased(
      new RunCommand(
        () -> intakeSubsystem.setmotor(0), intakeSubsystem)
    );

    //bind right bumper to shooter motor
    new JoystickButton(xbox, Button.kBumperRight.value).whenPressed(
      new RunCommand(
        () -> outakeSubsystem.setmotor(1), outakeSubsystem)
    ).whenReleased(
      new RunCommand(
        () -> outakeSubsystem.setmotor(0), outakeSubsystem)
    );


    //bind x button to turn 25 degrees
    new JoystickButton(xbox, Button.kX.value)
        .whenPressed(new TurnToAngle(driveSubsystem, 25).withTimeout(5));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return chooser.getSelected();
  }
}
