/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.canConstant;

public class ballOutakeSubsystem extends SubsystemBase {
  private final WPI_VictorSPX ballOutake = new WPI_VictorSPX(canConstant.ballOutakePort);
  private final WPI_VictorSPX ballOutake1 = new WPI_VictorSPX(canConstant.ballOutakePort1);


  public ballOutakeSubsystem() {}

  public void setmotor(double speed) {
    ballOutake.set(speed);
    ballOutake1.set(speed);
  }

}
