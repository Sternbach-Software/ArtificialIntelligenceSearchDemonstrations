/*    */ package search.applications;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.GridLayout;
/*    */ import javax.swing.JApplet;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import search.models.Node;
/*    */ import search.models.StreetNet;
/*    */ import search.views.NodeView;
/*    */ 
/*    */ public class Search
/*    */   extends JApplet
/*    */ {
/* 16 */   double VERSION = 2.0D;
/*    */   NodeView view;
/*    */   StreetNet net;
/* 19 */   JPanel panel = new JPanel();
/* 20 */   JPanel controlPanel = new JPanel();
/* 21 */   JButton startButton = new JButton("Set start");
/* 22 */   JButton goalButton = new JButton("Set goal");
/* 23 */   JButton stopButton = new JButton("Stop");
/* 24 */   JButton pauseButton = new JButton("Pause");
/* 25 */   JButton resumeButton = new JButton("Resume");
/* 26 */   JButton searchButton = new JButton("Search"); int mode;
/* 27 */   int SET_START = 0, SET_GOAL = 1;
/*    */   
/*    */   public Search() {
/* 30 */     this.mode = this.SET_START;
/* 31 */     this.controlPanel.setLayout(new GridLayout(1, 0));
/* 32 */     this.controlPanel.add(this.startButton);
/* 33 */     this.controlPanel.add(this.goalButton);
/* 34 */     this.controlPanel.add(this.stopButton);
/* 35 */     this.controlPanel.add(this.pauseButton);
/* 36 */     this.controlPanel.add(this.resumeButton);
/* 37 */     this.controlPanel.add(this.searchButton);
/* 38 */     SearchButtonListener searchButtonListener = new SearchButtonListener(this);
/* 39 */     this.startButton.addActionListener(searchButtonListener);
/* 40 */     this.goalButton.addActionListener(searchButtonListener);
/* 41 */     this.stopButton.addActionListener(searchButtonListener);
/* 42 */     this.pauseButton.addActionListener(searchButtonListener);
/* 43 */     this.resumeButton.addActionListener(searchButtonListener);
/* 44 */     this.searchButton.addActionListener(searchButtonListener);
/*    */     
/* 46 */     getContentPane().add((Component)getView(), "Center");
/* 47 */     getContentPane().add(this.controlPanel, "South");
/*    */ 
/*    */     
/* 50 */     getModel().readData("CAMBRIDGE.DATA");
/*    */     
/* 52 */     setJMenuBar(new SearchLocalMenuBar(this));
/*    */ 
/*    */     
/* 55 */     Node node = getModel().getClosest(-10000, 0);
/* 56 */     getModel().setStart(node);
/* 57 */     node = getModel().getClosest(10000, 0);
/* 58 */     getModel().setGoal(node);
/* 59 */     getModel().setFrameRate(30);
/* 60 */     getModel().changed();
/*    */   }
/*    */   public StreetNet getModel() {
/* 63 */     if (this.net != null) return this.net; 
/* 64 */     this.net = new StreetNet();
/* 65 */     this.net.addObserver(new SearchModelObserver(this));
/* 66 */     return this.net;
/*    */   }
/*    */   public NodeView getView() {
/* 69 */     if (this.view != null) return this.view; 
/* 70 */     this.view = new NodeView();
/* 71 */     this.view.addMouseListener(new SearchViewListener(this));
/* 72 */     return this.view;
/*    */   }
/*    */   public static void main(String[] paramArrayOfString) {
/* 75 */     Search search = new Search();
/* 76 */     JFrame jFrame = new JFrame();
/* 77 */     jFrame.setSize(800, 600);
/* 78 */     jFrame.addWindowListener(new SearchSearchCloser());
/* 79 */     jFrame.getContentPane().add(search);
/* 80 */     jFrame.show();
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\Search.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */