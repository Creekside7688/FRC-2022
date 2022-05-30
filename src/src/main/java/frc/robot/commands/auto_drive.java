// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LimeLight;

public class auto_drive extends CommandBase {
  /** Creates a new auto_drive. */
  private final DriveTrain dt;
  private final LimeLight ll;
  private final Timer time = new Timer();
  public auto_drive(DriveTrain dtt,LimeLight la) {
    dt = dtt;
    ll = la;
    addRequirements(dt);
    addRequirements(ll);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.reset();
    time.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  //Tyがゼロになったらロボットがバーの真下にある
  @Override
  public void execute() {
    if(ll.getTarget()==0){
      dt.drive(0.3, 0);
      System.out.println("Where ???????");
    } else {
      System.out.println("I can see the object!!!");
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dt.drive(0, 0);
   
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(ll.getTarget()==1){
      if(ll.getY()>-5 && ll.getY()>5){
        return true;
      }
    }
    
    return false;
    
  }
}
