import java.util.List;

public class Gen3_Pokemon extends Pokemon{

    private final String ability;

    public Gen3_Pokemon(final String species, final PokemonType type,
                           int maxHP,
                        final List<Attack> attacks , String ability) {
        super(species, type, maxHP, attacks);
        this.ability = ability;

    }
}
