package controller;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
