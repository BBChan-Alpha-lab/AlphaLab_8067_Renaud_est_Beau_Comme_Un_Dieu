/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

public class BasePilotable extends SubsystemBase {

  // Étape 4 - Création d’une variable contenant l’objet Drive pour la conduite
  // "drive"
  // private DifferentialDrive drive; // non instanciee dans le code original 
  // Regis
  /**
   * Creates a new BasePilotable.
   */
  // Étape 2 - Déclaration des variables pour les 4 moteurs CIM
  // avec la déclaration des constantes pour les ports de branchements dans le
  // fichier "Classe" Constants.java
  private final SpeedController m_leftMasterMotor = new WPI_TalonSRX(DriveConstants.LEFT_MASTER_PORT_ID);
  private final SpeedController m_leftSlaveMotor = new WPI_TalonSRX(DriveConstants.LEFT_SLAVE_PORT_ID);
  private final SpeedController m_rightMasterMotor = new WPI_TalonSRX(DriveConstants.RIGHT_MASTER_PORT_ID);
  private final SpeedController m_rightSlaveMotor = new WPI_TalonSRX(DriveConstants.RIGHT_SLAVE_PORT_ID);

  private final SpeedControllerGroup m_leftSide;
  private final SpeedControllerGroup m_rightSide;

  private DifferentialDrive m_drive;
  // fin Étape 2

  public BasePilotable()
  {

    // Étape 3 - Création d'un constructeur pour que les moteurs esclaves suivent
    // leurs maîtres
    // leftSlaveMotor).follow(leftMasterMotor);
    //rightSlaveMotor.follow(rightMasterMotor);
    
    //verifier le sens de rotation des moteurs et mettre les valeurs appropriees svp

    m_leftSlaveMotor.setInverted(false);
    m_rightMasterMotor.setInverted(true);
    m_rightSlaveMotor.setInverted(true);


    m_leftSide = new SpeedControllerGroup(m_leftMasterMotor, m_leftSlaveMotor);
    m_rightSide = new SpeedControllerGroup( m_rightMasterMotor, m_rightSlaveMotor);

    m_drive = new DifferentialDrive(m_leftSide, m_rightSide);
 //Inverser le courant pour le moteur de droite afin de faire avancer le robot
   // leftMasterMotor.setInverted(false);
   // rightMasterMotor.setInverted(true);
    //Fin Étape 3 
  }

//Étape 5  - ajout de deux méthodes(actions) une pour la conduite de style ArcadeDrive 
//et l'autre pour l'arrêt du robot
  public void drive(double forward, double turn) {
    m_drive.arcadeDrive(forward, turn);
  }

  public void stop() { 
    m_drive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}