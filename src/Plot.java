/**
 * This class represents the plot object with x, y, width, and depth values
 * 
 * @author Mark Kasule
 *
 */
public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;

	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}

	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.x;
		this.width = p.width;
		this.depth = p.depth;

	}

	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}

	// add width and depth but exceed width 10
	public boolean overlaps(Plot plot) {

		boolean plotOverlaps = true;

		if ((getX() + getWidth()) < plot.getX() && (getY() + getWidth()) < plot.getY()
				&& (plot.getY() + plot.getWidth()) < getY() && (plot.getX() + plot.getWidth()) < getX()
				&& getX() > plot.getY() && (getX() + getWidth()) > (plot.getY() + plot.getWidth())
				&& ((plot.getX() + plot.getWidth()) > (getY() + getWidth())) && (plot.getX() > getX())){
			plotOverlaps = false;
		}
		return plotOverlaps;

	}

	// add width and depth but not exceed width 10
	public boolean encompasses(Plot plot) {
		boolean plotEncompasses = true;

		if (plot.getX() >= getX() && plot.getX() + plot.getWidth() >= getX() + getWidth()
				&& plot.getX() + plot.getDepth() >= getX() + getDepth()
				&& plot.getX() + plot.getDepth() + plot.getWidth() >= getX() + getDepth() + getWidth()
				&& plot.getX() + plot.getDepth() + plot.getWidth() + plot.getDepth() >= getX() + getDepth() + getWidth()
						+ getDepth()
				&& plot.getX() + plot.getDepth() >= getX() + getDepth()
				&& plot.getX() < getX() && plot.getX() + plot.getWidth() < getWidth() + getX() 
				&& plot.getY() < getX() && plot.getY() < getY() + getWidth()) {
			plotEncompasses = false;
		}
		return plotEncompasses;
	}

	public String toString() {
		String str = "Upper left: (" + getX() + "," + getY() + "); Width: " + getWidth() + " Depth: " + getDepth();

		return str;
	}

}
