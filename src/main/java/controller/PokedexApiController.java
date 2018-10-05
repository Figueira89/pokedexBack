package controller;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
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
import java.util.List;

@RequestMapping("/api")
@RestController
public class PokedexApiController {

    @GetMapping("/getAll")
    public List<NamedApiResource> getAll(){
        PokeApi pokeApi = new PokeApiClient();
        List<NamedApiResource> list = pokeApi.getPokemonList(1,60).getResults();

        return list;
    }

    @CrossOrigin
    @GetMapping("/getAllMock")
    public JSONArray getAllMock() throws IOException, ParseException {
       String path = "src/resources/mock.json";

        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader(path));

        // typecasting obj to JSONObject
        JSONArray json = (JSONArray) obj;



        return json;
    }


}
