package Robbo;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class THelp
  extends Canvas
{
  MidlRobbo midlet;
  TBoard board;
  private static final int SCROLL_HEIGHT = 340;
  private static final int SCROLL_STEP = 5;
  private int scroll_y;
  private Image img_background;
  private Image img_capsule;
  private Image img_shoot;
  private Image img_robbo;
  private Image img_ammo;
  private Image img_back;
  private int cur_language;
  public static final String[][] text = { { "Help Robbo to collect", "all screws, then find", "capsule to fly away.", "", "", "", "Moving:", "Use joystick or press", "2,4,6,8 for move Robbo", "to desired direction.", "", "", "", "Shootting:", "Press and keep * and", "then press cursor key", "for shoot.", "Instead of *  you may", "press # or 5.", "", "", "", "Robbo can shoot only,", "when it has any ammo:" }, { "Pomóż Robbo zebrać", "wszystkie śrubki i", "znajdź kapsułę.", "", "", "", "Poruszanie:", "Poruszaj Robbo joy-", "stickiem, lub użyj", "klawiszy: 2,4,6,8.", "", "", "", "Strzelanie:", "Naciśnij i trzymaj *,", "nastepnie porusz joy-", "stickiem.", "Zamiast *  możesz u-", "żyć klawiszy # lub 5.", "", "", "", "Aby strzelać, Robbo", "musi zebrać amunicję:" } };
  
  public THelp(TBoard paramTBoard, MidlRobbo paramMidlRobbo)
  {
    this.midlet = paramMidlRobbo;
    this.board = paramTBoard;
    this.cur_language = 0;
    try
    {
      this.img_background = Image.createImage("/Robbo/res/backgr.png");
      this.img_capsule = Image.createImage("/Robbo/res/help_sc.png");
      this.img_shoot = Image.createImage("/Robbo/res/help_sh.png");
      this.img_robbo = Image.createImage("/Robbo/res/robbo.png");
      this.img_ammo = Image.createImage("/Robbo/res/ammo.png");
      this.img_back = Image.createImage("/Robbo/res/back_key.png");
    }
    catch (IOException localIOException) {}
  }
  
  protected void paint(Graphics paramGraphics)
  {
    int i = getWidth() / 2;
    paramGraphics.setColor(0, 0, 0);
    paramGraphics.fillRect(0, 0, getWidth(), getHeight());
    paramGraphics.drawImage(this.img_background, paramGraphics.getClipWidth() / 2, paramGraphics.getClipHeight() / 2, 3);
    paramGraphics.drawImage(this.img_capsule, i, 60 - this.scroll_y, 17);
    paramGraphics.drawImage(this.img_robbo, i, 145 - this.scroll_y, 17);
    paramGraphics.drawImage(this.img_shoot, i, 250 - this.scroll_y, 17);
    paramGraphics.drawImage(this.img_ammo, i, 310 - this.scroll_y, 17);
    paramGraphics.setColor(180, 180, 180);
    Font localFont = Font.getFont(64, 0, 8);
    paramGraphics.setFont(localFont);
    for (int j = 0; j < text[this.cur_language].length; j++) {
      paramGraphics.drawString(text[this.cur_language][j], i - 55, 12 + j * 12 - this.scroll_y, 20);
    }
    paramGraphics.drawImage(this.img_back, getWidth(), getHeight(), 40);
  }
  
  protected void keyPressed(int paramInt)
  {
    switch (paramInt)
    {
    case -11: 
    case -7: 
      this.midlet.Intro();
    }
    switch (getGameAction(paramInt))
    {
    case 6: 
      Move(6);
      break;
    case 1: 
      Move(1);
    }
    repaint();
  }
  
  protected void showNotify()
  {
    this.scroll_y = 0;
    this.cur_language = this.board.score.GetLanguage();
  }
  
  private void Move(int paramInt)
  {
    int i = this.scroll_y;
    int j = getHeight() - 20;
    if (paramInt == 6) {
      while ((this.scroll_y + getHeight() < 340) && (this.scroll_y < i + j))
      {
        this.scroll_y += 5;
        repaint();
        serviceRepaints();
      }
    }
    while ((this.scroll_y > 0) && (this.scroll_y > i - j))
    {
      this.scroll_y -= 5;
      repaint();
      serviceRepaints();
    }
  }
}


/* Location:              C:\Users\ATR\Desktop\Robbo.jar!\Robbo\THelp.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       0.7.1
 */