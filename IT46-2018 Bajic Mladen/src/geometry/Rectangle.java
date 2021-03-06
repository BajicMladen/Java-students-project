package geometry;

import java.awt.Color;
import java.awt.Graphics;

import frms.FrmStack;

public class Rectangle extends SurfaceShape {

	private Point upperLeftPoint;
	private int height;
	private int width;

	public Rectangle() {

	}

	public Rectangle(Point upperLeftPoint, int height, int width) {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}

	public String toStringStack() {
		return "Rectangle num-->" + (FrmStack.getStack().getSize() + 1) + ": Upper left point X and Y coordinates--> ("
				+ String.valueOf(getUpperLeftPoint().getX()) + ", " + String.valueOf(getUpperLeftPoint().getY())
				+ "), Width--> " + String.valueOf(getWidth()) + ", Height--> " + String.valueOf(getHeight());
	}

	public int area() {
		return this.height * this.width;
	}

	public String toStringSort() {
		return "Upper left point X and Y coordinates--> (" + String.valueOf(getUpperLeftPoint().getX()) + ", "
				+ String.valueOf(getUpperLeftPoint().getY()) + "), Width--> " + String.valueOf(getWidth())
				+ ", Height--> " + String.valueOf(getHeight()) + ", Area--> " + area();
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.upperLeftPoint.getX() + 1, this.getUpperLeftPoint().getY() + 1, width - 1, height - 1);

	}

	@Override
	public boolean contains(int x, int y) {
		if (this.getUpperLeftPoint().getX() <= x && upperLeftPoint.getY() <= y && x <= upperLeftPoint.getX() + width
				&& y <= this.getUpperLeftPoint().getY() + height) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(this.upperLeftPoint.getX(), this.upperLeftPoint.getY(), this.width, this.height);
		this.fill(g);
		if (isSelected()) {
			selected(g);
		}

	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
		g.drawRect(getUpperLeftPoint().getX() + getWidth() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
		g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() + getHeight() - 3, 6, 6);
		g.drawRect(getUpperLeftPoint().getX() + getWidth() - 3, getUpperLeftPoint().getY() + getHeight() - 3, 6, 6);

	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
