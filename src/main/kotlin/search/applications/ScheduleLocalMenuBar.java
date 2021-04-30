/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import search.models.Trip;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ScheduleLocalMenuBar
/*     */   extends JMenuBar
/*     */ {
/*     */   Schedule application;
/*     */   TripNet model;
/*     */   ScheduleView view;
/* 198 */   JMenuItem usaItem = new JMenuItem("Elementary job example");
/* 199 */   JMenuItem simpliciaItem = new JMenuItem("Harder job example");
/* 200 */   JMenuItem randomItem = new JMenuItem("Random job example");
/* 201 */   JMenuItem elementaryFlightItem = new JMenuItem("Elementary flight example");
/* 202 */   JMenuItem randomFlightItem = new JMenuItem("Random flight example");
/*     */ 
/*     */   
/* 205 */   JMenuItem slowItem = new JMenuItem("1 frame/sec");
/* 206 */   JMenuItem mediumItem = new JMenuItem("4 frames/sec");
/* 207 */   JMenuItem mediumFastItem = new JMenuItem("30 frames/sec");
/* 208 */   JMenuItem fastItem = new JMenuItem("No delay");
/*     */   
/* 210 */   JMenuItem oneItem = new JMenuItem("1");
/* 211 */   JMenuItem twoItem = new JMenuItem("2");
/* 212 */   JMenuItem threeItem = new JMenuItem("3");
/* 213 */   JMenuItem fourItem = new JMenuItem("4");
/* 214 */   JMenuItem fiveItem = new JMenuItem("5");
/* 215 */   JMenuItem sixItem = new JMenuItem("6");
/* 216 */   JMenuItem sevenItem = new JMenuItem("7");
/* 217 */   JMenuItem eightItem = new JMenuItem("8");
/* 218 */   JMenuItem nineItem = new JMenuItem("9");
/* 219 */   JMenuItem tenItem = new JMenuItem("10");
/*     */   
/* 221 */   JMenuItem aboutItem = new JMenuItem("About");
/*     */   
/* 223 */   JMenuItem noCheckItem = new JMenuItem("No checks");
/* 224 */   JMenuItem assignmentsOnlyItem = new JMenuItem("Assignments only");
/* 225 */   JMenuItem checkNeighborsItem = new JMenuItem("Check neighbors only");
/* 226 */   JMenuItem propagateIfOneItem = new JMenuItem("Propage through domains reduced to one value");
/* 227 */   JMenuItem propagageIfReducedItem = new JMenuItem("Propage through reduced domains");
/* 228 */   JMenuItem checkAllItem = new JMenuItem("Check everthing each time");
/*     */   
/* 230 */   JMenuItem alphabeticalItem = new JMenuItem("Alphabetical");
/* 231 */   JMenuItem mostConstrainedFirstItem = new JMenuItem("Most constrained first");
/* 232 */   JMenuItem leastConstrainedFirstItem = new JMenuItem("Least constrained first");
/* 233 */   JMenuItem badNewsItem = new JMenuItem("Ugh!");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ScheduleLocalMenuBar(Schedule paramSchedule) {
/* 239 */     this.application = paramSchedule;
/* 240 */     this.model = this.application.getModel();
/* 241 */     this.view = this.application.getView();
/*     */     
/* 243 */     LocalActionListener localActionListener = new LocalActionListener(this.application);
/*     */     
/*     */     JMenu jMenu;
/* 246 */     add(jMenu = new JMenu("Problem"));
/* 247 */     this.usaItem.addActionListener(localActionListener); jMenu.add(this.usaItem);
/* 248 */     this.simpliciaItem.addActionListener(localActionListener); jMenu.add(this.simpliciaItem);
/* 249 */     this.randomItem.addActionListener(localActionListener); jMenu.add(this.randomItem);
/* 250 */     this.elementaryFlightItem.addActionListener(localActionListener); jMenu.add(this.elementaryFlightItem);
/* 251 */     this.randomFlightItem.addActionListener(localActionListener); jMenu.add(this.randomFlightItem);
/*     */ 
/*     */     
/* 254 */     add(jMenu = new JMenu("Type"));
/* 255 */     this.noCheckItem.addActionListener(localActionListener); jMenu.add(this.noCheckItem);
/* 256 */     this.assignmentsOnlyItem.addActionListener(localActionListener); jMenu.add(this.assignmentsOnlyItem);
/* 257 */     this.checkNeighborsItem.addActionListener(localActionListener); jMenu.add(this.checkNeighborsItem);
/* 258 */     this.propagateIfOneItem.addActionListener(localActionListener); jMenu.add(this.propagateIfOneItem);
/* 259 */     this.propagageIfReducedItem.addActionListener(localActionListener); jMenu.add(this.propagageIfReducedItem);
/*     */ 
/*     */ 
/*     */     
/* 263 */     add(jMenu = new JMenu("Arrangement"));
/* 264 */     this.alphabeticalItem.addActionListener(localActionListener); jMenu.add(this.alphabeticalItem);
/* 265 */     this.mostConstrainedFirstItem.addActionListener(localActionListener); jMenu.add(this.mostConstrainedFirstItem);
/* 266 */     this.leastConstrainedFirstItem.addActionListener(localActionListener); jMenu.add(this.leastConstrainedFirstItem);
/*     */ 
/*     */ 
/*     */     
/* 270 */     add(jMenu = new JMenu("Resources"));
/* 271 */     jMenu.add(this.oneItem); this.oneItem.addActionListener(localActionListener);
/* 272 */     jMenu.add(this.twoItem); this.twoItem.addActionListener(localActionListener);
/* 273 */     jMenu.add(this.threeItem); this.threeItem.addActionListener(localActionListener);
/* 274 */     jMenu.add(this.fourItem); this.fourItem.addActionListener(localActionListener);
/* 275 */     jMenu.add(this.fiveItem); this.fiveItem.addActionListener(localActionListener);
/* 276 */     jMenu.add(this.sixItem); this.sixItem.addActionListener(localActionListener);
/* 277 */     jMenu.add(this.sevenItem); this.sevenItem.addActionListener(localActionListener);
/* 278 */     jMenu.add(this.eightItem); this.eightItem.addActionListener(localActionListener);
/* 279 */     jMenu.add(this.nineItem); this.nineItem.addActionListener(localActionListener);
/* 280 */     jMenu.add(this.tenItem); this.tenItem.addActionListener(localActionListener);
/*     */ 
/*     */     
/* 283 */     add(jMenu = new JMenu("Speed"));
/* 284 */     jMenu.add(this.slowItem); this.slowItem.addActionListener(localActionListener);
/* 285 */     jMenu.add(this.mediumItem); this.mediumItem.addActionListener(localActionListener);
/* 286 */     jMenu.add(this.mediumFastItem); this.mediumFastItem.addActionListener(localActionListener);
/* 287 */     jMenu.add(this.fastItem); this.fastItem.addActionListener(localActionListener);
/*     */ 
/*     */     
/* 290 */     add(jMenu = new JMenu("Help"));
/*     */     
/* 292 */     jMenu.add(this.aboutItem); this.aboutItem.addActionListener(localActionListener);
/*     */   }
/*     */   
/*     */   class LocalActionListener implements ActionListener {
/*     */     Schedule application;
/*     */
/*     */     
/*     */     public LocalActionListener(Schedule param1Schedule) {
/* 300 */       this.application = param1Schedule;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void actionPerformed(ActionEvent param1ActionEvent) {
/* 306 */       Object object = param1ActionEvent.getSource();
/*     */       
/* 308 */       if (object == ScheduleLocalMenuBar.this.slowItem) { ScheduleLocalMenuBar.this.model.setFrameRate(1); }
/* 309 */       else if (object == ScheduleLocalMenuBar.this.mediumItem) { ScheduleLocalMenuBar.this.model.setFrameRate(4); }
/* 310 */       else if (object == ScheduleLocalMenuBar.this.mediumFastItem) { ScheduleLocalMenuBar.this.model.setFrameRate(30); }
/* 311 */       else if (object == ScheduleLocalMenuBar.this.fastItem) { ScheduleLocalMenuBar.this.model.setFrameRate(1000); }
/*     */       
/* 313 */       else if (object == ScheduleLocalMenuBar.this.alphabeticalItem) { ScheduleLocalMenuBar.this.model.getClass(); ScheduleLocalMenuBar.this.model.setArrangement(0); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 314 */       else if (object == ScheduleLocalMenuBar.this.mostConstrainedFirstItem) { ScheduleLocalMenuBar.this.model.getClass(); ScheduleLocalMenuBar.this.model.setArrangement(1); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 315 */       else if (object == ScheduleLocalMenuBar.this.leastConstrainedFirstItem) { ScheduleLocalMenuBar.this.model.getClass(); ScheduleLocalMenuBar.this.model.setArrangement(2); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 316 */       else if (object == ScheduleLocalMenuBar.this.badNewsItem) { ScheduleLocalMenuBar.this.model.getClass(); ScheduleLocalMenuBar.this.model.setArrangement(3); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/*     */       
/* 318 */       else if (object == ScheduleLocalMenuBar.this.oneItem) { ScheduleLocalMenuBar.this.model.setResourceCount(1); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 319 */       else if (object == ScheduleLocalMenuBar.this.twoItem) { ScheduleLocalMenuBar.this.model.setResourceCount(2); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 320 */       else if (object == ScheduleLocalMenuBar.this.threeItem) { ScheduleLocalMenuBar.this.model.setResourceCount(3); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 321 */       else if (object == ScheduleLocalMenuBar.this.fourItem) { ScheduleLocalMenuBar.this.model.setResourceCount(4); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 322 */       else if (object == ScheduleLocalMenuBar.this.fiveItem) { ScheduleLocalMenuBar.this.model.setResourceCount(5); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 323 */       else if (object == ScheduleLocalMenuBar.this.sixItem) { ScheduleLocalMenuBar.this.model.setResourceCount(6); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 324 */       else if (object == ScheduleLocalMenuBar.this.sevenItem) { ScheduleLocalMenuBar.this.model.setResourceCount(7); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 325 */       else if (object == ScheduleLocalMenuBar.this.eightItem) { ScheduleLocalMenuBar.this.model.setResourceCount(8); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 326 */       else if (object == ScheduleLocalMenuBar.this.nineItem) { ScheduleLocalMenuBar.this.model.setResourceCount(9); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/* 327 */       else if (object == ScheduleLocalMenuBar.this.tenItem) { ScheduleLocalMenuBar.this.model.setResourceCount(10); ScheduleLocalMenuBar.this.model.quit(); ScheduleLocalMenuBar.this.model.clear(); }
/*     */       
/* 329 */       else if (object == ScheduleLocalMenuBar.this.noCheckItem) { ScheduleLocalMenuBar.this.model.getClass(); ScheduleLocalMenuBar.this.model.setType(-1); }
/* 330 */       else if (object == ScheduleLocalMenuBar.this.assignmentsOnlyItem) { ScheduleLocalMenuBar.this.model.getClass(); ScheduleLocalMenuBar.this.model.setType(0); }
/* 331 */       else if (object == ScheduleLocalMenuBar.this.checkNeighborsItem) { ScheduleLocalMenuBar.this.model.getClass(); ScheduleLocalMenuBar.this.model.setType(1); }
/* 332 */       else if (object == ScheduleLocalMenuBar.this.propagateIfOneItem) { ScheduleLocalMenuBar.this.model.getClass(); ScheduleLocalMenuBar.this.model.setType(3); }
/* 333 */       else if (object == ScheduleLocalMenuBar.this.propagageIfReducedItem) { ScheduleLocalMenuBar.this.model.getClass(); ScheduleLocalMenuBar.this.model.setType(2); }
/* 334 */       else if (object == ScheduleLocalMenuBar.this.checkAllItem) { ScheduleLocalMenuBar.this.model.getClass(); ScheduleLocalMenuBar.this.model.setType(5); }
/*     */       
/* 336 */       else if (object == ScheduleLocalMenuBar.this.usaItem)
/* 337 */       { ScheduleLocalMenuBar.this.model.quit();
/* 338 */         ScheduleLocalMenuBar.this.model.constructSimpleTestSet();
/* 339 */         ScheduleLocalMenuBar.this.view.clear();
/* 340 */         ScheduleLocalMenuBar.this.model.changed(); }
/*     */       
/* 342 */       else if (object == ScheduleLocalMenuBar.this.randomItem)
/* 343 */       { ScheduleLocalMenuBar.this.model.quit();
/* 344 */         ScheduleLocalMenuBar.this.model.constructRandomTestSet();
/* 345 */         ScheduleLocalMenuBar.this.view.clear();
/* 346 */         ScheduleLocalMenuBar.this.model.changed(); }
/*     */       
/* 348 */       else if (object == ScheduleLocalMenuBar.this.simpliciaItem)
/* 349 */       { ScheduleLocalMenuBar.this.model.quit();
/* 350 */         ScheduleLocalMenuBar.this.model.constructHardTestSet();
/* 351 */         ScheduleLocalMenuBar.this.view.clear();
/* 352 */         ScheduleLocalMenuBar.this.model.changed(); }
/*     */       
/* 354 */       else if (object == ScheduleLocalMenuBar.this.elementaryFlightItem)
/* 355 */       { ScheduleLocalMenuBar.this.model.quit();
/* 356 */         ScheduleLocalMenuBar.this.model.constructElementaryFlightTestSet();
/* 357 */         ScheduleLocalMenuBar.this.view.clear();
/* 358 */         ScheduleLocalMenuBar.this.model.changed(); }
/*     */       
/* 360 */       else if (object == ScheduleLocalMenuBar.this.randomFlightItem)
/* 361 */       { ScheduleLocalMenuBar.this.model.quit();
/* 362 */         Trip.resetTripNumber();
/* 363 */         ScheduleLocalMenuBar.this.model.constructRandomFlightTestSet();
/* 364 */         ScheduleLocalMenuBar.this.view.clear();
/* 365 */         ScheduleLocalMenuBar.this.model.changed();
/*     */          }
/*     */       
/* 368 */       else if (object == ScheduleLocalMenuBar.this.aboutItem)
/* 369 */       { JOptionPane.showMessageDialog(this.application, "Version " + this.application.VERSION + "\nImplemented by Patrick Winston"); }
/*     */ 
/*     */       
/* 372 */       ScheduleLocalMenuBar.this.model.changed();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\ScheduleLocalMenuBar.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */