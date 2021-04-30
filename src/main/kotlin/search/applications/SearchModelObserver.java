/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.Observable;
/*     */ import java.util.Observer;
/*     */ import java.util.Vector;
/*     */ import search.models.Node;
/*     */ import search.models.Path;
/*     */ import search.models.Queue;
/*     */ import search.models.StreetNet;
/*     */ import search.views.NodeView;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SearchModelObserver
/*     */   implements Observer
/*     */ {
/*     */   Search application;
/*     */   StreetNet model;
/*     */   NodeView view;
/*     */   
/*     */   public SearchModelObserver(Search paramSearch) {
/*  95 */     this.application = paramSearch;
/*  96 */     this.model = this.application.getModel();
/*  97 */     this.view = this.application.getView();
/*     */   }
/*     */   
/*     */   public void update(Observable paramObservable, Object paramObject) {
/* 101 */     this.view.clear();
/* 102 */     Vector vector1 = new Vector();
/* 103 */     this.model.getClass(); if (this.model.FILTER != 0) {
/* 104 */       this.model.getClass(); if (this.model.FILTER == 2) { vector1 = this.model.getExtendedNodes(); }
/* 105 */       else { this.model.getClass(); if (this.model.FILTER == 1) vector1 = this.model.getEnqueuedNodes();  } 
/* 106 */     }  Vector vector2 = this.model.getNodes(); short b;
/* 107 */     for (b = 0; b < vector2.size(); b++) {
/* 108 */       Node node = (Node) vector2.elementAt(b);
/* 109 */       int i = node.getX();
/* 110 */       int j = -node.getY();
/* 111 */       String str = node.getName();
/* 112 */       if (str != null) { this.view.addCircle(str, i, j); }
/* 113 */       else { this.view.addCircle(i, j); }
/* 114 */        Vector vector = node.getNeighbors();
/* 115 */       for (short b1 = 0; b1 < vector.size(); b1++) {
/* 116 */         Node node3 = (Node) vector.elementAt(b1);
/* 117 */         int k = node3.getX();
/* 118 */         int m = -node3.getY();
/* 119 */         this.view.addLine(i, j, k, m);
/*     */       } 
/*     */     } 
/* 122 */     for (b = 0; b < vector1.size(); b++) {
/* 123 */       Node node = (Node) vector1.elementAt(b);
/* 124 */       int i = node.getX();
/* 125 */       int j = -node.getY();
/* 126 */       this.view.addColoredCircle(Color.red, i, j);
/*     */     } 
/*     */     
/* 129 */     Queue queue = this.model.getQueue();
/* 130 */     if (!queue.isEmpty()) {
/* 131 */       Path path = (Path)queue.elementAt(0);
/* 132 */       Node node = (Node)path.elementAt(0);
/* 133 */       for (short b1 = 1; b1 < path.size(); b1++) {
/* 134 */         Node node3 = (Node)path.elementAt(b1);
/* 135 */         int i = node.getX();
/* 136 */         int j = -node.getY();
/* 137 */         int k = node3.getX();
/* 138 */         int m = -node3.getY();
/* 139 */         this.view.addLine(Color.red, i, j, k, m);
/* 140 */         node = node3;
/*     */       } 
/*     */     } 
/* 143 */     Node node1 = this.model.getStart();
/* 144 */     Node node2 = this.model.getGoal();
/* 145 */     if (node1 != null) this.view.addCircle("S", node1.getX(), -node1.getY()); 
/* 146 */     if (node2 != null) this.view.addCircle("G", node2.getX(), -node2.getY()); 
/* 147 */     this.view.resetMessages();
/* 148 */     this.view.addMessage("Type: " + this.model.getTypeString());
/* 149 */     this.view.addMessage("Enqueuings: " + this.model.getEnqueuedNodeCount());
/* 150 */     this.view.addMessage("Extensions: " + this.model.getExtendedNodeCount());
/* 151 */     this.view.addMessage("Queue size: " + this.model.getQueueSize());
/* 152 */     this.view.addMessage("Path elements: " + this.model.getCurrentPathElementCount());
/* 153 */     this.view.addMessage("Path length: " + kilometers(this.model.getCurrentPathLength()) + " k");
/* 154 */     this.view.repaint();
/*     */   }
/*     */ 
/*     */   
/*     */   private String kilometers(double paramDouble) {
/* 159 */     String str = "" + (paramDouble / 1000.0D);
/* 160 */     int i = str.indexOf('.');
/* 161 */     if (i >= 0 && i + 2 < str.length()) {
/* 162 */       str = str.substring(0, i + 2);
/*     */     }
/* 164 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\SearchModelObserver.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */