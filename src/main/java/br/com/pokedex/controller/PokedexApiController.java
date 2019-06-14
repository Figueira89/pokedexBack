package br.com.pokedex.controller;

import br.com.pokedex.model.Pokemon;
import br.com.pokedex.repository.PokeRepository;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class PokedexApiController {

    public static final Integer PAGE_SIZE = 20;
    @Autowired
    PokeRepository repository;

    @GetMapping("/getAll")
    //@RequestParam Integer pageNum
    public List<Pokemon> getAll() throws IOException {

        List<Pokemon> pokemonList = new ArrayList<>();


        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().register("br.com.pokedex.model").build()));

        MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        MongoDatabase db = mongoClient.getDatabase("PokeDB");

        MongoCollection<Pokemon> collection = db.getCollection("Pokedex", Pokemon.class);


        Block<Pokemon> printBlock = pokemon -> pokemonList.add(pokemon);


        collection.find().forEach(printBlock);
        /**
         * TODO Procurar uma maneira para trazer os registros ordenados na paginação.
         */
        //collection.find().limit(20).forEach(printBlock);

        //collection.find().forEach(printBlock);

        Collections.sort(pokemonList, new Pokemon.SortByNumber());

        return pokemonList;
    }



   /* private List<PokeModel> getPokemons(List<Pokemon> pokemons) {
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
    }*/


}
