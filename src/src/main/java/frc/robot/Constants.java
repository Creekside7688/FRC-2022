// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Drive train 
    public static final int LEFT_FRONT_TOP_MOTOR = 5;
    public static final int LEFT_FRONT_BOTTOM_MOTOR = 10;
    public static final int LEFT_BACK_TOP_MOTOR = 13;
    public static final int LEFT_BACK_BOTTOM_MOTOR = 8;

    public static final int RIGHT_FRONT_TOP_MOTOR = 1;
    public static final int RIGHT_FRONT_BOTTOM_MOTOR = 11;
    public static final int RIGHT_BACK_TOP_MOTOR = 12;
    public static final int RIGHT_BACK_BOTTOM_MOTOR = 4;

    public static final int[] LEFT_ENCODER= new int[]{0,1};
    public static final int[] RIGHT_ENCODER = new int[]{2,3};

    public static final double WHEELPERIMETERCM = 15.24*Math.PI;
    public static final double DISTENCEPERPULS = WHEELPERIMETERCM/2048;

    //Arm
    public static final int[] MOTOR_FOR_EXTENDING = new int[]{1,3};
    public static final int TOP_LIMIT_SWITCH = 0;
    public static final int BOTTOM_LIMIT_SWITCH = 1;

    //Pneumatic
    public static final int[] DOUBLE_SOLENOID = new int[]{0,1};
    //Controller
    public static final int RIGHT_X_AXIS = 0;
    public static final int RIGHT_Y_AXIS = 0;
    public static final int LEFT_X_AXIS = 0;
    public static final int LEFT_Y_AXIS = 0;
    public static final int X_BUTTON = 0;
    public static final int Y_BUTTON = 0;
    public static final int A_BUTTON = 0;
    public static final int B_BUTTON = 0;
    public static final int RIGHT_SHOULDER = 0;
    public static final int LEFT_SHOULDER = 0;

}
