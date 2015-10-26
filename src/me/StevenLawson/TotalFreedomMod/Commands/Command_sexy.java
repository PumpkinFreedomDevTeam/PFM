package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "DarkGamingDronze is totally sexy!", usage = "/<command>")
public class Command_sexy extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender_p.chat("Guys!");
        sender_p.chat("SapphireFreedom is Revamped");
        sender_p.chat("Built by there Dev");
        sender_p.chat("And ItzWolf is hot!!");
        playerMsg("", ChatColor.RED);
        playerMsg("", ChatColor.BLUE);
        return true;  
    }
}
