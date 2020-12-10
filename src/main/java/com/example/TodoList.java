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

  public TodoList() {
    ArrayList<Todo> todos = new ArrayList<>();
    todos.add(new Todo("Task 1"));
    todos.add(new Todo("Task 2"));
    setTodos(todos);
  }

  private void setTodos(List<Todo> todos) {
    this.todos = todos;
    removeAll();
    todos.forEach(todo -> {
      TodoLayout todoLayout = new TodoLayout(todo);
      todoLayout.addDeleteListener(this::removeTodo);
      add(todoLayout);
    });
  }

  private void removeTodo(DeleteEvent deleteEvent) {
    Todo todo = deleteEvent.getTodo();
    this.todos.remove(todo);
    setTodos(todos);
  }

  void addTodo(Todo todo) {
    System.out.println("TodoList: "+ todo.getTask());
    todos.add(todo);
    setTodos(todos);
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
