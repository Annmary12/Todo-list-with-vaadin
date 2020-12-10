package com.example;

import com.vaadin.flow.component.polymertemplate.Id;

public class Todo {

  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String task;
  private boolean done;

  public Todo(){

  }

  public Todo(String task){
    System.out.println("task: " + task);
    this.task = task;
  }

  public Todo(String text, boolean done) {
    this.task = text;
    this.done = done;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }
}
