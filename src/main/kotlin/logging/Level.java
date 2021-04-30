/*    */ package logging;
/*    */ 
/*    */ public class Level {
/*  4 */   public static final Level OFF = new Level("off", 7);
/*  5 */   public static final Level SEVERE = new Level("severe", 6);
/*  6 */   public static final Level WARNING = new Level("warning", 5);
/*  7 */   public static final Level INFO = new Level("info", 4);
/*  8 */   public static final Level CONFIG = new Level("config", 3);
/*  9 */   public static final Level FINE = new Level("fine", 2);
/* 10 */   public static final Level FINER = new Level("finer", 1);
/* 11 */   public static final Level FINEST = new Level("finest", 0);
/* 12 */   public static final Level All = new Level("all", -1);
/*    */   final int myLevel;
/*    */   final String name;
/*    */   
/*    */   protected Level(String paramString, int paramInt) {
/* 17 */     this.myLevel = paramInt;
/* 18 */     this.name = paramString;
/*    */   }
/* 20 */   public String toString() { return this.name; }
/* 21 */   public int intValue() { return this.myLevel; } public String getName() {
/* 22 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\logging\Level.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */