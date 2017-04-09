package Robbo;

import java.io.PrintStream;
import java.util.Random;

public class TBoardItem
{
  public static final int TILE_NULL = 65;
  public static final int TILE_WALL_01 = 66;
  public static final int TILE_ROBBO_DOWN_1 = 25;
  public static final int TILE_ROBBO_DOWN_2 = 26;
  public static final int TILE_ROBBO_RIGHT_1 = 27;
  public static final int TILE_ROBBO_RIGHT_2 = 28;
  public static final int TILE_ROBBO_LEFT_1 = 29;
  public static final int TILE_ROBBO_LEFT_2 = 30;
  public static final int TILE_ROBBO_UP_1 = 31;
  public static final int TILE_ROBBO_UP_2 = 32;
  public static final int TILE_SCREW = 11;
  public static final int TILE_BOX = 9;
  public static final int TILE_ROLLBOX = 10;
  public static final int TILE_DOOR = 17;
  public static final int TILE_CAPSULE_01 = 41;
  public static final int TILE_CAPSULE_02 = 42;
  public static final int TILE_AMMO = 12;
  public static final int TILE_BOMB = 13;
  public static final int TILE_KEY = 14;
  public static final int TILE_SUPRISE = 15;
  public static final int TILE_RUBBLE = 16;
  public static final int TILE_LASER_L = 35;
  public static final int TILE_LASER_R = 33;
  public static final int TILE_LASER_U = 36;
  public static final int TILE_LASER_D = 34;
  public static final int TILE_MOV_GUN = 37;
  public static final int TILE_TELEPORT_1 = 43;
  public static final int TILE_TELEPORT_2 = 44;
  public static final int TILE_EXPLO_1 = 57;
  public static final int TILE_EXPLO_2 = 58;
  public static final int TILE_EXPLO_3 = 59;
  public static final int TILE_EXPLO_4 = 60;
  public static final int TILE_EXPLO_5 = 61;
  public static final int TILE_EXPLO_6 = 62;
  public static final int TILE_BULLET_UD = 51;
  public static final int TILE_BULLET_LR = 49;
  public static final int TILE_VOID = 56;
  public static final int TILE_R_HAND_MONSTER_1 = 5;
  public static final int TILE_R_HAND_MONSTER_2 = 6;
  public static final int TILE_L_HAND_MONSTER_1 = 7;
  public static final int TILE_L_HAND_MONSTER_2 = 8;
  public static final int TILE_MAGNES_L = 63;
  public static final int TILE_MAGNES_R = 64;
  public static final int TILE_BIRD_1 = 3;
  public static final int TILE_BIRD_2 = 4;
  public static final int TILE_EYES_UP = 1;
  public static final int TILE_EYES_DN = 2;
  public static final byte TYPE_NOT_INITIALIZED = 0;
  public static final byte TYPE_FLOOR = 32;
  public static final byte TYPE_WALL = 77;
  public static final byte TYPE_ROBBO = 42;
  public static final byte TYPE_SCREW = 36;
  public static final byte TYPE_BOX = 35;
  public static final byte TYPE_ROLLBOX = 111;
  public static final byte TYPE_DOOR = 68;
  public static final byte TYPE_CAPSULE = 75;
  public static final byte TYPE_AMMO = 33;
  public static final byte TYPE_BOMB = 64;
  public static final byte TYPE_KEY = 61;
  public static final byte TYPE_SUPRISE = 63;
  public static final byte TYPE_RUBBLE = 37;
  public static final byte TYPE_LASER_L = 60;
  public static final byte TYPE_LASER_R = 62;
  public static final byte TYPE_LASER_U = 94;
  public static final byte TYPE_LASER_D = 113;
  public static final byte TYPE_GUN_L = 123;
  public static final byte TYPE_GUN_R = 125;
  public static final byte TYPE_GUN_U = 117;
  public static final byte TYPE_GUN_D = 100;
  public static final byte TYPE_ROT_GUN = 122;
  public static final byte TYPE_BLASTER_L = 93;
  public static final byte TYPE_BLASTER_R = 91;
  public static final byte TYPE_BLASTER_U = 103;
  public static final byte TYPE_BLASTER_D = 104;
  public static final byte TYPE_VOID = 120;
  public static final byte TYPE_R_HAND_MONSTER = 69;
  public static final byte TYPE_L_HAND_MONSTER = 65;
  public static final byte TYPE_MAGNES_L = 41;
  public static final byte TYPE_MAGNES_R = 40;
  public static final byte TYPE_BIRD_R = 115;
  public static final byte TYPE_BIRD_D = 102;
  public static final byte TYPE_BIRD_L = 118;
  public static final byte TYPE_BIRD_U = 97;
  public static final byte TYPE_MOV_BIRD_R = 106;
  public static final byte TYPE_MOV_BIRD_L = 107;
  public static final byte TYPE_MOV_GUN = 45;
  public static final byte TYPE_EYES = 38;
  public static final byte TYPE_TELEPORT_0 = 48;
  public static final byte TYPE_TELEPORT_1 = 49;
  public static final byte TYPE_TELEPORT_2 = 50;
  public static final byte TYPE_TELEPORT_3 = 51;
  public static final byte TYPE_TELEPORT_4 = 52;
  public static final byte TYPE_TELEPORT_5 = 53;
  public static final byte TYPE_TELEPORT_6 = 54;
  public static final byte TYPE_TELEPORT_7 = 55;
  public static final byte TYPE_TELEPORT_8 = 56;
  public static final byte TYPE_TELEPORT_9 = 57;
  public static final byte TYPE_EXPLOSION = -128;
  public static final byte TYPE_BULLET_UD = -127;
  public static final byte TYPE_BULLET_LR = -126;
  public static final byte TYPE_LASER_ACTIVE_UD = -125;
  public static final byte TYPE_LASER_ACTIVE_LR = -124;
  public static final byte TYPE_LASER_PASSIVE_UD = -123;
  public static final byte TYPE_LASER_PASSIVE_LR = -122;
  public static final byte TYPE_BLASTER_BULLET = -121;
  private static final int SHOOT_PROPABILITY = 12;
  private static final int SHOOT_PROPABILITY_BIRD = 6;
  private static final int EYES_MOV_PROPABILITY = 3;
  private static final int GUN_ROT_PROPABILITY = 12;
  private static final int SHOOT_PROPABILITY_GUN_ROT = 7;
  public static final byte NO_SIDE = -1;
  public static final byte RIGHT = 0;
  public static final byte DOWN = 1;
  public static final byte LEFT = 2;
  public static final byte UP = 3;
  private static final int[] SRH_TELEPORT_RIGHT = { 0, 3, 1, 2 };
  private static final int[] SRH_TELEPORT_DOWN = { 1, 2, 0, 3 };
  private static final int[] SRH_TELEPORT_LEFT = { 2, 1, 3, 0 };
  private static final int[] SRH_TELEPORT_UP = { 3, 0, 2, 1 };
  public static final int ANI_SEQUENCE_MAX_LENGTH = 25;
  public static final int ANI_NO_SEQUENCE = 0;
  public static final int ANI_FREEZE_ROBBO = 2001;
  public static final int ANI_UNFREEZE_ROBBO = 2002;
  public static final int ANI_DO_NOTHING = 2003;
  public static final int ANI_SET_LEVEL_COMPLETED = 2004;
  public static final int ANI_SET_ROBBO_DEFEATED = 2005;
  public static final int ANI_EXPLODE_ALL_AROUND = 2006;
  public static final int ANI_EXPLODE_ALL_ITEMS = 2007;
  public static final int ANI_CHANGE_TYPE_TO = 1000;
  public static final int ANI_ACTIONS = 2000;
  private static final int[] SEQ_ROBBO_CAPSULE_APPEAR = { 2003, 2003, 2003, 62, 61, 60, 59, 25, 2002 };
  private static final int[] SEQ_ROBBO_CAPSULE_DISAPPEAR = { 59, 60, 61, 62, 65, 2004 };
  private static final int[] SEQ_ROBBO_TELEPORT_DISAPPEAR = { 59, 60, 61, 62, 1032 };
  private static final int[] SEQ_ROBBO_TELEPORT_APPEAR = { 62, 61, 60, 59, 25, 2002 };
  private static final int[] SEQ_ROBBO_TELEPORT_NOMOVE = { 59, 60, 61, 62, 65, 62, 61, 60, 59, 25, 2002 };
  private static final int[] SEQ_ROBBO_DEFEATED = { 2001, 58, 59, 60, 61, 62, 65, 2007, 2003, 2003, 2003, 2003, 2003, 2003, 2005 };
  private static final int[] SEQ_ITEM_EXPLODE_AND_DISAPPEAR = { 58, 59, 60, 61, 62, 1032 };
  private static final int[] SEQ_EXPLODE_BOMB = { 57, 2006, 58, 59, 60, 61, 62, 1032 };
  private static final int[] SEQ_BULLET_PUFF_AND_DISAPPEAR = { 62, 1032 };
  private static final int[] SEQ_BLASTER = { 60, 59, 60, 61, 62, 1032 };
  private static final int[] SEQ_LASER_EXPLODE_AND_DISAPPEAR = { 62, 1032 };
  private static final byte[] SUPRISES = { 36, 36, 36, 35, 111, 33, 33, 64, 61, 61, 63, 63, 63, 122, 45, 38, 38 };
  public byte type;
  public int tile;
  public boolean action_item;
  public int pos_x;
  public int pos_y;
  private TBoard board;
  public int[] ani_sequence = new int[25];
  public int ani_pointer;
  public int moving_direction;
  public boolean animated_in_this_step;
  private boolean gun_move_in_this_step;
  
