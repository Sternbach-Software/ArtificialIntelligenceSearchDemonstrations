/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.Point;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import search.models.TripNet;
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
/*     */ class ScheduleViewListener
/*     */   extends MouseAdapter
/*     */ {
/*     */   Schedule application;
/*     */   TripNet model;
/*     */   NodeView view;
/*     */   
/*     */   public ScheduleViewListener(Schedule paramSchedule) {
/* 136 */     this.application = paramSchedule;
/* 137 */     this.model = this.application.getModel();
/* 138 */     this.view = (NodeView)this.application.getView();
/*     */   }
/*     */   public void mouseClicked(MouseEvent paramMouseEvent) {
/* 141 */     AffineTransform affineTransform = this.view.getInverseTransform();
/* 142 */     if (affineTransform == null)
/* 143 */       return;  Point point1 = new Point(paramMouseEvent.getX(), paramMouseEvent.getY());
/* 144 */     Point point2 = new Point(paramMouseEvent.getX(), paramMouseEvent.getY());
/* 145 */     affineTransform.transform(point1, point2);
/*     */     
/* 147 */     if (this.application.mode == this.application.SET_START) {
/* 148 */       this.view.clear();
/* 149 */       this.model.getQueue().clear();
/*     */     
/*     */     }
/* 152 */     else if (this.application.mode == this.application.SET_GOAL) {
/* 153 */       this.view.clear();
/* 154 */       this.model.getQueue().clear();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\ScheduleViewListener.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */