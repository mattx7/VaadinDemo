package com.jetbrains;

import javax.servlet.annotation.WebServlet;

import com.sun.org.apache.xpath.internal.operations.String;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Title("My UI")
@Theme("mytheme")
@Widgetset("com.jetbrains.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        // ROOT LAYOUT
        final VerticalLayout rootLayout = new VerticalLayout();

        // PROPERTY AND ITEM
        final Property<Double> property = new ObjectProperty<Double>(13.0);
        final PropertysetItem item = new PropertysetItem();

        // COMPONENTS
        final TextField textField = new TextField("TextField");
        final Slider slider = new Slider(-50.0, 50.0, 1);
        final Label label = new Label();

        // ADDING A PROPERTY TO COMPONENTS [1. dimension]
        textField.setPropertyDataSource(property);
        textField.setImmediate(true);
        slider.setPropertyDataSource(property);
        label.setPropertyDataSource(property);

        // ADDING PROPERTIES TO A ITEM [2. dimension]
        item.addItemProperty("zahlensystem", new ObjectProperty("dezimal"));
        item.addItemProperty("wert", property);


        // Bind it to a component
        Form form = new Form();
        form.setItemDataSource(item);

        // Nicer captions
        form.getField("zahlensystem").setCaption("Zahlensystem: ");
        form.getField("wert").setCaption("Wert: ");

        rootLayout.addComponents(textField,slider,label,form);
        rootLayout.setMargin(true);
        rootLayout.setSpacing(true);
        setContent(rootLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
