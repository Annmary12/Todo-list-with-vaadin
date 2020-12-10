package com.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {
  TodoList todoList;
  Checkbox done;
  TextField task;

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service) {
       VerticalLayout todosList = new VerticalLayout();
       TextField taskField = new TextField();
       Button addButton = new Button("Add");
       todoList = new TodoList();

       add(
           new H1("My Todos"),
           todoList,
           new HorizontalLayout(taskField, addButton)
       );

       addButton.addClickListener(e -> {
         System.out.println("get Value: " + taskField.getValue());
           todoList.addTodo(new Todo(taskField.getValue()));
//           done = new Checkbox();
//           task = new TextField(taskField.getValue());
//           todosList.add(new TodoLayout(new Todo(taskField.getValue()) ));
           taskField.clear();
           taskField.focus();
       });


    }

}


//    VerticalLayout todoList = new VerticalLayout();
//    TextField textField = new TextField();
//    Button button = new Button("Add");
//        button.addClickShortcut(Key.ENTER);
//            button.addClickListener(click -> {
//            Checkbox checkbox = new Checkbox(textField.getValue());
//            todoList.add(checkbox);
//            textField.clear();
//            });
//
//            add(
//            new H1("My Todoist"),
//            todoList,
//            new HorizontalLayout(textField, button)
//            );
