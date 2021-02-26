/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.canConstant;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ballIntakeSubsystem extends SubsystemBase {
   private final WPI_VictorSPX ballIntake = new WPI_VictorSPX(canConstant.ballIntakePort);
  
    public ballIntakeSubsystem () {
    }

    public void setmotor (double speed) {
      ballIntake.set(speed);
    }
}
