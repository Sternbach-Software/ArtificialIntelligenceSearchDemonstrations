/*    */ package search.models;

import java.util.Vector;

/*    */
/*    */ public class BasicNode {
/*  4 */   String name = null;
/*  5 */   Vector neighbors = new Vector();
/*  6 */   public String getName() { return this.name; }
/*  7 */   public void setName(String paramString) { this.name = paramString; } public void clearName(String paramString) {
/*  8 */     this.name = null;
/*    */   } public BasicNode(String paramString) {
/* 10 */     this.name = paramString;
/*    */   } public BasicNode() {} public void addNeighbor(BasicNode paramBasicNode) {
/* 12 */     Connection connection = new Connection(paramBasicNode);
/* 13 */     if (this.neighbors.contains(connection))
/* 14 */       return;  this.neighbors.add(connection);
/*    */   }
/*    */   
/*    */   public void addNeighbor(BasicNode paramBasicNode, String paramString) {
/* 18 */     Connection connection = new Connection(paramBasicNode, paramString);
/* 19 */     if (this.neighbors.contains(connection))
/* 20 */       return;  this.neighbors.add(connection);
/*    */   }
/*    */   
/*    */   public Vector getNeighbors() {
/* 24 */     Vector vector = new Vector();
/* 25 */     for (short b = 0; b < this.neighbors.size(); b++) {
/* 26 */       Connection connection = (Connection) this.neighbors.elementAt(b);
/* 27 */       vector.add(connection.neighbor);
/*    */     } 
/* 29 */     return vector;
/*    */   }
/*    */   public boolean equals(Object paramObject) {
/* 32 */     if (!(paramObject instanceof BasicNode)) return false; 
/* 33 */     BasicNode basicNode = (BasicNode)paramObject;
/* 34 */     if (getName() != null) {
/* 35 */       return getName().equals(basicNode.getName());
/*    */     }
/* 37 */     return false;
/*    */   }
/*    */   public String toString() {
/* 40 */     if (this.name != null) return this.name; 
/* 41 */     return "<<BasicNode>>";
/*    */   }
/*    */   public static void main(String[] paramArrayOfString) {
/* 44 */     BasicNode basicNode1 = new BasicNode("Foo");
/* 45 */     BasicNode basicNode2 = new BasicNode("Bar");
/* 46 */     BasicNode basicNode3 = new BasicNode("Baz");
/* 47 */     System.out.println("n1/n1 " + basicNode1.equals(basicNode1));
/* 48 */     System.out.println("n1/n2 " + basicNode1.equals(basicNode2));
/* 49 */     System.out.println("n1/n3 " + basicNode1.equals(basicNode3));
/* 50 */     System.out.println("n2/n3 " + basicNode2.equals(basicNode3));
/* 51 */     System.out.println("n1 prints as " + basicNode1);
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\BasicNode.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */