// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ballAnglerSubsystem;
import frc.robot.subsystems.manualAnglerSubsystem;


public class manualAnglerCommand extends CommandBase {
  private final manualAnglerSubsystem manualAnglerSubsystem;
  private final ballAnglerSubsystem ballAnglerSubsystem;
  private final DoubleSupplier speed;

  /** Creates a new manualAnglerCommand. */
  public manualAnglerCommand(manualAnglerSubsystem manualAnglerSubsystem, ballAnglerSubsystem ballAnglerSubsystem, DoubleSupplier speed) {
    this.manualAnglerSubsystem = manualAnglerSubsystem;
    this.speed = speed;
    this.ballAnglerSubsystem = ballAnglerSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.manualAnglerSubsystem);
    addRequirements(this.ballAnglerSubsystem);

  }

//  public manualAnglerCommand(frc.robot.subsystems.manualAnglerSubsystem mAnglerSubsystem, Object speed2) {
//}



@Override
  public void execute() {
    double tempSpeed = speed.getAsDouble();

     if(this.ballAnglerSubsystem.getLimitSwitch()){
       this.ballAnglerSubsystem.resetDistance();
       if(tempSpeed < 0){
       tempSpeed = 0;
       }
      // this.ballAnglerSubsystem.stopMotor();
     }
    manualAnglerSubsystem.manualAnglerCommand(tempSpeed);

    //Robot.manualAnglerSubsystem.setmotor()
   
  }
}
