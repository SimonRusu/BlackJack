package Model;

/**
 *
 * @author Simon
 */
public class PipCard extends Card
{
    private int value = 0;

    public PipCard(int value) 
    {
        this.value = value;
    }

    @Override
    public int getValue() 
    {
        return value;
    }  
}
