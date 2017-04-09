package Robbo;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class TIntro
  extends Canvas
{
  private Image introImage;
  private Image logoRobboImage;
  private TBoard board;
  private MidlRobbo midlet;
  private static final String[][] menu_0 = { { "Play game", "Options", "Help", "About", "Exit" }, { "Gra", "Opcje", "Pomoc", "O twórcach", "Wyjście" } };
  private static final String[][] menu_1 = { { "Continue game", "New game", "Back" }, { "Kontynuuj", "Nowa gra", "Wróć" } };
  private static final String[][] menu_2 = { { "Language: ", "Difficulty: ", "Sound: ", "Effects: ", "Back" }, { "Język: ", "Poziom: ", "Muzyka: ", "Dźwięki: ", "Wróć" } };
  private static final String[] languages = { "English", "Polski" };
  private static final String[][] diffs = { { "easy", "hard" }, { "łatwy", "trudny" } };
  private static final String[][] onOff = { { "off", "on" }, { "wył.", "wł." } };
  private String[] cur_menu;
  private int cur_menui = 0;
  private int cur_item = 0;
  private int cur_language = 0;
  private int cur_diff = 0;
  private int cur_sound = 1;
  private int cur_effects = 1;
  private boolean intro;
  
  public TIntro(TBoard paramTBoard, MidlRobbo paramMidlRobbo)
  {
    this.board = paramTBoard;
    this.midlet = paramMidlRobbo;
    this.intro = true;
    SetCurrentMenuItems();
    try
    {
      this.introImage = Image.createImage("/Robbo/res/menu.png");
      this.logoRobboImage = Image.createImage("/Robbo/res/robbo_logo.png");
    }
    catch (IOException localIOException) {}
  }
  
  protected void paint(Graphics paramGraphics)
  {
    paramGraphics.setColor(10, 10, 10);
    paramGraphics.fillRect(0, 0, getWidth(), getHeight());
    paramGraphics.drawImage(this.introImage, paramGraphics.getClipWidth() / 2, paramGraphics.getClipHeight() / 2, 3);
    if (this.intro)
    {
      paramGraphics.drawImage(this.logoRobboImage, paramGraphics.getClipWidth() / 2, paramGraphics.getClipHeight() / 2, 3);
    }
    else
    {
      Font localFont = Font.getFont(64, 1, 0);
      paramGraphics.setFont(localFont);
      int j = paramGraphics.getClipWidth() / 2;
      int i = paramGraphics.getClipHeight() / 2 - 30;
      for (int k = 0; k < this.cur_menu.length; k++)
      {
        String str = this.cur_menu[k];
        if (this.cur_menui == 2)
        {
          if (k == 0) {
            str = str + languages[this.cur_language];
          }
          if (k == 1) {
            str = str + diffs[this.cur_language][this.cur_diff];
          }
          if (k == 2) {
            str = str + onOff[this.cur_language][this.cur_sound];
          }
          if (k == 3) {
            str = str + onOff[this.cur_language][this.cur_effects];
          }
        }
        paramGraphics.setColor(105, 105, 105);
        paramGraphics.drawString(str, j - localFont.stringWidth(str) / 2, i + localFont.getHeight() * k, 20);
        if (k == this.cur_item) {
          paramGraphics.setColor(255, 80, 80);
        } else {
          paramGraphics.setColor(40, 40, 255);
        }
        paramGraphics.drawString(str, j - localFont.stringWidth(str) / 2 - 1, i + localFont.getHeight() * k - 1, 20);
      }
    }
  }
  
  protected void keyPressed(int paramInt)
  {
    if (this.intro) {
      this.intro = false;
    } else {
      switch (getGameAction(paramInt))
      {
      case 1: 
        if (this.cur_item > 0) {
          this.cur_item -= 1;
        }
        break;
      case 6: 
        if (this.cur_item < this.cur_menu.length - 1) {
          this.cur_item += 1;
        }
        break;
      case 8: 
        OnSelectedMenuItem();
      }
    }
    repaint();
    serviceRepaints();
    repaint();
    serviceRepaints();
  }
  
  protected void showNotify()
  {
    try
    {
    // this.board.sound.Effect(5);
    }
    catch (Exception localException) {}
    this.cur_language = this.board.score.GetLanguage();
    this.cur_diff = this.board.score.GetDifficulty();
   // this.cur_sound = this.board.score.GetSound();
    this.cur_effects = this.board.score.GetEffects();
    this.cur_menui = 0;
    this.cur_item = 0;
    SetCurrentMenuItems();
  }
  
  protected void hideNotify() {}
  
  protected void SetCurrentMenuItems()
  {
    switch (this.cur_menui)
    {
    case 0: 
      this.cur_menu = menu_0[this.cur_language];
      break;
    case 1: 
      this.cur_menu = menu_1[this.cur_language];
      break;
    case 2: 
      this.cur_menu = menu_2[this.cur_language];
      break;
    case 3: 
      this.cur_menu = languages;
      break;
    case 4: 
      this.cur_menu = diffs[this.cur_language];
      break;
    case 5: 
      this.cur_menu = onOff[this.cur_language];
      break;
    case 6: 
      this.cur_menu = onOff[this.cur_language];
    }
    this.cur_item = 0;
  }
  
  public void ExitCommand()
  {
    switch (this.cur_menui)
    {
    case 0: 
      this.midlet.Exit();
      break;
    default: 
      this.cur_menui = 0;
      SetCurrentMenuItems();
      repaint();
      serviceRepaints();
      repaint();
      serviceRepaints();
    }
  }
  
  private void OnSelectedMenuItem()
  {
    switch (this.cur_menui)
    {
    case 0: 
      OnSelectedMainMenuItem();
      break;
    case 1: 
      OnSelectedPlayMenuItem();
      break;
    case 2: 
      OnSelectedOptionsMenuItem();
      break;
    case 3: 
      OnSelectedLanguagesMenuItem();
      break;
    case 4: 
      OnSelectedDiffMenuItem();
      break;
    case 5: 
      OnSelectedSoundMenuItem();
      break;
    case 6: 
      OnSelectedEffectsMenuItem();
    }
  }
  
  private void OnSelectedMainMenuItem()
  {
    switch (this.cur_item)
    {
    case 0: 
      this.cur_menui = 1;
      SetCurrentMenuItems();
      break;
    case 1: 
      this.cur_menui = 2;
      SetCurrentMenuItems();
      break;
    case 2: 
      this.midlet.Help();
      break;
    case 3: 
      this.midlet.About();
      break;
    case 4: 
      this.midlet.Exit();
    }
  }
  
  private void OnSelectedPlayMenuItem()
  {
    switch (this.cur_item)
    {
    case 0: 
      try
      {
      //  this.board.sound.Stop(5);
      }
      catch (Exception localException1) {}
      this.midlet.PlayContinue();
      break;
    case 1: 
      try
      {
       // this.board.sound.Stop(5);
      }
      catch (Exception localException2) {}
      this.midlet.PlayNew();
      break;
    case 2: 
      this.cur_menui = 0;
      SetCurrentMenuItems();
    }
  }
  
  private void OnSelectedOptionsMenuItem()
  {
    switch (this.cur_item)
    {
    case 0: 
      this.cur_menui = 3;
      SetCurrentMenuItems();
      break;
    case 1: 
      this.cur_menui = 4;
      SetCurrentMenuItems();
      break;
    case 2: 
      this.cur_menui = 5;
      SetCurrentMenuItems();
      break;
    case 3: 
      this.cur_menui = 6;
      SetCurrentMenuItems();
      break;
    case 4: 
      this.cur_menui = 0;
      SetCurrentMenuItems();
    }
  }
  
  private void OnSelectedLanguagesMenuItem()
  {
    this.cur_language = this.cur_item;
    this.board.score.SetLanguage((byte)this.cur_language);
    this.cur_menui = 2;
    SetCurrentMenuItems();
  }
  
  private void OnSelectedDiffMenuItem()
  {
    this.cur_diff = this.cur_item;
    this.board.score.SetDifficulty((byte)this.cur_diff);
    this.cur_menui = 2;
    SetCurrentMenuItems();
  }
  
  private void OnSelectedSoundMenuItem()
  {
    this.cur_sound = this.cur_item;
    this.board.score.SetSound((byte)this.cur_sound);
    if (this.cur_sound == 1) {
      try
      {
      //  this.board.sound.Effect(5);
      }
      catch (Exception localException1) {}
    } else {
      try
      {
       // this.board.sound.Stop(5);
      }
      catch (Exception localException2) {}
    }
    this.cur_menui = 2;
    SetCurrentMenuItems();
  }
  
  private void OnSelectedEffectsMenuItem()
  {
    this.cur_effects = this.cur_item;
    this.board.score.SetEffects((byte)this.cur_effects);
    this.cur_menui = 2;
    SetCurrentMenuItems();
  }
}


/* Location:              C:\Users\ATR\Desktop\Robbo.jar!\Robbo\TIntro.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       0.7.1
 */