/*    */ package search.models;
/*    */ 
/*    */ import java.util.Observable;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class BasicNet extends Observable {
/*  7 */   Vector nodes = new Vector();
/*    */   
/*    */   public void addNode(BasicNode paramBasicNode) {
/* 10 */     if (this.nodes.contains(paramBasicNode))
/* 11 */       return;  this.nodes.add(paramBasicNode);
/*    */   } public Vector getNodes() {
/* 13 */     return this.nodes;
/*    */   } public void setNodes(Vector paramVector) {
/* 15 */     this.nodes = new Vector();
/* 16 */     for (short b = 0; b < paramVector.size(); b++) {
/* 17 */       this.nodes.add(paramVector.elementAt(b));
/*    */     }
/* 19 */     changed();
/*    */   }
/*    */   public void connect(BasicNode paramBasicNode1, BasicNode paramBasicNode2) {
/* 22 */     BasicNode basicNode1 = getNode(paramBasicNode1);
/* 23 */     BasicNode basicNode2 = getNode(paramBasicNode2);
/* 24 */     basicNode1.addNeighbor(basicNode2);
/*    */ 
/*    */     
/* 27 */     basicNode2.addNeighbor(basicNode1);
/*    */   }
/*    */   
/*    */   public void connect(BasicNode paramBasicNode1, BasicNode paramBasicNode2, String paramString) {
/* 31 */     BasicNode basicNode1 = getNode(paramBasicNode1);
/* 32 */     BasicNode basicNode2 = getNode(paramBasicNode2);
/* 33 */     basicNode1.addNeighbor(basicNode2, paramString);
/*    */ 
/*    */     
/* 36 */     basicNode2.addNeighbor(basicNode1, paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized void changed() {
/* 44 */     setChanged();
/* 45 */     notifyObservers();
/*    */   }
/*    */   
/*    */   private BasicNode getNode(BasicNode paramBasicNode) {
/* 49 */     if (this.nodes.contains(paramBasicNode)) {
/* 50 */       int i = this.nodes.indexOf(paramBasicNode);
/* 51 */       return (BasicNode) this.nodes.elementAt(i);
/*    */     } 
/* 53 */     addNode(paramBasicNode);
/* 54 */     return paramBasicNode;
/*    */   }
/*    */   
/*    */   public static void main(String[] paramArrayOfString) {
/* 58 */     Node node1 = new Node(0, 0, "Foo");
/* 59 */     Node node2 = new Node(0, 50, "Bar");
/* 60 */     Node node3 = new Node(50, 50, "Baz");
/* 61 */     BasicNet basicNet = new BasicNet();
/* 62 */     basicNet.connect(node1, node2);
/* 63 */     basicNet.connect(node2, node3);
/* 64 */     basicNet.addNode(node1);
/* 65 */     basicNet.addNode(node2);
/* 66 */     basicNet.addNode(node3);
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\BasicNet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */