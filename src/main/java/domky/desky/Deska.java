package domky.desky;

import domky.PlayerCommandExecutor;
import domky.pocatek.AbsLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Deska extends PlayerCommandExecutor {
    private int sirkaDesky;
    private int delkaDesky;

    public Deska(int sirkaDesky, int delkaDesky) {
        this.sirkaDesky = sirkaDesky;
        this.delkaDesky = delkaDesky;
    }

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        playerLocation.add(0, -1, 0);
        for (int i = 0; i < delkaDesky; i++) {
            for (int j = 0; j < sirkaDesky; j++) {
                Block aktualniBlok = world.getBlockAt(playerLocation);
                aktualniBlok.setType(Material.QUARTZ_BLOCK);
                playerLocation.add(0, 0, 1);
            }
            playerLocation.add(1, 0, -sirkaDesky);
        }
        return true;
    }
}
