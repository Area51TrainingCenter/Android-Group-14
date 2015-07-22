package com.johannfjs.examplemetaprogramacion;

/**
 * Created by johannfjs on 21/07/15.
 */

import java.lang.reflect.Field;

import android.view.View;

public class InitViews {
    public static void whichClass(Object object) {
        try {
            Field fieldRootView = object.getClass().getField("root");
            View root = (View) fieldRootView.get(object);
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (!View.class.isAssignableFrom(field.getType())
                        || field.getName().equals(fieldRootView.getName()))
                    continue;
                Field fieldIdRClass = R.id.class.getDeclaredField(field.getName());
                int idView = fieldIdRClass.getInt(fieldIdRClass);
                View view = (View) root.findViewById(idView);
                field.set(object, view);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}