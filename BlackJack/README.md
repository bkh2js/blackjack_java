# General Notes
I have Forked the original repo so it can be easy to check the changes on each task. Every task has a single commit.

# Observer implementation notes;
- Since we need to be informed when the a card is given, the Dealer should trigger the "A card is handed in " event.
- That means the `Dealer` (is) should be coupled to the Publisher.
- To pass the publisher to the Dealer. I have to pass it as a parameter to the `Game` then to the `Dealer`.
- I made the Controller itself as an observer -> Implements `IGameEventSubscriber` ( but it can be implemented on the view where the view subscribe to the publisher events ).
- I had to add a new `DisplayPauseMessage` to the view to display the wait message.
 