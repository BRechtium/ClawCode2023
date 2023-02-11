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
import frc.robot.Commands.DiscreteClawCommand;
import frc.robot.Subsystems.ClawSubsystem;

public class RobotContainer {
  Joystick m_joystick = new Joystick (0);
  ClawSubsystem m_clawSubsystem = new ClawSubsystem();
  DiscreteClawCommand clawCommand = new DiscreteClawCommand(m_clawSubsystem);

  public RobotContainer() { 
    m_clawSubsystem.setDefaultCommand(clawCommand);
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(m_joystick, 7).onTrue(new InstantCommand(() -> m_clawSubsystem.setRotations(kCubeClose))); // Optional
    new JoystickButton(m_joystick, 6).onTrue(new InstantCommand(() -> m_clawSubsystem.setRotations(kConeClose))); // Optional
   
    new JoystickButton(m_joystick, 1).onTrue(new InstantCommand(() -> m_clawSubsystem.colorCheck())); // To close the claw

    new JoystickButton(m_joystick, 5).onTrue(new InstantCommand(() -> m_clawSubsystem.setRotations(kOpen))); // Option 1: Open claw 
                                                                                                                //with different button
    if (m_joystick.getRawButtonReleased(1)) {  // Option 2: Open claw when button is released
      m_clawSubsystem.setRotations(kOpen);
    }
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
