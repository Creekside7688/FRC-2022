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
    public final static double MULTI(double speed, double sensitivity){
        double multiOutput = Math.pow(speed, 3) * sensitivity + (1 - sensitivity) * speed;
        return multiOutput;
    }

    public final static double SENSITIVITY = 1;

    /* Joystick */
    public static final int DRIVE_JOYSTICK_PORT = 1;

    /* Drive Train Motors */
    public static final int LEFT_FRONT_TOP_MOTOR = 1;
    public static final int LEFT_FRONT_BOTTOM_MOTOR = 2;
    public static final int LEFT_BACK_TOP_MOTOR = 3;
    public static final int LEFT_BACK_BOTTOM_MOTOR = 4;

    public static final int RIGHT_FRONT_TOP_MOTOR = 5;
    public static final int RIGHT_FRONT_BOTTOM_MOTOR = 6;
    public static final int RIGHT_BACK_TOP_MOTOR = 7;
    public static final int RIGHT_BACK_BOTTOM_MOTOR = 8;

    /* Encoders */
    public static final int[] LEFT_ENCODER= new int[]{0,1};
    public static final int[] RIGHT_ENCODER = new int[]{2,3};

    public static final double WHEELPERIMETERCM = 15.24 * Math.PI;
    public static final double DISTANCEPERPULS = WHEELPERIMETERCM / 2048;
}
