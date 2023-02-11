// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.ClawMechanism;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.CANSparkMax;

public class DiscreteClawCommand extends CommandBase {
  /** Creates a new DiscreteClawCommand. */
  ClawSubsystem m_ClawSubsystem;
  
  public DiscreteClawCommand(ClawSubsystem clawSubsystem) {
    m_ClawSubsystem = clawSubsystem;
    addRequirements(clawSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    m_ClawSubsystem.setReference();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
