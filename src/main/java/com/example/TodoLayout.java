package com.example;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;

public class TodoLayout extends HorizontalLayout {
    private final Checkbox done = new Checkbox();
    private final TextField task = new TextField();
    private final Button deleteButton = new Button("Delete");

    public TodoLayout(Todo todo){
      deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
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
        fireEvent(new DeleteEvent(this, todo, false));
      });
    }

  public Registration addDeleteListener(
      ComponentEventListener<DeleteEvent> listener) {
    return addListener(DeleteEvent.class, listener);
  }
}
