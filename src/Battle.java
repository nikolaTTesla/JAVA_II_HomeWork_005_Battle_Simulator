import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Battle
{


    public static void main(String[] args)
    {
        // define attacks
        final Attack tackle = new DamageAttack("Tackle", PokemonType.NORMAL, 30);
        final Attack razorleaf = new DamageAttack("Razor Leaf", PokemonType.GRASS, 30);
        final Attack watergun = new DamageAttack("Water Gun", PokemonType.WATER, 30);
        final Attack sing = new StatusAttack("Sing", PokemonType.NORMAL, Status.ASLEEP, 0.5f); // if both pokemon have sing they will pillow fight whole day
        final Attack ember = new DamageAttack("Ember", PokemonType.FIRE,30);
        //Calling new class that allows us to rename opponents nickname minor damage
        final Attack changeNickName = new ChangeTargetsNickName("Give_Ugly_name", 1); // If both pokemon decide to call each other ugly names, pokemon with higher starting HP will win.

        //CHOOSING POKEMON'S AND ASSIGNING THEM AN ATTACKS------------------------------------------------------------
        //------------------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------------------
        //Messages in the GUI
        String message1= "Chose FIRST pokemon";
        String message2 = "Chose MIN 1 and MAX 4 attacks";
        String message3 = "Chose SECOND pokemon";
        String message4 = "Hint: If both pokemons have just \"Sing\" attack, they will be fighting all daylong.";
        //Radio buttons
        JRadioButton radioBulbasaur=new JRadioButton("Bulbasaur");
        radioBulbasaur.setSelected(true); //Making radio button on to avoid crash if Pokemon wasn't selected
        JRadioButton radioPikachu=new JRadioButton("Pikachu");
        JRadioButton radioSquirtle=new JRadioButton("Squirtle");
        JRadioButton radioCharmander=new JRadioButton("Charmander");
        //Buttongroup allows groups all radio buttons we have, and allows user to choose only one
        ButtonGroup group = new ButtonGroup();
        group.add(radioBulbasaur);
        group.add(radioPikachu);
        group.add(radioSquirtle);
        group.add(radioCharmander);
        //Checkboxes initialization and assignments
        JCheckBox checkboxTackle = new JCheckBox("Tackle");
        JCheckBox checkboxWater_Gun = new JCheckBox("Water Gun");
        JCheckBox checkboxSing = new JCheckBox("Sing");
        JCheckBox checkboxRazor_leaf = new JCheckBox("Razor Leaf");
        JCheckBox checkboxEmber = new JCheckBox("Ember");
        JCheckBox checkboxGive_Ugly_name = new JCheckBox("Give Ugly name");

        //Objects that contain check boxes and radio buttons and strings that wraps them together
        Object[] paramsOfFirstPokemon = {message1,radioBulbasaur,radioPikachu,radioSquirtle,radioCharmander, message2,message4,checkboxTackle, checkboxWater_Gun, checkboxSing, checkboxRazor_leaf, checkboxEmber,checkboxGive_Ugly_name};
        Object[] paramsOfSecondPokemon = {message3,radioBulbasaur,radioPikachu,radioSquirtle,radioCharmander, message2,message4,checkboxTackle, checkboxWater_Gun, checkboxSing, checkboxRazor_leaf, checkboxEmber,checkboxGive_Ugly_name};

        int pokemonFirst =0;
        //Loop for making sure we have 1-4 attack selected for first pokemon
        int counter = 0;
        while (counter == 0 || counter >4)
        {
            counter = 0;
            pokemonFirst = JOptionPane.showConfirmDialog(null, paramsOfFirstPokemon, "Project Battle Simulator", JOptionPane.OK_CANCEL_OPTION);
            if(checkboxTackle.isSelected())
            {
                counter++;
            }
            if(checkboxWater_Gun.isSelected())
            {
                counter++;
            }
            if(checkboxSing.isSelected())
            {
                counter++;
            }
            if(checkboxRazor_leaf.isSelected())
            {
                counter++;
            }
            if(checkboxEmber.isSelected())
            {
                counter++;
            }
            if(pokemonFirst==2 ||pokemonFirst==-1)
            {
                System.exit(0);
            }
            if(checkboxGive_Ugly_name.isSelected())
            {
                counter++;
            }
        }
        counter = 0;

        //Setting up arrays before we start filing them up with type of attacks in GUI
        final List<Attack> spokemon_1_Attacks = new ArrayList<>(); // List of attacks for first pokemon
        final List<Attack> spokemon_2_Attacks = new ArrayList<>(); // List of attacks for second pokemon
        //Filling up arrays with attacks
        if(checkboxTackle.isSelected())
        {
            spokemon_1_Attacks.add(tackle);
        }
        if(checkboxWater_Gun.isSelected())
        {
            spokemon_1_Attacks.add(watergun);
        }
        if(checkboxSing.isSelected())
        {
            spokemon_1_Attacks.add(sing);
        }
        if(checkboxRazor_leaf.isSelected())
        {
            spokemon_1_Attacks.add(razorleaf);
        }
        if(checkboxEmber.isSelected())
        {
            spokemon_1_Attacks.add(ember);
        }
        if(checkboxGive_Ugly_name.isSelected())
        {
            spokemon_1_Attacks.add(changeNickName);
        }

        //Chosen first pokemon
        Pokemon pokemon_1 = null;
        Pokemon pokemon_2 = null;
        //adding chosen pokemon to the pokemon object
        if(group.isSelected(radioBulbasaur.getModel()))
        {
            pokemon_1 = new Pokemon("Bulsaur", PokemonType.GRASS, 80, spokemon_1_Attacks);
        }
        if(group.isSelected(radioPikachu.getModel()))
        {
            pokemon_1 = new Pokemon("Pikachu", PokemonType.ELECTRIC, 70, spokemon_1_Attacks);
        }
        if(group.isSelected(radioSquirtle.getModel()))
        {
            pokemon_1 = new Pokemon("Squirtle", PokemonType.WATER, 70, spokemon_1_Attacks);
        }
        if(group.isSelected(radioCharmander.getModel()))
        {
            pokemon_1 = new Pokemon("Charmander", PokemonType.FIRE, 70, spokemon_1_Attacks);
        }
        //Clearing all check boxes to make everything look better
        checkboxTackle.setSelected(false);      //Clear box if it was filed for previous pokemon
        checkboxWater_Gun.setSelected(false);   //Clear box if it was filed for previous pokemon
        checkboxSing.setSelected(false);        //Clear box if it was filed for previous pokemon
        checkboxRazor_leaf.setSelected(false);  //Clear box if it was filed for previous pokemon
        checkboxEmber.setSelected(false);       //Clear box if it was filed for previous pokemon
        checkboxGive_Ugly_name.setSelected(false);       //Clear box if it was filed for previous pokemon

        int pokemonSecond = 0;
        //Filter to make sure we have 1-4 attacks for pokemon
        while (counter == 0 || counter >4)
        {
            counter = 0;
            //Opening new window
            pokemonSecond = JOptionPane.showConfirmDialog(null, paramsOfSecondPokemon, "Project Battle Simulator", JOptionPane.OK_CANCEL_OPTION);
            if(checkboxTackle.isSelected())
            {
                counter++;
            }
            if(checkboxWater_Gun.isSelected())
            {
                counter++;
            }
            if(checkboxSing.isSelected())
            {
                counter++;
            }
            if(checkboxRazor_leaf.isSelected())
            {
                counter++;
            }
            if(checkboxEmber.isSelected())
            {
                counter++;
            }
            if(checkboxGive_Ugly_name.isSelected())
            {
                counter++;
            }
            //If close or cancel is pressed we exit program
            if(pokemonSecond==2 ||pokemonSecond==-1)
            {
                System.exit(0);
            }
        }
        //Checking which attack is selected, and if it is we are pushing it in to the list (I could do something about redundancy, maybe extra functions)
        if(checkboxTackle.isSelected())
        {
            spokemon_2_Attacks.add(tackle);
        }
        if(checkboxWater_Gun.isSelected())
        {
            spokemon_2_Attacks.add(watergun);
        }
        if(checkboxSing.isSelected())
        {
            spokemon_2_Attacks.add(sing);
        }
        if(checkboxRazor_leaf.isSelected())
        {
            spokemon_2_Attacks.add(razorleaf);
        }
        if(checkboxEmber.isSelected())
        {
            spokemon_2_Attacks.add(ember);
        }
        if(checkboxGive_Ugly_name.isSelected())
        {
            spokemon_2_Attacks.add(changeNickName);
        }
        //Checking which pokemon did we chose, and assigning it to the pokemon 2 object
        if(group.isSelected(radioBulbasaur.getModel()))
        {
            pokemon_2 = new Pokemon("Bulsaur", PokemonType.GRASS, 80, spokemon_2_Attacks);
        }
        if(group.isSelected(radioPikachu.getModel()))
        {
            pokemon_2 = new Pokemon("Pikachu", PokemonType.ELECTRIC, 70, spokemon_2_Attacks);
        }
        if(group.isSelected(radioSquirtle.getModel()))
        {
            pokemon_2 = new Pokemon("Squirtle", PokemonType.WATER, 70, spokemon_2_Attacks);
        }
        if(group.isSelected(radioCharmander.getModel()))
        {
            pokemon_2 = new Pokemon("Charmander", PokemonType.FIRE, 70, spokemon_2_Attacks);
        }
        //CHOOSING POKEMON'S AND ASSIGNING THEM AN ATTACKS------------------------------------------------------------
        //------------------------------------------------------------------------------------------------------------
        //------------------------------------------------------------------------------------------------------------

        // continue indefinitely - program will end when one pokemon faints
        Pokemon pkmn1 = pokemon_1; //pokemon_1 is new object created trough GUI
        Pokemon pkmn2 = pokemon_2; //pokemon_2 is new object created trough GUI
        while (true) {
            // pkmn1 attacks pkmn2
            takeTurn(pkmn1, pkmn2);

            // if pkmn2 has fainted, pkmnn1 wins and battle ends
            if (pkmn2.hasFainted()) {
                System.out.println(pkmn2.getNickname() + " has fainted! " + pkmn1.getNickname() + " wins!");
                return;
            }
            // pkmn2 attacks pkmn1
System.out.println(pkmn2.getNickname()+" has "+pkmn2.getCurrentHP()+" hit points");

            takeTurn(pkmn2, pkmn1);

            // if pkmn1 has fainted, pkmnn2 wins and battle ends
            if (pkmn1.hasFainted()) {
                System.out.println(pkmn1.getNickname() + " has fainted! " + pkmn2.getNickname() + " wins!");
                return;
            }
            System.out.println(pkmn1.getNickname()+" has "+pkmn1.getCurrentHP()+" hit points");
        }



    }

    private static void takeTurn(Pokemon attacker, Pokemon defender)
    {
        // if the attacker is asleep, it can't use a move
        if (attacker.getCurrentStatus() != Status.NORMAL)
        {
            System.out.println(attacker.getNickname() + " is " + attacker.getCurrentStatus().toString().toLowerCase() + "!");
            return;
        }

        // otherwise, it uses a move on the target
        Attack attack = attacker.chooseAttack();



        System.out.println(attacker.getNickname() + " used " + attack.getName() + "!");
        attack.useAttack(defender);
    }
}
