import { Injectable } from '@angular/core';
import {IWord} from '../model/iword';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionary: IWord[] = [
    {word: "cuntsucker", mean: "người bú cặc"},
    {word: "cocksucker", mean: "người bú lồn"},
    {word: "computer", mean: "máy tính"},
    {word: "phone", mean: "điện thoại"},
    {word: "pen", mean: "bút"},
    {word: "head phone", mean: "tai nghe chùm đầu"},
    {word: "mouse", mean: "con chuột"},
    {word: "display", mean: "màn hình"},
    {word: "battery", mean: "pin"},
    {word: "car", mean: "xe hơi"},
    {word: "truck", mean: "xe tải"},
    {word: "keyboard", mean: "bàn phím"},
    {word: "in", mean: "trong"},
    {word: "on", mean: "trên"},
    {word: "left", mean: "bên trái"},
    {word: "right", mean: "bên phải"},
    {word: "hand", mean: "tay"},
    {word: "head", mean: "đầu"},
    {word: "body", mean: "thân"},
    {word: "title", mean: "tiêu đề"},
    {word: "if", mean: "nếu"},
    {word: "this", mean: "cái này"},
    {word: "thas", mean: "cái đó"},
    {word: "my", mean: "của tôi"},
    {word: "your", mean: "của bạn"},
    {word: "they", mean: "họ"},
    {word: "who", mean: "là ai"},
    {word: "where", mean: "ở đâu"},
    {word: "what", mean: "cái gì"},
    {word: "how", mean: "thế nào"},
    {word: "do", mean: "làm"},
    {word: "developer", mean: "lập trình viên"},
    {word: "player", mean: "người chơi"},
    {word: "remote", mean: "điều khiển từ xa"},
    {word: "camera", mean: "máy ghi hình"},
    {word: "update", mean: "cập nhật"},
    {word: "setting", mean: "cài đặt"},
    {word: "basic", mean: "cơ bản"},
  ]

  constructor() { }

  getAll(){
    return this.dictionary;
  }

  findByWord(word: string) {
    return this.dictionary.find(item => item.word === word);
  }
}
