// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.MotorExtender;

public class ExtendLift extends CommandBase {
  /** Creates a new ClimbFirstBar. */

  private final MotorExtender motorExtender;
  private final DigitalInput topSwitch = new DigitalInput(Constants.TOP_LIMIT_SWITCH);
  private final DigitalInput bottomSwitch = new DigitalInput(Constants.BOTTOM_LIMIT_SWITCH);

  public ExtendLift(MotorExtender me) {
    // Use addRequirements() here to declare subsystem dependencies.

    motorExtender = me;
    addRequirements(motorExtender);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    motorExtender.run(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      motorExtender.run(0.25);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motorExtender.run(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return topSwitch.get();
  }
}
