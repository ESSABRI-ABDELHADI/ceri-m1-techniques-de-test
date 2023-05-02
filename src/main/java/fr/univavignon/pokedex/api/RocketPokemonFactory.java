package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;


public class RocketPokemonFactory implements IPokemonFactory {
IPokemonMetadataProvider provider;

public RocketPokemonFactory(IPokemonMetadataProvider provider){
    this.provider=provider;
}
    private static final Map<Integer, String> index2name;
    static {
        Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        //TODO : Gotta map them all !
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
    }

    private static int generateRandomStat() {
        int total = 0;
        for(int i=0; i < 1000000; i++)
        {
            Random rn = new Random();
            int r = rn.nextInt(2);
            total = total + r;
        }
        return total / 10000;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try{
            PokemonMetadata pokemonMetadata= provider.getPokemonMetadata (index);
            String name;
            if(!index2name.containsKey(index)) {
                name = index2name.get(0);
            } else {
                name = index2name.get(index);
            }

            int attack=pokemonMetadata.getAttack();
            int defense=pokemonMetadata.getDefense();
            int stamina=pokemonMetadata.getStamina();
            double iv=56;
            return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);

        }
        catch (PokedexException e){
            System.out.println(e.getMessage());
        }

    return  null;
    }

}