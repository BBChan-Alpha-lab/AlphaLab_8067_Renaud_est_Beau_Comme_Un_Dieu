/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BasePilotable;

public class DriveCommand extends CommandBase {
    
    //Étape 6 -- Création des variables contenant les objets du sous-système "BasePilotable"
    //et du Joystick
     
    private final DoubleSupplier m_forward;
    private final DoubleSupplier m_rotation;
    private final BasePilotable m_basePilotable;

 //Étape 7 -  Déclaration des sous-systèmes et stockage des attributs dans le Constructeur: 
 public DriveCommand( DoubleSupplier forward, DoubleSupplier rotation, BasePilotable basePilotable) {
    m_forward = forward;
    m_rotation = rotation;
    m_basePilotable = basePilotable;

    addRequirements(m_basePilotable);
 }
    

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }


// Étape 8 - Appel de la méthode avec les attributs du joystick
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_basePilotable.drive(m_forward.getAsDouble(), m_rotation.getAsDouble());
  }

  //Étape 9 - arrêt de la commande par interruption du programme 
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_basePilotable.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}