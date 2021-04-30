/*    */ package search.applications;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Component;
/*    */ import java.awt.GridLayout;
/*    */ import javax.swing.JApplet;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import logging.Logger;
/*    */ import search.models.TripNet;
/*    */ import search.views.ScheduleView;
/*    */ 
/*    */ public class Schedule extends JApplet {
/* 15 */   double VERSION = 1.0D;
/*    */   ScheduleView view;
/*    */   TripNet net;
/* 18 */   JPanel panel = new JPanel();
/* 19 */   JPanel controlPanel = new JPanel();
/* 20 */   JButton stopButton = new JButton("Stop");
/* 21 */   JButton pauseButton = new JButton("Pause");
/* 22 */   JButton resumeButton = new JButton("Resume");
/* 23 */   JButton searchButton = new JButton("Search"); int mode;
/* 24 */   int SET_START = 0, SET_GOAL = 1;
/*    */   
/*    */   public Schedule() {
/* 27 */     this.mode = this.SET_START;
/* 28 */     setJMenuBar(new ScheduleLocalMenuBar(this));
/* 29 */     this.controlPanel.setLayout(new GridLayout(1, 0));
/* 30 */     this.controlPanel.add(this.stopButton);
/* 31 */     this.controlPanel.add(this.pauseButton);
/* 32 */     this.controlPanel.add(this.resumeButton);
/* 33 */     this.controlPanel.add(this.searchButton);
/* 34 */     ScheduleButtonListener scheduleButtonListener = new ScheduleButtonListener(this);
/* 35 */     this.stopButton.addActionListener(scheduleButtonListener);
/* 36 */     this.pauseButton.addActionListener(scheduleButtonListener);
/* 37 */     this.resumeButton.addActionListener(scheduleButtonListener);
/* 38 */     this.searchButton.addActionListener(scheduleButtonListener);
/* 39 */     getContentPane().setLayout(new BorderLayout());
/* 40 */     this.panel.setLayout(new BorderLayout());
/* 41 */     this.panel.add((Component)getView(), "Center");
/* 42 */     this.panel.add(this.controlPanel, "South");
/* 43 */     getContentPane().add(this.panel, "Center");
/* 44 */     getView().setShowNames(true);
/* 45 */     getModel().constructSimpleTestSet();
/*    */ 
/*    */ 
/*    */     
/* 49 */     getModel().changed();
/*    */   }
/*    */   public TripNet getModel() {
/* 52 */     if (this.net != null) return this.net; 
/* 53 */     this.net = new TripNet();
/* 54 */     this.net.addObserver(new ScheduleModelObserver(this));
/* 55 */     return this.net;
/*    */   }
/*    */   public ScheduleView getView() {
/* 58 */     if (this.view != null) return this.view; 
/* 59 */     this.view = new ScheduleView();
/* 60 */     this.view.addMouseListener(new ScheduleViewListener(this));
/* 61 */     this.view.setPreferredSize(this.view.getSize());
/* 62 */     return this.view;
/*    */   }
/*    */   public static void fine(Object paramObject) {
/* 65 */     Logger.getLogger("search.applications.Schedule").fine(paramObject);
/*    */   }
/*    */   public static void info(Object paramObject) {
/* 68 */     Logger.getLogger("search.applications.Schedule").info(paramObject);
/*    */   }
/*    */   public static void warning(Object paramObject) {
/* 71 */     Logger.getLogger("search.applications.Schedule").warning(paramObject);
/*    */   }
/*    */   public static void main(String[] paramArrayOfString) {
/* 74 */     Schedule schedule = new Schedule();
/* 75 */     JFrame jFrame = new JFrame();
/* 76 */     jFrame.setSize(800, 600);
/* 77 */     jFrame.show();
/* 78 */     jFrame.addWindowListener(new ScheduleCloser());
/* 79 */     jFrame.getContentPane().add(schedule);
/* 80 */     jFrame.validate();
/*    */   }
/*    */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\applications\Schedule.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */