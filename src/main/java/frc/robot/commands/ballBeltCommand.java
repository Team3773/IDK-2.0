// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ballBeltSubsystem;


public class ballBeltCommand extends CommandBase {
  private BooleanSupplier reverse;
  private BooleanSupplier triggerRelease;
  private BooleanSupplier triggerPressed;

  // private BooleanSupplier lowerBallPresent;
  // private BooleanSupplier upperBallPresent;
  private final ballBeltSubsystem beltSubsystem;
 
  /** Creates a new ballBeltCommand. */
  public ballBeltCommand(ballBeltSubsystem beltSubsystem, BooleanSupplier reverse, BooleanSupplier triggerRelease, BooleanSupplier triggerPressed) {
    System.out.println("init");
    this.beltSubsystem = beltSubsystem;
    this.triggerRelease = triggerRelease;
    this.triggerPressed = triggerPressed;
    this.reverse = reverse;
    addRequirements(this.beltSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }



// Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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


    if (this.reverse.getAsBoolean()) {
      this.beltSubsystem.beltReverse();
    }else{
      Timer.delay(1.5);
//public static void delay(final double seconds) {}
      if(this.beltSubsystem.isUpperBallPresent()) {

        // if(this.triggerRelease.getAsBoolean()){
        //   this.beltSubsystem.beltForward();
        // }else{
          this.beltSubsystem.beltOff();
        // }
      
        System.out.println("Ball loaded!");
      }else if(this.beltSubsystem.islowerBallPresent()) {
        this.beltSubsystem.beltForward();
        System.out.println("Ball loading!");
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
