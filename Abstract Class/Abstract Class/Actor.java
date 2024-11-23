import java.util.List;

public abstract class Actor
{

    /**
     * Constructor for objects of class Actor
     */
    public Actor()
    {
    }

    abstract protected void act(List<Actor> newActors);
    
    abstract protected boolean isActive();
}