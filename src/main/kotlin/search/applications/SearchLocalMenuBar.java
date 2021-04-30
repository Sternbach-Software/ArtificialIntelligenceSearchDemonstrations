/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import search.models.StreetNet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SearchLocalMenuBar
/*     */   extends JMenuBar
/*     */ {
/*     */   Search application;
/* 235 */   JMenuItem slowItem = new JMenuItem("1 frame/sec");
/* 236 */   JMenuItem mediumItem = new JMenuItem("4 frames/sec");
/* 237 */   JMenuItem mediumFastItem = new JMenuItem("30 frames/sec");
/* 238 */   JMenuItem fastItem = new JMenuItem("No delay");
/*     */   
/* 240 */   JMenuItem noFilterItem = new JMenuItem("None");
/* 241 */   JMenuItem enqueuedItem = new JMenuItem("Use enqueued list");
/* 242 */   JMenuItem extendedItem = new JMenuItem("Use extended list");
/*     */   
/* 244 */   JMenuItem aboutItem = new JMenuItem("About");
/*     */   
/* 246 */   JMenuItem depthItem = new JMenuItem("Depth first");
/* 247 */   JMenuItem breadthItem = new JMenuItem("Breadth first");
/* 248 */   JMenuItem hillItem = new JMenuItem("Hill climbing");
/* 249 */   JMenuItem beamItem = new JMenuItem("Beam (width 5, no backup)");
/* 250 */   JMenuItem bestItem = new JMenuItem("Best first");
/* 251 */   JMenuItem bBItem = new JMenuItem("Branch and bound");
/* 252 */   JMenuItem bBLItem = new JMenuItem("Branch and bound with extended list");
/* 253 */   JMenuItem bBHItem = new JMenuItem("Branch and bound with admissible heuristic");
/* 254 */   JMenuItem aStarItem = new JMenuItem("A* (Branch and bound with extended list and admissible heuristic)");
/*     */   
/* 256 */   JMenuItem newYork = new JMenuItem("Thief");
/* 257 */   JMenuItem boston = new JMenuItem("Beginner");
/* 258 */   JMenuItem mit = new JMenuItem("Expert");
/*     */   
/* 260 */   JMenu filter = new JMenu("Filter");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SearchLocalMenuBar(Search paramSearch) {
/* 266 */     this.application = paramSearch;
/*     */     
/* 268 */     LocalActionListener localActionListener = new LocalActionListener(this.application);
/*     */     
/*     */     JMenu jMenu;
/* 271 */     add(jMenu = new JMenu("Type"));
/* 272 */     this.depthItem.addActionListener(localActionListener); jMenu.add(this.depthItem);
/* 273 */     this.breadthItem.addActionListener(localActionListener); jMenu.add(this.breadthItem);
/* 274 */     this.hillItem.addActionListener(localActionListener); jMenu.add(this.hillItem);
/*     */ 
/*     */     
/* 277 */     this.bestItem.addActionListener(localActionListener); jMenu.add(this.bestItem);
/* 278 */     this.bBItem.addActionListener(localActionListener); jMenu.add(this.bBItem);
/* 279 */     this.bBHItem.addActionListener(localActionListener); jMenu.add(this.bBHItem);
/* 280 */     this.bBLItem.addActionListener(localActionListener); jMenu.add(this.bBLItem);
/* 281 */     this.aStarItem.addActionListener(localActionListener); jMenu.add(this.aStarItem);
/*     */ 
/*     */     
/* 284 */     add(jMenu = new JMenu("Speed"));
/* 285 */     jMenu.add(this.slowItem); this.slowItem.addActionListener(localActionListener);
/* 286 */     jMenu.add(this.mediumItem); this.mediumItem.addActionListener(localActionListener);
/* 287 */     jMenu.add(this.mediumFastItem); this.mediumFastItem.addActionListener(localActionListener);
/* 288 */     jMenu.add(this.fastItem); this.fastItem.addActionListener(localActionListener);
/*     */ 
/*     */     
/* 291 */     add(this.filter);
/* 292 */     this.filter.add(this.noFilterItem); this.noFilterItem.addActionListener(localActionListener);
/* 293 */     this.filter.add(this.enqueuedItem); this.enqueuedItem.addActionListener(localActionListener);
/*     */ 
/*     */ 
/*     */     
/* 297 */     add(jMenu = new JMenu("Driver"));
/* 298 */     this.newYork.addActionListener(localActionListener); jMenu.add(this.newYork);
/* 299 */     this.boston.addActionListener(localActionListener); jMenu.add(this.boston);
/* 300 */     this.mit.addActionListener(localActionListener); jMenu.add(this.mit);
/*     */ 
/*     */     
/* 303 */     add(jMenu = new JMenu("Help"));
/*     */     
/* 305 */     jMenu.add(this.aboutItem); this.aboutItem.addActionListener(localActionListener);
/*     */   }
/*     */   
/*     */   class LocalActionListener implements ActionListener {
/*     */     Search application;
/*     */     StreetNet model;
/*     */
/*     */     
/*     */     public LocalActionListener(Search param1Search) {
/* 314 */       this.application = param1Search;
/* 315 */       this.model = this.application.getModel();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void actionPerformed(ActionEvent param1ActionEvent) {
/* 321 */       SearchLocalMenuBar.this.filter.setEnabled(true);
/* 322 */       Object object = param1ActionEvent.getSource();
/*     */       
/* 324 */       if (object == SearchLocalMenuBar.this.slowItem) { this.application.getModel().setFrameRate(1); }
/* 325 */       else if (object == SearchLocalMenuBar.this.mediumItem) { this.application.getModel().setFrameRate(4); }
/* 326 */       else if (object == SearchLocalMenuBar.this.mediumFastItem) { this.application.getModel().setFrameRate(30); }
/* 327 */       else if (object == SearchLocalMenuBar.this.fastItem) { this.application.getModel().setFrameRate(1000); }
/*     */       
/* 329 */       else if (object == SearchLocalMenuBar.this.noFilterItem) { this.application.getModel().getClass(); this.application.getModel().setFilter(0); this.model.quit(); this.model.clear(); }
/* 330 */       else if (object == SearchLocalMenuBar.this.enqueuedItem) { this.application.getModel().getClass(); this.application.getModel().setFilter(1); this.model.quit(); this.model.clear(); }
/* 331 */       else if (object == SearchLocalMenuBar.this.extendedItem) { this.application.getModel().getClass(); this.application.getModel().setFilter(2); this.model.quit(); this.model.clear(); }
/*     */       
/* 333 */       else if (object == SearchLocalMenuBar.this.depthItem || object == SearchLocalMenuBar.this.newYork)
/* 334 */       { this.application.getModel().getClass(); this.application.getModel().setFilter(0);
/* 335 */         this.application.getModel().getClass(); this.application.getModel().setType(0);
/* 336 */         this.model.quit(); this.model.clear(); }
/*     */       
/* 338 */       else if (object == SearchLocalMenuBar.this.breadthItem) { this.application.getModel().getClass(); this.application.getModel().setType(1); this.model.quit(); this.model.clear(); }
/* 339 */       else if (object == SearchLocalMenuBar.this.hillItem || object == SearchLocalMenuBar.this.boston) { this.application.getModel().getClass(); this.application.getModel().setType(2); this.model.quit(); this.model.clear(); }
/* 340 */       else if (object == SearchLocalMenuBar.this.beamItem) { this.application.getModel().getClass(); this.application.getModel().setType(3); this.model.quit(); this.model.clear(); }
/* 341 */       else if (object == SearchLocalMenuBar.this.bestItem) { this.application.getModel().getClass(); this.application.getModel().setType(4); this.model.quit(); this.model.clear(); }
/* 342 */       else if (object == SearchLocalMenuBar.this.bBItem)
/* 343 */       { this.application.getModel().getClass(); this.application.getModel().setType(5);
/* 344 */         this.application.getModel().getClass(); this.application.getModel().setFilter(0);
/* 345 */         this.model.quit(); this.model.clear();
/* 346 */         SearchLocalMenuBar.this.filter.setEnabled(false);
/*     */          }
/*     */       
/* 349 */       else if (object == SearchLocalMenuBar.this.bBLItem)
/* 350 */       { this.application.getModel().getClass(); this.application.getModel().setType(5);
/* 351 */         this.application.getModel().getClass(); this.application.getModel().setFilter(2);
/* 352 */         this.model.quit(); this.model.clear();
/* 353 */         SearchLocalMenuBar.this.filter.setEnabled(false);
/*     */          }
/*     */       
/* 356 */       else if (object == SearchLocalMenuBar.this.bBHItem)
/* 357 */       { this.application.getModel().getClass(); this.application.getModel().setType(7);
/* 358 */         this.application.getModel().getClass(); this.application.getModel().setFilter(0);
/* 359 */         this.model.quit(); this.model.clear();
/* 360 */         SearchLocalMenuBar.this.filter.setEnabled(false);
/*     */          }
/*     */       
/* 363 */       else if (object == SearchLocalMenuBar.this.aStarItem || object == SearchLocalMenuBar.this.mit)
/* 364 */       { this.application.getModel().getClass(); this.application.getModel().setFilter(2);
/* 365 */         this.application.getModel().getClass(); this.application.getModel().setType(8);
/* 366 */         this.model.quit(); this.model.clear();
/* 367 */         SearchLocalMenuBar.this.filter.setEnabled(false); }
/*     */       
/* 369 */       else if (object == SearchLocalMenuBar.this.aboutItem)
/* 370 */       { JOptionPane.showMessageDialog(this.application, "Search " + this.application.VERSION + "\nImplemented by Patrick Winston"); }
/*     */ 
/*     */       
/* 373 */       this.application.getModel().changed();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\SearchLocalMenuBar.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */