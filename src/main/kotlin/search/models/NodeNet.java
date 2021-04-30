/*    */ package search.models;
/*    */ 
/*    */ 
/*    */ public abstract class NodeNet
/*    */   extends SearchableNet
/*    */ {
/*    */   public Node getClosest(int paramInt1, int paramInt2) {
/*  8 */     if (this.nodes.isEmpty()) return null; 
/*  9 */     Node node = (Node) this.nodes.elementAt(0);
/* 10 */     int i = paramInt1 - node.getX();
/* 11 */     int j = paramInt2 - node.getY();
/* 12 */     int k = i * i + j * j;
/* 13 */     for (short b = 1; b < this.nodes.size(); b++) {
/* 14 */       Node node1 = (Node) this.nodes.elementAt(b);
/* 15 */       i = paramInt1 - node1.getX();
/* 16 */       j = paramInt2 - node1.getY();
/* 17 */       int m = i * i + j * j;
/* 18 */       if (m < k) { k = m; node = node1; }
/*    */     
/* 20 */     }  return node;
/*    */   }
/*    */   private Node getNode(Node paramNode) {
/* 23 */     if (this.nodes.contains(paramNode)) {
/* 24 */       int i = this.nodes.indexOf(paramNode);
/* 25 */       return (Node) this.nodes.elementAt(i);
/*    */     } 
/* 27 */     addNode(paramNode);
/* 28 */     return paramNode;
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\NodeNet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */