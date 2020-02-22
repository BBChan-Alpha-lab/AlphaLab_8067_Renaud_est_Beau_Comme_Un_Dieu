/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Ramasseur;

public class ArretRamasseurCmd extends CommandBase {
  /**
   * Creates a new RamasserCmd.
   */
  public Ramasseur m_Ramasseur;
  public ArretRamasseurCmd(Ramasseur rammasseur) {
    m_Ramasseur = rammasseur ; 
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Ramasseur);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Ramasseur.arret();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Ramasseur.arret();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}