/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.canConstant;

public class ballOutakeSubsystem extends SubsystemBase {
<<<<<<< HEAD
  private final WPI_VictorSPX ballOutake1 = new WPI_VictorSPX(canConstant.ballOutakePort1);
  private final WPI_TalonSRX ballOutake = new WPI_TalonSRX(canConstant.ballOutakePort);
=======
  private final WPI_VictorSPX ballOutake = new WPI_VictorSPX(canConstant.ballOutakePort);
  private final WPI_VictorSPX ballOutake1 = new WPI_VictorSPX(canConstant.ballOutakePort1);
>>>>>>> fd0a7b596f1d51955a38719051db898bb7f30577


  public ballOutakeSubsystem() {}

  public void setmotor(double speed) {
<<<<<<< HEAD
    ballOutake.set(-speed);
=======
    ballOutake.set(speed);
>>>>>>> fd0a7b596f1d51955a38719051db898bb7f30577
    ballOutake1.set(speed);
  }

}
