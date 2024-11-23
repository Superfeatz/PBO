public class Location
{
    // Row and column positions.
    private int row;
    private int col;

    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    

    public boolean equals(Object obj)
    {
        if(obj instanceof Location) {
            Location other = (Location) obj;
            return row == other.getRow() && col == other.getCol();
        }
        else {
            return false;
        }
    }
    
    public String toString()
    {
        return row + "," + col;
    }
    

    public int hashCode()
    {
        return (row << 16) + col;
    }
    
    /**
     * @return The row.
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * @return The column.
     */
    public int getCol()
    {
        return col;
    }
}