package br.com.pokedex.repository;

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
