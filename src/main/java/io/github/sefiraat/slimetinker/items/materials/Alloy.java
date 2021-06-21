package io.github.sefiraat.slimetinker.items.materials;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter @AllArgsConstructor
public class Alloy {

    private final String name;
    private final Map<String, Integer> recipe;

}
