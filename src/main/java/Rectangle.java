//this class understands a 4 sided figure with 4 90 angles
public class Rectangle {

    final private int width;
    final private int height;

    public Rectangle(int width, int height) {

        validateSides(width, height);
        this.width = width;
        this.height = height;
    }

    private void validateSides(int width, int height) {
        validateIsPositive(width);
        validateIsPositive(height);
    }

    private void validateIsPositive(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getPerimeter() {
        return 2*this.width + 2*this.height;
    }

    public int getArea() {
        return this.width * this.height;
    }
}
