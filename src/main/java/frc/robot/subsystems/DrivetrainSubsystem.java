// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {

  private CANSparkMax bl = new CANSparkMax(Constants.BL_MOTOR_ID, MotorType.kBrushless);
  private CANSparkMax br = new CANSparkMax(Constants.BR_MOTOR_ID, MotorType.kBrushless);
  private CANSparkMax fl = new CANSparkMax(Constants.FL_MOTOR_ID, MotorType.kBrushless);
  private CANSparkMax fr = new CANSparkMax(Constants.FR_MOTOR_ID, MotorType.kBrushless);

  private MotorControllerGroup leftMotors = new MotorControllerGroup(bl, fl);
  private MotorControllerGroup rightMotors = new MotorControllerGroup(br, fr);

  private DifferentialDrive drive;

  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {
    // Uncomment the lines below to correct backwardness
    // leftMotors.setInverted(true);
    // rightMotors.setInverted(true);

    drive = new DifferentialDrive(leftMotors, rightMotors);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void arcadeDrive(double speed, double rotation){
    drive.arcadeDrive(speed, rotation);
  }
}
