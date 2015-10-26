package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.TELNET, source = SourceType.BOTH)
@CommandParameters(description = "HailNo.", usage = "/<command>")
public class Command_lolno extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender_p.chat("HailNo.go Away or get Ban Hammered");
        Bukkit.dispatchCommand(sender, "expel");
        return true;
    }
}
