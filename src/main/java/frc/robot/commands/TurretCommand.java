// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TurretSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TurretCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final TurretSubsystem m_TurretSubsystem;
  private DoubleSupplier joystickX;
  /**
   * Creates a new TurretCommand.
   * Used to manually control the rotation of the turret using joysticks.
   * @param subsystem The subsystem used by this command.
   */
  public TurretCommand(TurretSubsystem turretSubsystem, DoubleSupplier joystickX) {
    m_TurretSubsystem = turretSubsystem;
    this.joystickX = joystickX;
    addRequirements(m_TurretSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_TurretSubsystem.set(joystickX.getAsDouble() / 2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_TurretSubsystem.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
