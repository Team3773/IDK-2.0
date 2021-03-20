// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ballAnglerSubsystem;

public class zeroAngler extends CommandBase {
  /** Creates a new zeroAngler. */
  private final ballAnglerSubsystem angler;
  // private final double calibrate;
  //  public zeroAngler(ballAnglerSubsystem angler, int i) {

   public zeroAngler(ballAnglerSubsystem angler) {
    this.angler = angler;
    // this.calibrate = i;
    addRequirements(this.angler);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  // @Override
  // public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     this.angler.setmotor(-1);
    // this.angler.setmotor(calibrate);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.angler.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(this.angler.getLimitSwitch()){
      this.angler.resetDistance();
      return true;
    }else{
      return false;
    }
  }
}
