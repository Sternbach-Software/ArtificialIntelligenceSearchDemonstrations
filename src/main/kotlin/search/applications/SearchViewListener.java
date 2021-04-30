/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.Point;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import search.models.Node;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SearchViewListener
/*     */   extends MouseAdapter
/*     */ {
/*     */   Search application;
/*     */   StreetNet model;
/*     */   NodeView view;
/*     */   
/*     */   public SearchViewListener(Search paramSearch) {
/* 173 */     this.application = paramSearch;
/* 174 */     this.model = this.application.getModel();
/* 175 */     this.view = this.application.getView();
/*     */   }
/*     */   public void mouseClicked(MouseEvent paramMouseEvent) {
/* 178 */     AffineTransform affineTransform = this.view.getInverseTransform();
/* 179 */     if (affineTransform == null)
/* 180 */       return;  Point point1 = new Point(paramMouseEvent.getX(), paramMouseEvent.getY());
/* 181 */     Point point2 = new Point(paramMouseEvent.getX(), paramMouseEvent.getY());
/* 182 */     affineTransform.transform(point1, point2);
/* 183 */     Node node = this.model.getClosest((int)point2.getX(), -((int)point2.getY()));
/* 184 */     if (this.application.mode == this.application.SET_START) {
/* 185 */       this.view.clear();
/* 186 */       this.model.getQueue().clear();
/* 187 */       this.model.setStart(node);
/*     */     }
/* 189 */     else if (this.application.mode == this.application.SET_GOAL) {
/* 190 */       this.view.clear();
/* 191 */       this.model.getQueue().clear();
/* 192 */       this.model.setGoal(node);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\SearchViewListener.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */