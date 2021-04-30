/*     */ package search.io;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ 
/*     */ 
/*     */ public class Tags
/*     */ {
/*     */   protected static boolean concise = true;
/*  11 */   private static DateFormat format = DateFormat.getDateTimeInstance(3, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String untagString(String paramString1, String paramString2) {
/*  19 */     String str = null;
/*  20 */     if (paramString2 == null) return str; 
/*  21 */     int i = paramString2.indexOf("<" + paramString1 + ">");
/*  22 */     int j = paramString2.indexOf("</" + paramString1 + ">", i);
/*  23 */     if (i >= 0 && j > i) {
/*  24 */       str = paramString2.substring(i + 2 + paramString1.length(), j).trim();
/*     */     }
/*  26 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean untagBoolean(String paramString1, String paramString2) {
/*  33 */     String str = untagString(paramString1, paramString2);
/*  34 */     if (str == null) return false; 
/*  35 */     return str.equalsIgnoreCase("true");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GregorianCalendar untagCalendar(String paramString1, String paramString2) {
/*  41 */     String str = untagString(paramString1, paramString2);
/*  42 */     GregorianCalendar gregorianCalendar = new GregorianCalendar();
/*     */     try {
/*  44 */       Date date = format.parse(str);
/*  45 */       gregorianCalendar.setTime(date);
/*     */     }
/*  47 */     catch (Exception exception) {
/*     */       
/*     */       try {
/*  50 */         long l = Long.parseLong(str);
/*  51 */         Date date = new Date();
/*  52 */         date.setTime(l);
/*  53 */         gregorianCalendar.setTime(date);
/*     */       }
/*  55 */       catch (Exception exception1) {
/*  56 */         System.err.println("Could not parse " + str + " as a calendar object or long");
/*     */       } 
/*     */     } 
/*  59 */     return gregorianCalendar;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int untagInt(String paramString1, String paramString2) {
/*  65 */     String str = untagString(paramString1, paramString2);
/*  66 */     if (str == null) return 0; 
/*  67 */     return Integer.parseInt(str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long untagLong(String paramString1, String paramString2) {
/*  73 */     String str = untagString(paramString1, paramString2);
/*  74 */     if (str == null) return 0L; 
/*  75 */     return Long.parseLong(str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double untagDouble(String paramString1, String paramString2) {
/*  81 */     String str = untagString(paramString1, paramString2);
/*  82 */     if (str == null) return 0.0D; 
/*  83 */     return Double.parseDouble(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String tag(String paramString, Object paramObject) {
/*  93 */     if (paramObject == null) return ""; 
/*  94 */     return addTag(paramString, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String tag(String paramString1, String paramString2) {
/* 101 */     if (paramString2 == null) return ""; 
/* 102 */     if (concise && paramString2.length() == 0) return ""; 
/* 103 */     return addTag(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String tag(String paramString, boolean paramBoolean) {
/* 110 */     if (concise && !paramBoolean) return ""; 
/* 111 */     return addTag(paramString, new Boolean(paramBoolean));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String tag(String paramString, GregorianCalendar paramGregorianCalendar) {
/* 118 */     if (paramGregorianCalendar == null) return ""; 
/* 119 */     return addTag(paramString, format.format(paramGregorianCalendar.getTime()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String tag(String paramString, int paramInt) {
/* 126 */     if (concise && paramInt == 0) return ""; 
/* 127 */     return addTag(paramString, Integer.toString(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String tag(String paramString, long paramLong) {
/* 134 */     if (concise && paramLong == 0L) return ""; 
/* 135 */     return addTag(paramString, Long.toString(paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String tag(String paramString, double paramDouble) {
/* 142 */     if (concise && paramDouble == 0.0D) return ""; 
/* 143 */     return addTag(paramString, Double.toString(paramDouble));
/*     */   }
/*     */   
/*     */   public static String removeAllTags(String paramString) {
/* 147 */     String str = paramString;
/*     */     while (true) {
/* 149 */       int i = str.indexOf("<");
/* 150 */       if (i < 0) return str; 
/* 151 */       int j = str.indexOf(">", i);
/* 152 */       if (j < 0) return str; 
/* 153 */       str = str.substring(0, i) + str.substring(j + 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String addTag(String paramString, Object paramObject) {
/* 158 */     if (paramObject == null) return ""; 
/* 159 */     String str = addSpaces(paramObject.toString());
/* 160 */     return "\n<" + paramString + ">" + ((str.charAt(0) == '\n') ? "" : "\n ") + str + "\n</" + paramString + ">";
/*     */   }
/*     */   
/*     */   private static String addSpaces(String paramString) {
/* 164 */     StringBuffer stringBuffer = new StringBuffer("");
/* 165 */     for (short b = 0; b < paramString.length(); b++) {
/* 166 */       char c = paramString.charAt(b);
/* 167 */       if (c == '\n') { stringBuffer.append("\n "); }
/* 168 */       else { stringBuffer.append(c); }
/*     */     
/* 170 */     }  return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 177 */     Object object = null;
/* 178 */     String str1 = tag("Sample", tag("Object", object) + tag("Boolean", true) + tag("Calendar", new GregorianCalendar()) + tag("String", "Hello World"));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     System.out.println(str1);
/* 184 */     String str2 = untagString("Sample", str1);
/* 185 */     System.out.println(untagString("String", str2));
/* 186 */     System.out.println(untagBoolean("Boolean", str2));
/* 187 */     System.out.println(untagCalendar("Calendar", str2).getTime());
/* 188 */     String str3 = null;
/* 189 */     System.out.println(tag("Null", str3));
/* 190 */     System.out.println(removeAllTags(str2));
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\io\Tags.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */