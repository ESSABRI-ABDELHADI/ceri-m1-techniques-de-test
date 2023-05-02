package fr.univavignon.pokedex.api;


        import static org.junit.Assert.assertEquals;

        import org.junit.Test;

public class IPokemonFactoryTest {

    @Test
    public void createPokemonTest() throws PokedexException {

       IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new RocketPokemonFactory(pokemonMetadataProvider);

        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(0, pokemon.getIndex());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals("MISSINGNO", pokemon.getName());
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getAttack(), pokemon.getAttack());
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getDefense(), pokemon.getDefense());
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getStamina(), pokemon.getStamina());

    }

}
