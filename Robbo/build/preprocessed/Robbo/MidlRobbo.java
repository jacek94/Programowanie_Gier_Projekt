/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Robbo;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;
import java.io.PrintStream;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

/**
 * @author ATR
 */
public class MidlRobbo extends MIDlet implements CommandListener{
    
    private Display mainDisplay = Display.getDisplay(this);
  private TIntro introCanvas = new TIntro(this.gameCanvas, this);
  private TBoard gameCanvas = new TBoard();
  private THelp helpCanvas = new THelp(this.gameCanvas, this);
  private TAbout aboutCanvas = new TAbout(this.gameCanvas, this);
  private Command nextLevelCommand = new Command("Next level", 8, 1);
  private Command prevLevelCommand = new Command("Prev. level", 8, 1);
  private Command introExitCommand = new Command("Back", 2, 1);
  private Command explodeCommand = new Command("Explode", 4, 1);
  private Command backCommand = new Command("Back", 2, 2);
  private Command helpBackCommand = new Command("Back", 2, 1);

  public MidlRobbo() throws Exception
  {
    this.introCanvas.setFullScreenMode(true);
    this.gameCanvas.setFullScreenMode(true);
    this.helpCanvas.setFullScreenMode(true);
    this.aboutCanvas.setFullScreenMode(true);
    this.introCanvas.setCommandListener(this);
    this.introCanvas.addCommand(this.introExitCommand);
    this.gameCanvas.setCommandListener(this);
    this.gameCanvas.addCommand(this.explodeCommand);
    this.gameCanvas.addCommand(this.backCommand);
  }
  
  
    public void startApp() throws MIDletStateChangeException {
        
        if ((this.gameCanvas.thread != null) && (this.gameCanvas.thread.isAlive())) {
      this.mainDisplay.setCurrent(this.gameCanvas);
    } else {
      this.mainDisplay.setCurrent(this.introCanvas);
    }
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean paramBoolean)
  {
    try
    {
     // this.gameCanvas.sound.Stop(5);
    }
    catch (Exception localException) {}
    this.mainDisplay.setCurrent((Displayable)null);
  }
  
  public void commandAction(Command paramCommand, Displayable paramDisplayable)
  {
    if (paramCommand == this.nextLevelCommand) {
      try
      {
        this.mainDisplay.setCurrent(this.gameCanvas);
        this.gameCanvas.PlayLevelNo(this.gameCanvas.score.GetLevelNumber() + 1);
      }
      catch (Exception localException1)
      {
        System.out.print(localException1.toString() + "\r\n");
      }
    }
    if (paramCommand == this.prevLevelCommand) {
      try
      {
        this.mainDisplay.setCurrent(this.gameCanvas);
        this.gameCanvas.PlayLevelNo(this.gameCanvas.score.GetLevelNumber() - 1);
      }
      catch (Exception localException2)
      {
        System.out.print(localException2.toString() + "\r\n");
      }
    }
    if (paramCommand == this.introExitCommand) {
      this.introCanvas.ExitCommand();
    }
    if (paramCommand == this.explodeCommand) {
      this.gameCanvas.ExplodeRobbo();
    }
    if (paramCommand == this.backCommand) {
      try
      {
        this.gameCanvas.StopPlaying();
        this.mainDisplay.setCurrent(this.introCanvas);
      }
      catch (Exception localException3)
      {
        System.out.print(localException3.toString() + "\r\n");
      }
    }
    if (paramCommand == this.helpBackCommand)
    {
      System.out.print("helpBackCommand\r\n");
      this.mainDisplay.setCurrent(this.introCanvas);
    }
  }
  
  public void PlayContinue()
  {
    try
    {
      this.mainDisplay.setCurrent(this.gameCanvas);
      this.gameCanvas.PlayCurrentLevel();
    }
    catch (Exception localException)
    {
      System.out.print(localException.toString() + "\r\n");
    }
  }
  
  public void PlayNew()
  {
    try
    {
      this.mainDisplay.setCurrent(this.gameCanvas);
      this.gameCanvas.PlayNewGame();
    }
    catch (Exception localException)
    {
      System.out.print(localException.toString() + "\r\n");
    }
  }
  
  public void Exit()
  {
    destroyApp(true);
    notifyDestroyed();
  }
  
  public void Help()
  {
    this.mainDisplay.setCurrent(this.helpCanvas);
  }
  
  public void About()
  {
    this.mainDisplay.setCurrent(this.aboutCanvas);
  }
  
  public void Intro()
  {
    this.mainDisplay.setCurrent(this.introCanvas);
  }
}





