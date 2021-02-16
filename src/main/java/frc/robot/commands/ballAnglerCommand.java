// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.angleConstants;
import frc.robot.subsystems.ballAnglerSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ballAnglerCommand extends CommandBase {
  private final ballAnglerSubsystem ballAnglerSubsystem;
  private final DoubleSupplier angle;

  /**
   * Creates a new ballAnglerCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ballAnglerCommand(ballAnglerSubsystem subsystem, DoubleSupplier angle) {
    this.ballAnglerSubsystem = subsystem;
    this.angle = angle;
    addRequirements(this.ballAnglerSubsystem);
  }
  // Use addRequirements() here to declare subsystem dependencies.

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double tempAngle = angle.getAsDouble() * angleConstants.anglerScalar;
    // ballAnglerSubsystem.periodic();

    ballAnglerSubsystem.ballAnglerCommand(tempAngle);
  }
}
