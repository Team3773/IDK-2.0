/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Encoder;
// import frc.robot.subsystems.DriveSubsystem;
// import edu.wpi.first.wpilibj.DigitalInput;
// import java.io.ObjectInputStream.GetField;


public class DriveManuallyCommand extends Command {
  boolean driveReverse = false;
  Encoder e = null;
  public DriveManuallyCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveSubsystem); 
  }
  
private static double speedScaler = 0.75;


  @Override
  protected void initialize() {

    driveReverse = false;

  
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
 
    if (Robot.oi.stick.getRawButtonPressed(1)) {
    driveReverse = !driveReverse;

    }
    double move = -Robot.oi.stick.getY();
    move = move*speedScaler;
    double turn = Robot.oi.stick.getX();
    turn = turn*speedScaler;
    if (driveReverse) {
      Robot.driveSubsystem.driveManually(-move, -turn);

    

    }else{

      Robot.driveSubsystem.driveManually(move, turn);
    }
  }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveSubsystem.driveManually(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
