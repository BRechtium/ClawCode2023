package frc.robot;

public final class Constants {

    public static class Claw {
        public static final double kP = 0.25; // Arbitrary, Needs Refinement
        public static final double kI = 0;
        public static final double kD = 0.25; // Arbitrary, Needs Refinement
        public static final double kFF = 0;
        public static final double kIZone = 0;
        public static final double kConeMinHue = 70;
        public static final double kConeMaxHue = 95;
        public static final double kCubeMinHue = 140;
        public static final double kCubeMaxHue = 230;
        public static final double kConeClose = 270 / 360; // (In Degrees) Arbitrary, Needs Refinement 
        public static final double kCubeClose = 120 / 360; // (In Degrees) Arbitrary, Needs Refinement
        public static final double kOpen = 0 / 360; // (In Degress) Arbitrary, Needs Refinement
        public static final double kOpenClawRate = -0.005; // Arbitrary, Needs Refinement
        public static final double kCloseClawRate = 0.005; // Arbitrary, Needs Refinement
        public static final double kContLimit = 290 / 360; // (In Degress) Arbitrary, Needs Refinement
    }

}
