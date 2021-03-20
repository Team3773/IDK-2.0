// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;
import frc.robot.Constants.canConstant;

public class manualAnglerSubsystem extends SubsystemBase {
  private final static WPI_VictorSPX ballAngler = new WPI_VictorSPX(canConstant.ballAnglerPort);



  /** Creates a new manualAngler. */

  public manualAnglerSubsystem() {}

	// public void manualAnglerCommand(boolean speed) {
      
  //     ballAngler.set(speed); 
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

// public void angleForward() {
//   ballAngler.set(0.5); 

// }

// public void angleBackward() {
//   ballAngler.set(-0.5); 
// }

// public void stopMotor() {
//   ballAngler.set(0); 

// }


}
