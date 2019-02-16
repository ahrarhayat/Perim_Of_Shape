package Perim_Of_Shape;

import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    public int getNumPoints(Shape s)
    {
        int NumberOfPoints=0;
        for(Point p:s.getPoints())
        {
           NumberOfPoints=NumberOfPoints+1;
           

        }
        return NumberOfPoints;
        
    }
    public double getAverageLength(Shape s)
    {
        double totalPerim=0;
        Point prevPt = s.getLastPoint();
        for(Point currPt:s.getPoints())
        {
           double currDist = prevPt.distance(currPt);
           totalPerim = totalPerim + currDist;
           prevPt = currPt;
           
           
        
        }
        double NumberOfPoints=getNumPoints(s);
        double averageLength=totalPerim/NumberOfPoints;
        return averageLength;
        
    }
    public double getLargestSide(Shape s)
    {
        Point prevPt = s.getLastPoint();
        double LargestDist=0;
        double prevDist=0;
        for(Point currPt:s.getPoints())
        {
            
            double currDist = prevPt.distance(currPt);
            
            
            if(prevDist>currDist)
            {
                LargestDist=prevDist;
            }
            else
            {
                LargestDist=currDist;
          
            }
            prevDist = currDist;
            prevPt=currPt;
            
            
            
        }
        return LargestDist;
        
        
    }
    public double getLargestX(Shape s)
    {
        Point prevPt = s.getLastPoint();
        double X = (s.getLastPoint()).getX();
        double LargestX=0;
        double prevX=0;
        for(Point currPt:s.getPoints())
        {
            double CurrX = currPt.getX();
            if(prevX>CurrX)
            {
                LargestX=prevX;
            }
            else
            {
                LargestX=CurrX;
          
            }
            prevX=CurrX;
            prevPt=currPt;
            
            
            
        }
        return LargestX;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int NumberOfPoints=getNumPoints(s);
        double averageLength=getAverageLength(s);
        double LargestDist=getLargestSide(s);
        double LargestX=getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("This shape has "+NumberOfPoints+" points");
        System.out.println("The average of all sides is " + averageLength);
        System.out.println("The largest side is "+ LargestDist);
        System.out.println("The largest x is "+LargestX);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
