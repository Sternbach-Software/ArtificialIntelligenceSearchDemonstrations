/*     */ package search.views;
/*     */ import java.awt.*;
/*     */
/*     */
/*     */ import javax.swing.JFrame;
/*     */ import logging.Logger;
/*     */ 
/*     */ public class ScheduleView extends NodeView {
/*   9 */   int intensity = 225; boolean showNameSwitch = false;
/*  10 */   Color fillColor = new Color(this.intensity, this.intensity, this.intensity);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShowNames(boolean paramBoolean) {
/*  17 */     this.showNameSwitch = paramBoolean;
/*     */   }
/*     */   public void addBlob(String paramString, double paramDouble1, double paramDouble2) {
/*  20 */     addBlob(paramString, Color.white, paramDouble1, paramDouble2);
/*     */   }
/*     */   
/*     */   public void addBlob(String paramString, Color paramColor, double paramDouble1, double paramDouble2) {
/*  24 */     adjustLimits(paramDouble1, 0.0D);
/*  25 */     adjustLimits(paramDouble1 + paramDouble2, 0.0D);
/*  26 */     this.nodes.add(new Blob(paramString, paramColor, paramDouble1, paramDouble2));
/*     */   }
/*     */   class Blob { double start; double width;
/*     */     String name;
/*     */     Color color;
/*     */     
/*     */     public Blob(String param1String, Color param1Color, double param1Double1, double param1Double2) {
/*  34 */       this.name = param1String;
/*  35 */       this.color = param1Color;
/*  36 */       this.start = param1Double1;
/*  37 */       this.width = param1Double2;
/*     */     }
/*  39 */     public double getStart() { return this.start; }
/*  40 */     public double getWidth() { return this.width; }
/*  41 */     public String getName() { return this.name; } public Color getColor() {
/*  42 */       return this.color;
/*     */     } }
/*     */   
/*     */   public void clear() {
/*  46 */     super.clear();
/*  47 */     this.limitsInitialized = false;
/*  48 */     repaint();
/*     */   }
/*     */   
/*     */   protected void drawNodes(Graphics2D paramGraphics2D) {
/*  52 */     if (this.nodes.isEmpty())
/*  53 */       return;  paramGraphics2D.setStroke(new BasicStroke(2.0F));
/*  54 */     Font font1 = paramGraphics2D.getFont();
/*  55 */     if (this.circleRadius == 0) this.circleRadius = 10; 
/*  56 */     fine("Font height will be " + this.circleRadius);
/*     */     
/*  58 */     Font font2 = new Font("Roman", 1, this.circleRadius);
/*  59 */     paramGraphics2D.setFont(font2);
/*  60 */     FontMetrics fontMetrics = paramGraphics2D.getFontMetrics();
/*     */     
/*  62 */     int i = getWidth();
/*  63 */     int j = getHeight();
/*  64 */     int k = i * 9 / 10;
/*  65 */     int m = j * 65 / 100;
/*  66 */     int n = (i - k) / 2;
/*  67 */     int i1 = j * 3 / 10;
/*  68 */     int i2 = this.nodes.size();
/*  69 */     int i3 = m / i2;
/*     */     
/*  71 */     paramGraphics2D.setColor(this.fillColor);
/*  72 */     paramGraphics2D.fillRect(n, i1, k, m);
/*     */     
/*  74 */     fine("Limits: " + this.minX + ", " + this.maxX);
/*  75 */     for (short b = 0; b < this.nodes.size(); b++) {
/*  76 */       Blob blob = (Blob)this.nodes.elementAt(b);
/*  77 */       if (blob instanceof Blob) {
/*  78 */         Blob blob1 = blob;
/*  79 */         int i4 = (int)(k * (blob1.getStart() - this.minX) / (this.maxX - this.minX));
/*  80 */         int i5 = (int)(k * blob1.getWidth() / (this.maxX - this.minX));
/*  81 */         paramGraphics2D.setColor(blob1.getColor());
/*  82 */         int i6 = b * m / i2;
/*  83 */         paramGraphics2D.fillRect(n + i4, i1 + i6, i5, i3);
/*  84 */         paramGraphics2D.setColor(Color.black);
/*  85 */         paramGraphics2D.drawRect(n + i4, i1 + i6, i5, i3);
/*  86 */         paramGraphics2D.drawRect(n, i1 + i6, k, i3);
/*  87 */         if (this.showNameSwitch && blob1.getName() != null) {
/*  88 */           int i7 = n + i4 + i5 / 2;
/*  89 */           int i8 = i1 + i6 + i3 / 2;
/*  90 */           String str = blob1.getName();
/*  91 */           i8 += fontMetrics.getHeight() / 2;
/*  92 */           i7 -= fontMetrics.stringWidth(str) / 2;
/*  93 */           paramGraphics2D.drawString(str, i7, i8);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void fine(Object paramObject) {
/* 100 */     Logger.getLogger("search.views.ScheduleView").fine(paramObject);
/*     */   }
/*     */   public static void info(Object paramObject) {
/* 103 */     Logger.getLogger("search.views.ScheduleView").info(paramObject);
/*     */   }
/*     */   public static void warning(Object paramObject) {
/* 106 */     Logger.getLogger("search.views.ScheduleView").warning(paramObject);
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 110 */     ScheduleView scheduleView = new ScheduleView();
/* 111 */     scheduleView.addBlob("S", Color.RED, 0.0D, 10.0D);
/* 112 */     scheduleView.addBlob("T", Color.YELLOW, 5.0D, 20.0D);
/* 113 */     scheduleView.addBlob("T", Color.GREEN, 7.5D, 20.0D);
/* 114 */     scheduleView.addBlob("T", Color.BLUE, 10.0D, 30.0D);
/* 115 */     scheduleView.addBlob("T", Color.PINK, 0.0D, 40.0D);
/* 116 */     scheduleView.setShowNames(true);
/* 117 */     JFrame jFrame = new JFrame();
/* 118 */     jFrame.setSize(400, 400);
/* 119 */     jFrame.addWindowListener(new ApplicationCloser());
/* 120 */     jFrame.getContentPane().add(scheduleView);
/* 121 */     jFrame.show();
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\views\ScheduleView.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */