/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.liftArmCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;

public class liftArmSubsystem extends Subsystem {
   PWMTalonSRX liftArm = null;
  
   

   public liftArmSubsystem () {
     liftArm = new PWMTalonSRX(RobotMap.liftArmPort);

   }
   public void setmotor(double speed) {
    liftArm.set(speed);
   }
  
  
   @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new liftArmCommand());
  }
}
