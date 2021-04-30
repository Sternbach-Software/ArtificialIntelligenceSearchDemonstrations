/*    */ package search.applications;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Component;
/*    */ import java.awt.GridLayout;
/*    */ import javax.swing.JApplet;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import search.models.MapNet;
/*    */ import search.views.BlobView;
/*    */ 
/*    */ public class Resource extends JApplet {
/* 14 */   double VERSION = 2.0D;
/*    */   BlobView view;
/*    */   MapNet net;
/* 17 */   JPanel panel = new JPanel();
/* 18 */   JPanel controlPanel = new JPanel();
/* 19 */   JButton stopButton = new JButton("Stop");
/* 20 */   JButton pauseButton = new JButton("Pause");
/* 21 */   JButton resumeButton = new JButton("Resume");
/* 22 */   JButton searchButton = new JButton("Search"); int mode;
/* 23 */   int SET_START = 0, SET_GOAL = 1;
/*    */   
/*    */   public Resource() {
/* 26 */     this.mode = this.SET_START;
/* 27 */     setJMenuBar(new ResourceLocalMenuBar(this));
/* 28 */     this.controlPanel.setLayout(new GridLayout(1, 0));
/* 29 */     this.controlPanel.add(this.stopButton);
/* 30 */     this.controlPanel.add(this.pauseButton);
/* 31 */     this.controlPanel.add(this.resumeButton);
/* 32 */     this.controlPanel.add(this.searchButton);
/* 33 */     ResourceButtonListener resourceButtonListener = new ResourceButtonListener(this);
/* 34 */     this.stopButton.addActionListener(resourceButtonListener);
/* 35 */     this.pauseButton.addActionListener(resourceButtonListener);
/* 36 */     this.resumeButton.addActionListener(resourceButtonListener);
/* 37 */     this.searchButton.addActionListener(resourceButtonListener);
/* 38 */     getContentPane().setLayout(new BorderLayout());
/* 39 */     this.panel.setLayout(new BorderLayout());
/* 40 */     this.panel.add((Component)getView(), "Center");
/* 41 */     this.panel.add(this.controlPanel, "South");
/* 42 */     getContentPane().add(this.panel, "Center");
/* 43 */     getModel().readData("USA.DATA");
/*    */ 
/*    */     
/* 46 */     getModel().changed();
/*    */   }
/*    */   public MapNet getModel() {
/* 49 */     if (this.net != null) return this.net; 
/* 50 */     this.net = new MapNet();
/* 51 */     this.net.addObserver(new ResourceModelObserver(this));
/* 52 */     return this.net;
/*    */   }
/*    */   public BlobView getView() {
/* 55 */     if (this.view != null) return this.view; 
/* 56 */     this.view = new BlobView();
/* 57 */     this.view.addMouseListener(new ResourceViewListener(this));
/* 58 */     this.view.setPreferredSize(this.view.getSize());
/* 59 */     return this.view;
/*    */   }
/*    */   public static void main(String[] paramArrayOfString) {
/* 62 */     Resource resource = new Resource();
/* 63 */     JFrame jFrame = new JFrame();
/* 64 */     jFrame.setSize(800, 600);
/* 65 */     jFrame.show();
/* 66 */     jFrame.addWindowListener(new ResourceCloser());
/* 67 */     jFrame.getContentPane().add(resource);
/* 68 */     jFrame.validate();
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\Resource.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */