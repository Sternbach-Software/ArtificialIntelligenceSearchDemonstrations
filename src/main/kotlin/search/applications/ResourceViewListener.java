/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.Point;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import search.models.MapNet;
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
/*     */ class ResourceViewListener
/*     */   extends MouseAdapter
/*     */ {
/*     */   Resource application;
/*     */   MapNet model;
/*     */   NodeView view;
/*     */   
/*     */   public ResourceViewListener(Resource paramResource) {
/* 126 */     this.application = paramResource;
/* 127 */     this.model = this.application.getModel();
/* 128 */     this.view = (NodeView)this.application.getView();
/*     */   }
/*     */   public void mouseClicked(MouseEvent paramMouseEvent) {
/* 131 */     AffineTransform affineTransform = this.view.getInverseTransform();
/* 132 */     if (affineTransform == null)
/* 133 */       return;  Point point1 = new Point(paramMouseEvent.getX(), paramMouseEvent.getY());
/* 134 */     Point point2 = new Point(paramMouseEvent.getX(), paramMouseEvent.getY());
/* 135 */     affineTransform.transform(point1, point2);
/*     */     
/* 137 */     if (this.application.mode == this.application.SET_START) {
/* 138 */       this.view.clear();
/* 139 */       this.model.getQueue().clear();
/*     */     
/*     */     }
/* 142 */     else if (this.application.mode == this.application.SET_GOAL) {
/* 143 */       this.view.clear();
/* 144 */       this.model.getQueue().clear();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\ResourceViewListener.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */