package io.github.sefiraat.slimetinker.items.tools;

import lombok.Getter;

public class ToolDefinition {

    @Getter
    private final String classType;
    @Getter
    private final String partType;
    @Getter
    private final String headMaterial;
    @Getter
    private final String binderMaterial;
    @Getter
    private final String rodMaterial;

    public ToolDefinition(String classType, String partType, String headMaterial, String binderMaterial, String rodMaterial) {
        this.classType = classType;
        this.partType = partType;
        this.headMaterial = headMaterial;
        this.binderMaterial = binderMaterial;
        this.rodMaterial = rodMaterial;
    }
}
