/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.angleConstants;
import frc.robot.Constants.canConstant;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ballAnglerSubsystem extends SubsystemBase {

  public final static WPI_TalonSRX ballAngler = new WPI_TalonSRX(canConstant.ballAnglerPort);
  public final double kP = 0.5;
  public double setpoint = 0;
  public final double kAngleTick = Math.PI * 2.75 / 360.0;
  public DigitalInput forwardLimitSwitch;
  public Encoder aEncoder;

  public ballAnglerSubsystem() {
    aEncoder.setDistancePerPulse(angleConstants.angleEncoderDistancePerPulse);
    SmartDashboard.putNumber("Encoder", aEncoder.getDistance());
    System.out.print(aEncoder.getDistance());
  }

  public double getAngle() {
    return aEncoder.getDistance();
  }

  public void resetDistance() {
    aEncoder.reset();
  }

  public void stopMotor() {
    ballAngler.set(0);
  }

  public static void setmotor(double speed) {
    ballAngler.set(speed);
  }
  public void ballAnglerCommand(double tempAngle) {
  }
}
