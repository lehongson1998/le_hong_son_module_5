import { Component, OnInit } from '@angular/core';
import {Todo} from '../../model/todo';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {TodoService} from '../service/todo.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];

  content = new FormControl();

  constructor(private todoService: TodoService, private router: Router) { }

  ngOnInit(): void {
    this.getAllTodo();
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  getAllTodo(){
    return this.todoService.getAll().subscribe(todos => {
      this.todos = todos;
    })
  }

  change(){
    const value = this.content.value;
    if (value){
      const todo: Todo = {
        content: value,
        complete: false
      };
      return this.todoService.saveTodo(todo).subscribe(() => {
        this.content.reset();
        this.getAllTodo();
      }, e => {
        console.log(e);
      })
    }
  }
}
