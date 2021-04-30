/*     */ package search.models;
/*     */ import java.net.URL;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
import java.util.TreeSet;
/*     */ import java.util.Vector;
/*     */ import search.io.IteratorForXML;
/*     */ import search.io.Tags;
import search.io.TextIO;

import javax.swing.*;

/*     */
/*     */ public class StreetNet extends NodeNet {
/*  10 */   double pathLength = 0.0D; Node start;
/*     */   Node goal;
/*  12 */   public final int DEPTH = 0, BREADTH = 1, HILL_CLIMBING = 2, BEAM = 3, BEST = 4, B_AND_B = 5;
/*  13 */   public final int B_AND_B_WITH_EXTENDED_LIST = 6; public final int B_AND_B_WITH_ADMISSIBLE_HEURISTIC = 7; public final int A_STAR = 8;
/*  14 */   int TYPE = 0;
/*     */   
/*  16 */   public final int NO_FILTER = 0; public final int ENQUEUED = 1; public final int EXTENDED = 2;
/*     */ 
/*     */   
/*  19 */   public int FILTER = 1;
/*     */   
/*  21 */   public void setStart(Node paramNode) { this.start = paramNode; changed(); }
/*  22 */   public void setGoal(Node paramNode) { this.goal = paramNode; changed(); }
/*  23 */   public Node getStart() { return this.start; }
/*  24 */   public Node getGoal() { return this.goal; }
/*  25 */   public void setType(int paramInt) { this.TYPE = paramInt; } public void setFilter(int paramInt) {
/*  26 */     this.FILTER = paramInt;
/*     */   } public String getTypeString() {
/*  28 */     String str = "";
/*  29 */     if (this.TYPE == 0) { str = str + "depth-first"; }
/*  30 */     else if (this.TYPE == 1) { str = str + "breadth-first"; }
/*  31 */     else if (this.TYPE == 2) { str = str + "hill-climbing"; }
/*  32 */     else if (this.TYPE == 3) { str = str + "beam"; }
/*  33 */     else if (this.TYPE == 4) { str = str + "best-first"; }
/*  34 */     else if (this.TYPE == 5) { str = str + "basic branch and bound"; }
/*  35 */     else if (this.TYPE == 6) { str = str + "branch and bound, with extended list filtering"; }
/*  36 */     else if (this.TYPE == 7) { str = str + "branch and bound, with admissible heuristic "; }
/*  37 */     else if (this.TYPE == 8) { str = str + "A*"; }
/*     */     
/*  39 */     if (this.FILTER == 1) { str = str + ", with enqued list filtering"; }
/*  40 */     else if (this.TYPE == 0 || this.TYPE == 1 || this.TYPE == 2 || this.TYPE == 3 || this.TYPE == 4)
/*  41 */     { str = str + ", with no enqued list filtering"; }
/*     */     
/*  43 */     return str;
/*     */   }
/*     */   public String getFilterString() {
/*  46 */     if (this.FILTER == 0) return "none"; 
/*  47 */     if (this.FILTER == 1) return "enqueued"; 
/*  48 */     if (this.FILTER == 2) return "extended"; 
/*  49 */     return "bug!";
/*     */   }
/*     */   public double getCurrentPathLength() {
/*  52 */     return this.pathLength;
/*     */   }
/*     */   public static void main(String[] paramArrayOfString) {
/*  55 */     Node node1 = new Node(0, 0, "Foo");
/*  56 */     Node node2 = new Node(0, 50, "Bar");
/*  57 */     Node node3 = new Node(50, 50, "Baz");
/*  58 */     StreetNet streetNet = new StreetNet();
/*  59 */     streetNet.connect(node1, node2);
/*  60 */     streetNet.connect(node2, node3);
/*  61 */     streetNet.addNode(node1);
/*  62 */     streetNet.addNode(node2);
/*  63 */     streetNet.addNode(node3);
/*  64 */     System.out.println(streetNet.queue);
/*  65 */     System.out.println(streetNet.getClosest(0, 50));
/*     */   }
/*     */   
/*     */   public void search() {
/*  69 */     clear();
/*  70 */     if (this.start == null || this.goal == null)
/*  71 */       return;  this.searchThread = new NodeThread();
/*  72 */     this.searchThread.start();
/*     */   }
/*     */   
/*     */   private Vector filter(Vector paramVector) {
/*  76 */     Vector vector = new Vector();
/*  77 */     if (this.FILTER == 0) { vector = paramVector; }
/*  78 */     else if (this.FILTER == 1)
/*  79 */     { for (short b = 0; b < paramVector.size(); b++) {
/*  80 */         Path path = (Path) paramVector.elementAt(b);
/*  81 */         Node node = (Node)path.lastElement();
/*  82 */         if (!this.enqueuedNodes.contains(node)) {
/*  83 */           vector.add(paramVector.elementAt(b));
/*     */         }
/*     */       }
/*     */        }
/*  87 */     else if (this.FILTER == 2)
/*  88 */     { for (short b = 0; b < paramVector.size(); b++) {
/*  89 */         Path path = (Path) paramVector.elementAt(b);
/*  90 */         Node node = (Node)path.lastElement();
/*  91 */         if (!this.extendedNodes.contains(node)) {
/*  92 */           vector.add(paramVector.elementAt(b));
/*     */         }
/*     */       }  }
/*     */     
/*  96 */     return vector;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 100 */     super.clear();
/* 101 */     this.queue.clear();
/* 102 */     this.extendedNodes = new Vector();
/* 103 */     this.enqueuedNodes = new Vector();
/* 104 */     this.extensions = 0;
/* 105 */     this.enqueuings = 0;
/* 106 */     this.pathLength = 0.0D;
/* 107 */     this.pathElements = 0;
/*     */   }
/*     */   class NodeThread extends SearchThread { Vector beamPaths;
/*     */     
/*     */     NodeThread() {
/* 112 */       this.beamPaths = new Vector();
/*     */     }
/*     */     
/*     */     public void run() {
/* 116 */       StreetNet.this.clear();
/* 117 */       Path path = new Path();
/* 118 */       path.add(StreetNet.this.start);
/* 119 */       StreetNet.this.queue.add(path);
/* 120 */       Node node = StreetNet.this.getGoal();
/*     */ 
/*     */       
/* 123 */       while (this.loop) {
/* 124 */         StreetNet.this.counter++;
/* 125 */         if (StreetNet.this.queue.isEmpty()) {
/* 126 */           System.out.println("Failed to find path!");
/*     */           return;
/*     */         } 
/* 129 */         if (!this.pause && 
/* 130 */           takeStep())
/*     */           return;  
/* 132 */         try { sleep(StreetNet.this.timeBetweenFrames); } catch (Exception exception) {}
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean takeStep() {
/* 138 */       Vector vector = new Vector();
/*     */ 
/*     */       
/* 141 */       Path path = (Path)StreetNet.this.queue.firstElement();
/* 142 */       StreetNet.this.pathLength = StreetNet.this.pathLength(path);
/* 143 */       StreetNet.this.pathElements = StreetNet.this.pathElementCount(path);
/* 144 */       Node node = (Node)path.lastElement();
/*     */ 
/*     */       
/* 147 */       if (node.equals(StreetNet.this.goal)) {
/* 148 */         StreetNet.this.report();
/* 149 */         ChangeHandler changeHandler1 = new ChangeHandler(StreetNet.this);
/* 150 */         SwingUtilities.invokeLater(changeHandler1);
/* 151 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 155 */       StreetNet.this.queue.remove(path);
/*     */ 
/*     */       
/* 158 */       if (StreetNet.this.FILTER == 2 && StreetNet.this.getExtendedNodes().contains(node)) {
/* 159 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 163 */       StreetNet.this.addExtendedNode(node);
/* 164 */       StreetNet.this.incrementExtendedNodeCount();
/* 165 */       if (StreetNet.this.TYPE == 3) {
/* 166 */         this.beamPaths.addAll(StreetNet.this.extend(path));
/* 167 */         if (StreetNet.this.queue.isEmpty()) {
/* 168 */           vector.addAll(this.beamPaths);
/* 169 */           this.beamPaths.clear();
/*     */         } 
/*     */       } else {
/*     */         
/* 173 */         vector.addAll(StreetNet.this.extend(path));
/*     */       } 
/*     */ 
/*     */       
/* 177 */       addPaths(vector);
/*     */ 
/*     */       
/* 180 */       if (StreetNet.this.TYPE == 0 || StreetNet.this.TYPE == 1 || StreetNet.this.TYPE == 2 || StreetNet.this.TYPE == 4) {
/* 181 */         for (short b = 0; b < vector.size(); b++) {
/* 182 */           Path path1 = (Path) vector.get(b);
/* 183 */           Node node1 = (Node)path1.lastElement();
/* 184 */           if (node1.equals(StreetNet.this.getGoal())) {
/* 185 */             StreetNet.this.queue.add(0, path1);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 190 */       ChangeHandler changeHandler = new ChangeHandler(StreetNet.this);
/* 191 */       SwingUtilities.invokeLater(changeHandler);
/* 192 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void addPaths(Vector param1Vector) {
/* 199 */       if (StreetNet.this.FILTER == 1) {
/* 200 */         Vector vector = new Vector();
/* 201 */         for (short b = 0; b < param1Vector.size(); b++) {
/* 202 */           Path path = (Path) param1Vector.get(b);
/* 203 */           Node node = (Node)path.lastElement();
/* 204 */           if (!StreetNet.this.getEnqueuedNodes().contains(node)) {
/* 205 */             vector.add(path);
/* 206 */             StreetNet.this.addEnqueuedNode(node);
/*     */           } 
/*     */         } 
/* 209 */         param1Vector = vector;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 214 */       if (StreetNet.this.TYPE == 3) {
/* 215 */         param1Vector = trimToSize(5, sortByDistanceToGoal(StreetNet.this.queue.get()));
/*     */       }
/*     */ 
/*     */       
/* 219 */       StreetNet.this.incrementEnqueuedNodeCount(param1Vector.size());
/*     */ 
/*     */       
/* 222 */       if (StreetNet.this.TYPE == 0) { StreetNet.this.queue.addToFront(param1Vector); }
/* 223 */       else if (StreetNet.this.TYPE == 1) { StreetNet.this.queue.addToRear(param1Vector); }
/* 224 */       else if (StreetNet.this.TYPE == 2) { StreetNet.this.queue.addToFront(sortByDistanceToGoal(param1Vector)); }
/* 225 */       else if (StreetNet.this.TYPE == 3) { StreetNet.this.queue.addAll((Collection)param1Vector); StreetNet.this.queue.set(trimToSize(5, sortByDistanceToGoal(StreetNet.this.queue.get()))); }
/* 226 */       else if (StreetNet.this.TYPE == 4) { StreetNet.this.queue.addAll((Collection)param1Vector); StreetNet.this.queue.set(sortByDistanceToGoal(StreetNet.this.queue.get())); }
/* 227 */       else if (StreetNet.this.TYPE == 5 || StreetNet.this.TYPE == 6)
/* 228 */       { StreetNet.this.queue.addAll((Collection)param1Vector);
/* 229 */         StreetNet.this.queue.moveToFront(getShortestPath(StreetNet.this.queue)); }
/*     */       
/* 231 */       else if (StreetNet.this.TYPE == 8 || StreetNet.this.TYPE == 7)
/* 232 */       { StreetNet.this.queue.addAll((Collection)param1Vector);
/* 233 */         StreetNet.this.queue.moveToFront(getShortestAugmentedPath(StreetNet.this.queue)); }
/*     */     
/*     */     }
/*     */     
/*     */     private Path getShortestPath(Vector param1Vector) {
/* 238 */       Path path = (Path) param1Vector.elementAt(0);
/* 239 */       double d = StreetNet.this.pathLength(path);
/* 240 */       for (short b = 1; b < param1Vector.size(); b++) {
/* 241 */         Path path1 = (Path) param1Vector.elementAt(b);
/* 242 */         double d1 = StreetNet.this.pathLength(path1);
/* 243 */         if (d1 < d) {
/* 244 */           path = path1;
/* 245 */           d = d1;
/*     */         } 
/*     */       } 
/* 248 */       return path;
/*     */     }
/*     */     private Path getShortestAugmentedPath(Vector param1Vector) {
/* 251 */       Path path = (Path) param1Vector.elementAt(0);
/* 252 */       double d = StreetNet.this.pathLength(path);
/* 253 */       Node node = (Node)path.lastElement();
/* 254 */       d += Math.sqrt(StreetNet.this.distanceSquared(node, StreetNet.this.getGoal()));
/* 255 */       for (short b = 1; b < param1Vector.size(); b++) {
/* 256 */         Path path1 = (Path) param1Vector.elementAt(b);
/* 257 */         double d1 = StreetNet.this.pathLength(path1);
/* 258 */         Node node1 = (Node)path1.lastElement();
/* 259 */         d1 += Math.sqrt(StreetNet.this.distanceSquared(node1, StreetNet.this.getGoal()));
/* 260 */         if (d1 < d) {
/* 261 */           path = path1;
/* 262 */           d = d1;
/*     */         } 
/*     */       } 
/* 265 */       return path;
/*     */     }
/*     */     private Vector sortByPathLength(Vector param1Vector) {
/* 268 */       TreeSet treeSet = new TreeSet(new PathLengthComparator());
/* 269 */       treeSet.addAll(param1Vector);
/* 270 */       return new Vector(treeSet);
/*     */     }
/*     */     
/*     */     private Vector sortByAugmentedPathLength(Vector param1Vector) {
/* 274 */       TreeSet treeSet = new TreeSet(new AugmentedPathLengthComparator());
/* 275 */       treeSet.addAll(param1Vector);
/* 276 */       return new Vector(treeSet);
/*     */     }
/*     */     
/*     */     private Vector trimToSize(int param1Int, Vector param1Vector) {
/* 280 */       Vector vector = new Vector();
/* 281 */       for (short b = 0; b < Math.min(param1Int, param1Vector.size()); b++) {
/* 282 */         vector.add(param1Vector.elementAt(b));
/*     */       }
/* 284 */       return vector;
/*     */     }
/*     */     private Vector sortByDistanceToGoal(Vector param1Vector) {
/* 287 */       TreeSet treeSet = new TreeSet(new DistanceToGoalComparator());
/* 288 */       treeSet.addAll(param1Vector);
/* 289 */       return new Vector(treeSet);
/*     */     } }
/*     */   
/*     */   class AugmentedPathLengthComparator implements Comparator {
/*     */     
/*     */     public int compare(Object param1Object1, Object param1Object2) {
/* 295 */       Path path1 = (Path)param1Object1;
/* 296 */       Path path2 = (Path)param1Object2;
/* 297 */       double d1 = StreetNet.this.pathLength(path1);
/* 298 */       double d2 = StreetNet.this.pathLength(path2);
/*     */       
/* 300 */       Node node1 = (Node)path1.lastElement();
/* 301 */       Node node2 = (Node)path2.lastElement();
/* 302 */       d1 += Math.sqrt(StreetNet.this.distanceSquared(node1, StreetNet.this.getGoal()));
/* 303 */       d2 += Math.sqrt(StreetNet.this.distanceSquared(node2, StreetNet.this.getGoal()));
/*     */       
/* 305 */       if (d1 < d2) return -1; 
/* 306 */       if (d1 > d2) return 1; 
/* 307 */       return 0;
/*     */     } }
/*     */   class PathLengthComparator implements Comparator {
/*     */     
/*     */     public int compare(Object param1Object1, Object param1Object2) {
/* 312 */       Path path1 = (Path)param1Object1;
/* 313 */       Path path2 = (Path)param1Object2;
/* 314 */       double d1 = StreetNet.this.pathLength(path1);
/* 315 */       double d2 = StreetNet.this.pathLength(path2);
/* 316 */       if (d1 < d2) return -1; 
/* 317 */       if (d1 > d2) return 1; 
/* 318 */       return 0;
/*     */     } }
/*     */   class DistanceToGoalComparator implements Comparator {
/*     */     
/*     */     public int compare(Object param1Object1, Object param1Object2) {
/* 323 */       Path path1 = (Path)param1Object1;
/* 324 */       Path path2 = (Path)param1Object2;
/* 325 */       Node node1 = (Node)path1.lastElement();
/* 326 */       Node node2 = (Node)path2.lastElement();
/* 327 */       int i = StreetNet.this.distanceSquared(node1, StreetNet.this.getGoal());
/* 328 */       int j = StreetNet.this.distanceSquared(node2, StreetNet.this.getGoal());
/* 329 */       if (i < j) return -1; 
/* 330 */       if (i > j) return 1; 
/* 331 */       return 0;
/*     */     } }
/*     */   
/*     */   private double pathLength(Path paramPath) {
/* 335 */     Node node = (Node)paramPath.firstElement();
/* 336 */     double d = 0.0D;
/* 337 */     for (short b = 1; b < paramPath.size(); b++) {
/* 338 */       Node node1 = (Node)paramPath.elementAt(b);
/* 339 */       d += Math.sqrt(distanceSquared(node, node1));
/* 340 */       node = node1;
/*     */     } 
/* 342 */     return d;
/*     */   }
/*     */   private int pathElementCount(Path paramPath) {
/* 345 */     return paramPath.size() - 1;
/*     */   }
/*     */   private int distanceSquared(Node paramNode1, Node paramNode2) {
/* 348 */     int i = paramNode1.getX();
/* 349 */     int j = paramNode1.getY();
/* 350 */     int k = paramNode2.getX();
/* 351 */     int m = paramNode2.getY();
/* 352 */     int n = i - k;
/* 353 */     int i1 = j - m;
/* 354 */     return n * n + i1 * i1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readData(String paramString) {
/* 361 */     String str = "";
/*     */     try {
/* 363 */       URL uRL = StreetNet.class.getResource(paramString);
/* 364 */       System.out.println("Trying to read from file " + paramString);
/* 365 */       System.out.println("Trying to read from url " + uRL);
/* 366 */       str = TextIO.readStringFromURL(uRL);
/* 367 */     } catch (Exception exception) {}
/*     */     
/* 369 */     Vector vector = new Vector(); IteratorForXML iteratorForXML;
/* 370 */     for (iteratorForXML = new IteratorForXML(str, "street"); iteratorForXML.hasNext(); ) {
/* 371 */       String str1 = iteratorForXML.next();
/* 372 */       int i = Tags.untagInt("x1", str1);
/* 373 */       int j = -Tags.untagInt("y1", str1);
/* 374 */       int k = Tags.untagInt("x2", str1);
/* 375 */       int m = -Tags.untagInt("y2", str1);
/* 376 */       Node node1 = new Node(i, j);
/* 377 */       vector.add(node1);
/* 378 */       Node node2 = new Node(k, m);
/* 379 */       vector.add(node2);
/*     */     } 
/* 381 */     setNodes(vector);
/*     */     
/* 383 */     for (iteratorForXML = new IteratorForXML(str, "street"); iteratorForXML.hasNext(); ) {
/* 384 */       String str1 = iteratorForXML.next();
/* 385 */       int i = Tags.untagInt("x1", str1);
/* 386 */       int j = -Tags.untagInt("y1", str1);
/* 387 */       int k = Tags.untagInt("x2", str1);
/* 388 */       int m = -Tags.untagInt("y2", str1);
/* 389 */       String str2 = Tags.untagString("name", str1);
/* 390 */       Node node1 = new Node(i, j);
/* 391 */       Node node2 = new Node(k, m);
/* 392 */       connect(node1, node2, str2);
/*     */ 
/*     */       
/* 395 */       connect(node2, node1, str2);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\StreetNet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */