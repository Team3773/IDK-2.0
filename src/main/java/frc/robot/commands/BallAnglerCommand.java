// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ballAnglerSubsystem;

public class BallAnglerCommand extends CommandBase {
  private final ballAnglerSubsystem angler;
  private final DoubleSupplier turn;

  /** Creates a new BallAnglerCommand. */
  public BallAnglerCommand(ballAnglerSubsystem angler, DoubleSupplier turn) {
    this.angler = angler;
    this.turn = turn;
    addRequirements(this.angler);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // // Called when the command is initially scheduled.
  // @Override
  // public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.angler.setmotor(this.turn.getAsDouble());
  }

  // // Called once the command ends or is interrupted.
  // @Override
  // public void end(boolean interrupted) {}

  // // Returns true when the command should end.
  // @Override
  // public boolean isFinished() {
  //   return false;
  // }
}
