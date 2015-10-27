package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.FOPM_TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_UuidManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "A Awesome Command.", usage = "/<command> <reuben | Hammer| Sprite> <partialname>")
public class Command_dronze extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String lbl, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            sender.sendMessage(ChatColor.GOLD + "Please enter one of the usages below.");
            return false;
        }
        if (args.length == 2)
        {
            if (args[0].equalsIgnoreCase("reuben"))
            {
                final Player p;
                p = getPlayer(args[1]);
                final Location loc = p.getLocation();
                TFM_Util.bcastMsg("Hey  " + p.getName() + ", Whats The Difference Between Sprite And Dronze? Nothing There both awesome Developers", FOPM_TFM_Util.randomChatColour());
                for (int x = -1; x <= 1; x++)
                {
                    for (int z = -1; z <= 1; z++)
                    {
                        Location strikePos = new Location(loc.getWorld(), loc.getBlockX() + x, loc.getBlockY(), loc.getBlockZ() + z);
                        loc.getWorld().strikeLightning(strikePos);
                    }
                }
                new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        TFM_Util.bcastMsg("I can't jelly my banhammer up your ass.", FOPM_TFM_Util.randomChatColour());
                        p.getWorld().createExplosion(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 4f, false, false);
                        p.setHealth(0.0D);
                        p.closeInventory();
                        p.getInventory().clear();
                        Bukkit.dispatchCommand(sender, "co rb u:" + p.getName() + " t:24h r:global #silent");
                    }
                }.runTaskLater(this.plugin, 60L);

                new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        String userIP = TFM_Util.getFuzzyIp(p.getAddress().getAddress().getHostAddress());
                        TFM_Util.bcastMsg(String.format("%s - banning: %s, IP: %s.", new Object[]
                        {
                            sender.getName(), p.getName(), userIP
                        }), ChatColor.RED);
                        TFM_BanManager.addIpBan(new TFM_Ban(userIP, p.getName(), sender.getName(), null, "You couldn't handle the ban hammer."));
                        TFM_BanManager.addUuidBan(new TFM_Ban(TFM_UuidManager.getUniqueId(p), p.getName(), sender.getName(), null, "You couldn't handle the ban hammer."));
                        p.kickPlayer(ChatColor.RED + "Feel Thy Ban Hammer.");
                    }
                }.runTaskLater(this.plugin, 80L);
            }
            else if (args[0].equalsIgnoreCase("Hammer"))
            {
                Player p = getPlayer(args[1]);
                TFM_Util.bcastMsg(p.getName() + " Has Been Hit By The Dronze Hammer.", FOPM_TFM_Util.randomChatColour());
                p.sendMessage(ChatColor.RED + "You Have Been Hit By The Dronze Hammer bad luck xD");
                Location l = p.getLocation();
                for (int x = -1; x <= 1; x++)
                {
                    for (int z = -1; z <= 1; z++)
                    {
                        Location strikePos = new Location(l.getWorld(), l.getBlockX() + x, l.getBlockY(), l.getBlockZ() + z);
                        l.getWorld().strikeLightning(strikePos);
                    }
                }
                p.setHealth(0.0D);
            }
            else if (args[0].equalsIgnoreCase("Sprite"))
            {
                Player p = getPlayer(args[1]);
                TFM_Util.bcastMsg(p.getName() + " Has Been Ban Hammered By Are Master Sprite.", FOPM_TFM_Util.randomChatColour());
                p.getInventory().clear();
                p.closeInventory();
                p.setHealth(0.0D);
                Location l = p.getLocation();
                for (int x = -1; x <= 1; x++)
                {
                    for (int z = -1; z <= 1; z++)
                    {
                        Location strikePos = new Location(l.getWorld(), l.getBlockX() + x, l.getBlockY(), l.getBlockZ() + z);
                        l.getWorld().strikeLightning(strikePos);
                    }
                }
            }
        }
        else
        {
            return false;
        }
        return true;
    }

    private void cancelLockup(TFM_PlayerData playerdata)
    {
        BukkitTask lockupScheduleID = playerdata.getLockupScheduleID();
        if (lockupScheduleID != null)
        {
            lockupScheduleID.cancel();
            playerdata.setLockupScheduleID(null);
        }
    }
}
