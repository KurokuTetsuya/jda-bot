package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if (event.getMember().getUser().isBot()) return;
        String msg = event.getMessage().getContentRaw();
        String user = event.getAuthor().getAsTag();
     // uselesssss logging wkewkw   System.out.println(user+" In "+ event.getGuild().getName()+"Said : "+ msg);
    }
}
