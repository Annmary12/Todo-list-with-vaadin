package com.example;


import com.vaadin.flow.component.ComponentEvent;

public class DeleteEvent extends ComponentEvent<TodoLayout> {
  private Todo _todo;
  public DeleteEvent(TodoLayout source, Todo todo, boolean fromClient) {
    super(source, fromClient);

    _todo = todo;
  }

  public Todo getTodo() { return _todo;}
}