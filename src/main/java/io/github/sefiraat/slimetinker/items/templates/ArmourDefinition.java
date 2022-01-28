package io.github.sefiraat.slimetinker.items.templates;

public class ArmourDefinition {

    private final String classType;
    private final String partType;
    private final String plateMaterial;
    private final String gambesonMaterial;
    private final String linksMaterial;

    public ArmourDefinition(String classType, String partType, String plateMaterial, String gambesonMaterial, String linksMaterial) {
        this.classType = classType;
        this.partType = partType;
        this.plateMaterial = plateMaterial;
        this.gambesonMaterial = gambesonMaterial;
        this.linksMaterial = linksMaterial;
    }
    
    public String getClassType() {
        return classType;
    }

    public String getPartType() {
        return partType;
    }

    public String getPlateMaterial() {
        return plateMaterial;
    }

    public String getGambesonMaterial() {
        return gambesonMaterial;
    }

    public String getLinksMaterial() {
        return linksMaterial;
    }
}
