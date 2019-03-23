import { Injectable } from '@angular/core';
import { ALL_TWEETS } from '../data/DataService';
import { Observable, of } from 'rxjs';
import { Tweet } from '../Module/Tweet';

@Injectable({
  providedIn: 'root'
})
export class TweetsService {

  constructor() { }


  getAllTweets(): Observable<Tweet[]> {
    return of(ALL_TWEETS);
  }

}
