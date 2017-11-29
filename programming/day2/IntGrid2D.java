/**
 * A class and methods implementing the IIntGrid2D interface
 */
public class IntGrid2D implements IIntGrid2D {

	private int lRX;
	private int lRY;
	private int uLX;
	private int uLY;	
	private char[][] grid;

	public IntGrid2D(int a, int b, int c, int d, char q){
		uLX = a;
		uLY = b;
		lRX = c;
		lRY = d;
		
		int i = Math.abs(uLX - lRX) + 1; 
		int j = Math.abs(uLY - lRY) + 1;

		grid = new char[i][j];	
		
		for (int x = 0; x < i; x++){
			for (int y  = 0; y < j; y++){	
				grid[x][y] = q;		
    		}
		}
	}
    /**
     * Sets the value at a point on the grid, replacing the previous value if any.
     * @param p The coordinate to set the value of
     * @param v The value to set at the coordinate
     */
    public void setPoint(IIntPoint2D p, char v){
    	int i = p.getX() - uLX;
    	int j = p.getY() - lRY;
    	grid[i][j] = v;
    }   
    /**
     * Gets the value at a point on the grid
     * @param p The coordinate to get the value of
     * @returns the stored value
     */
    public char getPoint(IIntPoint2D p){
    	int i = p.getX() - uLX;
    	int j = p.getY() - lRY;
    	return grid[i][j];
    }
    
    /**
     * Gets the coordinate for the upper left most location
     * @returns an IIntPoint that is the coordinate of the upper left corner
     */
    public IIntPoint2D getUpperLeftCorner(){
    	IIntPoint2D UL = new IntPoint2D(uLX, uLY);
    	return UL;
    }
    
    /**
     * Gets the coordinate for the lower right most location
     * @returns an IIntPoint that is the lower right corner
     */
    public IIntPoint2D getLowerRightCorner(){
    	IIntPoint2D UR = new IntPoint2D(lRX, lRY);
    	return UR;
    }
    
}