package es.techtalents.main;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class Ejercicio extends BukkitRunnable{

	private static boolean waitingForInt = false;
	private static boolean datointEntered = false;
	private static int datoInt;

	private static boolean datoFloatEntered = false;
	private static boolean waitingForFloat = false;
	private static float datoFloat;

	private static boolean datoDoubleEntered = false;
	private static boolean waitingForDouble = false;
	private static double datoDouble;

	private static boolean datoStringEntered = false;
	private static boolean waitingForString = false;
	private static String datoString;

	private static boolean waitingForBoolean = false;
	private static boolean datoBooleanEntered = false;
	private static boolean datoBoolean;
	private static Player lastChatPlayer;
	private final JavaPlugin plugin;


	public Ejercicio(JavaPlugin plugin){
		this.plugin = plugin;
	}

	protected void print(String message){
		Bukkit.getServer().broadcastMessage(message);
	}

	protected void print(int message){
		Bukkit.getServer().broadcastMessage(""+message);
	}

	protected void print(float message){
		Bukkit.getServer().broadcastMessage(""+message);
	}

	protected void print(boolean message){
		Bukkit.getServer().broadcastMessage(""+message);
	}

	protected void print(double message){
		Bukkit.getServer().broadcastMessage(""+message);
	}
	
	protected void printToPlayer(String message, String playerName){
		if(getPlayer(playerName) != null){
			getPlayer(playerName).sendMessage(message);
		}
	}
	
	
	
	protected void wait(int milisecs){
		try {
			Thread.sleep(milisecs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected int getInt(){
		waitingForInt = true;
		int acumulado = 0;
		while(!datointEntered){

			try {
				Thread.sleep(10);
				acumulado += 10;
				if(acumulado > 6500){
					print("Esperando un int...");
					acumulado=0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		datointEntered = false;
		waitingForInt = false;
		return datoInt;
	}

	protected float getFloat(){
		waitingForFloat = true;
		int acumulado = 0;
		while(!datoFloatEntered){

			try {
				Thread.sleep(10);
				acumulado += 10;
				if(acumulado > 6500){
					print("Esperando un float...");
					acumulado=0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		datoFloatEntered = false;
		waitingForFloat = false;
		return datoFloat;
	}

	protected double getDouble(){
		waitingForDouble = true;
		int acumulado = 0;
		while(!datoDoubleEntered){

			try {
				Thread.sleep(10);
				acumulado += 10;
				if(acumulado > 6500){
					print("Esperando un double...");
					acumulado=0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		datoDoubleEntered = false;
		waitingForDouble = false;
		return datoDouble;
	}

	protected String getString(){
		waitingForString = true;
		int acumulado = 0;
		while(!datoStringEntered){

			try {
				Thread.sleep(10);
				acumulado += 10;
				if(acumulado > 6500){
					print("Esperando un String...");
					acumulado=0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		datoStringEntered = false;
		waitingForString = false;
		return datoString;
	}

	protected boolean getBoolean(){
		waitingForBoolean = true;
		int acumulado = 0;
		while(!datoBooleanEntered){

			try {
				Thread.sleep(10);
				acumulado += 10;
				if(acumulado > 6500){
					print("Esperando un boolean...");
					acumulado=0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		datoBooleanEntered = false;
		waitingForBoolean = false;
		return datoBoolean;
	}


	private static void printMessage(String message){
		Bukkit.getServer().broadcastMessage(message);
	}

	private static void intEntered(String dato) {
		try{
			datoInt = Integer.parseInt(dato);
			datointEntered = waitingForInt;
		}catch(NumberFormatException e){
			printMessage(ChatColor.RED + "ERROR: '" + dato + "' no es un int correcto");
		}
	}

	private static void floatEntered(String dato) {
		try{
			datoFloat = Float.parseFloat(dato);
			datoFloatEntered = waitingForFloat ;
		}catch(NumberFormatException e){
			printMessage(ChatColor.RED + "ERROR: '" + dato + "' no es un float correcto");
		}
	}

	private static void doubleEntered(String dato) {
		try{
			datoDouble = Double.parseDouble(dato);
			datoDoubleEntered = waitingForDouble ;
		}catch(NumberFormatException e){
			printMessage(ChatColor.RED + "ERROR: '" + dato + "' no es un double correcto");
		}
	}

	private static void stringEntered(String dato) {
		datoStringEntered = waitingForString;
		datoString = dato;
	}

	private static void booleanEntered(String dato) {
		if(dato.equals("true")){
			datoBoolean = true;
			datoBooleanEntered = waitingForBoolean;
		}else if(dato.equals("false")){
			datoBoolean = false;
			datoBooleanEntered = waitingForBoolean;
		}else{
			printMessage(ChatColor.RED + "ERROR: '" + dato + "' no es un boolean correcto");
		}
	}

	public static boolean dataEntered(String dato, Player p) {
		if(waitingForInt){
			lastChatPlayer = p;
			intEntered(dato);
			return true;
		}
		if(waitingForFloat){
			lastChatPlayer = p;
			floatEntered(dato);
			return true;
		}
		if(waitingForDouble){
			lastChatPlayer = p;
			doubleEntered(dato);
			return true;
		}
		if(waitingForString){
			lastChatPlayer = p;
			stringEntered(dato);
			return true;
		}
		if(waitingForBoolean){
			lastChatPlayer = p;
			booleanEntered(dato);
			return true;
		}
		return false;
	}

	protected Player getPlayer(String name){
		return Bukkit.getServer().getPlayer(name);
	}

	protected void kickPlayer(final Player p, final String message){
		Bukkit.getServer().getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				p.kickPlayer(message);
			}
		});
	}

	protected void setBlockType(final Location location, final Material material){
		Bukkit.getServer().getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				location.getBlock().setType(material);
			}
		});
	}

	protected World getWorld(){
		return Bukkit.getServer().getWorlds().get(0);
	}
	
	protected void strikeLightning(Location lugar) {
		getWorld().strikeLightning(lugar);
	}

	protected void strikeLightning(Player p) {
		if(p!=null){
			strikeLightning(p.getLocation());
		}
	}
	
	protected Player getLastChatPlayer(){
		return lastChatPlayer;
	}
	
	protected void giveItem(Player p, Material m){
		Inventory i = p.getInventory();
		
		i.addItem(new ItemStack(m));
		
	}
	
}
