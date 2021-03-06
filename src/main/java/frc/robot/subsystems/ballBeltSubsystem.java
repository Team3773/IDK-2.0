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
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;

public class ballBeltSubsystem extends SubsystemBase {

  private final WPI_VictorSPX ballBelt = new WPI_VictorSPX(canConstant.ballBeltPort);
  public DigitalInput lowerBallPresent = new DigitalInput(sensorConstant.lowerBallPresentPort);
  public DigitalInput upperBallPresent = new DigitalInput(sensorConstant.upperBallPresentPort);
  double startTime;
  public ballBeltSubsystem() {
  }

  public boolean islowerBallPresent() {
    return !lowerBallPresent.get();
  }

  public boolean isUpperBallPresent() {
    return !upperBallPresent.get();
  }

  public boolean islowerBallClear() {
    return lowerBallPresent.get();
  }
  public void setmotor(double speed) {
    ballBelt.set(speed);
  }
  public void setStartTime(){
    startTime = System.currentTimeMillis(); 
  }
  // public void startTimeOriginal(){
  //   startTime;
  // }
  public void beltOff() {
    ballBelt.set(0);
  }

  public void beltReverse() {
    ballBelt.set(0.5);
  }

  public void beltForward() {
    ballBelt.set(-0.5);
  }

  public void read() {
  System.out.print(lowerBallPresent.get());

  }

public long getFPGATime() {
	return 0;
}



}
