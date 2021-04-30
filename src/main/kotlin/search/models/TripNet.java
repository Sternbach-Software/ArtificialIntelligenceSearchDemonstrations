/*     */ package search.models;
/*     */ 
/*     */ import java.util.Random;
/*     */ import java.util.Vector;
/*     */ import logging.Logger;
/*     */ 
/*     */ public class TripNet
/*     */   extends MapNet
/*     */ {
/*  10 */   double groundTime = 0.75D;
/*     */   
/*     */   Random generator;
/*     */   
/*     */   double start;
/*     */   
/*     */   double duration;
/*     */   
/*     */   double latestStart;
/*     */   
/*     */   double minimumDuration;
/*     */   
/*     */   double maximumDuration;
/*     */   
/*     */   public void constructRandomFlightTestSet() {
/*  25 */     clearModel();
/*  26 */     for (short b = 0; b < 20; b++) {
/*  27 */       addNode(Trip.getRandomTrip());
/*     */     }
/*  29 */     changed();
/*     */   }
/*     */   
/*     */   public void constructElementaryFlightTestSet() {
/*  33 */     clearModel();
/*  34 */     addNode(new Trip("F-A-BOS-JFK", "BOS", "JFK", 12.0D));
/*  35 */     addNode(new Trip("F-B-JFK-BOS", "JFK", "BOS", 13.0D));
/*  36 */     addNode(new Trip("F-C-BOS-JFK", "BOS", "JFK", 14.0D));
/*  37 */     addNode(new Trip("F-D-JFK-BOS", "JFK", "BOS", 15.0D));
/*  38 */     addNode(new Trip("F-E-BOS-LAX", "BOS", "LAX", 12.0D));
/*  39 */     changed();
/*     */   }
/*     */   public void constructSimpleTestSet() {
/*  42 */     addNode(new Action("Job 1", 0.0D, 1.0D));
/*  43 */     clearModel();
/*  44 */     Action action1 = new Action("Job A", 0.0D, 1.0D);
/*  45 */     Action action2 = new Action("Job B", 1.0D, 1.0D);
/*  46 */     Action action3 = new Action("Job C", 2.0D, 1.0D);
/*  47 */     Action action4 = new Action("Job D", 3.0D, 1.0D);
/*  48 */     Action action5 = new Action("Job E", 0.0D, 7.0D);
/*  49 */     addNode(action1);
/*  50 */     addNode(action2);
/*  51 */     addNode(action3);
/*  52 */     addNode(action4);
/*  53 */     addNode(action5);
/*  54 */     changed();
/*     */   }
/*     */   public void constructHardTestSet() {
/*  57 */     clearModel();
/*  58 */     addNode(new Action("Job A", 0.0D, 1.0D));
/*  59 */     addNode(new Action("Job B", 1.0D, 1.0D));
/*  60 */     addNode(new Action("Job C", 2.0D, 1.0D));
/*  61 */     addNode(new Action("Job D", 3.0D, 1.0D));
/*  62 */     addNode(new Action("Job E", 4.0D, 1.0D));
/*  63 */     addNode(new Action("Job F", 5.0D, 1.0D));
/*  64 */     addNode(new Action("Job G", 6.0D, 1.0D));
/*  65 */     addNode(new Action("Job H", 7.0D, 1.0D));
/*  66 */     addNode(new Action("Job I", 8.0D, 1.0D));
/*  67 */     addNode(new Action("Job J", 9.0D, 1.0D));
/*  68 */     addNode(new Action("Job K", 10.0D, 1.0D));
/*  69 */     addNode(new Action("Job L", 11.0D, 1.0D));
/*  70 */     addNode(new Action("Job M", 12.0D, 1.0D));
/*  71 */     addNode(new Action("Job N", 13.0D, 1.0D));
/*  72 */     addNode(new Action("Job O", 14.0D, 1.0D));
/*  73 */     addNode(new Action("Job P", 15.0D, 1.0D));
/*  74 */     addNode(new Action("Job Q", 16.0D, 1.0D));
/*  75 */     addNode(new Action("Job R", 17.0D, 1.0D));
/*  76 */     addNode(new Action("Job S", 18.0D, 1.0D));
/*  77 */     addNode(new Action("Job T", 19.0D, 1.0D));
/*  78 */     addNode(new Action("Job U", 20.0D, 1.0D));
/*  79 */     addNode(new Action("Job V", 21.0D, 1.0D));
/*  80 */     addNode(new Action("Job W", 22.0D, 1.0D));
/*  81 */     addNode(new Action("Job X", 23.0D, 1.0D));
/*  82 */     addNode(new Action("Job Y", 24.0D, 1.0D));
/*  83 */     addNode(new Action("Job Z", 0.0D, 25.0D));
/*  84 */     changed();
/*     */   }
/*     */   public void constructRandomTestSet() {
/*  87 */     clearModel();
/*  88 */     addNode(new Action("Job A", randomS(), randomD()));
/*  89 */     addNode(new Action("Job B", randomS(), randomD()));
/*  90 */     addNode(new Action("Job C", randomS(), randomD()));
/*  91 */     addNode(new Action("Job D", randomS(), randomD()));
/*  92 */     addNode(new Action("Job E", randomS(), randomD()));
/*  93 */     addNode(new Action("Job F", randomS(), randomD()));
/*  94 */     addNode(new Action("Job G", randomS(), randomD()));
/*  95 */     addNode(new Action("Job H", randomS(), randomD()));
/*  96 */     addNode(new Action("Job I", randomS(), randomD()));
/*  97 */     addNode(new Action("Job J", randomS(), randomD()));
/*  98 */     addNode(new Action("Job K", randomS(), randomD()));
/*  99 */     addNode(new Action("Job L", randomS(), randomD()));
/* 100 */     addNode(new Action("Job M", randomS(), randomD()));
/* 101 */     addNode(new Action("Job N", randomS(), randomD()));
/* 102 */     addNode(new Action("Job O", randomS(), randomD()));
/* 103 */     addNode(new Action("Job P", randomS(), randomD()));
/* 104 */     addNode(new Action("Job Q", randomS(), randomD()));
/* 105 */     addNode(new Action("Job R", randomS(), randomD()));
/* 106 */     addNode(new Action("Job S", randomS(), randomD()));
/* 107 */     addNode(new Action("Job T", randomS(), randomD()));
/* 108 */     addNode(new Action("Job U", randomS(), randomD()));
/* 109 */     addNode(new Action("Job V", randomS(), randomD()));
/* 110 */     addNode(new Action("Job W", randomS(), randomD()));
/* 111 */     addNode(new Action("Job X", randomS(), randomD()));
/* 112 */     addNode(new Action("Job Y", randomS(), randomD()));
/* 113 */     addNode(new Action("Job Z", randomS(), randomD()));
/* 114 */     changed();
/*     */   }
/*     */   
/* 117 */   public TripNet() { this.generator = new Random();
/*     */ 
/*     */     
/* 120 */     this.latestStart = 90.0D;
/* 121 */     this.minimumDuration = 1.0D;
/* 122 */     this.maximumDuration = 10.0D; new Place("BOS", 42.35D, 71.05D); new Place("LAX", 34.07D, 118.25D); new Place("JFK", 40.65D, 73.78D); new Place("ORD", 41, 59, 87, 54); new Place("PIA", 40, 40, 89, 41);
/*     */     new Place("MSY", 29, 57, 90, 4);
/*     */     new Place("YZD", 43, 44, 79, 27);
/* 125 */     new Place("ZTY", 39, 53, 75, 14); } private double randomS() { this.start = (int)((this.latestStart - this.minimumDuration) * this.generator.nextDouble());
/* 126 */     return this.start; }
/*     */ 
/*     */   
/*     */   private double randomD() {
/* 130 */     this.duration = this.minimumDuration + (this.maximumDuration - this.minimumDuration) * this.generator.nextDouble();
/* 131 */     this.duration = (int)Math.min(this.duration, this.latestStart + this.maximumDuration - this.start);
/* 132 */     return this.duration;
/*     */   }
/*     */   private void clearModel() {
/* 135 */     this.nodes.clear();
/*     */   }
/*     */   public void addNeighbor(Action paramAction1, Action paramAction2) {
/* 138 */     paramAction1.addNeighbor(paramAction2);
/* 139 */     paramAction2.addNeighbor(paramAction1);
/*     */   }
/*     */   public void addNode(Action paramAction) {
/* 142 */     addNode((BasicNode)paramAction);
/* 143 */     addConnections(paramAction);
/*     */   }
/*     */   
/*     */   private void addConnections(Job paramJob) {
/* 147 */     if (paramJob instanceof Trip) {
/* 148 */       addTripConnections((Trip)paramJob);
/*     */     }
/* 150 */     else if (paramJob instanceof Action) {
/* 151 */       addActionConnections((Action)paramJob);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addTripConnections(Trip paramTrip) {
/* 156 */     Vector vector = getNodes();
/* 157 */     for (short b = 0; b < vector.size(); b++) {
/* 158 */       Trip trip = (Trip) vector.get(b);
/* 159 */       if (!trip.equals(paramTrip) && tripOverlap(trip, paramTrip)) {
/* 160 */         fine("Connecting " + trip + "--" + paramTrip);
/* 161 */         addNeighbor(trip, paramTrip);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean tripOverlap(Trip paramTrip1, Trip paramTrip2) {
/* 167 */     double d1 = paramTrip1.getStart();
/* 168 */     double d2 = paramTrip2.getStart();
/* 169 */     double d3 = paramTrip1.getDuration();
/* 170 */     double d4 = paramTrip2.getDuration();
/* 171 */     double d5 = Trip.time(paramTrip1.getDestination(), paramTrip2.getOrigin());
/* 172 */     double d6 = Trip.time(paramTrip2.getDestination(), paramTrip1.getOrigin());
/* 173 */     if (d1 + d3 + d5 + this.groundTime < d2) {
/* 174 */       return false;
/*     */     }
/* 176 */     if (d2 + d4 + d6 + this.groundTime < d1) {
/* 177 */       return false;
/*     */     }
/* 179 */     fine(paramTrip1 + " overlaps " + paramTrip2);
/* 180 */     return true;
/*     */   }
/*     */   
/*     */   private void addActionConnections(Action paramAction) {
/* 184 */     Vector vector = getNodes();
/* 185 */     for (short b = 0; b < vector.size(); b++) {
/* 186 */       Action action = (Action) vector.get(b);
/* 187 */       if (!action.equals(paramAction) && actionOverlap(action, paramAction)) {
/* 188 */         fine("Connecting " + action + "--" + paramAction);
/* 189 */         addNeighbor(action, paramAction);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean actionOverlap(Action paramAction1, Action paramAction2) {
/* 195 */     double d1 = paramAction1.getStart();
/* 196 */     double d2 = paramAction2.getStart();
/* 197 */     double d3 = paramAction1.getDuration();
/* 198 */     double d4 = paramAction2.getDuration();
/* 199 */     if (d1 + d3 * 1.0D < d2 || d2 + d4 * 1.0D < d1) {
/* 200 */       return false;
/*     */     }
/* 202 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void fine(Object paramObject) {
/* 207 */     Logger.getLogger("search.models.TripNet").fine(paramObject);
/*     */   }
/*     */   public static void info(Object paramObject) {
/* 210 */     Logger.getLogger("search.models.TripNet").info(paramObject);
/*     */   }
/*     */   public static void warning(Object paramObject) {
/* 213 */     Logger.getLogger("search.models.TripNet").warning(paramObject);
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 217 */     TripNet tripNet = new TripNet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 223 */     System.out.println(Trip.distance("BOS", "LAX"));
/* 224 */     System.out.println(Trip.distance("BOS", "JFK"));
/* 225 */     System.out.println(Trip.distance("BOS", "BOS"));
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\TripNet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */