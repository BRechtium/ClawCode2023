// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ClawSubsystem;

public class ColorClawCommand extends CommandBase {
  ClawSubsystem m_ClawSubsystem;

  public ColorClawCommand(ClawSubsystem clawSubsystem) {
    addRequirements(clawSubsystem);
    m_ClawSubsystem = clawSubsystem;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_ClawSubsystem.colorCheck();
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
