package plugin;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class RastroParticulas extends JavaPlugin implements Listener{

	boolean brillo = false;
	boolean humo = false;
	boolean fuegosArtificiales = false;
	boolean explosion = false;
	boolean corazones = false;
	boolean agua = false;
	boolean magia = false;

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}


	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		final Player p = (Player)sender;

		if(command.getName().equalsIgnoreCase("rastro") && p.isOp()){

			if(args != null && args.length > 0 && args[0].equalsIgnoreCase("tipos") ){
				p.sendMessage(ChatColor.YELLOW + "Tipos de ratros: <brillo> <humo> <explosion> <corazones> <agua> <magia> <fuegosArtificiales>");
			}
			
			if(args != null && args.length > 0 && args[0].equalsIgnoreCase("brillo") ){

				brillo = true;
				humo = false;
				fuegosArtificiales = false;
				explosion = false;
				corazones = false;
				agua = false;
				magia = false;

			}
			
			if(args != null && args.length > 0 && args[0].equalsIgnoreCase("humo") ){

				brillo = false;
				humo = true;
				fuegosArtificiales = false;
				explosion = false;
				corazones = false;
				agua = false;
				magia = false;

			}
			
			if(args != null && args.length > 0 && args[0].equalsIgnoreCase("explosion") ){

				brillo = false;
				humo = false;
				fuegosArtificiales = false;
				explosion = true;
				corazones = false;
				agua = false;
				magia = false;

			}
			
			if(args != null && args.length > 0 && args[0].equalsIgnoreCase("corazones") ){

				brillo = false;
				humo = false;
				fuegosArtificiales = false;
				explosion = false;
				corazones = true;
				agua = false;
				magia = false;

			}
			
			if(args != null && args.length > 0 && args[0].equalsIgnoreCase("agua") ){

				brillo = false;
				humo = false;
				fuegosArtificiales = false;
				explosion = false;
				corazones = false;
				agua = true;
				magia = false;

			}
			
			if(args != null && args.length > 0 && args[0].equalsIgnoreCase("magia") ){

				brillo = false;
				humo = false;
				fuegosArtificiales = false;
				explosion = false;
				corazones = false;
				agua = false;
				magia = true;

			}
			
			if(args != null && args.length > 0 && args[0].equalsIgnoreCase("fuegosArtificiales") ){

				brillo = false;
				humo = false;
				fuegosArtificiales = true;
				explosion = false;
				corazones = false;
				agua = false;
				magia = false;

			}
		}
		return false;
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		final Player p = e.getPlayer();
		Location playerLoc = p.getLocation();
		
		if(brillo == true){
			p.playEffect(playerLoc, Effect.HAPPY_VILLAGER, 9999);
		}
		if(humo == true){
			p.playEffect(playerLoc, Effect.SMOKE, 10);
		}
		
		if(fuegosArtificiales == true){
			p.playEffect(playerLoc, Effect.FIREWORKS_SPARK, 9999);
		}
		
		if(explosion == true){
			p.playEffect(playerLoc, Effect.EXPLOSION_LARGE, 9999);
		}
		
		if(corazones == true){
			p.playEffect(playerLoc, Effect.HEART, 9999);
		}
		
		if(agua == true){
			p.playEffect(playerLoc, Effect.SPLASH, 999999999);
		}
		
		if(magia == true){
			p.playEffect(playerLoc, Effect.WITCH_MAGIC, 999999999);
		}


	}

}