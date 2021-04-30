/*    */ package search.io;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IteratorForXML
/*    */ {
/*    */   String input;
/*    */   String start;
/*    */   String end;
/*    */   String nextResult;
/*    */   boolean test = false;
/*    */   
/*    */   public IteratorForXML(String paramString1, String paramString2, String paramString3) {
/* 17 */     this.input = paramString1;
/* 18 */     this.start = paramString2;
/* 19 */     this.end = paramString3;
/* 20 */     next();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IteratorForXML(String paramString1, String paramString2) {
/* 26 */     this(paramString1, paramString2, paramString2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 32 */     return (this.nextResult != null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String next() {
/* 38 */     String str = this.nextResult;
/* 39 */     int i = -1;
/* 40 */     short b = 0;
/* 41 */     boolean bool = true;
/* 42 */     while (bool) {
/* 43 */       i = this.input.indexOf("<" + this.start, b);
/* 44 */       if (i >= 0) {
/* 45 */         char c = this.input.charAt(i + this.start.length() + 1);
/*    */         
/* 47 */         if (c == ' ' || c == '>') {
/* 48 */           bool = false; continue;
/*    */         } 
/* 50 */         b++; continue;
/*    */       } 
/* 52 */       bool = false;
/*    */     } 
/* 54 */     int j = this.input.indexOf("</" + this.end + ">", i);
/* 55 */     j = this.input.indexOf(">", j);
/* 56 */     if (i >= 0 && j > i) {
/* 57 */       this.nextResult = this.input.substring(i, j + 1);
/* 58 */       this.input = this.input.substring(j + 1);
/*    */     } else {
/* 60 */       this.nextResult = null;
/*    */     } 
/* 62 */     return str;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] paramArrayOfString) {
/* 68 */     IteratorForXML iteratorForXML = new IteratorForXML("<LINK  REV=\"MADE\" HREF=\"mailto:comments@chinfo.navy.mil\"><h5><a<h1 align=center><FONT COLOR=\"282477\">News Specials from<br>the United States Navy</FONT></h1><blockquote>The following are special news stories from the Navy Office of Information in Washington, D.C.  They are listed in reverse chronological order.<br><LI><A HREF=\"/news_stories/newsecnav.html\">The Honorable Gordon R. England sworn in today as 72nd Secretary of the Navy</A> 24 May 2001</LI><LI><A HREF=\"/news_stories/ep3-china05.html\">EP-3E crew lands at Hickam Field, Hawaii</A> 12 April 2001</LI></ul></blockquote><p><hr><LIST>blah blah\n\nblah<LI>this is a test</LI><LI>me too</LI>", "LI");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 85 */     iteratorForXML.next();
/* 86 */     iteratorForXML.next();
/* 87 */     iteratorForXML.next();
/* 88 */     iteratorForXML.next();
/* 89 */     iteratorForXML.next();
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\io\IteratorForXML.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */