/*     */ package search.models;
/*     */ 
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public abstract class SearchableNet extends BasicNet {
/*   7 */   Queue queue = new Queue();
/*   8 */   Vector enqueuedNodes = new Vector();
/*   9 */   Vector extendedNodes = new Vector();
/*  10 */   int enqueuings = 0;
/*  11 */   int extensions = 0;
/*  12 */   int pathElements = 0;
/*  13 */   int timeBetweenFrames = 250;
/*  14 */   int counter = 0; SearchThread searchThread;
/*  15 */   long then = 0L; public Queue getQueue() {
/*  16 */     return this.queue; }
/*  17 */   public Vector getEnqueuedNodes() { return this.enqueuedNodes; }
/*  18 */   public void addEnqueuedNode(Node paramNode) { this.enqueuedNodes.add(paramNode); }
/*  19 */   public Vector getExtendedNodes() { return this.extendedNodes; }
/*  20 */   public void addExtendedNode(Node paramNode) { this.extendedNodes.add(paramNode); }
/*  21 */   public int getQueueSize() { return this.queue.size(); }
/*  22 */   public int getExtendedNodeCount() { return this.extensions; }
/*  23 */   public int getEnqueuedNodeCount() { return this.enqueuings; }
/*  24 */   public void incrementExtendedNodeCount() { this.extensions++; }
/*  25 */   public void incrementEnqueuedNodeCount(int paramInt) { this.enqueuings += paramInt; } public int getCurrentPathElementCount() {
/*  26 */     return this.pathElements;
/*     */   } public void setFrameRate(int paramInt) {
/*  28 */     this.timeBetweenFrames = 1000 / paramInt;
/*     */   }
/*     */   protected Vector extend(Path paramPath) {
/*  31 */     Vector vector = new Vector();
/*  32 */     Node node = (Node)paramPath.lastElement();
/*  33 */     Vector vector1 = node.getNeighbors();
/*  34 */     for (short b = 0; b < vector1.size(); b++) {
/*  35 */       Node node1 = (Node) vector1.elementAt(b);
/*  36 */       if (!paramPath.contains(node1)) {
/*  37 */         Path path = (Path)paramPath.clone();
/*  38 */         path.add(node1);
/*  39 */         vector.add(path);
/*     */       } 
/*     */     } 
/*  42 */     return vector;
/*     */   }
/*     */   
/*     */   public void clear() {
/*  46 */     this.counter = 0;
/*  47 */     this.then = (new GregorianCalendar()).getTime().getTime();
/*     */   }
/*     */   
/*     */   public void report() {
/*  51 */     long l1 = (new GregorianCalendar()).getTime().getTime();
/*  52 */     long l2 = (l1 - this.then) / 1000L;
/*  53 */     System.out.println("Found assignment!");
/*  54 */     if (l2 > 0L) {
/*  55 */       System.out.println("Operations: " + this.counter + ", seconds: " + l2 + " (" + (this.counter / l2) + " per second)");
/*     */     } else {
/*     */       
/*  58 */       System.out.println(this.counter + " operations in less than 1 second");
/*     */     } 
/*     */   }
/*     */   class ChangeHandler implements Runnable {
/*     */ SearchableNet net1;
public ChangeHandler(SearchableNet net){net1 = net;}
/*     */     public void run() {
/*  64 */       net1.changed();
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public void quit() {
/*  70 */     if (this.searchThread == null)
/*  71 */       return;  this.searchThread.quit();
/*     */   }
/*     */ 
/*     */   
/*     */   public void pause() {
/*  76 */     if (this.searchThread == null)
/*  77 */       return;  this.searchThread.pause();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void go() {
/*  83 */     if (this.searchThread == null)
/*  84 */       return;  this.searchThread.go();
/*     */   }
/*     */   public abstract void search();
/*     */   
/*     */   protected class SearchThread extends Thread { protected boolean loop = true;
/*     */     protected boolean pause = false;
/*     */     
/*     */     public void quit() {
/*  93 */       this.loop = false;
/*  94 */       System.out.println("Stopping");
/*     */     }
/*     */     public void pause() {
/*  97 */       this.pause = true;
/*  98 */       System.out.println("Pausing");
/*     */     }
/*     */     public void go() {
/* 101 */       this.pause = false;
/* 102 */       System.out.println("Resuming");
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\SearchableNet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */