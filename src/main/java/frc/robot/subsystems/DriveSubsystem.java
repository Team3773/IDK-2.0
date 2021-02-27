/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Constants.driveConstants;
import edu.wpi.first.wpilibj.Encoder;

public class DriveSubsystem extends SubsystemBase {

  private final SpeedControllerGroup leftSide = 
    new SpeedControllerGroup(
       new WPI_TalonSRX(driveConstants.leftMasterPort),
       new WPI_TalonSRX(driveConstants.leftSlavePort));


  private final SpeedControllerGroup rightSide = 
    new SpeedControllerGroup(
      new WPI_TalonSRX(driveConstants.rightMasterPort),
      new WPI_TalonSRX(driveConstants.rightSlavePort));

  private final DifferentialDrive drive = new DifferentialDrive(leftSide, rightSide);

  private final Encoder e = new Encoder( 
    driveConstants.driveEncoderPorts[0], 
    driveConstants.driveEncoderPorts[1],
    driveConstants.driveEncoderReversed
    );

  public DriveSubsystem () {
      drive.setSafetyEnabled(false);
      //e.setDistancePerPulse(driveConstants.driveEncoderDistancePerPulse);
  }

  //drive with arcadeDrive
  public void driveManually(double move, double turn) {
    drive.arcadeDrive(move, turn);
  }

  //get encoder distance since reset
  public double getDistance(){
    return e.getDistance();
  }

  //reset encoder(s?)
  public void resetDistance(){
    e.reset();
  }
  public void stopMotors(){
    drive.arcadeDrive(0, 0);
  }
}