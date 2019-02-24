import commands.Fun;
import events.HelloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Bot {

    public static String prefix = "g!";
        public static void main (String[] args) throws Exception {
     JDA jda;
      jda = new JDABuilder("NTQ4MzU3MDI0MTE1NTg5MTIw.D1ES3Q.i3t7WYrpLR56bFWPCmBBoLwVClw").build();
      jda.addEventListener(new HelloEvent());
      jda.addEventListener(new Fun());
    }
}