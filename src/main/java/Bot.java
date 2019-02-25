import commands.Fun;
import events.Ready;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Bot {

    public static String prefix = "g!";
        public static void main (String[] args) throws Exception {
     JDA jda;
      jda = new JDABuilder("Your Token").build();

      // Import class
      jda.addEventListener(new Fun());
      jda.addEventListener(new Ready());
      
      // Presence
      jda.getPresence().setActivity(Activity.watching("GarkPR Team"));
      jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
    }
}
