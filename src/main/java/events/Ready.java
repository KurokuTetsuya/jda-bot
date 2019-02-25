package events;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ready extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent e){
        System.out.println(e.getJDA().getSelfUser().getAsTag()+" is online for "+e.getGuildTotalCount()+" guilds.");
    }
}
