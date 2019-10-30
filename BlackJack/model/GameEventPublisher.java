package BlackJack.model;

import java.util.ArrayList;
import java.util.List;

public class GameEventPublisher {

    private List<IGameEventSubscriber> m_subscribers = new ArrayList<>();

    public void Add(IGameEventSubscriber subscriber){
        m_subscribers.add(subscriber);
    }

    public void Remove(IGameEventSubscriber event){

    }

    public void Notify(){
        for(IGameEventSubscriber sub : m_subscribers){
            sub.OnEvent();
        }
    }

}
