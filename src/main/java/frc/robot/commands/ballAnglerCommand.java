/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.Robot;
import frc.robot.OI;


public class ballAnglerCommand extends Command {
  public double ballAnglerVar;
  private double yValue;

  public ballAnglerCommand() {
    requires(Robot.ballAnglerSub);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.ballAnglerSub.setmotor(0);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.ballAnglerSub.setmotor(yValue);
    yValue=OI.xbox.getY(GenericHID.Hand.kRight);
    System.out.println(yValue);
    }
    

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false; 
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }


  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
