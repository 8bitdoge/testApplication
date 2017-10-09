package com.dudin.model;

public abstract class BaseEntity {
    private int id;

    public BaseEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        return ((BaseEntity) obj).getId() == this.getId();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

