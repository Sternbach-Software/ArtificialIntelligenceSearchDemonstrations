/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.Observable;
/*     */ import java.util.Observer;
/*     */ import java.util.Random;
/*     */ import java.util.Vector;
/*     */ import search.models.Job;
/*     */ import search.models.Node;
/*     */ import search.models.Path;
/*     */ import search.models.Queue;
/*     */ import search.models.TripNet;
/*     */ import search.views.ScheduleView;
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
/*     */ class ScheduleModelObserver
/*     */   implements Observer
/*     */ {
/*     */   Schedule application;
/*     */   TripNet model;
/*     */   ScheduleView view;
/*     */   
/*     */   public ScheduleModelObserver(Schedule paramSchedule) {
/*  89 */     this.application = paramSchedule;
/*  90 */     this.model = this.application.getModel();
/*  91 */     this.view = this.application.getView();
/*     */   }
/*     */   public void update(Observable paramObservable, Object paramObject) {
/*  94 */     this.view.clear();
/*  95 */     Vector vector = this.model.getNodes();
/*     */     
/*  97 */     Random random = new Random();
/*  98 */     for (short b = 0; b < vector.size(); b++) {
/*  99 */       Job job = (Job) vector.elementAt(b);
/* 100 */       Schedule.fine("start/duration = " + job.getStart() + "/" + job.getDuration());
/* 101 */       this.view.addBlob(job.getName(), job.getResource(), job.getStart(), job.getDuration());
/*     */     } 
/* 103 */     Queue queue = this.model.getQueue();
/* 104 */     if (!queue.isEmpty()) {
/* 105 */       Path path = (Path)queue.elementAt(0);
/* 106 */       Node node = (Node)path.elementAt(0);
/* 107 */       for (short b1 = 1; b1 < path.size(); b1++) {
/* 108 */         Node node1 = (Node)path.elementAt(b1);
/* 109 */         int i = node.getX();
/* 110 */         int j = -node.getY();
/* 111 */         int k = node1.getX();
/* 112 */         int m = -node1.getY();
/* 113 */         this.view.addLine(Color.red, i, j, k, m);
/* 114 */         node = node1;
/*     */       } 
/*     */     } 
/* 117 */     this.view.resetMessages();
/* 118 */     this.view.addMessage("Arrangement: " + this.model.getArrangementString());
/* 119 */     this.view.addMessage("Constraint checks: " + this.model.getTypeString());
/* 120 */     this.view.addMessage("Resources: " + this.model.getResourceCount());
/* 121 */     this.view.addMessage("Current assignments: " + this.model.getAssignmentCount());
/* 122 */     this.view.addMessage("Dead ends: " + this.model.getDeadEndCount());
/*     */     
/* 124 */     this.view.addMessage("Constraints checked: " + this.model.getConstraintCheckCount());
/* 125 */     this.view.repaint();
/* 126 */     this.view.invalidate();
/* 127 */     this.application.validate();
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\ScheduleModelObserver.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */