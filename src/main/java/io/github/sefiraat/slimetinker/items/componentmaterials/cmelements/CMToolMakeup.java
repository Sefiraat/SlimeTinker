package io.github.sefiraat.slimetinker.items.componentmaterials.cmelements;

import lombok.Getter;

@Getter
public class CMToolMakeup {

    private final boolean isValidHead;
    private final boolean isValidBinder;
    private final boolean isValidRod;

    private final boolean isValidPlates;
    private final boolean isValidGambeson;
    private final boolean isValidLinks;

    public CMToolMakeup(boolean isValidHead, boolean isValidBinder, boolean isValidRod, boolean isValidPlates, boolean isValidGambeson, boolean isValidLinks) {
        this.isValidHead = isValidHead;
        this.isValidBinder = isValidBinder;
        this.isValidRod = isValidRod;
        this.isValidPlates = isValidPlates;
        this.isValidGambeson = isValidGambeson;
        this.isValidLinks = isValidLinks;
    }

}
