public class DamageAttack implements Attack {

    private final String name;
    private final PokemonType type;
    private final int damage;

    public DamageAttack(String name, PokemonType type, int damage)
    {
        this.name = name;
        this.type = type;
        this.damage = damage;
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
         int damage = calculateDamage(target.getType());
        target.doDamage(damage);
        System.out.println(target.getNickname() + " took " + damage + " damage!");
    }

    private int calculateDamage(final PokemonType defenderType)
    {
        // defender is vulnerable - double damage

        if ((type == PokemonType.FIRE && defenderType == PokemonType.GRASS) ||
                (type == PokemonType.WATER && defenderType == PokemonType.FIRE) ||
                (type == PokemonType.GRASS && defenderType == PokemonType.WATER))
        {
            return damage * 2;
        }

        // defender is resistant - half damage
        if ((type == PokemonType.GRASS && defenderType == PokemonType.FIRE) ||
                (type == PokemonType.FIRE && defenderType == PokemonType.WATER) ||
                (type == PokemonType.WATER && defenderType == PokemonType.GRASS))
        {
            return damage / 2;
        }

        // no weaknesses - normal damage
        return damage;
    }
}
