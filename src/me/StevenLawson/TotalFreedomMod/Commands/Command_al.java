package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Shows all admins", usage = "/<command>", aliases = "adminlist")
public class Command_al extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.GRAY + "- Rouge Admins -");
        sender.sendMessage(ChatColor.GRAY + "tylerhyperHD and darkwolfXST");
        sender.sendMessage(ChatColor.AQUA + "- Super Admins -");
        sender.sendMessage(ChatColor.AQUA + StringUtils.join(TFM_AdminList.getSuperAdminNames(), ", "));
        sender.sendMessage(ChatColor.DARK_GREEN + "- Telnet Admins -");
        sender.sendMessage(ChatColor.DARK_GREEN + StringUtils.join(TFM_AdminList.getTelnetAdminNames(), ", "));
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "- Senior Admins -");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + StringUtils.join(TFM_AdminList.getSeniorAdminNames(), ", "));
        sender.sendMessage(ChatColor.GOLD + "- Executives -");
        sender.sendMessage(ChatColor.GOLD + "None :(");
        sender.sendMessage(ChatColor.GREEN + "- Specialists -");
        sender.sendMessage(ChatColor.GREEN + "");
        sender.sendMessage(ChatColor.RED + "- System Admins -");
        sender.sendMessage(ChatColor.RED + " ,"ItzWolf");
        sender.sendMessage(ChatColor.DARK_PURPLE + "- Developers -");
        sender.sendMessage(ChatColor.DARK_PURPLE + "Lead Dev: reuben4545");
        sender.sendMessage(ChatColor.DARK_PURPLE + "Dev Team Manager: botisz02");
        sender.sendMessage(ChatColor.DARK_PURPLE + "Developers: TheGamingSprite");

}
