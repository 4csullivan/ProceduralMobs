package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts;

public class PartSpawnLocation {
    private float locX;
    private float locY;
    private float locZ;
    private PartType type;

    public PartSpawnLocation(float locX, float locY, float locZ, PartType type) {
        this.locX = locX;
        this.locY = locY;
        this.locZ = locZ;
        this.type = type;
    }

    public PartType getType() {
        return type;
    }

    public void setType(PartType type) {
        this.type = type;
    }


    public float getLocX() {
        return locX;
    }

    public float getLocY() {
        return locY;
    }

    public float getLocZ() {
        return locZ;
    }

    public void setLocX(float locX) {
        this.locX = locX;
    }

    public void setLocY(float locY) {
        this.locY = locY;
    }

    public void setLocZ(float locZ) {
        this.locZ = locZ;
    }
}
