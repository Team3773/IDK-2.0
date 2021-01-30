/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  //CAN
  public static int leftMasterPort = 3;
  public static int leftSlavePort = 4;
  public static int rightMasterPort = 1;
  public static int rightSlavePort = 2;

  public static int liftArmPort = 6;
  public static int ballIntakePort = 5; 
  public static int liftWinchPort = 8;
  public static int ballOutakePort = 7;
  public static int ballBeltPort = 9;

  //USB
  public static int joystickPort = 3;
  public static int xboxPort = 2;

  //Sensors
  public static int lowerBallPresentPort = 10;
  public static int upperBallPresentPort = 11;

  //public static int limitswitchportback= 7;
  //public static int limitswitchportfront= 6;
  
  
  
}