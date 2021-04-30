/*     */ package logging;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Logger
/*     */ {
/*  70 */   String identifier = "";
/*  71 */   String parentIdentifier = "";
/*  72 */   Level level = null;
/*  73 */   private static Vector loggers = new Vector();
/*  74 */   public static int OFF = 0; public static int ON = 1;
/*  75 */   private static int state = ON;
/*     */   private Logger(String paramString) {
/*  77 */     this.identifier = paramString;
/*  78 */     setParentString(this.identifier);
/*     */   }
/*     */   public static Logger getLogger(String paramString) {
/*  81 */     for (short b = 0; b < loggers.size(); b++) {
/*  82 */       Logger logger1 = (Logger) loggers.elementAt(b);
/*  83 */       if (logger1.identifier.equalsIgnoreCase(paramString)) {
/*  84 */         return logger1;
/*     */       }
/*     */     } 
/*  87 */     Logger logger = new Logger(paramString);
/*  88 */     loggers.add(logger);
/*  89 */     return logger;
/*     */   }
/*     */   public void setLevel(Level paramLevel) {
/*  92 */     this.level = paramLevel;
/*     */   }
/*     */   public boolean isLoggable(Level paramLevel) {
/*  95 */     return (paramLevel.intValue() > getLevel().intValue());
/*     */   }
/*     */   public void log(Level paramLevel, Object paramObject) {
/*  98 */     if (getLevel().intValue() > paramLevel.intValue())
/*  99 */       return;  String str = "Logger @ " + paramLevel.getName() + ": " + paramObject.toString();
/* 100 */     System.out.println(str);
/*     */   }
/*     */   public void severe(Object paramObject) {
/* 103 */     if (state == 0)
/* 104 */       return;  if (getLevel().intValue() > Level.SEVERE.intValue())
/* 105 */       return;  if (paramObject == null) paramObject = "null"; 
/* 106 */     String str = "Logger " + this.identifier + " @ severe: " + paramObject.toString();
/* 107 */     System.out.println(str);
/*     */   }
/*     */   public void warning(Object paramObject) {
/* 110 */     if (state == 0)
/* 111 */       return;  if (getLevel().intValue() > Level.WARNING.intValue())
/* 112 */       return;  if (paramObject == null) paramObject = "null"; 
/* 113 */     String str = "Logger " + this.identifier + " @ warning: " + paramObject.toString();
/* 114 */     System.out.println(str);
/*     */   }
/*     */   public void info(Object paramObject) {
/* 117 */     if (state == 0)
/* 118 */       return;  if (getLevel().intValue() > Level.INFO.intValue())
/* 119 */       return;  if (paramObject == null) paramObject = "null"; 
/* 120 */     String str = "Logger " + this.identifier + " @ info: " + paramObject.toString();
/* 121 */     System.out.println(str);
/*     */   }
/*     */   public void config(Object paramObject) {
/* 124 */     if (state == 0)
/* 125 */       return;  if (getLevel().intValue() > Level.CONFIG.intValue())
/* 126 */       return;  if (paramObject == null) paramObject = "null"; 
/* 127 */     String str = "Logger " + this.identifier + " @ config: " + paramObject.toString();
/* 128 */     System.out.println(str);
/*     */   }
/*     */   public void fine(Object paramObject) {
/* 131 */     if (state == 0)
/* 132 */       return;  if (getLevel().intValue() > Level.FINE.intValue())
/* 133 */       return;  if (paramObject == null) paramObject = "null"; 
/* 134 */     String str = "Logger " + this.identifier + " @ fine: " + paramObject.toString();
/* 135 */     System.out.println(str);
/*     */   }
/*     */   public void finer(Object paramObject) {
/* 138 */     if (state == 0)
/* 139 */       return;  if (getLevel().intValue() > Level.FINER.intValue())
/* 140 */       return;  if (paramObject == null) paramObject = "null"; 
/* 141 */     String str = "Logger " + this.identifier + " @ finer: " + paramObject.toString();
/* 142 */     System.out.println(str);
/*     */   }
/*     */   public void finest(Object paramObject) {
/* 145 */     if (state == 0)
/* 146 */       return;  if (getLevel().intValue() > Level.FINEST.intValue())
/* 147 */       return;  if (paramObject == null) paramObject = "null"; 
/* 148 */     String str = "Logger " + this.identifier + " @ finest: " + paramObject.toString();
/* 149 */     System.out.println(str);
/*     */   } public static void setState(int paramInt) {
/* 151 */     state = paramInt;
/*     */   } private void setParentString(String paramString) {
/* 153 */     int i = paramString.lastIndexOf('.');
/* 154 */     if (i >= 0)
/* 155 */       this.parentIdentifier = paramString.substring(0, i); 
/*     */   }
/*     */   
/*     */   private Logger getParent() {
/* 159 */     for (short b = 0; b < loggers.size(); b++) {
/* 160 */       Logger logger = (Logger) loggers.elementAt(b);
/* 161 */       if (logger.identifier.equalsIgnoreCase(this.parentIdentifier)) {
/* 162 */         return logger;
/*     */       }
/*     */     } 
/* 165 */     return null;
/*     */   }
/*     */   private Level getLevel() {
/* 168 */     if (this.level != null) return this.level; 
/* 169 */     Logger logger = getParent();
/* 170 */     if (logger != null) return logger.getLevel(); 
/* 171 */     return Level.INFO;
/*     */   } public String toString() {
/* 173 */     return "Logger " + this.identifier;
/*     */   } public static void main(String[] paramArrayOfString) {
/* 175 */     setState(OFF);
/* 176 */     setState(ON);
/* 177 */     System.out.println("A");
/* 178 */     getLogger("hello").setLevel(Level.WARNING);
/* 179 */     getLogger("hello.world").warning("Warning level logger triggered");
/* 180 */     getLogger("hello.world").info("Info level logger triggered");
/* 181 */     getLogger("hello.world").fine("Fine level logger triggered");
/* 182 */     System.out.println("B");
/* 183 */     getLogger("hello").setLevel(Level.INFO);
/* 184 */     getLogger("hello.world").warning("Warning level logger triggered");
/* 185 */     getLogger("hello.world").info("Info level logger triggered");
/* 186 */     getLogger("hello.world").fine("Fine level logger triggered");
/* 187 */     System.out.println("C");
/* 188 */     getLogger("hello").setLevel(Level.FINE);
/* 189 */     getLogger("hello.world").warning("Warning level logger triggered");
/* 190 */     getLogger("hello.world").info("Info level logger triggered");
/* 191 */     getLogger("hello.world").fine("Fine level logger triggered");
/* 192 */     System.out.println("D");
/* 193 */     getLogger("hello.world").setLevel(Level.WARNING);
/* 194 */     getLogger("hello.world").warning("Warning level logger triggered");
/* 195 */     getLogger("hello.world").info("Info level logger triggered");
/* 196 */     getLogger("hello.world").fine("Fine level logger triggered");
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\logging\Logger.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */