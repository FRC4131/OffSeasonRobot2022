// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DefaultDriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DrivetrainSubsystem m_DrivetrainSubsystem;
  private final DoubleSupplier leftJoystickY;
  private final DoubleSupplier rightJoystickX;
  /**
   * Creates a new DefaultDriveCommand to control the robot's drive train using arcade drive.
   *
   * @param drivetrainSubsystem The DrivetrainSubsystem used by this command.
   * @param leftJoystickY Value of the Y axis of the left joystick. Used to control movement forward and back
   * @param rightJoystickX Value of the X axis of the right joystick. Used to control rotational movement.
   */
  public DefaultDriveCommand(DrivetrainSubsystem drivetrainSubsystem, DoubleSupplier leftJoystickY, DoubleSupplier rightJoystickX) { 
    m_DrivetrainSubsystem = drivetrainSubsystem;
    this.leftJoystickY = leftJoystickY;
    this.rightJoystickX = rightJoystickX;

    addRequirements(drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_DrivetrainSubsystem.arcadeDrive(leftJoystickY.getAsDouble(), rightJoystickX.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DrivetrainSubsystem.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
