/*    */ package search.models;

import java.util.Vector;

/*    */ public class Node extends BasicNode {
/*    */   int x;
/*    */   
/*  5 */   public Node(int paramInt1, int paramInt2, String paramString) { this(paramInt1, paramInt2); this.name = paramString; } int y; public Node(int paramInt1, int paramInt2) {
/*  6 */     this.x = paramInt1; this.y = paramInt2; }
/*  7 */   public int getX() { return this.x; } public int getY() {
/*  8 */     return this.y;
/*    */   } public boolean equals(Object paramObject) {
/* 10 */     if (!(paramObject instanceof Node)) return false; 
/* 11 */     Node node = (Node)paramObject;
/* 12 */     if (getName() != null) {
/* 13 */       return getName().equals(node.getName());
/*    */     }
/* 15 */     if (getX() == node.getX() && getY() == node.getY()) return true; 
/* 16 */     return false;
/*    */   }
/*    */   public String toString() {
/* 19 */     if (this.name != null) return this.name; 
/* 20 */     String str = "[" + this.x + ", " + this.y + "]";
/* 21 */     if (!this.neighbors.isEmpty()) {
/* 22 */       Vector vector = new Vector();
/* 23 */       Connection connection = (Connection) this.neighbors.elementAt(0);
/* 24 */       str = str + " (intersection of " + connection.name;
/* 25 */       vector.add(connection.name);
/* 26 */       for (short b = 1; b < this.neighbors.size(); b++) {
/* 27 */         connection = (Connection) this.neighbors.elementAt(b);
/* 28 */         String str1 = connection.name;
/* 29 */         if (str1 != null && !vector.contains(str1)) { str = str + ", " + str1; vector.add(str1); }
/*    */       
/* 31 */       }  str = str + ")";
/*    */     } 
/* 33 */     return str;
/*    */   }
/*    */   public static void main(String[] paramArrayOfString) {
/* 36 */     Node node1 = new Node(0, 0);
/* 37 */     Node node2 = new Node(0, 0);
/* 38 */     Node node3 = new Node(0, 1);
/* 39 */     System.out.println("n1/n1 " + node1.equals(node1));
/* 40 */     System.out.println("n1/n2 " + node1.equals(node2));
/* 41 */     System.out.println("n1/n3 " + node1.equals(node3));
/* 42 */     System.out.println("n2/n3 " + node2.equals(node3));
/* 43 */     System.out.println("n1 prints as " + node1);
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\Node.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */