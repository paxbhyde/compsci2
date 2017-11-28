/**
 * A class implementing the IIntPoint2D interface.
 */ 
public class IntPoint2D implements IIntPoint2D{
	
	private int x;
	private int y;
	
	public IntPoint2D(int a, int b){
		x = a;
		y = b;
	}
	
	/**
	 * @returns the X coordinate
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * @returns the Y coordinate
	 */
	public int getY(){
		return y;
	}

	/**
	 * Computes the manhattan distance to another point. 
	 * formula: abs(x1-x2) + abs(y1-y2)
	 * @param o the other point
	 * @returns the manhattan distance
	 */
	public int manhattanDistance(IIntPoint2D o){
		int x1 = this.getX();
		int y1 = this.getY();
	
		int x2 = o.getX();
		int y2 = o.getY();

		int manhattan = Math.abs(x1 - x2) + Math.abs(y1 - y2);
		return manhattan;
	}
	/**
     * Computes the euclidean distance to another point. 
     * formula: sqrt((x1-x2)^2 + (y1-y2)^2)
     * @param o the other point
     * @returns the euclidean distance
     */
    public double distance(IIntPoint2D o){
    	int x3 = this.getX();
		int y3 = this.getY();
		int x4 = o.getX();
		int y4 = o.getY();
		
		double x1 = (double) x3;
		double x2 = (double) x4;
		double y1 = (double) y3;
		double y2 = (double) y4;
		
		double dist = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		return dist;
    
    }
     // The following methods make JAVA objects better behaved
    /**
     * Converts a point object to a string of the form (X,Y)
     * @returns human friendly point representation
     */
    public String toString(){
    	int x = this.getX();
		int y = this.getY();
		
		String point = "(" + x + ", " + y + ")";
		return point;
    }
    /**
     * Determines if this point is the same as another (i.e. x1=x2 and y1=y2)
     * @returns true if this point is the same as point o
     */
    public boolean equals(IIntPoint2D o){
    	int x1 = this.getX();
		int y1 = this.getY();
	
		int x2 = o.getX();
		int y2 = o.getY();
		
		boolean equal = false;
		if (x1 == x2 && y1 == y2){
			equal = true;
		}
		return equal;
    }
    /**
     * Hashcode to support some standard library data structures
     * formula: (x<<16)+y
     * @returns the hashcode for the point
     */
    public int hashcode(){
		int x = this.getX();
		int y = this.getY(); 
    
    	int hash = (x<<16) + y;
    	return hash;
    
    }
   
}