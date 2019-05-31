package br.com.pokedex.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@Document(collection = "Pokedex")
public class Pokemon implements Serializable {

    @Id
    private ObjectId id;

    private Integer number;

    private String height;

    private String weight;

    private String baseExperience;

    private String description;

    private List<String> types = new ArrayList<>();

    private String name;

    private String image;


    private final static long serialVersionUID = 3418650503334155412L;

    public Pokemon() {
        super();
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(number).append(height).append(weight).append(baseExperience).append(description).append(types).append(name).append(image).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pokemon) == false) {
            return false;
        }
        Pokemon rhs = ((Pokemon) other);
        return new EqualsBuilder().append(number, rhs.number).append(height, rhs.height).append(weight, rhs.weight).append(baseExperience, rhs.baseExperience).append(description, rhs.description).append(types, rhs.types).append(name, rhs.name).append(image, rhs.image).isEquals();
    }

    public static class SortByNumber implements Comparator<Pokemon>{

        @Override
        public int compare(Pokemon o1, Pokemon o2) {
            return o1.number - o2.number;
        }
    }
}