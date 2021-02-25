// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.ballBeltSubsystem;
import frc.robot.RobotContainer;

public class ballBeltCommand extends CommandBase {
  boolean beltVar;
  boolean beltReverse;
  boolean lowerBallPresent;
  boolean upperBallPresent;
  Joystick stick;
 
  /** Creates a new ballBeltCommand. */
  public ballBeltCommand() {
    addRequirements(RobotContainer.beltSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    beltVar = false;
    beltReverse = false;
    lowerBallPresent = false;
    upperBallPresent = false;
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(stick.getRawButton(5)){

      beltReverse = !beltReverse;
    }
    
    if(stick.getRawButton(6)){
      beltVar = !beltVar; 
  }

    if (beltReverse) {

  RobotContainer.beltSubsystem.setmotor(-0.5);

    }
  
    else {

      if(beltVar) {

        RobotContainer.beltSubsystem.setmotor(0.5);

      }
  }
    if(upperBallPresent = true) {

      RobotContainer.beltSubsystem.setmotor(0.0);

    }

    if(lowerBallPresent = true) {

      RobotContainer.beltSubsystem.setmotor(1.0);

    }
    if(upperBallPresent = true) {

      RobotContainer.beltSubsystem.setmotor(0.0);

    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
