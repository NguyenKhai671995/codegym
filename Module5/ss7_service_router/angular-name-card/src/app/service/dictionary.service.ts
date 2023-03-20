import {Injectable} from '@angular/core';
import {IWord} from "../model/iWord";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  words: IWord[] = [
    {word: 'hello', mean: 'xin chao', detail: 'khong co'},
    {word: 'age', mean: 'tuoi', detail: 'khong can thiet'},
    {word: 'name', mean: 'ten', detail: 'khong can ghi'},
  ];

  constructor() {
  }

  getAll() {
    return this.words;
  }

  findByWord(word: string) {
    return this.words.filter(w => w.word === word)[0];
  }
}
