package Robbo;

import java.io.*;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintStream;
import java.util.Random;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.TiledLayer;

class TBoard extends GameCanvas implements Runnable
{
  public static final int BOARD_WIDTH = 16;
  public static final int BOARD_HEIGHT = 31;
  private static final int CELL_SIZE = 16;
  private static final int ACTION_DELAY = 130;
  private static final int NO_OF_HI_LEVELS = 50;
  private static final int NO_OF_LO_LEVELS = 50;
  private static final int MAX_TICK = 1;
  private static final int STATE_IDLE = 0;
  private static final int STATE_PLAYING = 1;
  private static final int STATE_STOP = 2;
  private static final int STATE_STOPPING = 3;
  private Image layerImage;
  private Image img_explode;
  private Image img_back;
  private TiledLayer layer;
  private Graphics g;
  public Thread thread;
  public Random rand;
  public TScore score;
 // public TSound sound;
  private int thread_state;
  private int canvas_width;
  private int canvas_height;
  private int current_level;
  private int current_language;
  private int canvas_pos_x;
  private int canvas_pos_y;
  private int backg_color_r;
  private int backg_color_g;
  private int backg_color_b;
  public int wall_tile;
  public TBoardItem[][] items;
  public TBoardItem nullItem;
  public int robbo_pos_x;
  public int robbo_pos_y;
  public int keys;
  public int screws;
  public int ammo;
  public boolean zero_screws_informed;
  public boolean level_completed;
  public boolean robbo_defeated;
  public boolean robbo_frozen;
  public boolean robbo_catched_by_magnes;
  public int tick;
  private static final String[][] info = { { "Level", "Keys", "Screws", "Ammo" }, { "Poziom", "Klucze", "Srubki", "Naboje" } };
  
  public TBoard() throws Exception
  {
    super(true);
    try
    {
      this.items = new TBoardItem[16][31];
      for (int i = 0; i < 16; i++) {
        for (int j = 0; j < 31; j++) {
          this.items[i][j] = new TBoardItem();
        }
      }
      this.nullItem = new TBoardItem();
      this.nullItem.SetNew((byte)77, -1, -1, this);
      try
      {
        this.layerImage = Image.createImage("/Robbo/res/Tiles.png");
        this.img_back = Image.createImage("/Robbo/res/back_key.png");
        this.img_explode = Image.createImage("/Robbo/res/explode_key.png");
      }
      catch (IOException localIOException)
      {
        throw localIOException;
      }
      this.layer = new TiledLayer(16, 31, this.layerImage, 16, 16);
      this.rand = new Random();
      this.score = new TScore();
      //this.sound = new TSound(this.score);
      this.thread_state = 0;
      this.current_language = 0;
      Clear();
    }
    catch (Exception localException)
    {
      throw new Exception("TBoard.TBoard " + localException.toString() + "\r\n");
    }
  }
  
  private void InitCanvas()
  {
    this.canvas_width = (getWidth() / 16);
    this.canvas_height = (getHeight() / 16);
  }
  
  private int NoOfLevels() throws Exception
  {
    switch (this.score.GetDifficulty())
    {
    case 0: 
      return 50;
    case 1: 
      return 50;
    }
    throw new Exception("TBoard::NoOfLevels -> bad difficulty");
  }
  
  private void LoadLevelFromFile(int paramInt) throws IOException, Exception
  {
    InputStream localInputStream = null;
    byte[] arrayOfByte = new byte[18];
    Clear();
    try
    {
        
      //String str3;
        String str3;
      switch (this.score.GetDifficulty())
      {
      case 0: 
       // str3 = "level1";
          str3 = "level2";
        break;
      case 1: 
       // str3 = "level3";
          str3 = "level4";
        break;
      default: 
       // str3 = "level5";
          str3 = "level6";
      }
      
      for (String str2 = String.valueOf(paramInt); str2.length() < 3; str2 = "0" + str2) {
         
          int i = 2;
    switch (i) {
      case 1:
        localInputStream = getClass().getResourceAsStream("/Robbo/level001.txt");
        break;
      case 2:
        localInputStream = getClass().getResourceAsStream("/Robbo/level002.txt");
        break;
      default:
        localInputStream = getClass().getResourceAsStream("/Robbo/level003.txt");
    }
           
          localInputStream = getClass().getResourceAsStream("/Robbo/level001.txt");
          //localInputStream = getClass().getResourceAsStream("/Robbo"   + str3 + ".txt");
          //localInputStream = getClass().getResourceAsStream("/Robbo/levels/" + str3 + "/level" + str2 + ".txt");
         // localInputStream = TBoard.class.getResourceAsStream("/Robbo/levels/" + str3 + "/level" + str2 + ".txt");
      //localInputStream = TBoard.class.getClass().getResourceAsStream("/Robbo/levels/" + str3 + "/level" + str2 + ".txt");
      //    localInputStream = .getResourceAsStream("/Robbo/levels/" + str3 + "/level" + str2 + ".txt");
      //localInputStream.close();
      //localInputStream.read();
      }
      
      if (localInputStream != null)
      {
        localInputStream.read(arrayOfByte, 0, 17);
        String str1 = new String(arrayOfByte, 0, 15);
        this.screws = Integer.parseInt(str1.substring(0, 3));
        this.wall_tile = Integer.parseInt(str1.substring(3, 6));
        this.backg_color_r = Integer.parseInt(str1.substring(6, 9));
        this.backg_color_g = Integer.parseInt(str1.substring(9, 12));
        this.backg_color_b = Integer.parseInt(str1.substring(12, 15));
        for (int i = 0; i < 31; i++)
        {
          if (localInputStream.read(arrayOfByte, 0, 18) != 18) {
            throw new Exception("Too short line or no line in levelxxx.txt file");
          }
          if (arrayOfByte[16] != 13) {
            throw new Exception("Too long line in levelxxx.txt file");
          }
          for (int j = 0; j < 16; j++) {
            this.items[j][i].SetNew(arrayOfByte[j], j, i, this);
          }
        }
        localInputStream.close();
        this.current_level = paramInt;
      }
      else
      {
        throw new IOException("Could not find the game board for level " + paramInt);
      }
    }
    catch (IOException localIOException)
    {
      throw localIOException;
    }
  }
  
  private void Clear()
  {
    this.layer.fillCells(0, 0, 16, 31, 1);
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 31; j++) {
        this.items[i][j].Clear();
      }
    }
    this.canvas_pos_x = (8 - this.canvas_width / 2);
    this.canvas_pos_y = (15 - this.canvas_height / 2);
    this.layer.setPosition(this.canvas_pos_x * 16 * -1, this.canvas_pos_x * 16 * -1);
    this.backg_color_r = 25;
    this.backg_color_g = 105;
    this.backg_color_b = 0;
    this.wall_tile = 66;
    this.robbo_pos_x = -1;
    this.robbo_pos_x = -1;
    this.current_level = 0;
    this.keys = 0;
    this.screws = 0;
    this.ammo = 0;
    this.zero_screws_informed = false;
    this.level_completed = false;
    this.robbo_defeated = false;
    this.robbo_frozen = false;
    this.robbo_catched_by_magnes = false;
    this.tick = 0;
  }
  
  private void SetCapsulesActive()
  {
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 31; j++) {
        if (this.items[i][j].type == 75) {
          this.items[i][j].action_item = true;
        }
      }
    }
  }
  
  private void DrawBoard()
  {
    if ((this.screws == 0) && (!this.zero_screws_informed))
    {
      this.g.setColor(255, 255, 255);
      SetCapsulesActive();
      this.zero_screws_informed = true;
    }
    else
    {
      this.g.setColor(this.backg_color_r, this.backg_color_g, this.backg_color_b);
    }
    this.g.fillRect(0, 0, getWidth(), getHeight());
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 31; j++) {
        this.layer.setCell(i, j, this.items[i][j].tile);
      }
    }
    this.layer.paint(this.g);
    this.g.setColor(200, 200, 200);
    this.g.setFont(Font.getFont(64, 0, 8));
    this.g.drawString(info[this.current_language][0] + ": " + this.current_level, 0, 0, 20);
    this.g.drawString(info[this.current_language][1] + ": " + this.keys, 0, 10, 20);
    this.g.drawString(info[this.current_language][2] + ": " + this.screws, 0, 20, 20);
    this.g.drawString(info[this.current_language][3] + ": " + this.ammo, 0, 30, 20);
    this.g.drawImage(this.img_back, getWidth(), getHeight(), 40);
    this.g.drawImage(this.img_explode, 0, getHeight(), 36);
    flushGraphics();
  }
  
  private void SetNewLayerPositionOnRobboMove()
  {
    if (this.robbo_pos_x - 2 < this.canvas_pos_x) {
      this.canvas_pos_x = (this.robbo_pos_x - 3);
    } else if (this.robbo_pos_x + 2 > this.canvas_pos_x + this.canvas_width - 1) {
      this.canvas_pos_x = (this.robbo_pos_x + 3 - (this.canvas_width - 1));
    }
    if (this.robbo_pos_y - 2 < this.canvas_pos_y) {
      this.canvas_pos_y = (this.robbo_pos_y - 3);
    } else if (this.robbo_pos_y + 2 > this.canvas_pos_y + this.canvas_height - 1) {
      this.canvas_pos_y = (this.robbo_pos_y + 3 - (this.canvas_height - 1));
    }
    if (this.canvas_pos_x < 0) {
      this.canvas_pos_x = 0;
    } else if (this.canvas_pos_x + this.canvas_width >= 16) {
      this.canvas_pos_x = (16 - this.canvas_width);
    }
    if (this.canvas_pos_y < 0) {
      this.canvas_pos_y = 0;
    } else if (this.canvas_pos_y + this.canvas_height >= 31) {
      this.canvas_pos_y = (31 - this.canvas_height);
    }
  }
  
  private void MoveLayerToNewPosition()
  {
    int i1 = 0;
    int i2 = 0;
    int i = this.canvas_pos_x * 16 * -1;
    int j = this.canvas_pos_y * 16 * -1;
    int n = this.layer.getX() - i;
    int k;
    if ((n > 48) || (n < -48)) {
      k = 4;
    } else {
      k = 2;
    }
    n = this.layer.getY() - j;
    int m;
    if ((n > 48) || (n < -48)) {
      m = 4;
    } else {
      m = 2;
    }
    if (this.layer.getX() > i) {
      i1 = -1 * k;
    } else if (this.layer.getX() < i) {
      i1 = k;
    }
    if (this.layer.getY() > j) {
      i2 = -1 * m;
    } else if (this.layer.getY() < j) {
      i2 = m;
    }
    this.layer.move(i1, i2);
  }
  
  private void DrawStartingAnimation()
    throws Exception
  {
   // this.sound.Effect(10);
    DrawBoard();
  }
  
  private void DrawStoppingAnimation()
  {
    long l = System.currentTimeMillis();
    if (this.level_completed)
    {
      this.g.setColor(255, 255, 255);
      this.g.setFont(Font.getFont(0, 1, 16));
      this.g.drawString("Level completed!!!", 10, 50, 20);
      flushGraphics();
    }
    while (System.currentTimeMillis() < l + 1500L) {}
  }
  
  private void DrawGratulationsAnimation()
  {
    long l = System.currentTimeMillis();
    if (this.level_completed)
    {
      this.g.setColor(255, 255, 255);
      this.g.setFont(Font.getFont(0, 1, 16));
      this.g.drawString("Congratulations!!!", 10, 70, 20);
      flushGraphics();
    }
    while (System.currentTimeMillis() < l + 1500L) {}
  }
  
  public void ExplodeRobbo()
  {
    Robbo().onShooted();
  }
  
  private void onGameAnimation()
    throws Exception
  {
    int j;
    for (int i = 0; i < 16; i++) {
      for (j = 0; j < 31; j++) {
        this.items[i][j].Animate();
      }
    }
    int i;
    for (i = 0; i < 16; i++) {
      for (j = 0; j < 31; j++) {
        this.items[i][j].animated_in_this_step = false;
      }
    }
  }
  
  private void onKeysPressed(int paramInt)
    throws Exception
  {
    if (((paramInt & 0x20) != 0) && (FirePressed(paramInt))) {
      Robbo().Shoot(0, false);
    } else if (((paramInt & 0x40) != 0) && (FirePressed(paramInt))) {
      Robbo().Shoot(1, false);
    } else if (((paramInt & 0x4) != 0) && (FirePressed(paramInt))) {
      Robbo().Shoot(2, false);
    } else if (((paramInt & 0x2) != 0) && (FirePressed(paramInt))) {
      Robbo().Shoot(3, false);
    } else if ((paramInt & 0x20) != 0) {
      Robbo().LetRobboMove(0);
    } else if ((paramInt & 0x40) != 0) {
      Robbo().LetRobboMove(1);
    } else if ((paramInt & 0x4) != 0) {
      Robbo().LetRobboMove(2);
    } else if ((paramInt & 0x2) != 0) {
      Robbo().LetRobboMove(3);
    }
  }
  
  private boolean FirePressed(int paramInt)
  {
    return ((paramInt & 0x800) != 0) || ((paramInt & 0x1000) != 0) || ((paramInt & 0x100) != 0);
  }
  
  public TBoardItem Robbo()
  {
    return this.items[this.robbo_pos_x][this.robbo_pos_y];
  }
  
  public void PlayNewGame()
    throws IOException, Exception
  {
    PlayLevelNo(1);
  }
  
  public void PlayCurrentLevel()
    throws IOException, Exception
  {
    PlayLevelNo(this.score.GetLevelNumber());
  }
  
  public void PlayLevelNo(int paramInt)
    throws IOException, Exception
  {
    int i = paramInt;
    this.current_language = this.score.GetLanguage();
    if (i < 1) {
      i = 1;
    } else if (i > NoOfLevels()) {
      i = NoOfLevels();
    }
    this.score.SetLevelNumber((byte)i);
    InitCanvas();
    this.thread = new Thread(this);
    LoadLevelFromFile(i);
    this.g = getGraphics();
    DrawStartingAnimation();
    this.thread.start();
  }
  
  public void StopPlaying()
  {
    this.thread_state = 2;
    try
    {
      System.out.print("joining...\r\n");
      this.thread.join();
      System.out.print("end of joining...\r\n");
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public void run()
  {
    int i = 0;
    long l = System.currentTimeMillis();
    this.thread_state = 1;
    System.out.print("thread active!\r\n");
    try
    {
      for (;;)
      {
        this.score.SetLevelNumber((byte)this.current_level);
        do
        {
          if (this.thread_state == 1)
          {
            SetNewLayerPositionOnRobboMove();
            MoveLayerToNewPosition();
            if (System.currentTimeMillis() > l + 130L)
            {
              l = System.currentTimeMillis();
              this.tick += 1;
              if (this.tick > 1) {
                this.tick = 0;
              }
              onGameAnimation();
              i = getKeyStates();
              if ((!this.robbo_frozen) && (i != 0)) {
                onKeysPressed(i);
              }
            }
          }
          else if (this.thread_state == 2)
          {
            this.thread_state = 3;
          }
          else
          {
            this.thread_state = 0;
          }
          DrawBoard();
        } while ((this.thread_state != 0) && (!this.level_completed) && (!this.robbo_defeated));
        DrawStoppingAnimation();
        if (this.thread_state == 0) {
          //break label228;
        }
        int j;
        if (this.level_completed) {
          j = this.current_level + 1;
        } else {
          j = this.current_level;
        }
        if (j <= NoOfLevels()) {
          try
          {
            LoadLevelFromFile(j);
            DrawStartingAnimation();
          }
          catch (Exception localException1)
          {
      //      break label228;
          }
        }
      }
     // DrawGratulationsAnimation();
    }
    catch (Exception localException2)
    {
      label228:
      System.out.print(localException2.toString() + "\r\n");
    }
    this.thread_state = 0;
    System.out.print("end of thread work\r\n");
  }
}
