// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ClawSubsystem;
import static frc.robot.Constants.Claw.*;

public class ContinuousClawCommand extends CommandBase {
  ClawSubsystem m_clawSubsystem;
  boolean triggerState = false;
  double m_rotations = 0;
  double m_CurrentButton = 0;

  public ContinuousClawCommand(ClawSubsystem clawSubsystem) {
    addRequirements(clawSubsystem);
    m_clawSubsystem = clawSubsystem;
  }

  @Override
  public void initialize() {
    m_clawSubsystem.setTriggerState(true);
  }

  @Override
  public void execute() {
    m_CurrentButton = m_clawSubsystem.getCurrentButton();

    if (m_CurrentButton == 3 && m_rotations < kContLimit - 0.01) {
      m_rotations += kCloseClawRate;
    } else if (m_CurrentButton == 4 && m_rotations < kContLimit + 0.01) {
      m_rotations += kOpenClawRate;
    }

    m_clawSubsystem.setRotations(m_rotations);
  }

  @Override
  public void end(boolean interrupted) {
    m_clawSubsystem.setTriggerState(false);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
