package com.pisa.core.base.model.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a Self-Reference model representation.
 * 
 * Self reference are used when instances are associated to other instances of the same type.
 * 
 * @author PISA
 */

public abstract class PisaSelfReferenceModel<KEY_TYPE> extends PisaBaseModel<KEY_TYPE> {

    private PisaSelfReferenceModel<KEY_TYPE> parent;
    private List<PisaSelfReferenceModel<KEY_TYPE>> children;

    public PisaSelfReferenceModel<KEY_TYPE> getParent(){
        return this.parent;
    }

    public void setParent(PisaSelfReferenceModel<KEY_TYPE> parent){
        this.parent = parent;
    }

    public List<PisaSelfReferenceModel<KEY_TYPE>> getChildren() {
        return children;
    }

    public void addChildren(PisaSelfReferenceModel<KEY_TYPE> child) {
        if (children == null)
            children = new ArrayList<PisaSelfReferenceModel<KEY_TYPE>>();
        child.setParent(this);
        this.children.add(child);
    }
}