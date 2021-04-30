/*     */ package search.applications;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ResourceLocalMenuBar
/*     */   extends JMenuBar
/*     */ {
/*     */   Resource application;
/*     */   MapNet model;
/*     */   BlobView view;
/* 188 */   JMenuItem usaItem = new JMenuItem("USA");
/* 189 */   JMenuItem simpliciaItem = new JMenuItem("Simplicia");
/*     */   
/* 191 */   JMenuItem slowItem = new JMenuItem("1 frame/sec");
/* 192 */   JMenuItem mediumItem = new JMenuItem("4 frames/sec");
/* 193 */   JMenuItem mediumFastItem = new JMenuItem("30 frames/sec");
/* 194 */   JMenuItem fastItem = new JMenuItem("No delay");
/*     */   
/* 196 */   JMenuItem threeItem = new JMenuItem("3");
/* 197 */   JMenuItem fourItem = new JMenuItem("4");
/* 198 */   JMenuItem fiveItem = new JMenuItem("5");
/* 199 */   JMenuItem sixItem = new JMenuItem("6");
/* 200 */   JMenuItem sevenItem = new JMenuItem("7");
/*     */   
/* 202 */   JMenuItem aboutItem = new JMenuItem("About");
/*     */   
/* 204 */   JMenuItem noCheckItem = new JMenuItem("No checks");
/* 205 */   JMenuItem assignmentsOnlyItem = new JMenuItem("Assignments only");
/* 206 */   JMenuItem checkNeighborsItem = new JMenuItem("Check neighbors only");
/* 207 */   JMenuItem propagateIfOneItem = new JMenuItem("Propage through domains reduced to one value");
/* 208 */   JMenuItem propagageIfReducedItem = new JMenuItem("Propage through reduced domains");
/* 209 */   JMenuItem checkAllItem = new JMenuItem("Check everthing each time");
/*     */   
/* 211 */   JMenuItem alphabeticalItem = new JMenuItem("Alphabetical");
/* 212 */   JMenuItem mostConstrainedFirstItem = new JMenuItem("Most constrained first");
/* 213 */   JMenuItem leastConstrainedFirstItem = new JMenuItem("Least constrained first");
/* 214 */   JMenuItem badNewsItem = new JMenuItem("Ugh!");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceLocalMenuBar(Resource paramResource) {
/* 220 */     this.application = paramResource;
/* 221 */     this.model = this.application.getModel();
/* 222 */     this.view = this.application.getView();
/*     */     
/* 224 */     LocalActionListener localActionListener = new LocalActionListener(this.application);
/*     */     
/*     */     JMenu jMenu;
/* 227 */     add(jMenu = new JMenu("Map"));
/* 228 */     this.usaItem.addActionListener(localActionListener); jMenu.add(this.usaItem);
/* 229 */     this.simpliciaItem.addActionListener(localActionListener); jMenu.add(this.simpliciaItem);
/*     */ 
/*     */     
/* 232 */     add(jMenu = new JMenu("Type"));
/* 233 */     this.noCheckItem.addActionListener(localActionListener); jMenu.add(this.noCheckItem);
/* 234 */     this.assignmentsOnlyItem.addActionListener(localActionListener); jMenu.add(this.assignmentsOnlyItem);
/* 235 */     this.checkNeighborsItem.addActionListener(localActionListener); jMenu.add(this.checkNeighborsItem);
/* 236 */     this.propagateIfOneItem.addActionListener(localActionListener); jMenu.add(this.propagateIfOneItem);
/* 237 */     this.propagageIfReducedItem.addActionListener(localActionListener); jMenu.add(this.propagageIfReducedItem);
/*     */ 
/*     */ 
/*     */     
/* 241 */     add(jMenu = new JMenu("Arrangement"));
/* 242 */     this.alphabeticalItem.addActionListener(localActionListener); jMenu.add(this.alphabeticalItem);
/* 243 */     this.mostConstrainedFirstItem.addActionListener(localActionListener); jMenu.add(this.mostConstrainedFirstItem);
/* 244 */     this.leastConstrainedFirstItem.addActionListener(localActionListener); jMenu.add(this.leastConstrainedFirstItem);
/* 245 */     this.badNewsItem.addActionListener(localActionListener); jMenu.add(this.badNewsItem);
/*     */ 
/*     */     
/* 248 */     add(jMenu = new JMenu("Colors"));
/* 249 */     jMenu.add(this.threeItem); this.threeItem.addActionListener(localActionListener);
/* 250 */     jMenu.add(this.fourItem); this.fourItem.addActionListener(localActionListener);
/* 251 */     jMenu.add(this.fiveItem); this.fiveItem.addActionListener(localActionListener);
/* 252 */     jMenu.add(this.sixItem); this.sixItem.addActionListener(localActionListener);
/* 253 */     jMenu.add(this.sevenItem); this.sevenItem.addActionListener(localActionListener);
/*     */ 
/*     */     
/* 256 */     add(jMenu = new JMenu("Speed"));
/* 257 */     jMenu.add(this.slowItem); this.slowItem.addActionListener(localActionListener);
/* 258 */     jMenu.add(this.mediumItem); this.mediumItem.addActionListener(localActionListener);
/* 259 */     jMenu.add(this.mediumFastItem); this.mediumFastItem.addActionListener(localActionListener);
/* 260 */     jMenu.add(this.fastItem); this.fastItem.addActionListener(localActionListener);
/*     */ 
/*     */     
/* 263 */     add(jMenu = new JMenu("Help"));
/*     */     
/* 265 */     jMenu.add(this.aboutItem); this.aboutItem.addActionListener(localActionListener);
/*     */   }
/*     */   
/*     */   class LocalActionListener implements ActionListener {
/*     */     Resource application;
/*     */
/*     */     
/*     */     public LocalActionListener(Resource param1Resource) {
/* 273 */       this.application = param1Resource;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void actionPerformed(ActionEvent param1ActionEvent) {
/* 279 */       Object object = param1ActionEvent.getSource();
/*     */       
/* 281 */       if (object == ResourceLocalMenuBar.this.slowItem) { ResourceLocalMenuBar.this.model.setFrameRate(1); }
/* 282 */       else if (object == ResourceLocalMenuBar.this.mediumItem) { ResourceLocalMenuBar.this.model.setFrameRate(4); }
/* 283 */       else if (object == ResourceLocalMenuBar.this.mediumFastItem) { ResourceLocalMenuBar.this.model.setFrameRate(30); }
/* 284 */       else if (object == ResourceLocalMenuBar.this.fastItem) { ResourceLocalMenuBar.this.model.setFrameRate(1000); }
/*     */       
/* 286 */       else if (object == ResourceLocalMenuBar.this.alphabeticalItem) { ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setArrangement(0); ResourceLocalMenuBar.this.model.quit(); ResourceLocalMenuBar.this.model.clear(); }
/* 287 */       else if (object == ResourceLocalMenuBar.this.mostConstrainedFirstItem) { ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setArrangement(1); ResourceLocalMenuBar.this.model.quit(); ResourceLocalMenuBar.this.model.clear(); }
/* 288 */       else if (object == ResourceLocalMenuBar.this.leastConstrainedFirstItem) { ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setArrangement(2); ResourceLocalMenuBar.this.model.quit(); ResourceLocalMenuBar.this.model.clear(); }
/* 289 */       else if (object == ResourceLocalMenuBar.this.badNewsItem) { ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setArrangement(3); ResourceLocalMenuBar.this.model.quit(); ResourceLocalMenuBar.this.model.clear(); }
/*     */       
/* 291 */       else if (object == ResourceLocalMenuBar.this.threeItem) { ResourceLocalMenuBar.this.model.setResourceCount(3); ResourceLocalMenuBar.this.model.quit(); ResourceLocalMenuBar.this.model.clear(); }
/* 292 */       else if (object == ResourceLocalMenuBar.this.fourItem) { ResourceLocalMenuBar.this.model.setResourceCount(4); ResourceLocalMenuBar.this.model.quit(); ResourceLocalMenuBar.this.model.clear(); }
/* 293 */       else if (object == ResourceLocalMenuBar.this.fiveItem) { ResourceLocalMenuBar.this.model.setResourceCount(5); ResourceLocalMenuBar.this.model.quit(); ResourceLocalMenuBar.this.model.clear(); }
/* 294 */       else if (object == ResourceLocalMenuBar.this.sixItem) { ResourceLocalMenuBar.this.model.setResourceCount(6); ResourceLocalMenuBar.this.model.quit(); ResourceLocalMenuBar.this.model.clear(); }
/* 295 */       else if (object == ResourceLocalMenuBar.this.sevenItem) { ResourceLocalMenuBar.this.model.setResourceCount(7); ResourceLocalMenuBar.this.model.quit(); ResourceLocalMenuBar.this.model.clear(); }
/*     */       
/* 297 */       else if (object == ResourceLocalMenuBar.this.noCheckItem) { ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setType(-1); }
/* 298 */       else if (object == ResourceLocalMenuBar.this.assignmentsOnlyItem) { ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setType(0); }
/* 299 */       else if (object == ResourceLocalMenuBar.this.checkNeighborsItem) { ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setType(1); }
/* 300 */       else if (object == ResourceLocalMenuBar.this.propagateIfOneItem) { ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setType(3); }
/* 301 */       else if (object == ResourceLocalMenuBar.this.propagageIfReducedItem) { ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setType(2); }
/* 302 */       else if (object == ResourceLocalMenuBar.this.checkAllItem) { ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setType(5); }
/*     */       
/* 304 */       else if (object == ResourceLocalMenuBar.this.usaItem)
/* 305 */       { ResourceLocalMenuBar.this.model.quit();
/* 306 */         ResourceLocalMenuBar.this.view.clear();
/* 307 */         ResourceLocalMenuBar.this.view.setShowNames(false);
/* 308 */         ResourceLocalMenuBar.this.model.readData("USA.DATA");
/* 309 */         ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setArrangement(0); }
/*     */       
/* 311 */       else if (object == ResourceLocalMenuBar.this.simpliciaItem)
/* 312 */       { ResourceLocalMenuBar.this.model.quit();
/* 313 */         ResourceLocalMenuBar.this.view.clear();
/* 314 */         ResourceLocalMenuBar.this.view.setShowNames(true);
/* 315 */         ResourceLocalMenuBar.this.model.readData("SIMPLICIA.DATA");
/* 316 */         ResourceLocalMenuBar.this.model.getClass(); ResourceLocalMenuBar.this.model.setArrangement(0);
/*     */          }
/*     */       
/* 319 */       else if (object == ResourceLocalMenuBar.this.aboutItem)
/* 320 */       { JOptionPane.showMessageDialog(this.application, "Search " + this.application.VERSION + "\nImplemented by Patrick Winston"); }
/*     */ 
/*     */       
/* 323 */       ResourceLocalMenuBar.this.model.changed();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\ResourceLocalMenuBar.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */