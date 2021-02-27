/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.angleConstants;
import frc.robot.Constants.canConstant;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ballAnglerSubsystem extends SubsystemBase {

  private final static WPI_TalonSRX ballAngler = new WPI_TalonSRX(canConstant.ballAnglerPort);
  private DigitalInput forwardLimitSwitch = new DigitalInput(Constants.angleConstants.limitSwitchPort);
  private Encoder aEncoder = new Encoder(
    angleConstants.angleEncoderPorts[0],
    angleConstants.angleEncoderPorts[1],
    false,
    EncodingType.k4X);

  // private final double kAngleTick = Math.PI * 2.75 / 360.0;
  // private final double kP = 0.5;
  // private double setpoint = 0;

  public ballAnglerSubsystem() {
    //to init the angler we need to find the limit switch and set the encoder to zero
    //set motor to move until limit is reached
    //reset encoder
    //should be good to go

    aEncoder.setDistancePerPulse(angleConstants.kAngleTick);
    SmartDashboard.putNumber("Encoder", aEncoder.get());
    System.out.print(aEncoder.get());
  }

  public double getAngle() {
    return aEncoder.get();
  }

  public void resetDistance() {
    aEncoder.reset();
  }

  public void stopMotor() {
    ballAngler.set(0);
  }

  public void setmotor(double speed) {
    ballAngler.set(speed);
  }

  public boolean getLimitSwitch(){
    return this.forwardLimitSwitch.get();
  }
}
