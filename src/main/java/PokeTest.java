import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;

public class PokeTest {

    public static void main(String[] args) {
        PokeApi pokeApi = new PokeApiClient();
        //PokemonSpecies bulbasaur = pokeApi.getPokemonList(1,60);
        //System.out.println(bulbasaur.getName());
    }
}
