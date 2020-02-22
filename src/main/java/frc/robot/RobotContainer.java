/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArretRamasseurCmd;
//import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.EjecterCmd;
import frc.robot.commands.Other;
import frc.robot.commands.RamasserCmd;
//import frc.robot.commands.Piloter;
import frc.robot.subsystems.BasePilotable;
import frc.robot.subsystems.Ramasseur;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {



//Étape 10 Déclaration de tous les sous-systèmes, ici on déclare le sous-système BasePilotable
// Déclaration de la Manette de jeu 
private final BasePilotable m_basePilotable = new BasePilotable(); 
private final Joystick m_stick = new Joystick(0);

public Ramasseur m_Ramasseur = new Ramasseur();

private final Command m_autocommand = new RamasserCmd(m_Ramasseur);
private final Command m_autocommand4 = new EjecterCmd(m_Ramasseur);
private final Command m_autocommand3 = new ArretRamasseurCmd(m_Ramasseur);
private final Command m_autocommand2 = new Other(m_Ramasseur);

public int time = 0;

public void time1() {
  time = time +1;
}

public Command seconds3() {
  return m_autocommand2.withTimeout(1);
}

public Command seconds1() {
 
  return  m_autocommand.andThen(m_autocommand);
}

public void time0() {
  time = 0;
}
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */

   //Étape 11 -- Déclaration des Commandes par défaut- ici on appelle la commande basePilotable
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();

    // Commandes par défaut 
    setDefaultCommands();
    
     }
  private void setDefaultCommands(){
    m_basePilotable.setDefaultCommand(new DriveCommand(()->m_stick.getX(), ()->m_stick.getY(), m_basePilotable));

  }
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_stick, 5).whileHeld(new RamasserCmd(m_Ramasseur));

    new JoystickButton(m_stick, 3).whileHeld(new EjecterCmd(m_Ramasseur));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *return the command to run in autonomous
   * */
 
   
  public Command getAutonomousCommand() {
    time0();
 
    while (time <=15){
      if (time <= 15){
        if (time == 0) {
          time1();
        }
        else if (time == 1) {
          time1();
          return m_autocommand.withTimeout(1).andThen(m_autocommand3);
        }
        else if (time == 2) {
            time1();
          }
        else if (time == 3){
            seconds1();
            time1();
          }
        else if (time == 4) {
            seconds3();
            time1();
            return m_autocommand4;
          }
        else if (time == 5) {
          return m_autocommand3;
        }
          else {
            break;
          }
      }
    }
    return m_autocommand;
  }
}
 
 
