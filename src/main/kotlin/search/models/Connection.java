/*    */ package search.models;
/*    */ public class Connection {
/*    */   String name;
/*    */   BasicNode neighbor;
/*    */   
/*  6 */   public Connection(BasicNode paramBasicNode) { this.neighbor = paramBasicNode; } public Connection(BasicNode paramBasicNode, String paramString) {
/*  7 */     this.neighbor = paramBasicNode; this.name = paramString;
/*    */   } public boolean equals(Object paramObject) {
/*  9 */     if (!(paramObject instanceof Connection)) return false; 
/* 10 */     Connection connection = (Connection)paramObject;
/* 11 */     if (this.neighbor.equals(connection.neighbor)) return true; 
/* 12 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\Connection.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */