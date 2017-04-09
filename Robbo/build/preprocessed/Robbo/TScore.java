package Robbo;

import java.io.PrintStream;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public class TScore
{
  private static final int SCORE_SIZE = 10;
  private static final int SCO_LEVEL_LO = 0;
  private static final int SCO_LEVEL_HI = 1;
  private static final int SCO_DIFFICULTY = 2;
  private static final int SCO_LANGUAGE = 3;
  private static final int SCO_SOUND = 4;
  private static final int SCO_EFFECTS = 5;
  private byte[] score = new byte[10];
  private RecordStore store;
  public byte sound_enable = 1;
  public byte effects_enable = 1;
  
  public TScore()
  {
    Clear();
    this.sound_enable = GetSound();
    this.effects_enable = GetEffects();
  }
  
  private void Clear()
  {
    for (int i = 0; i < 10; i++) {
      this.score[i] = 0;
    }
    this.score[0] = 1;
    this.score[1] = 1;
    this.score[2] = 0;
    this.score[3] = 0;
    this.score[4] = 1;
    this.score[5] = 1;
  }
  
  private boolean Read()
  {
    Clear();
    try
    {
      this.store = RecordStore.openRecordStore("RobboScore", true);
    }
    catch (RecordStoreException localRecordStoreException1)
    {
      System.out.print(localRecordStoreException1.toString());
    }
    if (this.store == null) {
      return false;
    }
    try
    {
      RecordEnumeration localRecordEnumeration = this.store.enumerateRecords(null, null, false);
      if (localRecordEnumeration.hasNextElement())
      {
        int i = localRecordEnumeration.nextRecordId();
        this.store.getRecord(i, this.score, 0);
      }
      else
      {
        Save();
      }
    }
    catch (RecordStoreException localRecordStoreException2)
    {
      try
      {
        this.store.closeRecordStore();
      }
      catch (Exception localException2)
      {
        System.out.print(localException2.toString());
      }
      return false;
    }
    try
    {
      this.store.closeRecordStore();
    }
    catch (Exception localException1)
    {
      System.out.print(localException1.toString());
    }
    return true;
  }
  
  private boolean Save()
  {
    try
    {
      this.store = RecordStore.openRecordStore("RobboScore", true);
    }
    catch (RecordStoreException localRecordStoreException1)
    {
      System.out.print(localRecordStoreException1.toString());
    }
    if (this.store == null) {
      return false;
    }
    try
    {
      RecordEnumeration localRecordEnumeration = this.store.enumerateRecords(null, null, false);
      if (localRecordEnumeration.hasNextElement())
      {
        int i = localRecordEnumeration.nextRecordId();
        this.store.setRecord(i, this.score, 0, 10);
      }
      else
      {
        this.store.addRecord(this.score, 0, 10);
      }
    }
    catch (RecordStoreException localRecordStoreException2)
    {
      try
      {
        this.store.closeRecordStore();
      }
      catch (Exception localException2)
      {
        System.out.print(localException2.toString());
      }
      return false;
    }
    try
    {
      this.store.closeRecordStore();
    }
    catch (Exception localException1)
    {
      System.out.print(localException1.toString());
    }
    return true;
  }
  
  public byte GetLevelLoNumber()
  {
    Read();
    byte b = this.score[0];
    if (b < 1) {
      b = 1;
    }
    return b;
  }
  
  public void SetLevelLoNumber(byte paramByte)
  {
    Read();
    this.score[0] = paramByte;
    Save();
  }
  
  public byte GetLevelHiNumber()
  {
    Read();
    byte b = this.score[1];
    if (b < 1) {
      b = 1;
    }
    return b;
  }
  
  public void SetLevelHiNumber(byte paramByte)
  {
    Read();
    this.score[1] = paramByte;
    Save();
  }
  
  public byte GetLevelNumber()
  {
    Read();
    switch (this.score[2])
    {
    case 0: 
      return this.score[0];
    case 1: 
      return this.score[1];
    }
    return 1;
  }
  
  public void SetLevelNumber(byte paramByte)
  {
    Read();
    switch (this.score[2])
    {
    case 0: 
      this.score[0] = paramByte;
      break;
    case 1: 
      this.score[1] = paramByte;
    }
    Save();
  }
  
  public byte GetDifficulty()
  {
    Read();
    return this.score[2];
  }
  
  public void SetDifficulty(byte paramByte)
  {
    Read();
    this.score[2] = paramByte;
    Save();
  }
  
  public byte GetLanguage()
  {
    Read();
    return this.score[3];
  }
  
  public void SetLanguage(byte paramByte)
  {
    Read();
    this.score[3] = paramByte;
    Save();
  }
  
  public byte GetSound()
  {
    Read();
    return this.score[4];
  }
  
  public void SetSound(byte paramByte)
  {
    Read();
    this.score[4] = paramByte;
    Save();
    this.sound_enable = paramByte;
  }
  
  public byte GetEffects()
  {
    Read();
    return this.score[5];
  }
  
  public void SetEffects(byte paramByte)
  {
    Read();
    this.score[5] = paramByte;
    Save();
    this.effects_enable = paramByte;
  }
}


/* Location:              C:\Users\ATR\Desktop\Robbo.jar!\Robbo\TScore.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       0.7.1
 */