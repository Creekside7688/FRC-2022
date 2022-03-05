// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorExtender extends SubsystemBase {
  /** Creates a new MotorExtender. */
  private final TalonSRX motor_a = new TalonSRX(Constants.MOTOR_FOR_EXTENDING[0]);
  private final TalonSRX motor_b = new TalonSRX(Constants.MOTOR_FOR_EXTENDING[1]);
  public MotorExtender() {}

  public void run(double speed){
    motor_a.set(ControlMode.PercentOutput, speed);
    motor_b.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
