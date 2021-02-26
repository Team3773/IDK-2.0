
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
// import edu.wpi.first.wpilibj.DigitalInput;
// import edu.wpi.first.wpilibj.InterruptableSensorBase;

public class ballBeltCommand extends Command {
    boolean beltVar;
    boolean beltReverse;
    boolean lowerBallPresent;
    boolean upperBallPresent;
    public ballBeltCommand() {
    requires(Robot.ballBeltSub);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    beltVar = false;
    beltReverse = false;
    lowerBallPresent = false;
    upperBallPresent = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(stick.getRawButton(6)) {

      beltReverse = !beltReverse;
    }
    
    if(stick.getRawButton(7)){
      beltVar = !beltVar; 
  }

    if (beltReverse) {

  Robot.ballBeltSub.setmotor(-0.5);

    }
  
    else {

      if(beltVar) {

        Robot.ballBeltSub.setmotor(0.5);

      }
  }
    if(upperBallPresent = true) {

      Robot.ballBeltSub.setmotor(0.0);

    }

    if(lowerBallPresent = true) {

      Robot.ballBeltSub.setmotor(1.0);

    }
    if(upperBallPresent = true) {

      Robot.ballBeltSub.setmotor(0.0);

    }
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