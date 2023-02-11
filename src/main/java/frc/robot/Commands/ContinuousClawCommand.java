// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ClawSubsystem;
import static frc.robot.Constants.Claw.*;

public class ContinuousClawCommand extends CommandBase {
  ClawSubsystem m_clawSubsystem = new ClawSubsystem();
  boolean triggerState = false;
  double m_Rotations = 0;
  double m_CurrentButton = 0;

  public ContinuousClawCommand(ClawSubsystem clawSubsystem) {
    addRequirements(clawSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_clawSubsystem.setTriggerState(true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_CurrentButton = m_clawSubsystem.getCurrentButton();

    if (m_CurrentButton == 3) {
      m_Rotations += kCloseClawRate;
    m_clawSubsystem.setReference(m_Rotations);
    } else if (m_CurrentButton == 4) {
      m_Rotations += kOpenClawRate;

    m_clawSubsystem.setReference(m_Rotations); // C
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_clawSubsystem.setTriggerState(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
