import { Component, OnInit } from '@angular/core';
import { Tweet } from '../Module/Tweet';
import { TweetsService } from '../services/tweets.service';

@Component({
  selector: 'app-listado-tweets',
  templateUrl: './listado-tweets.component.html',
  styleUrls: ['./listado-tweets.component.css']
})
export class ListadoTweetsComponent implements OnInit {


  misTweets: Array<Tweet>;
  miTweet: Tweet;

  constructor(
    private tweetsService: TweetsService
  ) {

    tweetsService.getAllTweets().subscribe(
      misTweetsObs => {
        this.misTweets = misTweetsObs;
      }
    );

    this.miTweet = new Tweet();
    /*const tweet1 = {
      id: 1,
      texto: 'You know something is unusual when your code runs perfect at first time',
      autor: 'JustADevGuy'
      };
      const tweet2 = {
      id: 1,
      texto: 'You know something is unusual when your code runs perfect at first time',
      autor: 'JustADevGuy'
      };
      const tweet3 = {
      id: 1,
      texto: '1969: What are you doing with that 2KB of RAM? -sending   people to the moon',
      autor: 'AnotherDevGuy'
      };
      const tweet4 = {
      id: 1,
      texto: '2019: What are you doing with that 1.5GB of RAM? -Just checking facebook',
      autor: 'AnotherDevGuy'
      };

      this.misTweets.push(tweet1);
      this.misTweets.push(tweet2);
      this.misTweets.push(tweet3);
      this.misTweets.push(tweet4);
      */
  }

  ngOnInit() {
  }

  addNewTweet() {
    this.misTweets.push(this.miTweet);
    this.miTweet = new Tweet;
  }
}
