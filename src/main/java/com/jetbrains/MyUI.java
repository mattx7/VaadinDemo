package com.jetbrains;

import javax.servlet.annotation.WebServlet;

import com.sun.org.apache.xpath.internal.operations.String;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
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
        final VerticalLayout rootLayout = new VerticalLayout();
        final Label headline = new Label();
        final TextField pizza = new TextField();
        final TextField price = new TextField();
        // Have a data model
        ObjectProperty headlineText = new ObjectProperty("Pizza Shop",String.class);
        // Have a component that implements Viewer
        Label viewer = new Label();
        TextField editor = new TextField("Edit Greeting");
        // Bind it to the data
        viewer.setPropertyDataSource(headlineText);
        editor.setPropertyDataSource(headlineText);

        viewer.setPropertyDataSource(editor);
        // The value shown in the viewer is updated immediately
        // after editing the value in the editor (once it
        // loses the focus)
        editor.setImmediate(true);
//        pizza.addValueChangeListener(
//                new Property.ValueChangeListener() {
//                    @Override
//                    public void valueChange(Property.ValueChangeEvent event) {
//                        // Do something with the new value
//                        rootLayout.addComponent(new Label(pizza.getValue()));
//                    }
//                });



        rootLayout.addComponents(headline,pizza);
        rootLayout.setMargin(true);
        rootLayout.setSpacing(true);
        setContent(rootLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
