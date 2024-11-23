import java.util.List;
import java.util.Iterator;
import java.util.Random;


public class Fox extends Animal
{
    // Characteristics shared by all foxes (class variables).
    
    // The age at which a fox can start to breed.
    private static final int BREEDING_AGE = 15;
    // The age to which a fox can live.
    private static final int MAX_AGE = 150;
    // The likelihood of a fox breeding.
    private static final double BREEDING_PROBABILITY = 0.08;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static final int RABBIT_FOOD_VALUE = 9;
    
    // Individual characteristics (instance fields).
    // The fox's food level, which is increased by eating rabbits.
    private int foodLevel;

  
    public Fox(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        setLocation(location);
        if(randomAge) {
            setAge(getSharedRandom().nextInt(MAX_AGE));
            foodLevel = getSharedRandom().nextInt(RABBIT_FOOD_VALUE);
        }
        else {
            // leave age at 0
            foodLevel = getSharedRandom().nextInt(RABBIT_FOOD_VALUE);
        }
    }
    

    public void act(List<Actor> newFoxes)
    {
        incrementAge();
        incrementHunger();
        if(isActive()) {
            giveBirth(newFoxes);            
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }
    
    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }
    
    /**
     * Look for rabbits adjacent to the current location.
     * Only the first live rabbit is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood()
    {
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = getField().getObjectAt(where);
            if(animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if(rabbit.isActive()) { 
                    rabbit.setDead();
                    foodLevel = RABBIT_FOOD_VALUE;
                    return where;
                }
            }
        }
        return null;
    }
    
   
    private void giveBirth(List<Actor> newFoxes)
    {
        // New foxes are born into adjacent locations.
        // Get a list of adjacent free locations.
        List<Location> free = getField().getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Fox young = new Fox(false, getField(), loc);
            newFoxes.add(young);
        }
    }
    
    /**
     * Get the breedding age of the Fox.
     * @return The breeding age.
     */
    public int getBreedingAge()
    {
        return BREEDING_AGE;
    }    
    
    /**
     * Get the maximum age the Fox can live to.
     * @return The maximum age.
     */
    public int getMaxAge()
    {
        return MAX_AGE;
    }
    
    /**
     * Get the Fox's breeding probability.
     * @return The breeding probability.
     */
    public double getBreedingProbability()
    {
        return BREEDING_PROBABILITY;
    }
    
    /**
     * Get the Fox's maximum litter size. 
     * @return The max litter size.
     */
    public int getMaxLitterSize()
    {
        return MAX_LITTER_SIZE;
    }
}