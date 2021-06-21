package io.github.sefiraat.slimetinker.items.templates;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ToolDefinition {

    private final String classType;
    private final String partType;
    private final String headMaterial;
    private final String binderMaterial;
    private final String rodMaterial;

}
