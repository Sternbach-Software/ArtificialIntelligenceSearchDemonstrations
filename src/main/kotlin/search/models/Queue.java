/*    */ package search.models;

import java.util.Vector;

/*    */
/*    */ public class Queue extends Vector {
/*    */   public void addToRear(Vector paramVector) {
/*  5 */     for (short b = 0; b < paramVector.size(); b++) {
/*  6 */       Path path = (Path) paramVector.elementAt(b);
/*  7 */       add(path);
/*    */     } 
/*    */   }
/*    */   public void addToFront(Vector paramVector) {
/* 11 */     for (short b = 0; b < paramVector.size(); b++) {
/* 12 */       Path path = (Path) paramVector.elementAt(b);
/* 13 */       add(b, path);
/*    */     } 
/*    */   }
/*    */   public void set(Vector paramVector) {
/* 17 */     clear();
/* 18 */     addAll(paramVector);
/*    */   }
/*    */   public Vector get() {
/* 21 */     return this;
/*    */   }
/*    */   public void moveToFront(Path paramPath) {
/* 24 */     remove(paramPath);
/* 25 */     add(0, paramPath);
/*    */   }
/*    */   public void reverse() {
/* 28 */     Vector vector = (Vector)clone();
/* 29 */     clear();
/* 30 */     for (short b = 0; b < vector.size(); b++) {
/* 31 */       add(0, vector.elementAt(b));
/*    */     }
/*    */   }
/*    */   
/*    */   public void removeIfEndsAt(Node paramNode) {
/* 36 */     Queue queue = (Queue)clone();
/* 37 */     for (short b = 0; b < queue.size(); b++) {
/* 38 */       Path path = (Path) queue.elementAt(b);
/* 39 */       Node node = (Node) path.lastElement();
/* 40 */       if (paramNode.equals(node))
/*    */       {
/* 42 */         remove(path);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void main(String[] paramArrayOfString) {
/* 48 */     Path path = new Path();
/* 49 */     Node node1 = new Node(0, 0, "S");
/* 50 */     Node node2 = new Node(0, 0, "G");
/* 51 */     path.add(node1);
/* 52 */     path.add(node2);
/* 53 */     Queue queue = new Queue();
/* 54 */     Vector vector = new Vector();
/* 55 */     vector.add(path);
/* 56 */     queue.addToRear(vector);
/* 57 */     queue.addToFront(vector);
/* 58 */     queue.removeIfEndsAt(node2);
/* 59 */     System.out.println(queue);
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\Queue.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */