import java.util.Random;

public class StatusAttack implements Attack
{
    private final String name;
    private final PokemonType type;
    private final Status status;
    private final float probability;

    public StatusAttack(String aName, PokemonType aType, Status aStatus, float aProbability) {
        name = aName;
        type = aType;
        status = aStatus;
        if (aProbability < 0 || aProbability > 1)
        {
            throw new IllegalArgumentException("Probability must be between 0 (0%) and 1 (100%).");
        }
        probability = aProbability;
    }

    public String getName()
    {
        return name;
    }

    public PokemonType getType()
    {
        return type;
    }

    public void useAttack(Pokemon target)
    {
        final boolean succeeds = calculateSuccess();
        if (succeeds)
        {
            target.setCurrentStatus(status);
            System.out.println(target.getNickname() + " is now " + status.toString().toLowerCase() + "!");
        }
        else
        {
            System.out.println("The attack failed!");
        }
    }

    private boolean calculateSuccess()
    {
        float random = new Random().nextFloat();
        return (random < probability);
    }
}
