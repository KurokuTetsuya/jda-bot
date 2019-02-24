package commands;

        import net.dv8tion.jda.api.EmbedBuilder;
        import net.dv8tion.jda.api.entities.Member;
        import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
        import net.dv8tion.jda.api.hooks.ListenerAdapter;

        import java.awt.*;

public class Fun extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String prefix = "g!";
        if (e.getMember().getUser().isBot()) return;
        if (!e.getMessage().getContentRaw().startsWith(prefix)) return;
        String[] args = e.getMessage().getContentRaw().split(" ");
    
        if (e.getMessage().getContentRaw().equalsIgnoreCase("g!ping")) {
            e.getChannel().sendMessage(":ping_pong: Pong !").queue();
        }

        if (args[0].equalsIgnoreCase("g!avatar")) {
            Member mmber = e.getMessage().getMentionedMembers().get(0);
            if (e.getMessage().getMentionedMembers().isEmpty()) e.getChannel().sendMessage("Please mention user first !");
            EmbedBuilder eb = new EmbedBuilder();
            eb.setAuthor(mmber.getUser().getAsTag() + "'s Avatar", "" + mmber.getUser().getAvatarUrl());
            eb.setColor(Color.BLUE);
            eb.setDescription("**[Picture Link](" + mmber.getUser().getAvatarUrl() + ")**");
            eb.setImage(mmber.getUser().getAvatarUrl());
            eb.setFooter("• Message for " + e.getAuthor().getAsTag(), e.getAuthor().getAvatarUrl());
            e.getChannel().sendMessage(eb.build()).queue();
        }

        if (args[0].equalsIgnoreCase("g!help")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setAuthor(e.getJDA().getSelfUser().getName() + " Help !", "" + e.getJDA().getSelfUser().getAvatarUrl());
            eb.setColor(Color.BLUE);
            eb.setDescription(e.getJDA().getSelfUser().getAsTag() + " is a simple discord bot using jda library and java language, created by GarukPeler Team. \nMy prefix is `g!`");
            eb.addField("Commands :", "`help`, `ping`, `avatar`, `userinfo`, `serverinfo`", true);
            eb.setFooter("• Message for " + e.getAuthor().getAsTag(), e.getAuthor().getAvatarUrl());
            e.getChannel().sendMessage(eb.build()).queue();
        }

        if (args[0].equalsIgnoreCase("g!serverinfo")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setAuthor(e.getGuild().getName(), "" + e.getGuild().getIconUrl());
            eb.setDescription("ID : " + e.getGuild().getId());
            eb.addField(":crown: | Server Owner", e.getGuild().getOwner().getAsMention() + " (" + e.getGuild().getOwnerId() + ")", true);
            eb.addField(":stopwatch: |  Created At", "" + e.getGuild().getTimeCreated(), true);
            eb.addField(":earth_americas: | Region", "" + e.getGuild().getRegion(), true);
            eb.setFooter("• Message for " + e.getAuthor().getAsTag(), e.getAuthor().getAvatarUrl());
            e.getChannel().sendMessage(eb.build()).queue();
        }

        if (args[0].equalsIgnoreCase("g!userinfo")) {
            Member mem = e.getMessage().getMentionedMembers().get(0);
            if (e.getMessage().getMentionedMembers().isEmpty()) e.getChannel().sendMessage("Please mention user first !");
            EmbedBuilder eb = new EmbedBuilder();
            eb.setAuthor(mem.getUser().getName() + "'s Info", "" + mem.getUser().getAvatarUrl());
            eb.setColor(Color.GREEN);
            eb.addField("<:os:525584598508503040> | Name", mem.getAsMention() + " (" + mem.getId() + ")", true);
            eb.addField("<a:streaming:534281081323782144> | Presence", "" + mem.getOnlineStatus(), true);
            eb.addField("<a:rips:525585074129731584> | Account Created At", "" + mem.getUser().getTimeCreated(), true);
            e.getChannel().sendMessage(eb.build()).queue();
        }
    }
}
