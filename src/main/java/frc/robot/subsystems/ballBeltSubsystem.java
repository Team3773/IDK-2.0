/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.ballBeltCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;
// import com.ctre.phoenix.motorcontrol.SensorCollection;
import edu.wpi.first.wpilibj.DigitalInput;



public class ballBeltSubsystem extends Subsystem {
   PWMTalonSRX ballBelt = null;
   public DigitalInput lowerBallPresent = null;
   public DigitalInput upperBallPresent = null; 
  
  
    public ballBeltSubsystem () {
      ballBelt = new PWMTalonSRX(RobotMap.ballBeltPort);
      upperBallPresent = new DigitalInput(RobotMap.upperBallPresentPort);
      lowerBallPresent = new DigitalInput(RobotMap.lowerBallPresentPort);

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
    

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new ballBeltCommand());
  }
}
