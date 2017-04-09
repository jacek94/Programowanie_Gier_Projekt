package Robbo;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class TAbout extends Canvas
{
  MidlRobbo midlet;
  TBoard board;
  private Image img_background;
  private Image img_back;
  private int cur_language;
  public static final String[][] text_title = { { "Pomysł na grę i poziomy", "" ,"", "Tworzenie  kodu gry", "", "", "", "Grafika", "", "" , "Testowanie" } };
  public static final String[] text_person = { "", "Szymon Bogusławski", "" ,"", "Szymon Bogusławski", "", "", "", "Szymon Bogusławski", "" ,"" , "Jacek Woźniak" };
  
  public TAbout(TBoard paramTBoard, MidlRobbo paramMidlRobbo)
  {
    this.midlet = paramMidlRobbo;
    this.board = paramTBoard;
    this.cur_language = 0;
    try
    {
      this.img_background = Image.createImage("/Robbo/res/backgr.png");
      this.img_back = Image.createImage("/Robbo/res/back_key.png");
    }
    catch (IOException localIOException) {}
  }
  
  protected void paint(Graphics paramGraphics)
  {
    int i = paramGraphics.getClipWidth() / 2;
    paramGraphics.setColor(0, 0, 0);
    paramGraphics.fillRect(0, 0, getWidth(), getHeight());
    paramGraphics.drawImage(this.img_background, paramGraphics.getClipWidth() / 2, paramGraphics.getClipHeight() / 2, 3);
    paramGraphics.setColor(240, 240, 240);
    Font localFont = Font.getFont(64, 1, 8);
    paramGraphics.setFont(localFont);
    for (int j = 0; j < text_title[this.cur_language].length; j++) {
      paramGraphics.drawString(text_title[this.cur_language][j], i - localFont.stringWidth(text_title[this.cur_language][j]) / 2, 12 + j * 12, 20);
    }
    paramGraphics.setColor(120, 120, 120);
    int j;
    for (j = 0; j < text_person.length; j++) {
      paramGraphics.drawString(text_person[j], i - localFont.stringWidth(text_person[j]) / 2, 12 + j * 12, 20);
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
  }
  
  protected void showNotify()
  {
    this.cur_language = this.board.score.GetLanguage();
  }
}
