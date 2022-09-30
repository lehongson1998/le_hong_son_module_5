import { Injectable } from '@angular/core';
import {Song} from '../model/song';

@Injectable({
  providedIn: 'root'
})
export class SongService {

  playlist: Song[] = [
    {
      id: '9BoZN8zhzp0',
      name: 'Céline Dion - Ashes (from the Deadpool 2 Motion Picture Soundtrack)'
    },
    {
      id: '2',
      name: 'Deadpool 2 - Take on Me'
    },
    {
      id: '3',
      name: 'Nelly - Just A Dream'
    },
    {
      id: '4',
      name: 'Eminem - Love The Way You Lie ft. Rihanna'
    },
    {
      id: '5',
      name: 'The Black Eyed Peas - Where Is The Love?'
    }
  ];

  constructor() { }

  findSongById(id: string){
    return this.playlist.find(item => item.id === id);
  }
}
