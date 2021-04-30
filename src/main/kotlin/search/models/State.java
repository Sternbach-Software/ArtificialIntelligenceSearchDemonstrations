/*    */ package search.models;
/*    */ import java.awt.Color;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class State extends BasicNode implements Job {
/*    */   Vector polygons;
/*    */   Color resource;
/*    */   
/*    */   public State(String paramString, Vector paramVector) {
/* 10 */     super(paramString);
/* 11 */     this.polygons = paramVector;
/* 12 */     this.resource = Color.white;
/*    */   }
/* 14 */   public void setResource(Color paramColor) { this.resource = paramColor; }

    public double getStart() {
        return 0;
    }

    public double getDuration() {
        return 0;
    }

    /* 15 */   public Color getResource() { return this.resource; } public Vector getPolygons() {
/* 16 */     return this.polygons;
/*    */   } public boolean equals(Object paramObject) {
/* 18 */     if (!(paramObject instanceof State)) return false; 
/* 19 */     State state = (State)paramObject;
/* 20 */     return getName().equals(state.getName());
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\State.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */