/*     */ package search.views;
/*     */ import logging.Logger;

import java.awt.*;
/*     */
/*     */
/*     */
/*     */
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class BlobView extends NodeView {
/*     */   public BlobView() {
/*  11 */     this.xTranslationMultiplier = 0.5D;
/*  12 */     this.yTranslationMultiplier = 0.65D;
/*  13 */     this.circleRadius = 10;
/*     */   } boolean showNameSwitch = false; public void setShowNames(boolean paramBoolean) {
/*  15 */     this.showNameSwitch = paramBoolean;
/*     */   }
/*     */   public void addBlob(String paramString, Polygon paramPolygon) {
/*  18 */     addBlob(paramString, Color.white, paramPolygon);
/*     */   }
/*     */   
/*     */   public void addBlob(String paramString, Color paramColor, Polygon paramPolygon) {
/*  22 */     Polygon polygon = paramPolygon;
/*  23 */     Rectangle rectangle = paramPolygon.getBounds();
/*  24 */     adjustLimits((int)rectangle.getMaxX(), (int)rectangle.getMaxY());
/*  25 */     adjustLimits((int)rectangle.getMinX(), (int)rectangle.getMinY());
/*  26 */     this.nodes.add(new Blob(paramString, paramColor, paramPolygon));
/*     */   }
/*     */   class Blob { Polygon polygon;
/*     */     String name;
/*     */     Color color;
/*     */
/*     */     
/*     */     public Blob(String param1String, Color param1Color, Polygon param1Polygon) {
/*  34 */       this.name = param1String;
/*  35 */       this.color = param1Color;
/*  36 */       this.polygon = param1Polygon;
/*     */     }
/*  38 */     public Polygon getPolygon() { return this.polygon; }
/*  39 */     public String getName() { return this.name; } public Color getColor() {
/*  40 */       return this.color;
/*     */     } }
/*     */   
/*     */   protected void drawNodes(Graphics2D paramGraphics2D) {
/*  44 */     paramGraphics2D.setStroke(new BasicStroke(2.0F));
/*  45 */     Font font1 = paramGraphics2D.getFont();
/*  46 */     if (this.circleRadius == 0) this.circleRadius = 10;
/*     */     
/*  48 */     Font font2 = new Font("Roman", font1.getStyle(), this.circleRadius);
/*  49 */     paramGraphics2D.setFont(font2);
/*  50 */     FontMetrics fontMetrics = paramGraphics2D.getFontMetrics();
/*     */     
/*  52 */     for (short b = 0; b < this.nodes.size(); b++) {
/*  53 */       Blob blob = (Blob)this.nodes.elementAt(b);
/*  54 */       if (blob instanceof Blob) {
/*  55 */         Blob blob1 = blob;
/*  56 */         Polygon polygon = mapPolygon(blob1.getPolygon());
/*  57 */         paramGraphics2D.setColor(blob1.getColor());
/*  58 */         paramGraphics2D.fill(polygon);
/*  59 */         paramGraphics2D.setColor(Color.black);
/*  60 */         fine("Drawing " + polygon.getBounds().getLocation() + "/" + polygon.getBounds().getSize());
/*  61 */         paramGraphics2D.draw(polygon);
/*  62 */         if (this.showNameSwitch) {
/*  63 */           Point point = polygon.getBounds().getLocation();
/*  64 */           Dimension dimension = polygon.getBounds().getSize();
/*  65 */           int i = (int)(point.getX() + dimension.getWidth() / 2.0D);
/*  66 */           int j = (int)(point.getY() + dimension.getHeight() / 2.0D);
/*  67 */           String str = blob1.getName();
/*  68 */           j += fontMetrics.getHeight() / 2;
/*  69 */           i -= fontMetrics.stringWidth(str) / 2;
/*  70 */           paramGraphics2D.drawString(str, i, j);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private Polygon mapPolygon(Polygon paramPolygon) {
/*  77 */     int[] arrayOfInt1 = paramPolygon.xpoints;
/*  78 */     int[] arrayOfInt2 = paramPolygon.ypoints;
/*  79 */     int[] arrayOfInt3 = new int[arrayOfInt1.length];
/*  80 */     int[] arrayOfInt4 = new int[arrayOfInt2.length];
/*  81 */     for (short b = 0; b < arrayOfInt1.length; b++) {
/*  82 */       arrayOfInt3[b] = mapX(arrayOfInt1[b]);
/*  83 */       arrayOfInt4[b] = mapY(arrayOfInt2[b]);
/*     */     } 
/*  85 */     return new Polygon(arrayOfInt3, arrayOfInt4, arrayOfInt1.length);
/*     */   }
/*     */   
/*     */   public static void fine(Object paramObject) {
/*  89 */     Logger.getLogger("search.views.BlobView").fine(paramObject);
/*     */   }
/*     */   public static void info(Object paramObject) {
/*  92 */     Logger.getLogger("search.views.BlobView").info(paramObject);
/*     */   }
/*     */   public static void warning(Object paramObject) {
/*  95 */     Logger.getLogger("search.views.BlobView").warning(paramObject);
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*  99 */     BlobView blobView = new BlobView();
/* 100 */     int[] arrayOfInt1 = { 0, 10, 10, 0 };
/* 101 */     int[] arrayOfInt2 = { 0, 0, 10, 10 };
/* 102 */     Polygon polygon = new Polygon(arrayOfInt1, arrayOfInt2, 4);
/* 103 */     blobView.addBlob("S", Color.RED, polygon);
/* 104 */     int[] arrayOfInt3 = { 10, 20, 20, 10 };
/* 105 */     int[] arrayOfInt4 = { 10, 10, 20, 20 };
/* 106 */     polygon = new Polygon(arrayOfInt3, arrayOfInt4, 4);
/* 107 */     blobView.addBlob("T", Color.YELLOW, polygon);
/*     */     
/* 109 */     JFrame jFrame = new JFrame();
/* 110 */     jFrame.setSize(400, 400);
/* 111 */     jFrame.addWindowListener(new ApplicationCloser());
/* 112 */     jFrame.getContentPane().add(blobView);
/* 113 */     jFrame.show();
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\views\BlobView.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */