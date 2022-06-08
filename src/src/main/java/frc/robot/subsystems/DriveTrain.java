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
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  //Left motors
  private final WPI_TalonSRX LFTmotor;
  private final WPI_VictorSPX LFBmotor;
  private final WPI_VictorSPX LBTmotor;
  private final WPI_VictorSPX LBBmotor;
  //Right motors
  private final WPI_VictorSPX RFTmotor;
  private final WPI_TalonSRX RFBmotor;
  private final WPI_VictorSPX RBTmotor;
  private final WPI_VictorSPX RBBmotor;

  private final MotorControllerGroup rightMotor;
  private final MotorControllerGroup leftMotor;

  private final DifferentialDrive diffdrive;
  //Encoder
  private final Encoder rightEncoder;
  private final Encoder leftEncoder;

  public DriveTrain() {
    LFTmotor = new WPI_TalonSRX(Constants.LEFT_FRONT_TOP_MOTOR);
    LFBmotor = new WPI_VictorSPX(Constants.LEFT_FRONT_BOTTOM_MOTOR);
    LBTmotor = new WPI_VictorSPX(Constants.LEFT_BACK_TOP_MOTOR);
    LBBmotor = new WPI_VictorSPX(Constants.LEFT_BACK_BOTTOM_MOTOR);

    leftMotor = new MotorControllerGroup(LFTmotor,LFBmotor,LBTmotor,LBBmotor);
    leftMotor.setInverted(true);

    RFTmotor = new WPI_VictorSPX(Constants.RIGHT_FRONT_TOP_MOTOR);
    RFBmotor = new WPI_TalonSRX(Constants.RIGHT_FRONT_BOTTOM_MOTOR);
    RBTmotor = new WPI_VictorSPX(Constants.RIGHT_BACK_TOP_MOTOR);
    RBBmotor = new WPI_VictorSPX(Constants.RIGHT_BACK_BOTTOM_MOTOR);

    rightMotor = new MotorControllerGroup(RFTmotor,RFBmotor,RBTmotor,RBBmotor);
    diffdrive = new DifferentialDrive(leftMotor,rightMotor);

    rightEncoder = new Encoder(Constants.RIGHT_ENCODER[0], Constants.RIGHT_ENCODER[1],false);
    leftEncoder = new Encoder(Constants.LEFT_ENCODER[0], Constants.LEFT_ENCODER[1],true);

    rightEncoder.setDistancePerPulse(Constants.DISTENCEPERPULS);
    leftEncoder.setDistancePerPulse(Constants.DISTENCEPERPULS);
  }

  public double get_distance_travelled(){
    return (rightEncoder.getDistance()+leftEncoder.getDistance())/2;
  }

  public double get_rightEncoder_value(){
    return rightEncoder.getDecodingScaleFactor();
  }

  public double get_leftEncoder_value(){
    return leftEncoder.getDistance();
  }

  public void drive(double speed,double rotation){
    diffdrive.arcadeDrive(speed, rotation);
  }

  public void stop(){
    diffdrive.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