  public TBoardItem()
  {
    try
    {
      jbInit();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void Clear()
  {
    this.type = 0;
    this.tile = 65;
    this.action_item = false;
    this.pos_x = -1;
    this.pos_y = -1;
    this.ani_pointer = 0;
    this.animated_in_this_step = false;
    this.moving_direction = -1;
    this.gun_move_in_this_step = false;
  }
  
  private void Copy(TBoardItem paramTBoardItem1, TBoardItem paramTBoardItem2)
  {
    paramTBoardItem2.action_item = paramTBoardItem1.action_item;
    paramTBoardItem2.tile = paramTBoardItem1.tile;
    paramTBoardItem2.type = paramTBoardItem1.type;
    paramTBoardItem2.ani_pointer = paramTBoardItem1.ani_pointer;
    paramTBoardItem2.moving_direction = paramTBoardItem1.moving_direction;
    paramTBoardItem2.animated_in_this_step = paramTBoardItem1.animated_in_this_step;
    paramTBoardItem2.gun_move_in_this_step = paramTBoardItem1.gun_move_in_this_step;
    for (int i = 0; i < paramTBoardItem1.ani_pointer; i++) {
      paramTBoardItem2.ani_sequence[i] = paramTBoardItem1.ani_sequence[i];
    }
  }
  
  public void SetNew(byte paramByte, int paramInt1, int paramInt2, TBoard paramTBoard)
  {
    Clear();
    this.type = paramByte;
    this.pos_x = paramInt1;
    this.pos_y = paramInt2;
    this.board = paramTBoard;
    this.tile = GetDefaultTile(paramByte);
    this.action_item = GetDefaultActionType(paramByte);
    switch (paramByte)
    {
    case 42: 
      AniAddSequence(SEQ_ROBBO_CAPSULE_APPEAR);
      this.tile = 41;
      this.board.robbo_frozen = true;
      this.board.robbo_pos_x = this.pos_x;
      this.board.robbo_pos_y = this.pos_y;
      break;
    case 36: 
      break;
    case 115: 
      this.moving_direction = 0;
      break;
    case 102: 
      this.moving_direction = 1;
      break;
    case 118: 
      this.moving_direction = 2;
      break;
    case 97: 
      this.moving_direction = 3;
      break;
    case 106: 
      this.moving_direction = 0;
      break;
    case 107: 
      this.moving_direction = 2;
      break;
    case 45: 
      this.moving_direction = 0;
      break;
    case 122: 
      this.moving_direction = 3;
    }
  }
  
  private int GetDefaultTile(byte paramByte)
  {
    int i = 65;
    switch (paramByte)
    {
    case 77: 
      i = this.board.wall_tile;
      break;
    case 42: 
      i = 25;
      break;
    case 36: 
      i = 11;
      break;
    case 35: 
      i = 9;
      break;
    case 111: 
      i = 10;
      break;
    case 68: 
      i = 17;
      break;
    case 75: 
      i = 41;
      break;
    case 33: 
      i = 12;
      break;
    case 64: 
      i = 13;
      break;
    case 61: 
      i = 14;
      break;
    case 63: 
      i = 15;
      break;
    case 37: 
      i = 16;
      break;
    case 60: 
    case 93: 
    case 123: 
      i = 35;
      break;
    case 62: 
    case 91: 
    case 125: 
      i = 33;
      break;
    case 94: 
    case 103: 
    case 117: 
      i = 36;
      break;
    case 100: 
    case 104: 
    case 113: 
      i = 34;
      break;
    case 122: 
      i = 33;
      break;
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
      i = 43;
      break;
    case -128: 
      i = 65;
      break;
    case -127: 
      i = 51;
      break;
    case -126: 
      i = 49;
      break;
    case 120: 
      i = 56;
      break;
    case 69: 
      i = 5;
      break;
    case 65: 
      i = 7;
      break;
    case 41: 
      i = 63;
      break;
    case 40: 
      i = 64;
      break;
    case -125: 
    case -123: 
      i = 51;
      break;
    case -124: 
    case -122: 
      i = 49;
      break;
    case -121: 
      i = 62;
      break;
    case 97: 
    case 102: 
    case 106: 
    case 107: 
    case 115: 
    case 118: 
      i = 4;
      break;
    case 45: 
      i = 37;
      break;
    case 38: 
      i = 1;
      break;
    case -120: 
    case -119: 
    case -118: 
    case -117: 
    case -116: 
    case -115: 
    case -114: 
    case -113: 
    case -112: 
    case -111: 
    case -110: 
    case -109: 
    case -108: 
    case -107: 
    case -106: 
    case -105: 
    case -104: 
    case -103: 
    case -102: 
    case -101: 
    case -100: 
    case -99: 
    case -98: 
    case -97: 
    case -96: 
    case -95: 
    case -94: 
    case -93: 
    case -92: 
    case -91: 
    case -90: 
    case -89: 
    case -88: 
    case -87: 
    case -86: 
    case -85: 
    case -84: 
    case -83: 
    case -82: 
    case -81: 
    case -80: 
    case -79: 
    case -78: 
    case -77: 
    case -76: 
    case -75: 
    case -74: 
    case -73: 
    case -72: 
    case -71: 
    case -70: 
    case -69: 
    case -68: 
    case -67: 
    case -66: 
    case -65: 
    case -64: 
    case -63: 
    case -62: 
    case -61: 
    case -60: 
    case -59: 
    case -58: 
    case -57: 
    case -56: 
    case -55: 
    case -54: 
    case -53: 
    case -52: 
    case -51: 
    case -50: 
    case -49: 
    case -48: 
    case -47: 
    case -46: 
    case -45: 
    case -44: 
    case -43: 
    case -42: 
    case -41: 
    case -40: 
    case -39: 
    case -38: 
    case -37: 
    case -36: 
    case -35: 
    case -34: 
    case -33: 
    case -32: 
    case -31: 
    case -30: 
    case -29: 
    case -28: 
    case -27: 
    case -26: 
    case -25: 
    case -24: 
    case -23: 
    case -22: 
    case -21: 
    case -20: 
    case -19: 
    case -18: 
    case -17: 
    case -16: 
    case -15: 
    case -14: 
    case -13: 
    case -12: 
    case -11: 
    case -10: 
    case -9: 
    case -8: 
    case -7: 
    case -6: 
    case -5: 
    case -4: 
    case -3: 
    case -2: 
    case -1: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 34: 
    case 39: 
    case 43: 
    case 44: 
    case 46: 
    case 47: 
    case 58: 
    case 59: 
    case 66: 
    case 67: 
    case 70: 
    case 71: 
    case 72: 
    case 73: 
    case 74: 
    case 76: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    case 82: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 92: 
    case 95: 
    case 96: 
    case 98: 
    case 99: 
    case 101: 
    case 105: 
    case 108: 
    case 109: 
    case 110: 
    case 112: 
    case 114: 
    case 116: 
    case 119: 
    case 121: 
    case 124: 
    default: 
      i = 65;
    }
    return i;
  }
  
  private boolean GetDefaultActionType(byte paramByte)
  {
    boolean bool;
    switch (paramByte)
    {
    case 77: 
      bool = false;
      break;
    case 42: 
      bool = false;
      break;
    case 36: 
      bool = false;
      break;
    case 35: 
      bool = false;
      break;
    case 111: 
      bool = false;
      break;
    case 68: 
      bool = false;
      break;
    case 75: 
      bool = false;
      break;
    case 33: 
      bool = false;
      break;
    case 64: 
      bool = false;
      break;
    case 61: 
      bool = false;
      break;
    case 63: 
      bool = false;
      break;
    case 37: 
      bool = false;
      break;
    case 60: 
    case 62: 
    case 91: 
    case 93: 
    case 94: 
    case 100: 
    case 103: 
    case 104: 
    case 113: 
    case 117: 
    case 123: 
    case 125: 
      bool = true;
      break;
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
      bool = true;
      break;
    case -128: 
      bool = false;
      break;
    case -127: 
    case -126: 
      bool = true;
      break;
    case -125: 
    case -124: 
      bool = true;
      break;
    case -123: 
    case -122: 
      bool = false;
      break;
    case -121: 
      bool = true;
      break;
    case 120: 
      bool = false;
      break;
    case 65: 
    case 69: 
      bool = true;
      break;
    case 40: 
    case 41: 
      bool = true;
      break;
    case 38: 
    case 45: 
    case 97: 
    case 102: 
    case 106: 
    case 107: 
    case 115: 
    case 118: 
      bool = true;
      break;
    case 122: 
      bool = true;
      break;
    case -120: 
    case -119: 
    case -118: 
    case -117: 
    case -116: 
    case -115: 
    case -114: 
    case -113: 
    case -112: 
    case -111: 
    case -110: 
    case -109: 
    case -108: 
    case -107: 
    case -106: 
    case -105: 
    case -104: 
    case -103: 
    case -102: 
    case -101: 
    case -100: 
    case -99: 
    case -98: 
    case -97: 
    case -96: 
    case -95: 
    case -94: 
    case -93: 
    case -92: 
    case -91: 
    case -90: 
    case -89: 
    case -88: 
    case -87: 
    case -86: 
    case -85: 
    case -84: 
    case -83: 
    case -82: 
    case -81: 
    case -80: 
    case -79: 
    case -78: 
    case -77: 
    case -76: 
    case -75: 
    case -74: 
    case -73: 
    case -72: 
    case -71: 
    case -70: 
    case -69: 
    case -68: 
    case -67: 
    case -66: 
    case -65: 
    case -64: 
    case -63: 
    case -62: 
    case -61: 
    case -60: 
    case -59: 
    case -58: 
    case -57: 
    case -56: 
    case -55: 
    case -54: 
    case -53: 
    case -52: 
    case -51: 
    case -50: 
    case -49: 
    case -48: 
    case -47: 
    case -46: 
    case -45: 
    case -44: 
    case -43: 
    case -42: 
    case -41: 
    case -40: 
    case -39: 
    case -38: 
    case -37: 
    case -36: 
    case -35: 
    case -34: 
    case -33: 
    case -32: 
    case -31: 
    case -30: 
    case -29: 
    case -28: 
    case -27: 
    case -26: 
    case -25: 
    case -24: 
    case -23: 
    case -22: 
    case -21: 
    case -20: 
    case -19: 
    case -18: 
    case -17: 
    case -16: 
    case -15: 
    case -14: 
    case -13: 
    case -12: 
    case -11: 
    case -10: 
    case -9: 
    case -8: 
    case -7: 
    case -6: 
    case -5: 
    case -4: 
    case -3: 
    case -2: 
    case -1: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 34: 
    case 39: 
    case 43: 
    case 44: 
    case 46: 
    case 47: 
    case 58: 
    case 59: 
    case 66: 
    case 67: 
    case 70: 
    case 71: 
    case 72: 
    case 73: 
    case 74: 
    case 76: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    case 82: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 92: 
    case 95: 
    case 96: 
    case 98: 
    case 99: 
    case 101: 
    case 105: 
    case 108: 
    case 109: 
    case 110: 
    case 112: 
    case 114: 
    case 116: 
    case 119: 
    case 121: 
    case 124: 
    default: 
      bool = false;
    }
    return bool;
  }
  
  public boolean LetRobboMove(int paramInt)
    throws Exception
  {
    int[] arrayOfInt = new int[1];
    switch (paramInt)
    {
    case 0: 
      if ((this.tile != 27) && (this.tile != 28)) {
        this.tile = 27;
      }
      arrayOfInt[0] = (this.tile == 27 ? 28 : 27);
      break;
    case 1: 
      if ((this.tile != 25) && (this.tile != 26)) {
        this.tile = 25;
      }
      arrayOfInt[0] = (this.tile == 25 ? 26 : 25);
      break;
    case 2: 
      if ((this.tile != 29) && (this.tile != 30)) {
        this.tile = 29;
      }
      arrayOfInt[0] = (this.tile == 29 ? 30 : 29);
      break;
    case 3: 
      if ((this.tile != 31) && (this.tile != 32)) {
        this.tile = 31;
      }
      arrayOfInt[0] = (this.tile == 31 ? 32 : 31);
    }
    if (((ItemOn(paramInt).type < 48) || (ItemOn(paramInt).type > 57)) && (this.ani_pointer == 0)) {
      AniAddSequence(arrayOfInt);
    }
    switch (ItemOn(paramInt).type)
    {
    case 32: 
      Move(paramInt);
    //  this.board.sound.Effect(1);
      LetRobboToCheckDeadlyItemsAround();
      return true;
    case 35: 
    case 45: 
    case 63: 
    case 64: 
    case 111: 
      if (ItemOn(paramInt).LetItemMove(paramInt))
      {
      //  this.board.sound.Effect(6);
        Move(paramInt);
        LetRobboToCheckDeadlyItemsAround();
        return true;
      }
      return false;
    case 61: 
   //   this.board.sound.Effect(9);
      Move(paramInt);
      LetRobboToCheckDeadlyItemsAround();
      this.board.keys += 1;
      return true;
    case 68: 
      if (this.board.keys > 0)
      {
  //     this.board.sound.Effect(14);
        Move(paramInt);
        this.board.keys -= 1;
        LetRobboToCheckDeadlyItemsAround();
        return true;
      }
      break;
    case 36: 
      Move(paramInt);
      if (this.board.screws > 0) {
        this.board.screws -= 1;
      }
     // this.board.sound.Effect(2);
      LetRobboToCheckDeadlyItemsAround();
      return true;
    case 33: 
   //   this.board.sound.Effect(8);
      Move(paramInt);
      this.board.ammo += 9;
      LetRobboToCheckDeadlyItemsAround();
      return true;
    case 75: 
      if (ItemOn(paramInt).action_item)
      {
        this.board.robbo_frozen = true;
      //  this.board.sound.Effect(11);
        AniAddSequence(SEQ_ROBBO_CAPSULE_DISAPPEAR);
        return false;
      }
      if (ItemOn(paramInt).LetItemMove(paramInt))
      {
     //   this.board.sound.Effect(6);
        Move(paramInt);
        LetRobboToCheckDeadlyItemsAround();
        return true;
      }
      return false;
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
   //   this.board.sound.Effect(7);
      TeleportRobbo(paramInt);
    }
    return false;
  }
  
  private void TeleportRobbo(int paramInt)
  {
    for (TBoardItem localTBoardItem = ItemOn(paramInt).FindNextTeleport(); TeleportTo(localTBoardItem, paramInt) != true; localTBoardItem = localTBoardItem.FindNextTeleport()) {}
  }
  
  private TBoardItem FindNextTeleport()
  {
    int j;
    for (int i = this.pos_y; i < 31; i++) {
      for (j = 0; j < 16; j++) {
        if (((i != this.pos_y) || (j > this.pos_x)) && (this.board.items[j][i].type == this.type)) {
          return this.board.items[j][i];
        }
      }
    }
    int i;
    for (i = 0; i <= this.pos_y; i++) {
      for (j = 0; j < 16; j++) {
        if (((i != this.pos_y) || (j < this.pos_x)) && (this.board.items[j][i].type == this.type)) {
          return this.board.items[j][i];
        }
      }
    }
    return this;
  }
  
  private boolean TeleportTo(TBoardItem paramTBoardItem, int paramInt)
  {
    int[] arrayOfInt = new int[4];
    switch (paramInt)
    {
    case 0: 
      arrayOfInt = SRH_TELEPORT_RIGHT;
      break;
    case 1: 
      arrayOfInt = SRH_TELEPORT_DOWN;
      break;
    case 2: 
      arrayOfInt = SRH_TELEPORT_LEFT;
      break;
    case 3: 
      arrayOfInt = SRH_TELEPORT_UP;
    }
    for (int i = 0; i < 4; i++)
    {
      if (paramTBoardItem.ItemOn(arrayOfInt[i]).type == 32)
      {
        TBoardItem localTBoardItem = paramTBoardItem.ItemOn(arrayOfInt[i]);
        this.board.robbo_frozen = true;
        Copy(this, localTBoardItem);
        localTBoardItem.tile = 65;
        localTBoardItem.AniAddSequence(SEQ_ROBBO_TELEPORT_APPEAR);
        this.board.robbo_pos_x = localTBoardItem.pos_x;
        this.board.robbo_pos_y = localTBoardItem.pos_y;
        this.type = Byte.MIN_VALUE;
        AniAddSequence(SEQ_ROBBO_TELEPORT_DISAPPEAR);
        return true;
      }
      if (paramTBoardItem.ItemOn(arrayOfInt[i]).type == 42)
      {
        this.board.robbo_frozen = true;
        AniAddSequence(SEQ_ROBBO_TELEPORT_NOMOVE);
        return true;
      }
    }
    return false;
  }
  
  private void LetItemToGoAndToFrom()
    throws Exception
  {
    if (this.type == 45)
    {
      this.gun_move_in_this_step = (!this.gun_move_in_this_step);
      if (this.gun_move_in_this_step) {
        return;
      }
    }
    if (ItemOn(this.moving_direction).type != 32) {
      this.moving_direction = GetOppositeSide(this.moving_direction);
    } else {
      LetItemMove(this.moving_direction);
    }
    LetRobboToCheckDeadlyItemsAround();
  }
  
  private void LetEyesMove()
  {
    int i = -1;
    int j = -1;
    int k = -1;
    boolean bool = false;
    if (randomInt(3) == 0)
    {
      i = randomInt(4);
      if (i == 3) {
        this.tile = 1;
      }
      if (i == 1) {
        this.tile = 2;
      }
      LetItemMove(i);
    }
    else
    {
      if (this.pos_y > this.board.robbo_pos_y) {
        k = 3;
      } else if (this.pos_y < this.board.robbo_pos_y) {
        k = 1;
      }
      if (this.pos_x > this.board.robbo_pos_x) {
        j = 2;
      } else if (this.pos_x < this.board.robbo_pos_x) {
        j = 0;
      }
      if (k != -1)
      {
        if (k == 3) {
          this.tile = 1;
        }
        if (k == 1) {
          this.tile = 2;
        }
        bool = LetItemMove(k);
      }
      if ((!bool) && (j != -1)) {
        LetItemMove(j);
      }
    }
  }
  
  private void RandomRotateGun()
    throws Exception
  {
    if (randomInt(12) == 0)
    {
      if (randomInt(2) == 0) {
        this.moving_direction = GetSideOnRightOf(this.moving_direction);
      } else {
        this.moving_direction = GetSideOnLeftOf(this.moving_direction);
      }
      switch (this.moving_direction)
      {
      case 0: 
        this.tile = 33;
        break;
      case 1: 
        this.tile = 34;
        break;
      case 2: 
        this.tile = 35;
        break;
      case 3: 
        this.tile = 36;
      }
    }
  }
  
  public boolean LetItemMove(int paramInt)
  {
    if (ItemOn(paramInt).type != 32)
    {
      if (this.type == 111)
      {
        if (this.action_item) {
          ItemOn(paramInt).onShooted();
        }
        this.action_item = false;
        this.moving_direction = -1;
      }
      return false;
    }
    if (this.type == 111)
    {
      this.action_item = true;
      this.moving_direction = paramInt;
    }
    Move(paramInt);
    return true;
  }
  
  private boolean LetLaserMove(int paramInt)
    throws Exception
  {
    switch (ItemOn(paramInt).type)
    {
    case 32: 
      MoveLaser(paramInt);
      return true;
    case -123: 
      if ((paramInt == 3) || (paramInt == 1))
      {
        Move(paramInt);
        return true;
      }
      return false;
    case -122: 
      if ((paramInt == 0) || (paramInt == 2))
      {
        Move(paramInt);
        return true;
      }
      return false;
    case 60: 
    case 62: 
    case 94: 
    case 113: 
      if ((ItemOn(GetOppositeSide(paramInt)).type == -122) || (ItemOn(GetOppositeSide(paramInt)).type == -123)) {
        return false;
      }
      this.action_item = false;
      AniAddSequence(SEQ_BULLET_PUFF_AND_DISAPPEAR);
      return true;
    }
    ItemOn(this.moving_direction).onShooted();
    return false;
  }
  
  private void Move(int paramInt)
  {
    int i = 0;
    int j = 0;
    switch (paramInt)
    {
    case 0: 
      i = 1;
      break;
    case 1: 
      j = 1;
      break;
    case 2: 
      i = -1;
      break;
    case 3: 
      j = -1;
    }
    if (this.type == 42)
    {
      this.board.robbo_pos_x = (this.pos_x + i);
      this.board.robbo_pos_y = (this.pos_y + j);
    }
    Copy(this, this.board.items[(this.pos_x + i)][(this.pos_y + j)]);
    ChangeToFloor();
  }
  
  private void MoveLaser(int paramInt)
  {
    int i = 0;
    int j = 0;
    switch (paramInt)
    {
    case 0: 
      i = 1;
      break;
    case 1: 
      j = 1;
      break;
    case 2: 
      i = -1;
      break;
    case 3: 
      j = -1;
    }
    if (this.type == 42)
    {
      this.board.robbo_pos_x = (this.pos_x + i);
      this.board.robbo_pos_y = (this.pos_y + j);
    }
    Copy(this, this.board.items[(this.pos_x + i)][(this.pos_y + j)]);
    if ((paramInt == 0) || (paramInt == 2))
    {
      this.type = -122;
      this.tile = 49;
    }
    else
    {
      this.type = -123;
      this.tile = 51;
    }
    this.action_item = false;
  }
  
  private void ChangeToFloor()
  {
    this.action_item = false;
    this.ani_pointer = 0;
    this.tile = 65;
    this.type = 32;
  }
  
  private TBoardItem ItemOn(int paramInt)
  {
    if (((this.pos_x == 0) && (paramInt == 2)) || ((this.pos_y == 0) && (paramInt == 3)) || ((this.pos_x >= 15) && (paramInt == 0)) || ((this.pos_y >= 30) && (paramInt == 1)))
    {
      System.out.print("TBoardItem::ItemOn - asking for over game board\r\n");
      return this.board.nullItem;
    }
    switch (paramInt)
    {
    case 0: 
      return this.board.items[(this.pos_x + 1)][this.pos_y];
    case 1: 
      return this.board.items[this.pos_x][(this.pos_y + 1)];
    case 2: 
      return this.board.items[(this.pos_x - 1)][this.pos_y];
    case 3: 
      return this.board.items[this.pos_x][(this.pos_y - 1)];
    }
    return null;
  }
  
  public void Animate()
    throws Exception
  {
    if (this.animated_in_this_step) {
      return;
    }
    AnimateSequence();
    if (this.action_item != true) {
      return;
    }
    this.animated_in_this_step = true;
    switch (this.type)
    {
    case -127: 
    case -126: 
      if (!LetItemMove(this.moving_direction))
      {
        ItemOn(this.moving_direction).onShooted();
        this.type = Byte.MIN_VALUE;
        this.tile = 61;
        AniAddSequence(SEQ_BULLET_PUFF_AND_DISAPPEAR);
      }
      break;
    case -125: 
    case -124: 
      if (!LetLaserMove(this.moving_direction)) {
        this.moving_direction = GetOppositeSide(this.moving_direction);
      }
      break;
    case -121: 
      LetBlasterMove(this.moving_direction);
      break;
    case 125: 
      RandomShoot(0, 12, false);
      break;
    case 100: 
      RandomShoot(1, 12, false);
      break;
    case 123: 
      RandomShoot(2, 12, false);
      break;
    case 117: 
      RandomShoot(3, 12, false);
      break;
    case 62: 
      RandomShoot(0, 12, true);
      break;
    case 113: 
      RandomShoot(1, 12, true);
      break;
    case 60: 
      RandomShoot(2, 12, true);
      break;
    case 94: 
      RandomShoot(3, 12, true);
      break;
    case 91: 
      RandomBlast(0, 12);
      break;
    case 104: 
      RandomBlast(1, 12);
      break;
    case 93: 
      RandomBlast(2, 12);
      break;
    case 103: 
      RandomBlast(3, 12);
      break;
    case 65: 
      OnTickSwitchTile(7, 8);
      MoveLeftHandMonster();
      LetRobboToCheckDeadlyItemsAround();
      break;
    case 69: 
      OnTickSwitchTile(5, 6);
      MoveRightHandMonster();
      LetRobboToCheckDeadlyItemsAround();
      break;
    case 41: 
      FindRobboToCatchHim(2);
      break;
    case 40: 
      FindRobboToCatchHim(0);
      break;
    case 42: 
      MoveRobboCatchedByMagnes();
      LetRobboToCheckDeadlyItemsAround();
      break;
    case 111: 
      LetItemMove(this.moving_direction);
      break;
    case 97: 
    case 102: 
    case 115: 
    case 118: 
      OnTickSwitchTile(3, 4);
      LetItemToGoAndToFrom();
      LetRobboToCheckDeadlyItemsAround();
      break;
    case 106: 
    case 107: 
      OnTickSwitchTile(3, 4);
      RandomShoot(1, 6, false);
      LetItemToGoAndToFrom();
      LetRobboToCheckDeadlyItemsAround();
      break;
    case 45: 
      RandomShoot(3, 12, false);
      LetItemToGoAndToFrom();
      LetRobboToCheckDeadlyItemsAround();
      break;
    case 122: 
      RandomRotateGun();
      RandomShoot(this.moving_direction, 7, false);
      break;
    case 38: 
      LetEyesMove();
      LetRobboToCheckDeadlyItemsAround();
      break;
    case 75: 
      OnTickSwitchTile(41, 42);
      break;
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
      OnTickSwitchTile(43, 44);
    }
  }
  
  private void AnimateSequence()
    throws Exception
  {
    if (this.ani_pointer <= 0) {
      return;
    }
    int i = AniGet();
    if (i < 1000)
    {
      this.tile = i;
    }
    else if ((i > 1000) && (i < 2000))
    {
      this.type = ((byte)(i - 1000));
      this.tile = GetDefaultTile(this.type);
      this.action_item = GetDefaultActionType(this.type);
      this.moving_direction = 0;
    }
    else
    {
      switch (i)
      {
      case 2001: 
        this.board.robbo_frozen = true;
        break;
      case 2002: 
        this.board.robbo_frozen = false;
        break;
      case 2003: 
        break;
      case 2006: 
        ExplodeAllAround();
        break;
      case 2004: 
        this.board.level_completed = true;
        break;
      case 2005: 
        this.board.robbo_defeated = true;
        break;
      case 2007: 
        ExplodeAllItems();
      }
    }
  }
  
  private void ExplodeAllAround()
    throws Exception
  {
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if ((this.pos_x + i >= 0) && (this.pos_y + j >= 0) && (this.pos_x + i < 16) && (this.pos_y + j < 31) && ((i != 0) || (j != 0))) {
          this.board.items[(this.pos_x + i)][(this.pos_y + j)].onExplosion();
        }
      }
    }
  }
  
