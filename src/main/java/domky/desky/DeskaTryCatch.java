package domky.desky;

import domky.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class DeskaTryCatch extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int delkaDesky = 10;
        int sirkaDesky = 15;
        try {
            if (args.length == 2) {
                delkaDesky = Integer.parseInt(args[0]);
                delkaDesky = Integer.parseInt(args[1]);
            } else if (args.length > 0 && args.length != 2) {
                player.sendMessage("Musis zadat dva parametry, delkaDesky a sirkaDesky.");
            }
            playerLocation.add(0, -1, 0);
            for (int i = 0; i < delkaDesky; i++) {
                for (int j = 0; j < sirkaDesky; j++) {
                    Block aktualniBlok = world.getBlockAt(playerLocation);
                    aktualniBlok.setType(Material.QUARTZ_BLOCK);
                    playerLocation.add(0, 0, 1);
                }
                playerLocation.add(1, 0, -sirkaDesky);
            }
        } catch (NumberFormatException e) {
            player.sendMessage("Argument musi byt cislo.");
        }
        return true;
    }
}
