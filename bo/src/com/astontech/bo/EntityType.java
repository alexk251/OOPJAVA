package com.astontech.bo;

public class EntityType extends BaseBO {

    //properties
    private int EntityTypeId;
    private String EntityTypeName;
    private int EntityId;


    //Constructors
    public EntityType() {};

    public EntityType(String entityTypeName) {
        this.setEntityTypeName(entityTypeName);
    }


    //Getter Setters
    public int getEntityTypeId() {
        return EntityTypeId;
    }
    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getEntityTypeName() {
        return EntityTypeName;
    }

    public void setEntityTypeName(String entityTypeName) {
        EntityTypeName = entityTypeName;
    }

    public int getEntityId() {
        return EntityId;
    }

    public void setEntityId(int entityId) {
        EntityId = entityId;
    }

    //Polymorphism example

    public String test_method() {
        return "sub method";
    }
}
