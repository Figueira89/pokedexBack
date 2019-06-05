package br.com.pokedex.repository;

import br.com.pokedex.model.Pokemon;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokeRepository extends MongoRepository<Pokemon, String> {

    Pokemon findById(ObjectId id);

    @Override
    public List<Pokemon> findAll();
}
