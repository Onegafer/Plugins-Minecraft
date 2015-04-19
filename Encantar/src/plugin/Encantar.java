package plugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Encantar extends JavaPlugin implements Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		Player p = (Player)sender;
		
		//Comprobamos si el que envía el comando es un jugador
		if(sender instanceof Player){
			
			//Comprobamos si el comando es "encantar"
			if(command.getName().equalsIgnoreCase("encantar")){
					
					ItemStack item = p.getItemInHand();
					Material itemType = item.getType();
					
					item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL , 5);
					item.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS , 5);
					item.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD , 5);
					item.addUnsafeEnchantment(Enchantment.DURABILITY , 4);
					item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT , 4);
					item.addUnsafeEnchantment(Enchantment.KNOCKBACK , 4);
					item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS , 5);
					item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE , 5);
					item.addUnsafeEnchantment(Enchantment.ARROW_FIRE , 5);
					item.addUnsafeEnchantment(Enchantment.ARROW_INFINITE , 5);
					item.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK , 5);
					item.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER , 5);
					item.addUnsafeEnchantment(Enchantment.DIG_SPEED , 5);
					item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS , 5);
					item.addUnsafeEnchantment(Enchantment.OXYGEN , 5);
					item.addUnsafeEnchantment(Enchantment.LURE , 5);
					item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL , 5);
					item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL , 5);
					item.addUnsafeEnchantment(Enchantment.SILK_TOUCH , 5);
					item.addUnsafeEnchantment(Enchantment.THORNS , 5);
					item.addUnsafeEnchantment(Enchantment.WATER_WORKER , 5);
					
					p.sendMessage(ChatColor.YELLOW + "Tu " + itemType + " ya está escantada!");
					}

				}
			return false;
	}
}