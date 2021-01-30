/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.ballOutakeCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;

public class ballOutakeSubsystem extends Subsystem {
   PWMTalonSRX ballOutake = null;
  
  
    public ballOutakeSubsystem () {
      ballOutake = new PWMTalonSRX(RobotMap.ballIntakePort);

    }
    public void setmotor (double speed) {
      ballOutake.set(speed);

    }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new ballOutakeCommand());
  }
}
