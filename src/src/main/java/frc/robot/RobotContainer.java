// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Extend_and_Retract;
import frc.robot.commands.driveJoystick;
import frc.robot.commands.tilt_Arm;
import frc.robot.commands.tilt_arm_back;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.MotorExtender;
import frc.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.Constants.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrain dt = new DriveTrain();
  private final driveJoystick drive = new driveJoystick(dt);

  // motor extender
  private final MotorExtender mext = new MotorExtender();
  private final Extend_and_Retract ear = new Extend_and_Retract(mext);

  // pneumatics
  private final Pneumatics pneu = new Pneumatics();
  private final tilt_Arm forward_tilt = new tilt_Arm(pneu);
  private final tilt_arm_back backward_tilt = new tilt_arm_back(pneu);

  private final Joystick joystick = new Joystick(JOYSTICK_PORT);
  private final JoystickButton rb_button = new JoystickButton(joystick, RB_BUTTON);
  private final JoystickButton y_button = new JoystickButton(joystick, Y_BUTTON);
  private final JoystickButton a_button = new JoystickButton(joystick, A_BUTTON);
  private final JoystickButton x_button = new JoystickButton(joystick, X_BUTTON);

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    rb_button.whileHeld(drive);

    y_button.whenPressed(forward_tilt);
    a_button.whenPressed(backward_tilt);
    x_button.whileHeld(ear);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
