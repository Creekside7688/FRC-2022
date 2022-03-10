// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.MotorExtender;

public class Extend_and_Retract extends CommandBase {
  private final MotorExtender motorExtender;
  private final Joystick joystick = new Joystick(0);

  /** Creates a new Extend. */
  public Extend_and_Retract(MotorExtender me) {
    motorExtender = me;
    addRequirements(motorExtender);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motorExtender.run(joystick.getRawAxis(Constants.RIGHT_Y_AXIS));
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
