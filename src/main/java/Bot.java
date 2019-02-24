import commands.Fun;
import events.HelloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Bot {

    public static String prefix = "g!";
        public static void main (String[] args) throws Exception {
     JDA jda;
      jda = new JDABuilder("token").build();
      jda.addEventListener(new HelloEvent());
      jda.addEventListener(new Fun());
    }
}
