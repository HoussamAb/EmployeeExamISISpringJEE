package com.employees.formaters;

import com.employees.entities.Role;
import org.springframework.core.convert.converter.Converter;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;

public class RoleFormater implements Converter<String, Role>, PropertyEditor {
    @Override
    public Role convert(String element) {
        if(!element.equals(null)) {
            Role role =  new Role(Long.parseLong(String.valueOf(element)));
            return role;
        }else{
            return null;
        }
    }

    @Override
    public void setValue(Object value) {

    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public boolean isPaintable() {
        return false;
    }

    @Override
    public void paintValue(Graphics gfx, Rectangle box) {

    }

    @Override
    public String getJavaInitializationString() {
        return null;
    }

    @Override
    public String getAsText() {
        return null;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

    }

    @Override
    public String[] getTags() {
        return new String[0];
    }

    @Override
    public Component getCustomEditor() {
        return null;
    }

    @Override
    public boolean supportsCustomEditor() {
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }
}
