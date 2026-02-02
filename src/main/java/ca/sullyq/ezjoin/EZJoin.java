package ca.sullyq.ezjoin;

import ca.sullyq.ezjoin.commands.EZJoinCommand;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import lombok.Getter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.logging.Level;

@Getter
public class EZJoin extends JavaPlugin {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    @Getter
    private static EZJoin instance;

    private final String GREEN = "\u001b[0;32m";

    private final String PLUGIN_NAME = GREEN + "[EZ Join]";


    public EZJoin(@Nonnull JavaPluginInit init) {
        super(init);
        instance = this;
    }

    @Override
    protected void setup() {
        LOGGER.at(Level.INFO).log(PLUGIN_NAME + " Setting up...");

        registerCommands();

        LOGGER.at(Level.INFO).log(PLUGIN_NAME + " Setup complete!");
    }

    /**
     * Register plugin commands.
     */
    private void registerCommands() {
        try {
            LOGGER.at(Level.INFO).log(PLUGIN_NAME + " Registered /ej command");
            getCommandRegistry().registerCommand(new EZJoinCommand());
        } catch (Exception e) {
            LOGGER.at(Level.WARNING).withCause(e).log(PLUGIN_NAME + " Failed to register commands");
        }
    }

    @Override
    protected void start() {
        LOGGER.at(Level.INFO).log(PLUGIN_NAME + " Started!");
        LOGGER.at(Level.INFO).log(PLUGIN_NAME + "  Use /ej help for commands");
    }

    @Override
    protected void shutdown() {
        LOGGER.at(Level.INFO).log(PLUGIN_NAME + " Shutting down...");
        instance = null;
    }

}
