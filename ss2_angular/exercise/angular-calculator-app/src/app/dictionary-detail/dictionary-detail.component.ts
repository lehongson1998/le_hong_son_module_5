import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {DictionaryService} from '../service/dictionary.service';
import {IWord} from '../model/iword';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  word1: IWord = {};

  constructor(private activatedRoute: ActivatedRoute,
              private dictionaryService: DictionaryService) { }

  ngOnInit(): void {
    this.findByWord();
  }

  findByWord(){
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const word = paramMap.get("word");
      this.word1 = this.dictionaryService.findByWord(word);
    })
  }

}
