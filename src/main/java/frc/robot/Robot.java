/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.driveAuto;
// import frc.robot.commands.DriveManuallyCommand;
import frc.robot.subsystems.*;
import edu.wpi.first.cameraserver.CameraServer;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import java.sql.Time;
import frc.robot.subsystems.DriveSubsystem;
// import edu.wpi.first.wpilibj.PWM;
// import frc.robot.commands.DriveManuallyCommand;


//import frc.robot.commands.ballDoorCommand;
//import frc.robot.subsystems.ballDoorSubsystem;
//import frc.robot.RobotMap;
//import edu.wpi.cscore.VideoSource;
//import edu.wpi.cscore.UsbCamera;
//import edu.wpi.first.wpilibj.cameraServer.CameraServer;
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj
//import frc.robot.commands.DriveManuallyCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveSubsystem driveSubsystem = null;
  public static ballIntakeSubsystem ballIntakeSub = null;
  public static liftArmSubsystem liftArmSub = null;
  public static liftWinchSubsystem liftWinchSub = null;
  public static ballOutakeSubsystem ballOutakeSub = null;
  public static ballBeltSubsystem ballBeltSub = null;
  
  public static OI oi;
 
  driveAuto auto= null;
 // public static CameraServer cs = null;
  Command autonomousCommand;
  SendableChooser<Command> chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    driveSubsystem = new DriveSubsystem();
    ballIntakeSub = new ballIntakeSubsystem();
    liftArmSub = new liftArmSubsystem();
    liftWinchSub = new liftWinchSubsystem();
    ballOutakeSub = new ballOutakeSubsystem();
    ballBeltSub = new ballBeltSubsystem();
    
    
   


    
    //limitSwitchfront = new DigitalInput(1);//RobotMap.limitswitchportfront);
    oi = new OI(); 
    CameraServer.getInstance().startAutomaticCapture();
    
  

    //cs.getInstance().startAutomaticCapture();
    //chooser.setDefaultOption("Default Auto", new DriveManuallyCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    auto = new driveAuto();


    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    //addSequential(new driveAuto());


  
      
    
  }
  // Drives forward at half speed until the robot has moved 5 feet, then stops:
  





  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
