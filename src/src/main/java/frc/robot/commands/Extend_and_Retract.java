// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.MotorExtender;
import static frc.robot.Constants.*;

public class Extend_and_Retract extends CommandBase {
  private final MotorExtender motorExtender;
  private final Joystick joystick = new Joystick(JOYSTICK_PORT);
  private final DigitalInput topSwitch = new DigitalInput(Constants.TOP_LIMIT_SWITCH);
  private final DigitalInput bottomSwitch = new DigitalInput(Constants.BOTTOM_LIMIT_SWITCH);
  /** Creates a new Extend. */
  public Extend_and_Retract(MotorExtender me) {
    motorExtender = me;
    addRequirements(motorExtender);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    motorExtender.run(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(topSwitch.get()){
      System.out.println("top switch active");
    }else if(bottomSwitch.get()){
      System.out.println("bottom switch active");
    }
    //left down
    if (joystick.getRawAxis(Constants.L_TRIGGER) > 0) {
      motorExtender.run((joystick.getRawAxis(Constants.L_TRIGGER) * -0.5));
    //right up
    } else if (joystick.getRawAxis(Constants.R_TRIGGER) > 0) {
      motorExtender.run(joystick.getRawAxis(Constants.R_TRIGGER) * 0.5);
    } else {
      motorExtender.run(0);
    }
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motorExtender.run(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
