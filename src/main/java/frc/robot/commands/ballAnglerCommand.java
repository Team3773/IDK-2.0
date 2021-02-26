// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.angleConstants;
import frc.robot.subsystems.ballAnglerSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ballAnglerCommand extends CommandBase {
  private final ballAnglerSubsystem ballAnglerSubsystem;
  private final Double setPoint;

  /**
   * Creates a new ballAnglerCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ballAnglerCommand(ballAnglerSubsystem subsystem, Double setPoint) {
    this.ballAnglerSubsystem = subsystem;
    this.setPoint = setPoint;
    addRequirements(this.ballAnglerSubsystem);
  }
  
  // Use addRequirements() here to declare subsystem dependencies.

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    // double sensorPosition = aEncoder.get() * kAngleTick;
    // double error = setpoint - sensorPosition;
    // double outputSpeed = kP * error;
    // double angle = aEncoder.get();

    // aEncoder = new Encoder( 
    //       angleConstants.angleEncoderPorts[1],
    //       angleConstants.angleEncoderPorts[2],
    //       false,
    //       EncodingType.k4X);
    
    // forwardLimitSwitch = new DigitalInput(9);

          
  // if (forwardLimitSwitch.get()){
  //   setpoint = 100;
  //   aEncoder.reset(); 
  //   angle = 0;
          

  //     ballAnglerSubsystem.setmotor(outputSpeed);


    // double tempAngle = angle.getAsDouble() * angleConstants.anglerScalar;
    // // ballAnglerSubsystem.periodic();

    // ballAnglerSubsystem.ballAnglerCommand(tempAngle);
  }
}
