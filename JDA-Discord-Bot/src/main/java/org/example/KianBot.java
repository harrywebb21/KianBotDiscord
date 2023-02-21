package org.example;
import org.example.listeners.EventListener;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
public class KianBot {

    private final Dotenv config;
    private final ShardManager shardManager;

    public KianBot() throws LoginException {
        // Load the .env file
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");


        // Create the shard manager
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        // Set the status and activity
        builder.setStatus(net.dv8tion.jda.api.OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("Kian's every move"));
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setChunkingFilter(ChunkingFilter.ALL);
        builder.enableCache(CacheFlag.ONLINE_STATUS);
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES);
        // Add the event listener
        shardManager = builder.build();

        // Add the event listener
        shardManager.addEventListener(new EventListener());

    }
    public Dotenv getConfig() {
        return config;
    }
    public ShardManager getShardManager() {
        return shardManager;
    }
    public static void main(String[] args) {
        try {
            KianBot kianBot = new KianBot();
        } catch (LoginException e) {
            System.out.println("Bot token is invalid!");
        }



    }
}
