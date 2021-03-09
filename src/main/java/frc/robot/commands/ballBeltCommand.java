// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ballBeltSubsystem;
import edu.wpi.first.wpilibj.Timer;


public class ballBeltCommand extends CommandBase {
  private BooleanSupplier reverse;
  private BooleanSupplier triggerRelease;
  private BooleanSupplier triggerPressed;
  private final ballBeltSubsystem beltSubsystem;
  private Timer ballTimer = new Timer();
  private Timer triggerTimer = new Timer();

 
  /** Creates a new ballBeltCommand. */
  public ballBeltCommand(ballBeltSubsystem beltSubsystem, BooleanSupplier reverse, BooleanSupplier triggerRelease, BooleanSupplier triggerPressed) {
    System.out.println("init");
    this.beltSubsystem = beltSubsystem;
    this.triggerRelease = triggerRelease;
    this.triggerPressed = triggerPressed;
    this.reverse = reverse;



    addRequirements(this.beltSubsystem);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    System.out.printf("lower ball = %b, upper ball = %b",this.beltSubsystem.islowerBallPresent(), this.beltSubsystem.isUpperBallPresent() );

    if (this.reverse.getAsBoolean()) {
      this.beltSubsystem.beltReverse();
    }else{
      if( this.triggerRelease.getAsBoolean()){
        if(triggerTimer.get() > 3){
        this.beltSubsystem.beltOff();
        triggerTimer.stop();
        triggerTimer.reset();
        }
      }
      if(this.triggerPressed.getAsBoolean()){
        triggerTimer.start();
        if(triggerTimer.get() <= 3){
        this.beltSubsystem.beltForward();
        }
      }else{
          if(this.beltSubsystem.islowerBallPresent()) {
            ballTimer.start();
            System.out.println(ballTimer.get());
            System.out.println("Beam broken!");
             if(ballTimer.get() <= 0.59){
             this.beltSubsystem.beltForward();
            }
          //  timer.stop();
        }
          if(this.beltSubsystem.islowerBallClear()){
            System.out.println("Beam clear!");
            // timer.start();
            //   System.out.println(timer.get());
            //   if(timer.get() < 3){
              if (ballTimer.get() > 0.59){
              beltSubsystem.beltOff();
              ballTimer.stop();
              ballTimer.reset(); 
              }
            //  }
           // timer.reset(); 
          }
      }
    }   
  }

  // while (beltSubsystem.getFPGATime() - initTime <= millisecondsToRun){

          //   // }
        //  System.out.println("Ball loaded!");


          //if(this.beltSubsystem.isUpperBallPresent()) {

      //   // if(this.triggerRelease.getAsBoolean()){
      //   //   this.beltSubsystem.beltForward();
      //   // }else{
              // if(beltSubsystem.getFPGATime() - initTime >= millisecondsToRun){

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
