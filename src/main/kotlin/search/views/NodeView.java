/*     */ package search.views;
/*     */ import logging.Logger;

import java.awt.*;
/*     */
/*     */
/*     */
/*     */
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.util.Vector;
/*     */ import javax.swing.*;

/*     */
/*     */ public class NodeView extends JPanel {
/*  12 */   Vector nodes = new Vector();
/*  13 */   Vector lines = new Vector();
/*     */   AffineTransform transform;
/*  15 */   Vector messages = new Vector(); double maxX;
/*     */   double minX;
/*     */   double maxY;
/*     */   double minY;
/*     */   protected boolean limitsInitialized = false;
/*  20 */   protected double windowFraction = 0.9D; int hHandle;
/*     */   int wHandle;
/*     */   int nHandle;
/*     */   protected int circleRadius;
/*     */   int nodeRadius;
/*     */   protected double xTranslationMultiplier;
/*     */   
/*     */   public void addCircle(int paramInt1, int paramInt2) {
/*  28 */     adjustLimits(paramInt1, paramInt2);
/*  29 */     this.nodes.add(new Circle(paramInt1, paramInt2));
/*     */   } protected double yTranslationMultiplier; double scale; double translateX; double translateY; double retranslateX; double retranslateY;
/*     */   public void addColoredCircle(Color paramColor, int paramInt1, int paramInt2) {
/*  32 */     adjustLimits(paramInt1, paramInt2);
/*  33 */     this.nodes.add(new ColoredCircle(paramColor, paramInt1, paramInt2));
/*     */   }
/*     */   public void addCircle(String paramString, int paramInt1, int paramInt2) {
/*  36 */     adjustLimits(paramInt1, paramInt2);
/*  37 */     this.nodes.add(new NamedCircle(paramString, paramInt1, paramInt2));
/*     */   }
/*     */   public void addCircle(String paramString, Color paramColor, int paramInt1, int paramInt2) {
/*  40 */     adjustLimits(paramInt1, paramInt2);
/*  41 */     NamedCircle namedCircle = new NamedCircle(paramString, paramInt1, paramInt2);
/*  42 */     namedCircle.setColor(paramColor);
/*  43 */     this.nodes.add(namedCircle);
/*     */   }
/*     */   public void addCircle(String paramString, Color paramColor1, Color paramColor2, int paramInt1, int paramInt2) {
/*  46 */     adjustLimits(paramInt1, paramInt2);
/*  47 */     NamedCircle namedCircle = new NamedCircle(paramString, paramInt1, paramInt2);
/*  48 */     namedCircle.setColor(paramColor1);
/*  49 */     namedCircle.setBackgroundColor(paramColor2);
/*  50 */     this.nodes.add(namedCircle);
/*     */   }
/*     */   
/*     */   protected void adjustLimits(int paramInt1, int paramInt2) {
/*  54 */     adjustLimits(Integer.valueOf(paramInt1).doubleValue(), Integer.valueOf(paramInt2).doubleValue());
/*     */   }
/*     */   protected void adjustLimits(double paramDouble1, double paramDouble2) {
/*  57 */     fine("Input: " + paramDouble1 + ", " + paramDouble2);
/*  58 */     if (!this.limitsInitialized) {
/*  59 */       this.maxX = this.minX = paramDouble1;
/*  60 */       this.maxY = this.minY = paramDouble2;
/*  61 */       this.limitsInitialized = true;
/*     */       return;
/*     */     } 
/*  64 */     if (paramDouble1 > this.maxX) { this.maxX = paramDouble1; }
/*  65 */     else if (paramDouble1 < this.minX) { this.minX = paramDouble1; }
/*  66 */      if (paramDouble2 > this.maxY) { this.maxY = paramDouble2; }
/*  67 */     else if (paramDouble2 < this.minY) { this.minY = paramDouble2; }
/*  68 */      fine("Limits: " + this.minX + ", " + this.maxX + "; " + this.minY + ", " + this.maxY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  75 */     addLine(new Line(paramInt1, paramInt2, paramInt3, paramInt4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLine(Color paramColor, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  83 */     addLine(new Line(paramColor, paramInt1, paramInt2, paramInt3, paramInt4));
/*     */   }
/*     */   public void addLine(Line paramLine) {
/*  86 */     if (!this.lines.contains(paramLine)) this.lines.add(paramLine); 
/*     */   }
/*     */   public void resetMessages() {
/*  89 */     this.messages.clear();
/*     */   }
/*     */   public void addMessage(String paramString) {
/*  92 */     this.messages.add(paramString);
/*     */   }
/*     */   public void clear() {
/*  95 */     this.messages.clear();
/*  96 */     this.nodes.clear();
/*  97 */     this.lines.clear();
/*  98 */     repaint();
/*     */   }
/*     */   
/*     */   protected class Circle { int x;
/*     */     int y;
/* 103 */     Color color = Color.black;
/* 104 */     Color background = Color.white;
/* 105 */     public Circle(int param1Int1, int param1Int2) { this.x = param1Int1; this.y = param1Int2; }
/* 106 */     public int getX() { return this.x; }
/* 107 */     public int getY() { return this.y; }
/* 108 */     public void setColor(Color param1Color) { this.color = param1Color; }
/* 109 */     public Color getColor() { return this.color; }
/* 110 */     public void setBackgroundColor(Color param1Color) { this.background = param1Color; } public Color getBackgroundColor() {
/* 111 */       return this.background;
/*     */     } }
/*     */   protected class NamedCircle extends Circle { String text;
/*     */     public NamedCircle(String param1String, int param1Int1, int param1Int2) {
/* 115 */       super(param1Int1, param1Int2); this.text = param1String;
/*     */     } } protected class ColoredCircle extends Circle {
/*     */     public ColoredCircle(Color param1Color, int param1Int1, int param1Int2) {
/* 118 */       super(param1Int1, param1Int2); this.color = param1Color;
/*     */     } }
/*     */   protected class Line { int x1; int x2;
/*     */     int y1;
/*     */     int y2;
/* 123 */     Color color = Color.lightGray;
/* 124 */     public Line(int param1Int1, int param1Int2, int param1Int3, int param1Int4) { this.x1 = param1Int1; this.y1 = param1Int2; this.x2 = param1Int3; this.y2 = param1Int4; } public Line(Color param1Color, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 125 */       this(param1Int1, param1Int2, param1Int3, param1Int4); this.color = param1Color;
/*     */     } public boolean equals(Object param1Object) {
/* 127 */       if (!(param1Object instanceof Line)) return false; 
/* 128 */       Line line = (Line)param1Object;
/* 129 */       if (this.x1 == line.x1 && this.x2 == line.x2 && this.y1 == line.y1 && this.y2 == line.y2 && this.color.equals(line.color)) {
/* 130 */         return true;
/*     */       }
/* 132 */       return false;
/*     */     } }
/*     */   
/*     */   public AffineTransform getTransform() {
/* 136 */     return this.transform;
/*     */   }
/*     */   public AffineTransform getInverseTransform() {
/* 139 */     AffineTransform affineTransform = null; 
/* 140 */     try { affineTransform = this.transform.createInverse(); } catch (Exception exception) {}
/* 141 */     return affineTransform;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paint(Graphics paramGraphics) {
/* 154 */     super.paint(paramGraphics);
/*     */     
/* 156 */     Dimension dimension = getSize();
/* 157 */     int i = dimension.width, j = dimension.height;
/* 158 */     if (j == 0 || i == 0)
/* 159 */       return;  paintMessages(paramGraphics);
/* 160 */     paintNodes(paramGraphics);
/*     */   }
/*     */   
/*     */   public void paintMessages(Graphics paramGraphics) {
/* 164 */     Dimension dimension = getSize();
/* 165 */     int i = dimension.height;
/* 166 */     int j = dimension.width;
/* 167 */     if (i == 0 || j == 0)
/* 168 */       return;  Font font1 = paramGraphics.getFont();
/* 169 */     Font font2 = new Font("Roman", font1.getStyle(), i / 30);
/* 170 */     paramGraphics.setFont(font2);
/* 171 */     FontMetrics fontMetrics = paramGraphics.getFontMetrics();
/* 172 */     int k = fontMetrics.getHeight();
/* 173 */     int m = i / 25;
/* 174 */     int n = j / 30;
/* 175 */     for (short b = 0; b < this.messages.size(); b++) {
/* 176 */       String str = (String) this.messages.elementAt(b);
/* 177 */       paramGraphics.drawString(str, n, m);
/* 178 */       m += k;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NodeView() {
/* 187 */     this.hHandle = 0;
/* 188 */     this.wHandle = 0;
/* 189 */     this.nHandle = 0;
/* 190 */     this.circleRadius = 0;
/* 191 */     this.nodeRadius = 0;
/*     */ 
/*     */     
/* 194 */     this.xTranslationMultiplier = 0.5D;
/* 195 */     this.yTranslationMultiplier = 0.5D;
/*     */     setOpaque(true);
/*     */     setBackground(Color.white);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void paintNodes(Graphics paramGraphics) {
/* 203 */     Dimension dimension = getSize();
/* 204 */     int i = dimension.width;
/* 205 */     int j = dimension.height;
/* 206 */     if (j == 0 || i == 0)
/*     */       return; 
/* 208 */     Graphics2D graphics2D = (Graphics2D)paramGraphics;
/* 209 */     if (this.hHandle != j || this.wHandle != i || this.nHandle != this.nodes.size()) {
/*     */       
/* 211 */       this.wHandle = i;
/* 212 */       this.hHandle = j;
/* 213 */       this.nHandle = this.nodes.size();
/*     */       
/* 215 */       this.retranslateX = this.xTranslationMultiplier * i;
/* 216 */       this.retranslateY = this.yTranslationMultiplier * j;
/*     */       
/* 218 */       double d1 = this.maxX - this.minX;
/* 219 */       double d2 = this.maxY - this.minY;
/* 220 */       double d3 = this.windowFraction * i / d1;
/* 221 */       double d4 = this.windowFraction * j / d2;
/* 222 */       this.circleRadius = (int)(Math.min(d1, d2) / 20.0D);
/*     */       
/* 224 */       this.scale = d3;
/* 225 */       if (d4 < d3) this.scale = d4;
/*     */       
/* 227 */       this.translateX = -(this.maxX + this.minX) / 2.0D;
/* 228 */       this.translateY = -(this.maxY + this.minY) / 2.0D;
/*     */       
/* 230 */       this.nodeRadius = this.circleRadius / 3;
/* 231 */       this.transform = new AffineTransform();
/* 232 */       this.transform.translate(this.retranslateX, this.retranslateY);
/* 233 */       this.transform.scale(this.scale, this.scale);
/* 234 */       this.transform.translate(this.translateX, this.translateY);
/*     */     } 
/* 236 */     Stroke stroke = graphics2D.getStroke();
/* 237 */     AffineTransform affineTransform = graphics2D.getTransform();
/*     */ 
/*     */     
/* 240 */     graphics2D.setStroke(new BasicStroke(3.0F));
/* 241 */     drawLines(graphics2D);
/* 242 */     drawNodes(graphics2D);
/* 243 */     graphics2D.setTransform(affineTransform);
/* 244 */     graphics2D.setStroke(stroke);
/*     */   }
/*     */   protected int mapX(int paramInt) {
/* 247 */     int i = paramInt;
/* 248 */     i = (int)(i + this.translateX);
/* 249 */     i = (int)(i * this.scale);
/* 250 */     i = (int)(i + this.retranslateX);
/* 251 */     return i;
/*     */   }
/*     */   protected int mapY(int paramInt) {
/* 254 */     int i = paramInt;
/* 255 */     i = (int)(i + this.translateY);
/* 256 */     i = (int)(i * this.scale);
/* 257 */     i = (int)(i + this.retranslateY);
/* 258 */     return i;
/*     */   }
/*     */   protected int mapL(int paramInt) {
/* 261 */     int i = paramInt;
/* 262 */     return (int)(i * this.scale);
/*     */   }
/*     */   
/*     */   private void drawLines(Graphics2D paramGraphics2D) {
/* 266 */     for (short b = 0; b < this.lines.size(); b++) {
/* 267 */       Line line = (Line) this.lines.elementAt(b);
/* 268 */       paramGraphics2D.setColor(line.color);
/* 269 */       paramGraphics2D.drawLine(mapX(line.x1), mapY(line.y1), mapX(line.x2), mapY(line.y2));
/* 270 */       paramGraphics2D.setColor(Color.black);
/*     */     } 
/*     */   }
/*     */   protected void drawNodes(Graphics2D paramGraphics2D) {
/* 274 */     Font font1 = paramGraphics2D.getFont();
/* 275 */     Font font2 = new Font("Roman", font1.getStyle(), mapL(this.circleRadius));
/*     */     
/* 277 */     paramGraphics2D.setFont(font2);
/* 278 */     FontMetrics fontMetrics = paramGraphics2D.getFontMetrics();
/*     */
/* 280 */     for (short b = 0; b < this.nodes.size(); b++) {
/* 281 */       Circle circle = (Circle)this.nodes.elementAt(b);
/* 282 */       if (circle instanceof NamedCircle) {
/* 283 */         Circle circle1 = circle;
/*     */         
/* 285 */         String str = ((NamedCircle)circle1).text;
/* 286 */         int i = fontMetrics.getHeight() / 2;
/* 287 */         i -= fontMetrics.getDescent();
/* 288 */         int j = (int)(fontMetrics.stringWidth(str) / 2.0D);
/*     */ 
/*     */         
/* 291 */         drawFrame(paramGraphics2D, circle1, j, i);
/* 292 */         paramGraphics2D.drawString(str, mapX(circle1.x) - j, mapY(circle1.y) + i);
/*     */       }
/* 294 */       else if (circle instanceof Circle) {
/* 295 */         Circle circle1 = circle;
/* 296 */         paramGraphics2D.setColor(Color.black);
/* 297 */         if (circle1 instanceof ColoredCircle) {
/* 298 */           paramGraphics2D.setColor(((ColoredCircle)circle1).color);
/*     */         }
/* 300 */         paramGraphics2D.fillOval(mapX(circle1.x - this.nodeRadius), mapY(circle1.y - this.nodeRadius), mapL(2 * this.nodeRadius), mapL(2 * this.nodeRadius));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void drawFrame(Graphics2D paramGraphics2D, Circle paramCircle, int paramInt1, int paramInt2) {
/* 307 */     int i = mapX(paramCircle.x - this.circleRadius);
/* 308 */     int j = mapY(paramCircle.y - this.circleRadius);
/* 309 */     int k = mapL(2 * this.circleRadius);
/* 310 */     Color color = paramGraphics2D.getColor();
/* 311 */     paramGraphics2D.setColor(Color.white);
/* 312 */     paramGraphics2D.fillOval(i, j, k, k);
/* 313 */     paramGraphics2D.setColor(Color.black);
/* 314 */     paramGraphics2D.drawOval(i, j, k, k);
/* 315 */     paramGraphics2D.setColor(color);
/*     */   }
/*     */   
/*     */   public static void fine(Object paramObject) {
/* 319 */     Logger.getLogger("search.views.NodeView").fine(paramObject);
/*     */   }
/*     */   public static void info(Object paramObject) {
/* 322 */     Logger.getLogger("search.views.NodeView").info(paramObject);
/*     */   }
/*     */   public static void warning(Object paramObject) {
/* 325 */     Logger.getLogger("search.views.NodeView").warning(paramObject);
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 329 */     NodeView nodeView = new NodeView();
/* 330 */     nodeView.addCircle("S", 0, 10);
/* 331 */     nodeView.addCircle(50, 100);
/* 332 */     nodeView.addLine(Color.red, 0, 10, 50, 100);
/* 333 */     nodeView.addLine(25, 50, 50, 50);
/* 334 */     Vector vector = new Vector();
/* 335 */     nodeView.addMessage("Hello");
/* 336 */     nodeView.addMessage("World");
/* 337 */     JFrame jFrame = new JFrame();
/* 338 */     jFrame.setSize(400, 400);
/* 339 */     jFrame.show();
/* 340 */     jFrame.addWindowListener(new ApplicationCloser());
/* 341 */     jFrame.getContentPane().add(nodeView);
/* 342 */     jFrame.validate();
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\views\NodeView.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */