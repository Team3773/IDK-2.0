/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants.canConstant;
import frc.robot.Constants.sensorConstant;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;

public class ballBeltSubsystem extends SubsystemBase {
   private final WPI_TalonSRX ballBelt = new WPI_TalonSRX(canConstant.ballBeltPort);
   private DigitalInput lowerBallPresent = new DigitalInput(sensorConstant.lowerBallPresentPort);
   public DigitalInput upperBallPresent = new DigitalInput(sensorConstant.upperBallPresentPort); 
  
    public ballBeltSubsystem () {
    }

    public boolean islowerBallPresentSet() {
      return !lowerBallPresent.get();
    }

    public boolean isUpperBallPresentSet() {
      return !upperBallPresent.get();
    }

    public void setmotor (double speed) {
      ballBelt.set(speed);
    }

    public void beltOff(){
      ballBelt.set(0);
    }

    public void beltReverse(){
      ballBelt.set(-0.5);
    }

    public void beltForward(){
      ballBelt.set(0.5);
    }

}
