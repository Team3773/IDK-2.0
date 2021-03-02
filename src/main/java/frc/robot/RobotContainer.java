// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.Constants.driveConstants;
import frc.robot.Constants.usbConstant;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.DriveManuallyCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ballAnglerSubsystem;
import frc.robot.subsystems.ballBeltSubsystem;
import frc.robot.subsystems.ballIntakeSubsystem;
import frc.robot.subsystems.ballOutakeSubsystem;
import frc.robot.commands.ballAnglerCommand;
import frc.robot.commands.ballBeltCommand;
import frc.robot.commands.zeroAngler;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ballAnglerSubsystem anglerSubsystem = new ballAnglerSubsystem();
  private final ballBeltSubsystem beltSubsystem = new ballBeltSubsystem();
  private final ballIntakeSubsystem intakeSubsystem = new ballIntakeSubsystem();
  private final ballOutakeSubsystem outakeSubsystem = new ballOutakeSubsystem();

  // Autonomous Commmands
  private final DriveDistance drive1Units = new DriveDistance(driveSubsystem, 1, 0.5, 0);

  private final DriveDistance drive5Units = new DriveDistance(driveSubsystem, 5, 0.5, 0);

  private final DriveDistance drive10Units = new DriveDistance(driveSubsystem, 10, 0.5, 0);

  // A chooser for autonomous commands
  SendableChooser<Command> chooser = new SendableChooser<>();

  public Joystick stick = new Joystick(usbConstant.joystickPort);
 
  private Button button1;
  private Button button2;
  private Button button3;
  private Button button4;
  private Button button5;
  private Button button6;
  private Button button7;
  private Button button11;
  private Button button12;

  // public Encoder aEncoder;
  // public double setpoint = 0;
  // private double angle;
  // final double kP = 0.5;
  // private DigitalInput forwardLimitSwitch;
  // private final double kAngleTick = Math.PI * 2.75 / 360.0;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // going to try using lambdas here...

    driveSubsystem.setDefaultCommand(new DriveManuallyCommand(driveSubsystem, () -> stick.getY(), () -> stick.getX(),
        stick.getRawButtonPressed(driveConstants.reverseButton)));

    beltSubsystem.setDefaultCommand(new ballBeltCommand(beltSubsystem, () -> stick.getRawButton(3), () -> stick.getTriggerReleased(), () -> stick.getRawButton(1)));
    // anglerSubsystem.setDefaultCommand(new ballAnglerCommand(anglerSubsystem, () -> stick.getThrottle()));
    // beltSubsystem.setDefaultCommand(new ballBeltCommand(beltSubsystem, () -> stick.get));
    //beltSubsystem = new ballBeltSubsystem();

    chooser.setDefaultOption("drive 1 units?", drive1Units);
    chooser.addOption("drive 5 units", drive5Units);
    chooser.addOption("drive 10 units", drive10Units);
    Shuffleboard.getTab("Autonomous").add(chooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    button1 = new JoystickButton(stick, 1);
    button2 = new JoystickButton(stick, 2);
    button3 = new JoystickButton(stick, 3);
    button4 = new JoystickButton(stick, 4);
    button5 = new JoystickButton(stick, 5);
    button6 = new JoystickButton(stick, 6);
    button7 = new JoystickButton(stick, 7);

    button11 = new JoystickButton(stick, 11);

    button12 = new JoystickButton(stick, 12);
    

    // bind left bumper to intake motor
    button6.whenPressed(new RunCommand(() -> intakeSubsystem.setmotor(0.7), intakeSubsystem))
         .whenReleased(new RunCommand(() -> intakeSubsystem.setmotor(0), intakeSubsystem));

    button1.whenPressed(new RunCommand(() -> outakeSubsystem.setmotor(0.7), outakeSubsystem))
         .whenReleased(new RunCommand(() -> outakeSubsystem.setmotor(0), outakeSubsystem));

    // button11.whenPressed(new RunCommand(() -> anglerSubsystem.setmotor(1), anglerSubsystem));

    button12.whenPressed(new zeroAngler(anglerSubsystem));

    // button1.whenReleased(new RunCommand(() -> beltSubsystem.beltOff(), beltSubsystem), beltSubsystem.setDefaultCommand(new ballBeltCommand(beltSubsystem, () -> stick.getRawButton(3), () -> stick.getRawButton(1))));
    // button1.whenPressed(new RunCommand(() -> beltSubsystem.beltForward(), beltSubsystem))
    //      .whenReleased(new RunCommand(() ->  beltSubsystem.beltOff(), beltSubsystem));

    // setpoint = 4.35833;
    // setpoint = 5.449541;
    // setpoint = 6.53945;
    //button?.whenPressed(new ballAnglerCommand(subsystem, setPoint);
    button7.whenPressed(new ballAnglerCommand(this.anglerSubsystem, 1.0));//4.35833));
    button4.whenPressed(new ballAnglerCommand(this.anglerSubsystem, 1.1));
    button5.whenPressed(new ballAnglerCommand(this.anglerSubsystem, 1.2));
    //  button2.whenPressed(new ballBeltCommand(beltSubsystem, true))
    //      .whenReleased(new ballBeltCommand(beltSubsystem, false));

    // new zeroAngler(this.anglerSubsystem);

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
