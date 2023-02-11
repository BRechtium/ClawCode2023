// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import static frc.robot.Constants.Claw.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.ContinuousClawCommand;
import frc.robot.Commands.ColorClawCommand;
import frc.robot.Subsystems.ClawSubsystem;

public class RobotContainer {
  Joystick m_joystick = new Joystick (0);
  ClawSubsystem m_clawSubsystem = new ClawSubsystem();
  ColorClawCommand colorClawCommand = new ColorClawCommand(m_clawSubsystem);
  ContinuousClawCommand contClawCommand = new ContinuousClawCommand(m_clawSubsystem);

  public RobotContainer() { 
    m_clawSubsystem.setDefaultCommand(contClawCommand);
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(m_joystick, 3).onTrue(new InstantCommand(() -> m_clawSubsystem.setReference(kCubeClose)));
    new JoystickButton(m_joystick, 4).onTrue(new InstantCommand(() -> m_clawSubsystem.setReference(kConeClose)));
    new JoystickButton(m_joystick, 2).onTrue(colorClawCommand); // To close the claw (with color sensor)
    new JoystickButton(m_joystick, 1).whileTrue(contClawCommand);
    
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
