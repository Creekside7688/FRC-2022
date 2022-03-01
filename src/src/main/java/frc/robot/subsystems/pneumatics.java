// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class pneumatics extends SubsystemBase {
  /** Creates a new pneumatics. */
  private final DoubleSolenoid cylinders = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);

  public pneumatics() {}
  public void push(){
    cylinders.set(Value.kForward);
  }

  public void back() {
    cylinders.set(Value.kReverse);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
