import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.css']
})
export class ProgressBarComponent implements OnInit {
  @Input() backgroundColor = '#D9D9D9';
  @Input() progressColor = 'green';
  @Input() progress = 0;

  constructor() {
  }

  ngOnInit(): void {
    this.loading();
  }

  loading() {
    let interval = setInterval(() => {
      this.progress = +this.progress + 5;
      if (this.progress > 100) {
        this.progress = +this.progress - 5;
        clearInterval(interval);
        alert("load xong");
      }
    }, 300);
  }
}
