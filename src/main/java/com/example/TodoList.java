package com.example;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@UIScope
@SpringComponent
public class TodoList extends VerticalLayout {
  private List<Todo> todos = new ArrayList<>();

  @PostConstruct
  void init() {
    setWidth("80%");
  }

  private void setTodos(List<Todo> todos) {
    this.todos = todos;
    todos.forEach(todo -> add(new TodoLayout(todo)));
  }

  void addTodo(Todo todo) {
    System.out.println("TodoList: "+ todo.getTask());
    todos.add(todo);
    add(new TodoLayout(todo));
  }

  public void deleteCompleted() {
    todos.stream().map(todo -> {
      return !todo.isDone();
    });
  }

  public void removeTodo() {
    // find the index of the todo and remove
    todos.remove(0);
  }
}