  public void ExplodeAllItems()
  {
    try
    {
  //    this.board.sound.Effect(16);
    }
    catch (Exception localException) {}
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 31; j++) {
        switch (this.board.items[i][j].type)
        {
        case -128: 
        case 0: 
        case 32: 
        case 77: 
        case 120: 
          break;
        default: 
          this.board.items[i][j].type = Byte.MIN_VALUE;
          this.board.items[i][j].tile = 57;
          this.board.items[i][j].AniAddSequence(SEQ_ITEM_EXPLODE_AND_DISAPPEAR);
        }
      }
    }
  }
  
  private void AniAddSequence(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    if (25 - this.ani_pointer < i)
    {
      System.out.print("Type: " + this.type + ", position: " + this.pos_x + "/" + this.pos_y + "\r\n");
      System.out.print("No more place for animation sequence!!!\r\n");
      return;
    }
    for (int j = 0; j < i; j++) {
      this.ani_sequence[(this.ani_pointer + j)] = paramArrayOfInt[j];
    }
    this.ani_pointer += i;
  }
  
  private int AniGet()
  {
    if (this.ani_pointer > 0)
    {
      int i = this.ani_sequence[0];
      for (int j = 0; j < this.ani_pointer - 1; j++) {
        this.ani_sequence[j] = this.ani_sequence[(j + 1)];
      }
      this.ani_pointer -= 1;
      return i;
    }
    return 0;
  }
  
  public void Shoot(int paramInt, boolean paramBoolean)
  {
    if (this.type == 42)
    {
      switch (paramInt)
      {
      case 0: 
        this.tile = 27;
        break;
      case 1: 
        this.tile = 25;
        break;
      case 2: 
        this.tile = 29;
        break;
      case 3: 
        this.tile = 31;
      }
      if (this.board.ammo <= 0) {
        return;
      }
      this.board.ammo -= 1;
    }
    if (ItemOn(paramInt).type == 32)
    {
      if ((paramInt == 0) || (paramInt == 2))
      {
        if (paramBoolean) {
          ItemOn(paramInt).type = -124;
        } else {
          ItemOn(paramInt).type = -126;
        }
      }
      else if (paramBoolean) {
        ItemOn(paramInt).type = -125;
      } else {
        ItemOn(paramInt).type = -127;
      }
      ItemOn(paramInt).action_item = GetDefaultActionType(ItemOn(paramInt).type);
      ItemOn(paramInt).moving_direction = paramInt;
      ItemOn(paramInt).tile = GetDefaultTile(ItemOn(paramInt).type);
      if (this.type != 42) {
        ItemOn(paramInt).animated_in_this_step = true;
      }
    }
    else if ((ItemOn(paramInt).type != -126) && (ItemOn(paramInt).type != -127))
    {
      ItemOn(paramInt).onShooted();
    }
  }
  
  private void RandomShoot(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = randomInt(paramInt2);
    if (i == 0) {
      Shoot(paramInt1, paramBoolean);
    }
  }
  
  public void onShooted()
  {
    int[] arrayOfInt = new int[1];
    switch (this.type)
    {
    case 42: 
      if (IsRobboVisible())
      {
        this.type = Byte.MIN_VALUE;
        this.board.robbo_frozen = true;
        AniAddSequence(SEQ_ROBBO_DEFEATED);
        try
        {
      //    this.board.sound.Effect(15);
        }
        catch (Exception localException1) {}
      }
      break;
    case 64: 
      this.type = Byte.MIN_VALUE;
      this.tile = 57;
      AniAddSequence(SEQ_EXPLODE_BOMB);
      try
      {
      //  this.board.sound.Effect(12);
      }
      catch (Exception localException2) {}
    case 63: 
      this.type = Byte.MIN_VALUE;
      this.tile = 57;
      AniAddSequence(SEQ_ITEM_EXPLODE_AND_DISAPPEAR);
      arrayOfInt[0] = (1000 + SUPRISES[randomInt(SUPRISES.length)]);
      AniAddSequence(arrayOfInt);
      try
      {
       // this.board.sound.Effect(15);
      }
      catch (Exception localException3) {}
    case 33: 
    case 37: 
    case 38: 
    case 65: 
    case 69: 
    case 97: 
    case 102: 
    case 106: 
    case 107: 
    case 115: 
    case 118: 
      this.type = Byte.MIN_VALUE;
      this.tile = 57;
      AniAddSequence(SEQ_ITEM_EXPLODE_AND_DISAPPEAR);
      try
      {
      //  this.board.sound.Effect(15);
      }
      catch (Exception localException4) {}
    }
  }
  
  private void RandomBlast(int paramInt1, int paramInt2)
  {
    int i = randomInt(paramInt2);
    if (i != 0) {
      return;
    }
    if (ItemOn(paramInt1).type == 42)
    {
      ItemOn(paramInt1).onShooted();
    }
    else if (IsBlastedItem(ItemOn(paramInt1).type))
    {
      ItemOn(paramInt1).type = -121;
      ItemOn(paramInt1).tile = 62;
      ItemOn(paramInt1).moving_direction = paramInt1;
      ItemOn(paramInt1).action_item = true;
    }
  }
  
  private boolean IsBlastedItem(int paramInt)
  {
    switch (paramInt)
    {
    case 32: 
    case 33: 
    case 37: 
    case 38: 
    case 63: 
    case 65: 
    case 69: 
    case 97: 
    case 102: 
    case 106: 
    case 107: 
    case 115: 
    case 118: 
      return true;
    }
    return false;
  }
  
  private void LetBlasterMove(int paramInt)
    throws Exception
  {
    int i = 0;
    int j = 0;
    if (IsBlastedItem(ItemOn(paramInt).type))
    {
      switch (paramInt)
      {
      case 0: 
        i = 1;
        break;
      case 1: 
        j = 1;
        break;
      case 2: 
        i = -1;
        break;
      case 3: 
        j = -1;
      }
      Copy(this, this.board.items[(this.pos_x + i)][(this.pos_y + j)]);
    }
    else
    {
      switch (ItemOn(paramInt).type)
      {
      case 42: 
      case 64: 
        ItemOn(paramInt).onShooted();
      }
      ChangeToFloor();
    }
    this.type = Byte.MIN_VALUE;
    this.tile = 61;
    this.action_item = false;
    AniAddSequence(SEQ_BLASTER);
  }
  
  public void onExplosion()
    throws Exception
  {
    switch (this.type)
    {
    case 42: 
      this.type = Byte.MIN_VALUE;
      this.board.robbo_frozen = true;
      AniAddSequence(SEQ_ROBBO_DEFEATED);
      break;
    case 64: 
  ///    this.board.sound.Effect(12);
      this.type = Byte.MIN_VALUE;
      AniAddSequence(SEQ_EXPLODE_BOMB);
      break;
    case -128: 
    case -125: 
    case -124: 
    case -123: 
    case -122: 
    case 0: 
    case 40: 
    case 41: 
    case 75: 
    case 77: 
    case 120: 
      break;
    case 60: 
    case 62: 
    case 94: 
    case 113: 
      LaserDisappear();
      this.type = Byte.MIN_VALUE;
      this.tile = 57;
      AniAddSequence(SEQ_ITEM_EXPLODE_AND_DISAPPEAR);
      break;
    default: 
      this.type = Byte.MIN_VALUE;
      this.tile = 57;
      AniAddSequence(SEQ_ITEM_EXPLODE_AND_DISAPPEAR);
    }
  }
  
  private void LaserDisappear()
  {
    System.out.print("Laser disappear\r\n");
    int i;
    switch (this.type)
    {
    case 60: 
      i = 2;
      break;
    case 62: 
      i = 0;
      break;
    case 94: 
      i = 3;
      break;
    case 113: 
      i = 1;
      break;
    default: 
      return;
    }
    TBoardItem localTBoardItem = this;
    for (;;)
    {
      localTBoardItem = localTBoardItem.ItemOn(i);
      if ((localTBoardItem.type == -122) && ((i == 2) || (i == 0)))
      {
        localTBoardItem.AniAddSequence(SEQ_LASER_EXPLODE_AND_DISAPPEAR);
      }
      else
      {
        if ((localTBoardItem.type == -124) && ((i == 2) || (i == 0)))
        {
          localTBoardItem.AniAddSequence(SEQ_LASER_EXPLODE_AND_DISAPPEAR);
          return;
        }
        if ((localTBoardItem.type != -123) || ((i != 3) && (i != 1))) {
          break;
        }
        localTBoardItem.AniAddSequence(SEQ_LASER_EXPLODE_AND_DISAPPEAR);
      }
    }
    if ((localTBoardItem.type == -125) && ((i == 3) || (i == 1))) {
      localTBoardItem.AniAddSequence(SEQ_LASER_EXPLODE_AND_DISAPPEAR);
    }
  }
  
  private void MoveLeftHandMonster()
    throws Exception
  {
    if (this.moving_direction == -1) {
      if (ItemOn(1).type != 32) {
        this.moving_direction = GetSideOnRightOf(1);
      } else if (ItemOn(0).type != 32) {
        this.moving_direction = GetSideOnRightOf(0);
      } else if (ItemOn(3).type != 32) {
        this.moving_direction = GetSideOnRightOf(3);
      } else {
        this.moving_direction = 3;
      }
    }
    for (int i = 0; i < 2; i++)
    {
      if (LetItemMove(GetSideOnLeftOf(this.moving_direction)) == true)
      {
        ItemOn(GetSideOnLeftOf(this.moving_direction)).moving_direction = GetSideOnLeftOf(this.moving_direction);
        break;
      }
      this.moving_direction = GetSideOnRightOf(this.moving_direction);
    }
  }
  
  private void MoveRightHandMonster()
    throws Exception
  {
    if (this.moving_direction == -1) {
      if (ItemOn(3).type != 32) {
        this.moving_direction = GetSideOnLeftOf(3);
      } else if (ItemOn(2).type != 32) {
        this.moving_direction = GetSideOnLeftOf(2);
      } else if (ItemOn(1).type != 32) {
        this.moving_direction = GetSideOnLeftOf(1);
      } else {
        this.moving_direction = 1;
      }
    }
    for (int i = 0; i < 2; i++)
    {
      if (LetItemMove(GetSideOnRightOf(this.moving_direction)) == true)
      {
        ItemOn(GetSideOnRightOf(this.moving_direction)).moving_direction = GetSideOnRightOf(this.moving_direction);
        break;
      }
      this.moving_direction = GetSideOnLeftOf(this.moving_direction);
    }
  }
  
  private int GetSideOnLeftOf(int paramInt)
    throws Exception
  {
    int i;
    switch (paramInt)
    {
    case 0: 
      i = 3;
      break;
    case 1: 
      i = 0;
      break;
    case 2: 
      i = 1;
      break;
    case 3: 
      i = 2;
      break;
    default: 
      throw new Exception("Illegal moving direction when asking for left hand");
    }
    return i;
  }
  
  private void FindRobboToCatchHim(int paramInt)
  {
    if (this.board.robbo_catched_by_magnes) {
      return;
    }
    if (this.board.robbo_frozen) {
      return;
    }
    int i;
    if (paramInt == 0) {
      for (i = this.pos_x + 1; i < 16; i++)
      {
        if ((this.board.items[i][this.pos_y].type != 32) && (this.board.items[i][this.pos_y].type != 42)) {
          return;
        }
        if (this.board.items[i][this.pos_y].type == 42)
        {
          try
          {
          //  this.board.sound.Effect(13);
          }
          catch (Exception localException1) {}
          this.board.robbo_frozen = true;
          this.board.robbo_catched_by_magnes = true;
          this.board.Robbo().moving_direction = 2;
          this.board.Robbo().action_item = true;
          this.board.Robbo().tile = 28;
        }
      }
    } else if (paramInt == 2) {
      for (i = this.pos_x - 1; i >= 0; i--)
      {
        if ((this.board.items[i][this.pos_y].type != 32) && (this.board.items[i][this.pos_y].type != 42)) {
          return;
        }
        if (this.board.items[i][this.pos_y].type == 42)
        {
          try
          {
          //  this.board.sound.Effect(13);
          }
          catch (Exception localException2) {}
          this.board.robbo_frozen = true;
          this.board.robbo_catched_by_magnes = true;
          this.board.Robbo().moving_direction = 0;
          this.board.Robbo().action_item = true;
          this.board.Robbo().tile = 30;
        }
      }
    }
  }
  
  private void MoveRobboCatchedByMagnes()
  {
    if (ItemOn(this.moving_direction).type == 32)
    {
      Move(this.moving_direction);
    }
    else
    {
      this.action_item = false;
      onShooted();
    }
  }
  
  private int GetSideOnRightOf(int paramInt)
    throws Exception
  {
    int i;
    switch (paramInt)
    {
    case 0: 
      i = 1;
      break;
    case 1: 
      i = 2;
      break;
    case 2: 
      i = 3;
      break;
    case 3: 
      i = 0;
      break;
    default: 
      throw new Exception("Illegal moving direction when asking for left hand");
    }
    return i;
  }
  
  private int GetOppositeSide(int paramInt)
    throws Exception
  {
    int i;
    switch (paramInt)
    {
    case 0: 
      i = 2;
      break;
    case 1: 
      i = 3;
      break;
    case 2: 
      i = 0;
      break;
    case 3: 
      i = 1;
      break;
    default: 
      throw new Exception("Illegal moving direction when asking for left hand");
    }
    return i;
  }
  
  private void LetRobboToCheckDeadlyItemsAround()
  {
    if ((IsDeadlyItem(this.board.items[this.board.robbo_pos_x][this.board.robbo_pos_y].ItemOn(0).type)) || (IsDeadlyItem(this.board.items[this.board.robbo_pos_x][this.board.robbo_pos_y].ItemOn(1).type)) || (IsDeadlyItem(this.board.items[this.board.robbo_pos_x][this.board.robbo_pos_y].ItemOn(2).type)) || (IsDeadlyItem(this.board.items[this.board.robbo_pos_x][this.board.robbo_pos_y].ItemOn(3).type))) {
      this.board.ExplodeRobbo();
    }
  }
  
  private boolean IsDeadlyItem(int paramInt)
  {
    switch (paramInt)
    {
    case 38: 
    case 65: 
    case 69: 
    case 97: 
    case 102: 
    case 106: 
    case 107: 
    case 115: 
    case 118: 
      return true;
    }
    return false;
  }
  
  private void OnTickSwitchTile(int paramInt1, int paramInt2)
  {
    if (this.board.tick == 0) {
      this.tile = (this.tile == paramInt1 ? paramInt2 : paramInt1);
    }
  }
  
  private boolean IsRobboVisible()
  {
    switch (this.tile)
    {
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
      return true;
    }
    return false;
  }
  
  private int randomInt(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    int i = this.board.rand.nextInt();
    i = i < 0 ? i * -1 : i;
    return i % paramInt;
  }
  
  private void jbInit()
    throws Exception
  {}
}
