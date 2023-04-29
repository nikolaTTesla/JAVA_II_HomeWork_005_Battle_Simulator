import java.util.List;
import java.util.Random;

public class Pokemon
{
    private final String species;
    private final PokemonType type;
    private  int maxHP;
    private final List<Attack> attacks;

    private String nickname;
    private int currentHP;
    private Status currentStatus;

    public Pokemon(final String species, final PokemonType type, final int maxHP, final List<Attack> attacks)
    {
        this.species = species;
        this.maxHP = maxHP;
        this.type = type;
        final Attack struggle = new DamageAttack("Struggle", PokemonType.NORMAL, 5);
        if (attacks.size() < 1 || attacks.size() > 4)
        {
           // attacks.add(struggle);
            throw new IllegalArgumentException("Pokemon must know between one and four attacks.");
        }
        this.attacks = attacks;

        this.nickname = species;
        this.currentHP = maxHP;
        this.currentStatus = Status.NORMAL;
    }

    public PokemonType getType()
    {
        return type;
    }

    public void setNickname(final String nickname)
    {
        if (nickname.contains("poop")) //Let's leave this here xD
        {
            throw new IllegalArgumentException("Please give your Pokemon a more polite nickname.");
        }
        this.nickname = nickname;
    }

    public Attack chooseAttack()
    {
        // choose at random -

        return attacks.get(new Random().nextInt(attacks.size()));
    }

    public String getNickname()
    {
        return nickname;
    }

    public void doDamage(final int damage) { currentHP -= damage; }

    public int getCurrentHP()
    {
        return currentHP;
    }

    public boolean hasFainted()
    {
        return (currentHP <= 0);
    }

    public void setCurrentStatus(Status status)
    {
        currentStatus = status;
    }

    public Status getCurrentStatus()
    {
        return currentStatus;
    }

    public void compareTypes(Pokemon target)
    {
        if (this.type == target.type)
        {
            System.out.println("These are the same type");
        }
        else
        {
            System.out.println("These are different types");
        }
    }
}
