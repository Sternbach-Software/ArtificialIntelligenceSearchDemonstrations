/*    */ package search.models;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class Action extends BasicNode implements Job {
/*    */   double start;
/*    */   double duration;
/*  8 */   Color resource = Color.WHITE;
/*    */   public Action() {}
/*    */   public Action(String paramString, double paramDouble1, double paramDouble2) {
/* 11 */     this(paramDouble1, paramDouble2);
/* 12 */     this.name = paramString;
/*    */   }
/*    */   public Action(double paramDouble1, double paramDouble2) {
/* 15 */     this.start = paramDouble1;
/* 16 */     this.duration = paramDouble2;
/*    */   }
/* 18 */   public double getStart() { return this.start; }
/* 19 */   public double getDuration() { return this.duration; }
/* 20 */   public void setResource(Color paramColor) { this.resource = paramColor; } public Color getResource() {
/* 21 */     return this.resource;
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\Action.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */