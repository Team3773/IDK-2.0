/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.driveConstants;
import frc.robot.subsystems.DriveSubsystem;
import java.util.function.DoubleSupplier;

public class DriveManuallyCommand extends CommandBase {
  private final DriveSubsystem driveSubsystem;
  private final DoubleSupplier move;
  private final DoubleSupplier turn;
  private final boolean reversed;

  public DriveManuallyCommand(DriveSubsystem driveSubsystem, DoubleSupplier move, DoubleSupplier turn, boolean reversed) {
    this.driveSubsystem = driveSubsystem;
    this.move = move;
    this.turn = turn;
    this.reversed = reversed;
    addRequirements(this.driveSubsystem);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {

    double tempMove = move.getAsDouble() * driveConstants.speedScaler;
    double tempTurn = turn.getAsDouble() * driveConstants.speedScaler;
    
    if(reversed){
      tempMove = -tempMove;
      tempTurn = -tempTurn;
    }

    driveSubsystem.driveManually(tempMove, tempTurn);
  }
 
}
