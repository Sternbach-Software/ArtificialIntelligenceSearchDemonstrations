/*     */ package search.models;
/*     */ import java.awt.Color;
/*     */ import java.awt.Polygon;
/*     */ import java.net.URL;
import java.util.Comparator;
import java.util.TreeSet;
/*     */ import java.util.Vector;
/*     */ import search.io.IteratorForXML;
/*     */ import search.io.Tags;
import search.io.TextIO;

import javax.swing.*;

/*     */
/*     */ public class MapNet extends SearchableNet {
/*  10 */   public final int NO_CHECKS = -1, ASSIGNMENTS_ONLY = 0, NEIGHBORS_ONLY = 1, DOMAIN_SHRINKS = 2;
/*  11 */   public final int DOMAIN_SHRINKS_TO_ONE = 3; public final int CHECK_EVERYTHING = 4; public final int CHECK_ALL = 5;
/*     */   
/*     */   int TYPE;
/*  14 */   public final int ALPHABETICAL = 0; public final int MOST_FIRST = 1; public final int LEAST_FIRST = 2; public final int BAD_NEWS_FIRST = 3;
/*     */   
/*     */   int ARRANGEMENT;
/*  17 */   private Color[] colors = new Color[] { Color.red, Color.green, Color.blue, Color.yellow, Color.cyan, Color.magenta, Color.orange, Color.pink, Color.darkGray, Color.black };
/*     */   
/*     */   public void setType(int paramInt) {
/*  20 */     this.TYPE = paramInt; } public void setArrangement(int paramInt) {
/*  21 */     this.ARRANGEMENT = paramInt;
/*     */   }
/*     */   public String getTypeString() {
/*  24 */     if (this.TYPE == -1) return "no checks at all"; 
/*  25 */     if (this.TYPE == 0) return "assignments only"; 
/*  26 */     if (this.TYPE == 1) return "neighbors only"; 
/*  27 */     if (this.TYPE == 3) return "propagate through domains shrinking to one value"; 
/*  28 */     if (this.TYPE == 2) return "propagate through shrinking domains"; 
/*  29 */     return "bug!";
/*     */   }
/*     */   public String getArrangementString() {
/*  32 */     if (this.ARRANGEMENT == 0) return "Alphabetical"; 
/*  33 */     if (this.ARRANGEMENT == 1) return "Most constrained first"; 
/*  34 */     if (this.ARRANGEMENT == 2) return "Least constrained first"; 
/*  35 */     if (this.ARRANGEMENT == 3) return "Ugh!"; 
/*  36 */     return "bug!";
/*     */   }
/*     */   
/*     */   public void setResourceCount(int paramInt) {
/*  40 */     this.resourceValues.clear();
/*  41 */     for (short b = 0; b < paramInt; b++)
/*  42 */       this.resourceValues.add(this.colors[b]); 
/*     */   }
/*     */   
/*     */   public int getResourceCount() {
/*  46 */     return this.resourceValues.size();
/*     */   }
/*  48 */   Vector resourceValues = new Vector();
/*     */   
/*     */   Vector alternatives;
/*     */   
/*     */   int index;
/*     */   
/*     */   int constraintChecks;
/*     */   
/*     */   int deadEnds;
/*     */   int assignments;
/*     */   
/*     */   public Vector getResourceDomain() {
/*  60 */     return this.resourceValues; } public void setResourceDomain(Vector paramVector) {
/*  61 */     this.resourceValues = paramVector;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readData(String paramString) {
/*  67 */     String str = "";
/*     */     try {
/*  69 */       URL uRL = MapNet.class.getResource(paramString);
/*  70 */       System.out.println("Trying to read from file " + paramString);
/*  71 */       System.out.println("Trying to read from url " + uRL);
/*  72 */       str = TextIO.readStringFromURL(uRL);
/*  73 */     } catch (Exception exception) {}
/*     */     
/*  75 */     Vector vector = new Vector(); IteratorForXML iteratorForXML;
/*  76 */     for (iteratorForXML = new IteratorForXML(str, "state"); iteratorForXML.hasNext(); ) {
/*  77 */       String str1 = iteratorForXML.next();
/*  78 */       String str2 = Tags.untagString("name", str1);
/*  79 */       Vector vector1 = new Vector();
/*  80 */       Vector vector2 = new Vector();
/*  81 */       Vector vector3 = new Vector();
/*  82 */       int i = 0, j = 0;
/*  83 */       for (IteratorForXML iteratorForXML1 = new IteratorForXML(str1, "pair"); iteratorForXML1.hasNext(); ) {
/*  84 */         String str3 = iteratorForXML1.next();
/*  85 */         int k = Tags.untagInt("x", str3);
/*  86 */         int m = Tags.untagInt("y", str3);
/*  87 */         vector1.add(k);
/*  88 */         vector2.add(-m);
/*  89 */         if (vector1.size() == 1) { i = k; j = m; continue; }
/*  90 */          if (k == i && m == j) {
/*  91 */           int[] arrayOfInt1 = new int[vector1.size()];
/*  92 */           int[] arrayOfInt2 = new int[vector2.size()]; short b;
/*  93 */           for (b = 0; b < arrayOfInt1.length; ) { arrayOfInt1[b] = (Integer) vector1.elementAt(b); b++; }
/*  94 */            for (b = 0; b < arrayOfInt2.length; ) { arrayOfInt2[b] = (Integer) vector2.elementAt(b); b++; }
/*  95 */            Polygon polygon = new Polygon(arrayOfInt1, arrayOfInt2, arrayOfInt1.length);
/*  96 */           vector3.add(polygon);
/*  97 */           vector1.clear();
/*  98 */           vector2.clear();
/*     */         } 
/*     */       } 
/* 101 */       State state = new State(str2, vector3);
/* 102 */       state.setResource(Color.white);
/* 103 */       vector.add(state);
/*     */     } 
/* 105 */     setNodes(vector);
/* 106 */     for (iteratorForXML = new IteratorForXML(str, "state"); iteratorForXML.hasNext(); ) {
/* 107 */       String str1 = iteratorForXML.next();
/* 108 */       State state = getState(Tags.untagString("name", str1));
/* 109 */       for (IteratorForXML iteratorForXML1 = new IteratorForXML(str1, "neighbor"); iteratorForXML1.hasNext(); ) {
/* 110 */         String str2 = iteratorForXML1.next();
/* 111 */         State state1 = getState(Tags.untagString("neighbor", str2));
/* 112 */         connect(state, state1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 117 */     sortAlphabetically();
/*     */   }
/*     */   
/*     */   private void sortByBadNews() {
/* 121 */     State state1 = getState("TX");
/* 122 */     State state2 = getState("NM");
/* 123 */     State state3 = getState("OK");
/* 124 */     State state4 = getState("AK");
/* 125 */     State state5 = getState("LA");
/* 126 */     if (state1 == null || state2 == null || state3 == null || state4 == null || state5 == null) { System.out.println("Does not apply!"); return; }
/* 127 */      sortByLeastConstraint();
/* 128 */     this.nodes.remove(state1);
/* 129 */     this.nodes.remove(state2);
/* 130 */     this.nodes.remove(state3);
/* 131 */     this.nodes.remove(state4);
/* 132 */     this.nodes.remove(state5);
/* 133 */     this.nodes.add(state1);
/* 134 */     this.nodes.add(0, state5);
/* 135 */     this.nodes.add(0, state4);
/* 136 */     this.nodes.add(0, state3);
/* 137 */     this.nodes.add(0, state2);
/*     */   }
/*     */   
/*     */   private State getState(String paramString) {
/* 141 */     State state = new State(paramString, new Vector());
/* 142 */     return getState(state);
/*     */   }
/*     */   
/*     */   private State getState(State paramState) {
/* 146 */     if (this.nodes.contains(paramState)) {
/* 147 */       int i = this.nodes.indexOf(paramState);
/* 148 */       return (State) this.nodes.elementAt(i);
/*     */     } 
/* 150 */     System.err.println("Neighbor " + paramState + " found that is not a known state!");
/* 151 */     return null;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 155 */     super.clear();
/* 156 */     Vector vector = getNodes();
/* 157 */     for (short b = 0; b < vector.size(); b++) {
/* 158 */       Job job = (Job) vector.elementAt(b);
/* 159 */       job.setResource(Color.white);
/*     */     } 
/* 161 */     this.index = 0;
/* 162 */     this.constraintChecks = 0;
/* 163 */     this.deadEnds = 0;
/* 164 */     this.assignments = 0;
/* 165 */     this.alternatives = new Vector();
/* 166 */     switch (this.ARRANGEMENT) { case 0:
/* 167 */         sortAlphabetically(); break;
/* 168 */       case 1: sortByMostConstraint(); break;
/* 169 */       case 2: sortByLeastConstraint(); break;
/* 170 */       case 3: sortByBadNews(); break;
/* 171 */       default: System.out.println("Unrecognized arrangement"); break; }
/*     */     
/* 173 */     changed();
/*     */   }
/*     */   
/* 176 */   public MapNet() { this.alternatives = new Vector();
/*     */     
/* 178 */     this.index = 0;
/* 179 */     this.constraintChecks = 0;
/* 180 */     this.deadEnds = 0;
/* 181 */     this.assignments = 0; setType(0); setFrameRate(30); setResourceCount(4); setArrangement(0);
/*     */     setType(0);
/* 183 */     clear(); } public int getAssignmentCount() { return Math.max(0, this.index); }
/*     */    public int getAssignmentsMadeCount() {
/* 185 */     return this.assignments;
/*     */   } public int getConstraintCheckCount() {
/* 187 */     return this.constraintChecks;
/*     */   } public int getDeadEndCount() {
/* 189 */     return this.deadEnds;
/*     */   }
/*     */   public void search() {
/* 192 */     clear();
/* 193 */     this.searchThread = new MapThread();
/* 194 */     this.searchThread.start();
/*     */   }
/*     */   
/*     */   class MapThread extends SearchThread {
/*     */     
/*     */     public void run() {
/* 200 */       Vector vector = MapNet.this.getNodes();
/*     */       
/* 202 */       while (this.loop) {
/*     */         
/* 204 */         if (MapNet.this.index < 0) {
/* 205 */           System.out.println("Failed to find assignment!");
/*     */           return;
/*     */         } 
/* 208 */         if (MapNet.this.index == vector.size()) {
/* 209 */           MapNet.this.report();
/*     */           return;
/*     */         } 
/* 212 */         if (!this.pause) {
/*     */           
/* 214 */           for (int i = MapNet.this.alternatives.size(); i < vector.size(); i++) {
/* 215 */             Job job1 = (Job) vector.elementAt(i);
/* 216 */             job1.setResource(Color.white);
/*     */           } 
/*     */           
/* 219 */           Job job = (Job) vector.elementAt(MapNet.this.index);
/*     */           
/* 221 */           Vector vector1 = fetchDomain(MapNet.this.index);
/*     */           
/* 223 */           if (vector1.isEmpty()) {
/*     */             
/* 225 */             job.setResource(Color.white);
/* 226 */             MapNet.this.alternatives.setSize(MapNet.this.index);
/* 227 */             MapNet.this.deadEnds++;
/* 228 */             MapNet.this.index--;
/*     */           } else {
/*     */             
/* 231 */             Color color = selectFromDomain(vector1);
/* 232 */             job.setResource(color);
/*     */             
/* 234 */             if (MapNet.this.TYPE == -1) {
/*     */               
/* 236 */               MapNet.this.index++;
/*     */             }
/* 238 */             else if (checkLocalConsistency(job)) {
/*     */               
/* 240 */               MapNet.this.assignments++;
/*     */               
/* 242 */               if (MapNet.this.TYPE == 5) {
/* 243 */                 Vector vector2 = new Vector();
/* 244 */                 for (int j = MapNet.this.index + 1; j < vector.size(); j++) {
/* 245 */                   vector2.add(vector.elementAt(j));
/*     */                 }
/* 247 */                 if (MapNet.this.checkStates(vector2)) {
/* 248 */                   MapNet.this.index++;
/*     */                 }
/*     */               }
/* 251 */               else if (MapNet.this.TYPE == 0 || checkNeighbors(job)) {
/*     */                 
/* 253 */                 MapNet.this.index++;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 265 */         ChangeHandler changeHandler = new ChangeHandler(MapNet.this);
/* 266 */         SwingUtilities.invokeLater(changeHandler);
/* 267 */         try { sleep(MapNet.this.timeBetweenFrames); } catch (Exception exception) {}
/*     */       } 
/*     */     }
/*     */     private Vector fetchDomain(int param1Int) {
/* 271 */       if (param1Int < MapNet.this.alternatives.size()) return (Vector) MapNet.this.alternatives.elementAt(param1Int);
/*     */       
/* 273 */       addNewDomain();
/*     */       
/* 275 */       return fetchDomain(param1Int);
/*     */     }
/*     */     private void addNewDomain() {
/* 278 */       Vector vector = (Vector)MapNet.this.resourceValues.clone();
/* 279 */       MapNet.this.alternatives.add(vector);
/*     */     }
/*     */     private Color selectFromDomain(Vector param1Vector) {
/* 282 */       Color color = (Color) param1Vector.elementAt(MapNet.this.counter++ % param1Vector.size());
/* 283 */       param1Vector.remove(color);
/* 284 */       return color;
/*     */     }
/*     */     private boolean checkLocalConsistency(Job param1Job) {
/* 287 */       Vector vector = param1Job.getNeighbors();
/* 288 */       for (short b = 0; b < vector.size(); b++) {
/* 289 */         Job job = (Job) vector.elementAt(b);
/* 290 */         if (job.getResource().equals(param1Job.getResource())) {
/* 291 */           return false;
/*     */         }
/*     */       } 
/* 294 */       return true;
/*     */     }
/*     */     
/*     */     private boolean checkNeighbors(Job param1Job) {
/* 298 */       return MapNet.this.checkStates(MapNet.this.getUnassignedNeighbors(param1Job));
/*     */     } }
/*     */ 
/*     */   
/*     */   private Vector getUnassignedNeighbors(Job paramJob) {
/* 303 */     Vector vector = paramJob.getNeighbors();
/* 304 */     Vector vector1 = (Vector)vector.clone();
/* 305 */     for (short b = 0; b < vector.size(); b++) {
/* 306 */       Job job = (Job) vector.elementAt(b);
/* 307 */       if (this.resourceValues.contains(job.getResource()))
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 312 */         vector1.remove(job);
/*     */       }
/*     */     } 
/* 315 */     return vector1;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkStates(Vector paramVector) {
/* 320 */     Vector vector = new Vector(); short b;
/* 321 */     for (b = 0; b < paramVector.size(); b++) {
/* 322 */       vector.add((Vector)this.resourceValues.clone());
/*     */     }
/* 324 */     b = 1;
/*     */     
/* 326 */     while (b != 0) {
/* 327 */       b = 0;
/* 328 */       for (short b1 = 0; b1 < paramVector.size(); b1++) {
/* 329 */         boolean bool = false;
/*     */         
/* 331 */         Job job = (Job) paramVector.elementAt(b1);
/* 332 */         job.setResource(Color.lightGray);
/* 333 */         Vector vector1 = (Vector) vector.elementAt(b1);
/* 334 */         this.constraintChecks++;
/*     */         
/* 336 */         Vector vector2 = job.getNeighbors();
/*     */         
/* 338 */         for (short b2 = 0; b2 < vector2.size(); b2++) {
/* 339 */           Job job1 = (Job) vector2.elementAt(b2);
/*     */           
/* 341 */           Color color = job1.getResource();
/* 342 */           if (this.resourceValues.contains(color) && 
/* 343 */             vector1.remove(color)) {
/*     */             
/* 345 */             b = 1; bool = true;
/*     */           } 
/*     */ 
/*     */           
/* 349 */           int i = paramVector.indexOf(job1);
/* 350 */           if (i >= 0) {
/*     */             
/* 352 */             Vector vector3 = (Vector) vector.elementAt(i);
/* 353 */             if (vector3.size() == 1) {
/* 354 */               color = (Color) vector3.firstElement();
/* 355 */               if (vector1.remove(color)) {
/*     */                 
/* 357 */                 b = 1; bool = true;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 363 */         if (vector1.isEmpty()) return false;
/*     */         
/* 365 */         if (shouldPropagate(bool, vector1.size())) {
/* 366 */           Vector vector3 = getUnassignedNeighbors(job);
/* 367 */           for (short b3 = 0; b3 < vector3.size(); b3++) {
/* 368 */             Job job1 = (Job) vector3.elementAt(b3);
/* 369 */             if (!paramVector.contains(job1)) {
/*     */               
/* 371 */               paramVector.add(job1);
/* 372 */               vector.add((Vector)this.resourceValues.clone());
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 379 */     return true;
/*     */   }
/*     */   
/*     */   private boolean shouldPropagate(boolean paramBoolean, int paramInt) {
/* 383 */     if (this.TYPE == 1) return false; 
/* 384 */     if (this.TYPE == 2 && paramBoolean) return true; 
/* 385 */     if (this.TYPE == 3 && paramBoolean && paramInt == 1) return true; 
/* 386 */     return false;
/*     */   }
/*     */   
/*     */   public void sortAlphabetically() {
/* 390 */     TreeSet treeSet = new TreeSet(new AlphabeticalComparitor());
/* 391 */     treeSet.addAll(getNodes());
/* 392 */     Vector vector = new Vector(treeSet);
/* 393 */     setNodes(vector);
/*     */   }
/*     */   class AlphabeticalComparitor implements Comparator {
/*     */     
/*     */     public int compare(Object param1Object1, Object param1Object2) {
/* 398 */       Job job1 = (Job)param1Object1;
/* 399 */       Job job2 = (Job)param1Object2;
/* 400 */       return job1.getName().compareTo(job2.getName());
/*     */     } }
/*     */ 
/*     */   
/*     */   public void sortByMostConstraint() {
/* 405 */     TreeSet treeSet = new TreeSet(new MostConstraintComparitor());
/* 406 */     treeSet.addAll(getNodes());
/* 407 */     Vector vector = new Vector(treeSet);
/* 408 */     setNodes(vector);
/*     */   }
/*     */   class MostConstraintComparitor implements Comparator {
/*     */     
/*     */     public int compare(Object param1Object1, Object param1Object2) {
/* 413 */       Job job1 = (Job)param1Object1;
/* 414 */       Job job2 = (Job)param1Object2;
/* 415 */       int i = job1.getNeighbors().size();
/* 416 */       int j = job2.getNeighbors().size();
/* 417 */       if (i > j) return -1; 
/* 418 */       if (i < j) return 1; 
/* 419 */       return job1.getName().compareTo(job2.getName());
/*     */     } }
/*     */   
/*     */   public void sortByLeastConstraint() {
/* 423 */     TreeSet treeSet = new TreeSet(new LeastConstraintComparitor());
/* 424 */     treeSet.addAll(getNodes());
/* 425 */     Vector vector = new Vector(treeSet);
/* 426 */     setNodes(vector);
/*     */   }
/*     */   class LeastConstraintComparitor implements Comparator {
/*     */     
/*     */     public int compare(Object param1Object1, Object param1Object2) {
/* 431 */       Job job1 = (Job)param1Object1;
/* 432 */       Job job2 = (Job)param1Object2;
/* 433 */       int i = job1.getNeighbors().size();
/* 434 */       int j = job2.getNeighbors().size();
/* 435 */       if (i > j) return 1; 
/* 436 */       if (i < j) return -1; 
/* 437 */       return job1.getName().compareTo(job2.getName());
/*     */     } }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 442 */     MapNet mapNet = new MapNet();
/* 443 */     mapNet.readData("USA.DATA");
/* 444 */     System.out.println(mapNet.getNodes());
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\MapNet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */