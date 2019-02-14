package model;

public class PokeModel {

    private Integer id;

    private String name;

    private String sprite;

    private String spriteShiny;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getSpriteShiny() {
        return spriteShiny;
    }

    public void setSpriteShiny(String spriteShiny) {
        this.spriteShiny = spriteShiny;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
