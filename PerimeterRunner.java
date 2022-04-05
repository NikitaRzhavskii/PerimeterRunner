import edu.duke.*;
import java.io.File;

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
    public double getLargestSide(Shape s){
        Point pervPt = s.getLastPoint();
        double largestS = 0.0;
        for(Point currPt: s.getPoints()){
            double currDist = pervPt.distance(currPt);
            if(currDist>largestS){
                largestS = currDist; 
            }
        }
        return largestS;
    }
    public double getLargestX(Shape s) {
        Point lastPoint = s.getLastPoint();
        double largestX = lastPoint.getX();        
        for(Point p : s.getPoints()){
            int newX = p.getX();
            if(newX > largestX) {
                largestX = newX;
            }
        }
        return largestX;
    }
        public int getNumPoints(Shape s) {
       int numPt = 0;
        for(Point newPt: s.getPoints()){
            numPt = numPt +1 ;
        }
        return numPt;
    }
    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerm = 0.0; 
        for (File f: dr.selectedFiles()){
            FileResource oneFile = new FileResource(f);
            Shape s = new Shape(oneFile);
            double perimt = getPerimeter(s);
            if(perimt>largestPerm){
                largestPerm = perimt;
            }
        }
        return largestPerm;
    }
    public void testPerimeterMultipleFiles(){
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter =" + largestPerimeter);
    }
    public String getFileWithLargestPerimeter(){
        DirectoryResource dr = new DirectoryResource();
        File temp = null;
        double largestPerm = 0.0; 
        for (File f: dr.selectedFiles()){
            FileResource oneFile = new FileResource(f);
            Shape s = new Shape(oneFile);
            double perimt = getPerimeter(s);
            if(perimt>largestPerm){
                largestPerm = perimt;
                temp = f;
            }
        }
        return temp.getName();
    }  
    public void testFileWithLargestPerimeter(){
        String largestFile = getFileWithLargestPerimeter();
        System.out.println("File with largest Perimeter =" + largestFile);
    }
        public double getAverageLength(Shape s){
        double length = getPerimeter(s);
        double sum = getNumPoints(s); 
        double average = length/sum; 
        return average;  

    }
    public void testPerimeter(){
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int sum = getNumPoints(s);
        double average = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number point =" + sum);
        System.out.println("average =" + average);
        System.out.println("largest side =" + largestSide);
        System.out.println("largest x =" + largestX); 
    }
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
        pr.testFileWithLargestPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}
