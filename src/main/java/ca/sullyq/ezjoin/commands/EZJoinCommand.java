package ca.sullyq.ezjoin.commands;

import com.hypixel.hytale.server.core.command.system.basecommands.AbstractCommandCollection;

public class EZJoinCommand extends AbstractCommandCollection {

    public EZJoinCommand() {
        super("ej", "EZJoin plugin commands");
        this.addSubCommand(new JoinDMECommand());
        this.addSubCommand(new JoinShadowTaleCommand());
        this.addSubCommand(new JoinSleepyHallowCommand());
    }
}
