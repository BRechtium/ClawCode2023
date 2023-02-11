package frc.robot;

public final class Constants {

    public static class Claw {
        public static final double kP = 0.25; // Arbitrary, Needs Refinement
        public static final double kI = 0;
        public static final double kD = 0.25; // Arbitrary, Needs Refinement
        public static final double kFF = 0;
        public static final double kIZone = 0;
        public static final double kConeMinHue = 30;
        public static final double kConeMaxHue = 70;
        public static final double kCubeMinHue = 250;
        public static final double kCubeMaxHue = 300;
        public static final double kConeClose = 270; // (In Degrees) Arbitrary, Needs Refinement 
        public static final double kCubeClose = 120; // (In Degrees) Arbitrary, Needs Refinement
        public static final double kOpen = 0; // (In Degress) Arbitrary, Needs Refinement
    }

}
