/*    */ package search.models;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.util.Random;
/*    */ import logging.Logger;
/*    */ 
/*    */ public class Trip
/*    */   extends Action implements Job {
/*  9 */   private static double speed = 500.0D;
/* 10 */   Color resource = Color.WHITE; String origin;
/*    */   String destination;
/* 12 */   static int period = 18; private static final float Rad = 2.9088822E-4F;
/*    */   public Trip(String paramString1, String paramString2, String paramString3, double paramDouble) {
/* 14 */     this.name = paramString1;
/* 15 */     this.origin = paramString2;
/* 16 */     this.destination = paramString3;
/* 17 */     this.start = paramDouble;
/* 18 */     this.duration = time(paramString2, paramString3);
/* 19 */     info("From " + paramString2 + " to " + paramString3 + ", " + distance(paramString2, paramString3) + " miles, " + this.duration + " hrs");
/*    */   }
/* 21 */   public double getDuration() { return this.duration; }
/* 22 */   public String getOrigin() { return this.origin; } public String getDestination() {
/* 23 */     return this.destination;
/*    */   }
/* 25 */   public void setResource(Color paramColor) { this.resource = paramColor; } public Color getResource() {
/* 26 */     return this.resource;
/*    */   }
/*    */ 
/*    */   
/*    */   public static double time(String paramString1, String paramString2) {
/* 31 */     return distance(paramString1, paramString2) / speed;
/*    */   }
/*    */   
/*    */   public static int distance(String paramString1, String paramString2) {
/* 35 */     Place place1 = Place.getPlace(paramString1);
/* 36 */     Place place2 = Place.getPlace(paramString2);
/* 37 */     return degreeDistance(place1.getLatitude(), place1.getLongitude(), place2.getLatitude(), place2.getLongitude());
/*    */   }
/*    */   
/*    */   public static int degreeDistance(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 41 */     return minuteDistance((int)(60.0D * paramDouble1), (int)(60.0D * paramDouble2), (int)(60.0D * paramDouble3), (int)(60.0D * paramDouble4));
/*    */   }
/*    */   
/*    */   public static int minuteDistance(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 45 */     float f = (float)(Math.cos((paramInt1 * 2.9088822E-4F)) * Math.cos((paramInt3 * 2.9088822E-4F)) * Math.cos(((paramInt2 - paramInt4) * 2.9088822E-4F)) + Math.sin((paramInt1 * 2.9088822E-4F)) * Math.sin((paramInt3 * 2.9088822E-4F)));
/* 46 */     if (f >= 1.0F) return 0; 
/* 47 */     if (f < -1.0F) return 20012; 
/* 48 */     return (int)Math.round(6370.0D * Math.acos(f) * 0.62D);
/*    */   }
/*    */   
/* 51 */   static Random generator = new Random();
/* 52 */   static int tripNumber = 0;
/*    */   public static void resetTripNumber() {
/* 54 */     tripNumber = 0;
/*    */   }
/*    */   public static Trip getRandomTrip() {
/* 57 */     if (Place.places.size() < 2) {
/* 58 */       warning("Cannot get trip unless there are at least two cities!");
/* 59 */       return null;
/*    */     } 
/* 61 */     Place place1 = Place.getRandomPlace();
/*    */     Place place2;
/* 63 */     while ((place2 = Place.getRandomPlace()) == place1) {
/* 64 */       fine("Repeating ....");
/*    */     }
/* 66 */     String str1 = place1.getName();
/* 67 */     String str2 = place2.getName();
/* 68 */     return new Trip("F-" + tripChar(tripNumber++) + "-" + str1 + "-" + str2, str1, str2, generator.nextInt(period));
/*    */   }
/*    */   private static char tripChar(int paramInt) {
/* 71 */     return (char)(paramInt + 65);
/*    */   }
/*    */   public static void fine(Object paramObject) {
/* 74 */     Logger.getLogger("search.models.Trip").fine(paramObject);
/*    */   }
/*    */   public static void info(Object paramObject) {
/* 77 */     Logger.getLogger("search.models.Trip").info(paramObject);
/*    */   }
/*    */   public static void warning(Object paramObject) {
/* 80 */     Logger.getLogger("search.models.Trip").warning(paramObject);
/*    */   }
/*    */   
/*    */   public static void main(String[] paramArrayOfString) {
/* 84 */     new Place("BOS", 42.35D, 71.05D);
/* 85 */     new Place("LAX", 34.07D, 118.25D);
/* 86 */     new Place("JFK", 40.65D, 73.78D);
/* 87 */     new Place("ORD", 41, 59, 87, 54);
/* 88 */     System.out.println(distance("BOS", "LAX"));
/* 89 */     System.out.println(distance("JFK", "ORD"));
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\Trip.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */