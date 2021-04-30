/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ScheduleButtonListener
/*     */   implements ActionListener
/*     */ {
/*     */   Schedule application;
/*     */   TripNet model;
/*     */   ScheduleView view;
/*     */   
/*     */   public ScheduleButtonListener(Schedule paramSchedule) {
/* 165 */     this.application = paramSchedule;
/* 166 */     this.model = this.application.getModel();
/* 167 */     this.view = this.application.getView();
/*     */   }
/*     */   public void actionPerformed(ActionEvent paramActionEvent) {
/* 170 */     if (this.application.stopButton.equals(paramActionEvent.getSource())) {
/* 171 */       this.model.quit();
/*     */     }
/* 173 */     else if (this.application.pauseButton.equals(paramActionEvent.getSource())) {
/* 174 */       this.model.pause();
/*     */     }
/* 176 */     else if (this.application.resumeButton.equals(paramActionEvent.getSource())) {
/* 177 */       this.model.go();
/*     */     }
/* 179 */     else if (this.application.searchButton.equals(paramActionEvent.getSource())) {
/* 180 */       this.model.quit();
/* 181 */       this.view.clear();
/* 182 */       this.model.search();
/* 183 */       this.model.changed();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\ScheduleButtonListener.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */