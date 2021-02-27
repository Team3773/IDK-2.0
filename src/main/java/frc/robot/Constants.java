// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class canConstant {
        public static final int ballAnglerPort = 9;
        public static final int ballIntakePort = 1;
        public static final int ballOutakePort = 6;
        public static final int ballOutakePort1 = 2;
        public static final int ballBeltPort = 3;
    }

    public static final class usbConstant {
        public static final int joystickPort = 3;
        // public static final int xboxPort = 2;
    }

    public static final class sensorConstant {
        public static final int lowerBallPresentPort = 8;
        public static final int upperBallPresentPort = 7;

    }

    public static final class angleConstants {
        public static final int anglerScalar = 1;
        public static final int[] angleEncoderPorts = new int[] { 0, 1 };
        public static final double setPoint = 0;
        public static final int limitSwitchPort = 2;
        public static final double kAngleTick = Math.PI * 2.75 / 360.0;
        //public static final double angleEncoderDistancePerPulse = 1.0 / 256.0 * 6 * Math.PI / 12;;

    }

    public static final class driveConstants {
        public static final int leftMasterPort = 8;
        public static final int leftSlavePort = 7;
        public static final int rightMasterPort = 5;
        public static final int rightSlavePort = 4;
        public static final int[] driveEncoderPorts = new int[] { 5, 6 };
        public static final boolean driveEncoderReversed = false;
        public static final double driveEncoderDistancePerPulse = 1.0 / 256.0;
        public static final double speedScaler = 1;
        public static final int reverseButton = 1;
    }

}
