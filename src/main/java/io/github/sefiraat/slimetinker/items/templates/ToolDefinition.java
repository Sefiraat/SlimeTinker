package io.github.sefiraat.slimetinker.items.templates;

public class ToolDefinition {

    private final String classType;
    private final String partType;
    private final String headMaterial;
    private final String binderMaterial;
    private final String rodMaterial;

    public ToolDefinition(String classType, String partType, String headMaterial, String binderMaterial, String rodMaterial) {
        this.classType = classType;
        this.partType = partType;
        this.headMaterial = headMaterial;
        this.binderMaterial = binderMaterial;
        this.rodMaterial = rodMaterial;
    }

    public String getClassType() {
        return classType;
    }

    public String getPartType() {
        return partType;
    }

    public String getHeadMaterial() {
        return headMaterial;
    }

    public String getBinderMaterial() {
        return binderMaterial;
    }

    public String getRodMaterial() {
        return rodMaterial;
    }
}
