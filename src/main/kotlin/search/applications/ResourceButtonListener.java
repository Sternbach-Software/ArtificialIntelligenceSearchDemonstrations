/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import search.models.MapNet;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ResourceButtonListener
/*     */   implements ActionListener
/*     */ {
/*     */   Resource application;
/*     */   MapNet model;
/*     */   BlobView view;
/*     */   
/*     */   public ResourceButtonListener(Resource paramResource) {
/* 155 */     this.application = paramResource;
/* 156 */     this.model = this.application.getModel();
/* 157 */     this.view = this.application.getView();
/*     */   }
/*     */   public void actionPerformed(ActionEvent paramActionEvent) {
/* 160 */     if (this.application.stopButton.equals(paramActionEvent.getSource())) {
/* 161 */       this.model.quit();
/*     */     }
/* 163 */     else if (this.application.pauseButton.equals(paramActionEvent.getSource())) {
/* 164 */       this.model.pause();
/*     */     }
/* 166 */     else if (this.application.resumeButton.equals(paramActionEvent.getSource())) {
/* 167 */       this.model.go();
/*     */     }
/* 169 */     else if (this.application.searchButton.equals(paramActionEvent.getSource())) {
/* 170 */       this.model.quit();
/* 171 */       this.view.clear();
/* 172 */       this.model.search();
/* 173 */       this.model.changed();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\ResourceButtonListener.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */