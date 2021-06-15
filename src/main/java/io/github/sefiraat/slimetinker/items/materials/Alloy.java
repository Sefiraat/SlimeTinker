package io.github.sefiraat.slimetinker.items.materials;

import lombok.Getter;

import java.util.Map;

public class Alloy {

    @Getter
    private final String name;

    @Getter
    private final Map<String, Integer> recipe;

    public Alloy(String name, Map<String, Integer> recipe) {
        this.name = name;
        this.recipe = recipe;
    }

}
