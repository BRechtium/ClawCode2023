// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.ClawMechanism;
import static frc.robot.Constants.Claw.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ColorSensorV3.RawColor;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClawSubsystem extends SubsystemBase {
  /** Creates a new ClawSubsystem. */
  CANSparkMax m_motor = new CANSparkMax(0, MotorType.kBrushless);
 
  double kRotations = 0;
  double hue = 0;
  double prevHue = 0;
  ColorSensorV3 m_colorSensor = new ColorSensorV3(Port.kOnboard);
  public SparkMaxPIDController m_pidController = m_motor.getPIDController();

  public ClawSubsystem() {
    m_motor.restoreFactoryDefaults();
    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
    m_pidController.setFF(kFF);
    m_pidController.setIZone(kIZone); 
  }

  @Override
  public void periodic() {
    hue = getHue(m_colorSensor.getRawColor());

    if (hue > prevHue + 20 || hue < prevHue - 20) {
      if (kConeMinHue <= hue && hue >= kConeMaxHue) {
        kRotations = kConeClose / 360;
        setReference();
      } else if (kCubeMinHue <= hue && hue <= kCubeMaxHue) {
        kRotations = kCubeClose / 360 ;
        setReference();
      }
      
    }
  }

  public void setRotations(double rotations) {
    kRotations = rotations;
  }

  public double getRotations() {
    return kRotations;
  }
  public void setReference() {
    m_pidController.setReference(kRotations, ControlType.kPosition);
  }

  public double getHue (RawColor color) {
    double Red = color.red;
    double Blue = color.blue;
    double Green = color.green;
    double preHue = 0;

    if (Red == Math.max(Red, Math.max(Green, Blue))) {
      preHue = (Green - Blue) / (Red - Math.min(Green, Blue));
    } else if (Green == Math.max(Red, Math.max(Green, Blue))) {
      preHue = 2 + (Red - Blue) / (Green - Math.min(Red, Blue));
    } else {
      preHue = 4 + (Red - Green) / (Blue - Math.min(Green, Red));
    }

    if (preHue < 0) {preHue += 6;}
    return preHue * 60;
  }
}