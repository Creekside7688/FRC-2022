// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */

  /**Left Front Bottom */
  private final WPI_TalonSRX LFBmotor;
  private final WPI_VictorSPX LFTmotor;
  private final WPI_VictorSPX LBBmotor;
  private final WPI_VictorSPX LBTmotor;

  /* Right Back Top */
  private final WPI_TalonSRX RFTmotor;
  private final WPI_VictorSPX RFBmotor;
  private final WPI_VictorSPX RBTmotor;
  private final WPI_VictorSPX RBBmotor;

  private final MotorControllerGroup LEFT_MOTORS;
  private final MotorControllerGroup RIGHT_MOTORS;

  private final DifferentialDrive Diffdrive;
  private final Encoder leftencoder;
  private final Encoder rightencoder;

  /**
   * DriveTrain to drive the robot around.
   */
  public DriveTrain() {
    /* Left Motors */
    LFBmotor = new WPI_TalonSRX(LEFT_FRONT_BOTTOM_MOTOR);
    LFTmotor = new WPI_VictorSPX(LEFT_FRONT_TOP_MOTOR);
    LBBmotor = new WPI_VictorSPX(LEFT_BACK_BOTTOM_MOTOR);
    LBTmotor = new WPI_VictorSPX(LEFT_BACK_TOP_MOTOR);

    LEFT_MOTORS = new MotorControllerGroup(LFBmotor, LFTmotor, LBBmotor, LBTmotor);

    /* Right Motors */
    RFTmotor = new WPI_TalonSRX(RIGHT_FRONT_TOP_MOTOR);
    RFBmotor = new WPI_VictorSPX(RIGHT_FRONT_BOTTOM_MOTOR);
    RBTmotor = new WPI_VictorSPX(RIGHT_BACK_TOP_MOTOR);
    RBBmotor = new WPI_VictorSPX(RIGHT_BACK_BOTTOM_MOTOR);

    RIGHT_MOTORS = new MotorControllerGroup(RFTmotor, RFBmotor, RBTmotor, RBBmotor);
    RIGHT_MOTORS.setInverted(true);

    /* Encoder */
    leftencoder = new Encoder(LEFT_ENCODER[0], LEFT_ENCODER[1], true);
    rightencoder = new Encoder(RIGHT_ENCODER[0], RIGHT_ENCODER[1], false);

    leftencoder.setDistancePerPulse(DISTANCEPERPULS);
    rightencoder.setDistancePerPulse(DISTANCEPERPULS);

    /* Diffdrive */
    Diffdrive = new DifferentialDrive(LEFT_MOTORS, RIGHT_MOTORS);
  }

  /**
   * Resets the encoders
   */
  public void resetEncoders() {
    leftencoder.reset();
    rightencoder.reset();
  }

  /**
   * Get the average distance
   * @return the average distance of the left and right encoder
   */
  public double getAverageDistance() {
    return (leftencoder.getDistance() + rightencoder.getDistance()) / 2;
  }

  public double getDiffDistance() {
    return leftencoder.getDistance() - rightencoder.getDistance();
  }

  /**
   * Drive the drivetrain
   * @param speed Speed (positive = forwards)
   * @param rotation Rotation
   */
  public void drive(double speed, double rotation) {
    Diffdrive.arcadeDrive(speed, rotation);
  }

  /**
   * Stop the drivetrain
   */
  public void stop() {
    Diffdrive.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
