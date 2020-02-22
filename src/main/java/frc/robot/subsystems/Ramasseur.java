/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.RamasseurConstants;

public class Ramasseur extends SubsystemBase {
  /**
   * Creates a new Ramasseur.
   */
  private final WPI_TalonSRX m_moteurRamasseur;
  
  public Ramasseur() {
    m_moteurRamasseur = new WPI_TalonSRX(frc.robot.Constants.RamasseurConstants.kLancerMotor);
   }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void ramasserBalle() {
    m_moteurRamasseur.set(0.5);
  }
  public void ejecter() {
    m_moteurRamasseur.set(-1);
  }
  public void arret() {
    m_moteurRamasseur.stopMotor();
  }
}