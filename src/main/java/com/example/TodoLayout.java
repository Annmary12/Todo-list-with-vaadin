package com.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class TodoLayout extends HorizontalLayout {
    private final Checkbox done;
    private final TextField task;
    private final Button deleteButton;

    public TodoLayout(Todo todo){
      done = new Checkbox();
      task = new TextField();
      deleteButton = new Button("Delete");
      deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
      System.out.println("Inside TodoLayout: "+ todo.getTask());
      add(done, task, deleteButton);
      setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

      Binder<Todo> binder = new Binder<Todo>(Todo.class);
      binder.bindInstanceFields(this);
      binder.setBean(todo);

      binder.addValueChangeListener(e -> {
        // something should happen
        System.out.println("Change Listener ===>>>");
      });

      deleteButton.addClickListener(e -> {
        System.out.println(todo.getTask());
      });
    }
}
