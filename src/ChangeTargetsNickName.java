public class ChangeTargetsNickName implements Attack {
    private final String name;
    private final int damage;
    public void DamageAttack(String name, PokemonType type, int damage)
    {

    }

    public ChangeTargetsNickName(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public PokemonType getType() {
        return null;
    }


    public void useAttack(Pokemon target)
    {
        target.doDamage(damage);
        target.setNickname("LOOSER");
        System.out.println("Target's name is now: " + target.getNickname());
        System.out.println(target.getNickname() + " took " + damage + " damage!");
    }
}
