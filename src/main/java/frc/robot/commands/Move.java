/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.DriveManuallyCommand;
import frc.robot.commands.driveGroup;

public class Move extends Command {
    double m_time;

  public Move(double time) {
    time = m_time;
    
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  public Move(double m_time, double move, double turn) {
}

// Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveSubsystem.driveManually(0.5,0.5);
    setTimeout(m_time);
    }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveSubsystem.driveManually(0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
