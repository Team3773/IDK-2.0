/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

//import frc.robot.Robot;
//import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManuallyCommand;
import edu.wpi.first.wpilibj.Encoder;

public class DriveSubsystem extends Subsystem {
   PWMTalonSRX leftMaster = null;
   PWMTalonSRX leftSlave = null;
   PWMTalonSRX rightMaster = null;
   PWMTalonSRX rightSlave = null;
   DifferentialDrive drive = null;
   Encoder e = null;
   
  // PWMTalonSRX thing = null;

  public DriveSubsystem () {

     PWMTalonSRX leftMaster = new  PWMTalonSRX(RobotMap.leftMasterPort);
     PWMTalonSRX leftSlave = new  PWMTalonSRX(RobotMap.leftSlavePort);
      SpeedControllerGroup leftSide = new SpeedControllerGroup(leftMaster, leftSlave);
  
      PWMTalonSRX rightMaster = new  PWMTalonSRX(RobotMap.rightMasterPort);
      PWMTalonSRX rightSlave = new  PWMTalonSRX(RobotMap.rightSlavePort);
      SpeedControllerGroup rightSide = new SpeedControllerGroup(rightMaster, rightSlave);
      

    
      drive = new DifferentialDrive(leftSide, rightSide);
      drive.setSafetyEnabled(false);   
      //encoder init
      e = new Encoder(0, 1);
      e.setDistancePerPulse(1.0/256.0);

  }

  public void driveManually(double move, double turn) {
    //leftSlave.follow(leftMaster);
   // rightSlave.follow(rightMaster);
    drive.arcadeDrive(move, turn);
  
  }
  public double getDistance(){
    return e.getDistance();
  }
  public void resetDistance(){
    e.reset();
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveManuallyCommand());
    //setDefaultCommand(new ());
  }
}