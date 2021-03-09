// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ballAnglerSubsystem;
import frc.robot.subsystems.manualAnglerSubsystem;


public class manualAnglerCommand extends CommandBase {
  private final manualAnglerSubsystem manualAnglerSubsystem;
  private final ballAnglerSubsystem ballAnglerSubsystem;
  private final BooleanSupplier angleForward;
  private final BooleanSupplier angleForwardReleased;
  private final BooleanSupplier angleBackward;
  private final BooleanSupplier angleBackwardReleased;


  /** Creates a new manualAnglerCommand. */
  public manualAnglerCommand(manualAnglerSubsystem manualAnglerSubsystem, ballAnglerSubsystem ballAnglerSubsystem, BooleanSupplier angleForward, BooleanSupplier angleBackward, BooleanSupplier angleForwardReleased, BooleanSupplier angleBackwardReleased) {
    this.manualAnglerSubsystem = manualAnglerSubsystem;
    this.angleForward = angleForward;
    this.angleBackward = angleBackward;
    this.ballAnglerSubsystem = ballAnglerSubsystem;
    this.angleForwardReleased = angleForwardReleased;
    this.angleBackwardReleased = angleBackwardReleased;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.manualAnglerSubsystem);
    addRequirements(this.ballAnglerSubsystem);

  }

//  public manualAnglerCommand(frc.robot.subsystems.manualAnglerSubsystem mAnglerSubsystem, Object speed2) {
//}

@Override
  public void execute() {
    if(this.angleBackwardReleased.getAsBoolean()){
      this.manualAnglerSubsystem.stopMotor();
    }
    if(this.angleForwardReleased.getAsBoolean()){
      this.manualAnglerSubsystem.stopMotor();
    }
    if (this.angleForward.getAsBoolean()) {
      this.manualAnglerSubsystem.angleForward();
    }else{
    if(this.ballAnglerSubsystem.getLimitSwitch()){
      this.ballAnglerSubsystem.resetDistance();
      this.manualAnglerSubsystem.stopMotor();
   }else{
    if(this.angleBackward.getAsBoolean()){
      this.manualAnglerSubsystem.angleBackward();
    }
   }
   /*    if (this.angleForward.getAsBoolean()) {
      this.manualAnglerSubsystem.angleForward();
    }else{
    if(this.ballAnglerSubsystem.getLimitSwitch()){
      this.ballAnglerSubsystem.resetDistance();
      this.manualAnglerSubsystem.stopMotor();
   }else{
    if(this.angleBackward.getAsBoolean()){
      this.manualAnglerSubsystem.angleBackward();
    }
   }*/
    //    if(tempSpeed = 0){
    //    tempSpeed = 0;
    //    }
    //   // this.ballAnglerSubsystem.stopMotor();
    //  }
    // manualAnglerSubsystem.manualAnglerCommand(tempSpeed);

    //Robot.manualAnglerSubsystem.setmotor()
   
  }
}
}
