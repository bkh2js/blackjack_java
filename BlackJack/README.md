# Content
1- Executable version can be found when we cd into `/out/artifacts/BlackJack_jar` then run the command `$ java -jar  BlackJack.jar`
2- An updated class diagram can be found on the root of the application file names `ws3-diagram.png`.
3- The source code. 

# General Notes
I have Forked the original repo so it can be easy to check the changes on each task. Every task has a single commit. (except at the end I have updated the places of the classes)
you can check the repo on `https://github.com/bkh2js/blackjack_java/commits/master` 

# Observer implementation (thinking loudly would be like this);
- Since we need to be informed when the a card is given, the Dealer should trigger the "A card is handed in" event.
- That means the `Dealer` (is) should be coupled to the Publisher.
- To pass the publisher to the Dealer. I have to pass it as a parameter to the `Game` then to the `Dealer`.
- I made the Controller itself as an observer -> Implements `IGameEventSubscriber` ( but it can be implemented on the view where the view subscribe to the publisher events ).
- I had to add a new `DisplayPauseMessage` to the view to display the wait message. 
 