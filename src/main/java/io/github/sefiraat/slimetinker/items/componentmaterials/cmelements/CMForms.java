package io.github.sefiraat.slimetinker.items.componentmaterials.cmelements;

import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;

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
    private ComponentMaterial parent;

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

    public String getFormNugget() {
        return formNugget;
    }

    public String getFormIngot() {
        return formIngot;
    }

    public String getFormBlock() {
        return formBlock;
    }

    public String getFormOre() {
        return formOre;
    }

    public String getFormGem() {
        return formGem;
    }

    public String getFormDust() {
        return formDust;
    }

    public String getFormBoot() {
        return formBoot;
    }

    public String getFormLeg() {
        return formLeg;
    }

    public String getFormChest() {
        return formChest;
    }

    public String getFormHelm() {
        return formHelm;
    }

    public ComponentMaterial getParent() {
        return parent;
    }
}
