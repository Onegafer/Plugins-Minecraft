package plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillAll {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(sender instanceof Player){
			if(command.getName().equalsIgnoreCase("killall")){

				Player p = (Player)sender;

				p.getWorld().getEntities();

				for(int i = 0; i < p.getWorld().getEntities().size(); i++){
					p.getWorld().getEntities().get(i).remove();
				}

			}
		}
		return false;

	}
}
