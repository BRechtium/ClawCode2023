// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.ClawCommand;
import frc.robot.Subsystems.ClawSubsystem;

public class RobotContainer {
  Joystick m_joystick = new Joystick (0);
  ClawSubsystem m_clawSubsystem = new ClawSubsystem();
  ClawCommand clawCommand = new ClawCommand(
    m_clawSubsystem,
    () -> m_joystick.getTrigger(),
    () -> m_joystick.getRawButton(3),
    () -> m_joystick.getRawButton(4));

  public RobotContainer() { 
    m_clawSubsystem.setDefaultCommand(clawCommand);
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(m_joystick, 2).onTrue(new InstantCommand(() -> m_clawSubsystem.colorCheck())); // To close the claw (with color sensor) 
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
