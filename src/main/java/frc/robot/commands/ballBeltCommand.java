// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ballBeltSubsystem;


public class ballBeltCommand extends CommandBase {
  private boolean reverse;
  private boolean lowerBallPresent;
  private boolean upperBallPresent;
  private final ballBeltSubsystem beltSubsystem;

 
  /** Creates a new ballBeltCommand. */
  public ballBeltCommand(ballBeltSubsystem beltSubsystem, boolean reverse) {
    this.beltSubsystem = beltSubsystem;
    this.reverse = reverse;
    addRequirements(this.beltSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (this.reverse) {
      this.beltSubsystem.beltReverse();
    } 
    else {
      if(upperBallPresent == true) {
        this.beltSubsystem.beltOff();
      }else if(this.lowerBallPresent == true) {
        this.beltSubsystem.beltForward();
      }
    }  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.beltSubsystem.beltOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
