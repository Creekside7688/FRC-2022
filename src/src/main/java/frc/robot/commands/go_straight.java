// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class go_straight extends CommandBase {
  /** Creates a new go_straight. */
  private final DriveTrain dt;
  public go_straight(DriveTrain dtt) {
    dt = dtt;
    addRequirements(dt);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    dt.reset_encoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    dt.drive(0.3, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dt.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //unit is cm
    if(dt.get_distance_travelled()>20){
      return true;
    }
    return false;
  }
}
