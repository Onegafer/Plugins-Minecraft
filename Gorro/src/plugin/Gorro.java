package plugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Gorro extends JavaPlugin implements Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		Player p = (Player)sender;
		
		//Comprobamos si el que envía el comando es un jugador
		if(sender instanceof Player){
			
			//Comprobamos si el comando es "gorro"
			if(command.getName().equalsIgnoreCase("gorro")){
					
					ItemStack bloque = p.getItemInHand(); 
					
					p.getInventory().setHelmet(bloque);
					Material bloqueTipo = bloque.getType();
					
					p.sendMessage(ChatColor.GOLD + "Ahora llevas un gorro de " + bloqueTipo);
				}
				}
				return false;
	}
}