/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.canConstant;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ballIntakeSubsystem extends SubsystemBase {
   private final WPI_TalonSRX ballIntake = new WPI_TalonSRX(canConstant.ballIntakePort);
  
    public ballIntakeSubsystem () {
    }

    public void setMotor (double speed) {
      ballIntake.set(speed);
    }

    public void startMotor (){
      ballIntake.set(1);
    }

    public void stopMotor(){
      ballIntake.set(0);
    }
}
