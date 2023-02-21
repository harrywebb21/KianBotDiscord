package org.example.listeners;


import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;





public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        User user = event.getJDA().getUserById("440657230510161921");
        User kian = event.getJDA().getUserById("858453372541599754");
        String message = kian.getAsMention() + " No one cares for your reaction!";
        event.getChannel().sendMessage(message).queue();
    }

    @Override
    public void onUserUpdateOnlineStatus(@NotNull UserUpdateOnlineStatusEvent event) {
        super.onUserUpdateOnlineStatus(event);
        User kian = event.getJDA().getUserById("858453372541599754");
        User user = event.getJDA().getUserById("440657230510161921");
        String messageOnline = kian.getAsMention() + " is now online ffs!";
        String messageOffline = "Finally " + kian.getAsMention() + " is now offline!";
        if (event.getNewOnlineStatus().getKey().equals("online")) {
            event.getJDA().getTextChannelById("1077591818520252448").sendMessage(messageOnline).queue();
        }
        if (event.getNewOnlineStatus().getKey().equals("offline")) {
            event.getJDA().getTextChannelById("1077591818520252448").sendMessage(messageOffline).queue();
        }
    }

    String[] kianInsults = {
            "Stop talking",
            "Please be quiet",
            "You're annoying",
            "You're a waste of space",
            "You're a waste of oxygen",
            "No one cares for your opinion",
            "Why are you even here?",
            "Why are you even alive?",
            "Why are you still talking?",
            "Just shut up",
            "Stop typing",
            "https://media.giphy.com/media/U7isUDZ6VPWJW/giphy.gif",
            "https://media.giphy.com/media/6gVAFvio89QaqKYBA2/giphy.gif",
            "https://media.giphy.com/media/UAJpANY0bGPhS/giphy.gif",
            "https://media.giphy.com/media/1rLDTQAsBBFicPIi0D/giphy.gif",
            "https://media.giphy.com/media/1qxHhpb2V8Bxu/giphy.gif",
            "https://media.giphy.com/media/f8oqjTlp0PdMA/giphy.gif",
            "https://media.giphy.com/media/l0HUbtILos6CdAtxu/giphy.gif",
            "https://media.giphy.com/media/xUNd9Wd8iNaRwGyPCM/giphy.gif",
            "https://media.giphy.com/media/VOXYLGT929LOLGA1oT/giphy.gif",
            "https://media.giphy.com/media/lNrNLRLmpC3VIjl82D/giphy.gif",
            "https://media.giphy.com/media/KiICaQKQkdu3rWxNCT/giphy.gif"


    };
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        User user = event.getJDA().getUserById("440657230510161921");
        User kian = event.getJDA().getUserById("858453372541599754");
        if (event.getAuthor().getId().equals(kian.getId())) {
            int random = (int) (Math.random() * kianInsults.length);
            event.getChannel().sendMessage(kianInsults[random]).queue();
            if (message.contains(user.getAsMention())) {
                event.getChannel().sendMessage("Harry doesn't care for your opinion so don't mention him").queue();
            }
        }


    }
}

