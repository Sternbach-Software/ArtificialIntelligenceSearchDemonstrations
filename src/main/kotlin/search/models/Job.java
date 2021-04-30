package search.models;

import java.awt.Color;
import java.util.Vector;

public interface Job {
  String getName();
  
  Color getResource();
  
  void setResource(Color paramColor);
  
  Vector getNeighbors();
  
  double getStart();
  
  double getDuration();
}


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\models\Job.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */