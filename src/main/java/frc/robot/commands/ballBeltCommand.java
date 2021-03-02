// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ballBeltSubsystem;


public class ballBeltCommand extends CommandBase {
  private BooleanSupplier reverse;
  private BooleanSupplier triggerRelease;
  private BooleanSupplier triggerPressed;
  
  // private BooleanSupplier lowerBallPresent;
  // private BooleanSupplier upperBallPresent;
  private final ballBeltSubsystem beltSubsystem;
  //private double beltTimeout;

 
  /** Creates a new ballBeltCommand. */
  public ballBeltCommand(ballBeltSubsystem beltSubsystem, BooleanSupplier reverse, BooleanSupplier triggerRelease, BooleanSupplier triggerPressed) {
    System.out.println("init");
    //double beltTimeout
    //this.beltTimeout = beltTimeout;
    this.beltSubsystem = beltSubsystem;
    this.triggerRelease = triggerRelease;
    this.triggerPressed = triggerPressed;
    this.reverse = reverse;


    addRequirements(this.beltSubsystem);
  }

    // Use addRequirements() here to declare subsystem dependencies.

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    long millisecondsToRun = 2000;
    long initTime = beltSubsystem.getFPGATime();

    System.out.printf("lower ball = %b, upper ball = %b",this.beltSubsystem.islowerBallPresent(), this.beltSubsystem.isUpperBallPresent() );

    // if(on.getAsBoolean()){
    //   this.beltSubsystem.beltForward();
    // }else if(!on.getAsBoolean()){
    //   this.beltSubsystem.beltOff();
    // }
     if( this.triggerRelease.getAsBoolean()){
      this.beltSubsystem.beltOff();
     }
     if(this.triggerPressed.getAsBoolean()){
      this.beltSubsystem.beltForward();
     }

//Add time to when sensor is broken
    if (this.reverse.getAsBoolean()) {
      this.beltSubsystem.beltReverse();
    }else{
      if(beltSubsystem.getFPGATime() - initTime >= millisecondsToRun){

      // if(this.beltSubsystem.isUpperBallPresent()) {
      //   // if(this.triggerRelease.getAsBoolean()){
      //   //   this.beltSubsystem.beltForward();
      //   // }else{
           this.beltSubsystem.beltOff();
      //   // }
         System.out.println("Ball loaded!");
      }else if(this.beltSubsystem.islowerBallPresent()) {
        while (beltSubsystem.getFPGATime() - initTime <= millisecondsToRun){

        this.beltSubsystem.beltForward();
        System.out.println("Ball loading!");
        }
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
