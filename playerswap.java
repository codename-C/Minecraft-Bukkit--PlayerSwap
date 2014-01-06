//I decided not to add comments this time. Too lazy :P


package com.mooo.GuildHub;
//package for our server "The GuildHub".

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
//All of our imports.

public final class playerswap extends JavaPlugin implements Listener{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static playerswap plugin;
	public int version = (int) 1.0;
	//named our final class, logger, plugin, and implemented our listener.
	
  	@Override
	public void onEnable(){
		getLogger().info("PlayerSwap " + version + " has been enabled!");
		getLogger().getPluginManager().registerEvents((Listener)this, this);
	}
	
	@Override
	public void onDisable(){
		getLogger().info("PlayerSwap " + version + " has been disabled!");
	}
	
	@EventHandler (priority = EventPriority.HIGH)
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event){
		if(event.getRightClicked() instanceof Player) {
			Player interacted = (Player) event.getRightClicked();
			Player interacter = (Player) event.getPlayer();
			Location l1 = event.getPlayer().getLocation();
			Location l2 = interacted.getLocation();
			event.getPlayer().teleport(l2);
			interacted.teleport(l1);
			
			interacter.sendMessage(ChatColor.DARK_RED + "Switched!");
			interacted.sendMessage(ChatColor.DARK_RED + "You were switched!");
			
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String [] args){
		Player player = (Player) sender;
		
		if(commandLabel.equalsIgnoreCase("Swap")){
			if(args.length == 0){
				player.sendMessage(ChatColor.DARK_RED + "Swap (Your name) (Target Username)");
			}
			
			if(args.length == 1){
						Player P1 = player.getServer().getPlayer(args[0]);
						Player P2 = player.getServer().getPlayer(args[1]);
						Location l1 = P1.getLocation();
						Location l2 = P2.getLocation();
						P1.teleport(l2);
						P2.teleport(l1);
						
						P1.sendMessage(ChatColor.DARK_RED + "Switched!");
						P2.sendMessage(ChatColor.DARK_RED + "You were switched!");
			}
			
		}
		return false;
		
	}
		


	
}
