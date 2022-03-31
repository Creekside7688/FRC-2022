// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class driveJoystick extends CommandBase {
  private final DriveTrain m_Drivetrain;
  private final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);
  /** Creates a new driveJoystick. */
  public driveJoystick(DriveTrain d) {
    m_Drivetrain = d;
    addRequirements(m_Drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drivetrain.drive(joystick.getRawAxis(Constants.LEFT_Y_AXIS) * 0.5 * Constants.SAFETYSPEED, joystick.getRawAxis(Constants.RIGHT_X_AXIS) * 0.5 * Constants.SAFETYSPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
