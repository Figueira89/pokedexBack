package controller;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonType;
import model.PokeModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class PokedexApiController {

    @GetMapping("/getAll")
    public List<PokeModel> getAll() {
        PokeApi pokeApi = new PokeApiClient();
        List<NamedApiResource> list = pokeApi.getPokemonList(0, 80).getResults();
        List<Pokemon> pokemons = new ArrayList<>();
        for (NamedApiResource pokemon : list) {
            pokemons.add(pokeApi.getPokemon(pokemon.getId()));
        }

        List<PokeModel> pokeModelList = getPokemons(pokemons);

        return pokeModelList;
    }

    private List<PokeModel> getPokemons(List<Pokemon> pokemons) {
        List<PokeModel> pokeModelList = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            PokeModel model = new PokeModel();
            model.setId(pokemon.getId());
            model.setName(pokemon.getName());
            model.setSprite(pokemon.getSprites().getFrontDefault());
            model.setSpriteShiny(pokemon.getSprites().getFrontShiny());
            StringBuilder string = new StringBuilder();
            for (PokemonType type : pokemon.getTypes()) {
                string.append(" | ");
                string.append(type.getType().getName().toUpperCase());
                string.append(" | ");
            }
            model.setType(string.toString());
            pokeModelList.add(model);
        }

        return pokeModelList;
    }

    @CrossOrigin
    @GetMapping("/getAllMock")
    public JSONObject getAllMock() throws IOException, ParseException {
        String path = "src/resources/mock.json";

        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader(path));

        // typecasting obj to JSONObject
        JSONObject json = (JSONObject) obj;


        return json;
    }


}
