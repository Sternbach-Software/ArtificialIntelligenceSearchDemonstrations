/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SearchButtonListener
/*     */   implements ActionListener
/*     */ {
/*     */   Search application;
/*     */   StreetNet model;
/*     */   NodeView view;
/*     */   
/*     */   public SearchButtonListener(Search paramSearch) {
/* 202 */     this.application = paramSearch;
/* 203 */     this.model = this.application.getModel();
/* 204 */     this.view = this.application.getView();
/*     */   }
/*     */   public void actionPerformed(ActionEvent paramActionEvent) {
/* 207 */     if (this.application.stopButton.equals(paramActionEvent.getSource())) {
/* 208 */       this.model.quit();
/*     */     }
/* 210 */     else if (this.application.pauseButton.equals(paramActionEvent.getSource())) {
/* 211 */       this.model.pause();
/*     */     }
/* 213 */     else if (this.application.resumeButton.equals(paramActionEvent.getSource())) {
/* 214 */       this.model.go();
/*     */     }
/* 216 */     else if (this.application.startButton.equals(paramActionEvent.getSource())) {
/* 217 */       this.application.mode = this.application.SET_START;
/*     */     }
/* 219 */     else if (this.application.goalButton.equals(paramActionEvent.getSource())) {
/* 220 */       this.application.mode = this.application.SET_GOAL;
/*     */     }
/* 222 */     else if (this.application.searchButton.equals(paramActionEvent.getSource())) {
/* 223 */       this.application.getView().clear();
/* 224 */       this.application.getModel().search();
/* 225 */       this.application.getModel().changed();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\SearchButtonListener.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */