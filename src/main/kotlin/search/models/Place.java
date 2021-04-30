/*    */ package search.models;
/*    */ import java.util.Random;
/*    */ import java.util.TreeMap;
/*    */ 
/*    */ public class Place {
/*    */   String name;
/*    */   double longitude;
/*    */   double latitude;
/*  9 */   static TreeMap places = new TreeMap();
/* 10 */   static Random generator = new Random();
/*    */   
/*    */   public Place(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 13 */     this(paramString, paramInt1 + paramInt2 / 60.0D, paramInt3 + paramInt4 / 60.0D);
/*    */   }
/*    */   
/*    */   public Place(String paramString, double paramDouble1, double paramDouble2) {
/* 17 */     this.name = paramString;
/* 18 */     this.longitude = paramDouble1;
/* 19 */     this.latitude = paramDouble2;
/* 20 */     places.put(this.name, this);
/*    */   }
/*    */   
/* 23 */   public double getLongitude() { return this.longitude; }
/* 24 */   public double getLatitude() { return this.latitude; } public String getName() {
/* 25 */     return this.name;
/*    */   }
/*    */   public static Place getPlace(String paramString) {
/* 28 */     return (Place)places.get(paramString);
/*    */   }
/*    */   
/*    */   public static Place getRandomPlace() {
/* 32 */     int i = generator.nextInt(places.size());
/* 33 */     return (Place)places.values().toArray()[i];
/*    */   }
/*    */   
/*    */   public static void main(String[] paramArrayOfString) {
/* 37 */     new Place("JFK", 40.65D, 73.78D);
/* 38 */     new Place("ORD", 41, 59, 87, 54);
/* 39 */     System.out.println(((Place)places.get("JFK")).getLongitude());
/* 40 */     System.out.println(getRandomPlace().getName());
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\Place.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */