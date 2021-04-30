/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Polygon;
/*     */ import java.util.Observable;
/*     */ import java.util.Observer;
/*     */ import java.util.Random;
/*     */ import java.util.Vector;
/*     */ import search.models.MapNet;
/*     */ import search.models.Node;
/*     */ import search.models.Path;
/*     */ import search.models.Queue;
/*     */ import search.models.State;
/*     */ import search.views.BlobView;
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
/*     */ class ResourceModelObserver
/*     */   implements Observer
/*     */ {
/*     */   Resource application;
/*     */   MapNet model;
/*     */   BlobView view;
/*     */   
/*     */   public ResourceModelObserver(Resource paramResource) {
/*  77 */     this.application = paramResource;
/*  78 */     this.model = this.application.getModel();
/*  79 */     this.view = this.application.getView();
/*     */   }
/*     */   public void update(Observable paramObservable, Object paramObject) {
/*  82 */     this.view.clear();
/*  83 */     Vector vector = this.model.getNodes();
/*     */     
/*  85 */     Random random = new Random();
/*  86 */     for (short b = 0; b < vector.size(); b++) {
/*  87 */       State state = (State) vector.elementAt(b);
/*  88 */       Vector vector1 = state.getPolygons();
/*  89 */       for (short b1 = 0; b1 < vector1.size(); b1++) {
/*  90 */         this.view.addBlob(state.getName(), state.getResource(), (Polygon) vector1.elementAt(b1));
/*     */       }
/*     */     } 
/*  93 */     Queue queue = this.model.getQueue();
/*  94 */     if (!queue.isEmpty()) {
/*  95 */       Path path = (Path)queue.elementAt(0);
/*  96 */       Node node = (Node)path.elementAt(0);
/*  97 */       for (short b1 = 1; b1 < path.size(); b1++) {
/*  98 */         Node node1 = (Node)path.elementAt(b1);
/*  99 */         int i = node.getX();
/* 100 */         int j = -node.getY();
/* 101 */         int k = node1.getX();
/* 102 */         int m = -node1.getY();
/* 103 */         this.view.addLine(Color.red, i, j, k, m);
/* 104 */         node = node1;
/*     */       } 
/*     */     } 
/* 107 */     this.view.resetMessages();
/* 108 */     this.view.addMessage("Arrangement: " + this.model.getArrangementString());
/* 109 */     this.view.addMessage("Constraint checks: " + this.model.getTypeString());
/* 110 */     this.view.addMessage("Color count: " + this.model.getResourceCount());
/* 111 */     this.view.addMessage("Current assignments: " + this.model.getAssignmentCount());
/* 112 */     this.view.addMessage("Dead ends: " + this.model.getDeadEndCount());
/*     */     
/* 114 */     this.view.addMessage("Constraints checked: " + this.model.getConstraintCheckCount());
/* 115 */     this.view.repaint();
/* 116 */     this.view.invalidate();
/* 117 */     this.application.validate();
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\ResourceModelObserver.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */