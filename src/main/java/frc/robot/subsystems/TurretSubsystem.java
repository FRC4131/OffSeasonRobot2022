// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TurretSubsystem extends SubsystemBase {
  private TalonSRX motor = new TalonSRX(Constants.TURRET_ROTATOR_ID);

  public TurretSubsystem() {
    motor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.QuadEncoder, 0, 6800);
    motor.configForwardSoftLimitThreshold(2000);
    motor.configReverseSoftLimitThreshold(-2000);
    motor.configForwardSoftLimitEnable(true);
    motor.configReverseSoftLimitEnable(true);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Turret Encoder Pos", getEncoderPos());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void set(double power){
    motor.set(TalonSRXControlMode.PercentOutput, power);
  }

  public double getEncoderPos(){
    return motor.getSelectedSensorPosition(0);
  }
}
