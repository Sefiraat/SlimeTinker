package io.github.sefiraat.slimetinker.items.componentmaterials;

import lombok.Getter;

@Getter
public class CMForms {
    private final String formNugget;
    private final String formIngot;
    private final String formBlock;
    private final String formOre;
    private final String formGem;
    private final String formDust;
    private final String formBoot;
    private final String formLeg;
    private final String formChest;
    private final String formHelm;

    public CMForms(String formNugget, String formIngot, String formBlock, String formOre, String formGem, String formDust, String formBoot, String formLeg, String formChest, String formHelm) {
        this.formNugget = formNugget;
        this.formIngot = formIngot;
        this.formBlock = formBlock;
        this.formOre = formOre;
        this.formGem = formGem;
        this.formDust = formDust;
        this.formBoot = formBoot;
        this.formLeg = formLeg;
        this.formChest = formChest;
        this.formHelm = formHelm;
    }
}
