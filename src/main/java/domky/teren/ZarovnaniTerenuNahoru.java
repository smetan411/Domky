package domky.teren;

import domky.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class ZarovnaniTerenuNahoru extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {

        int delkaRoviny = 50;
        int sirkaRoviny = 50;

        playerLocation.add(-delkaRoviny / 2, -1, -sirkaRoviny / 2);

        for (int i = 0; i < delkaRoviny; i++) {
            for (int j = 0; j < sirkaRoviny; j++) {
                playerLocation.add(1, 0, 0);
                Block aktualniBlok = world.getBlockAt(playerLocation);
                aktualniBlok.setType(Material.GRASS_BLOCK);
                //nad deskou vzduch
                playerLocation.add(0, 1, 0);
                for (int y = 0; y < 35; y++) {
                    Block novyBlok = world.getBlockAt(playerLocation);
                    novyBlok.setType(Material.AIR);
                    playerLocation.add(0, 1, 0);
                }
                playerLocation.add(0, -36, 0);
            }
            playerLocation.add(-sirkaRoviny, 0, 1);
        }
        playerLocation.add(0, 1, -delkaRoviny);
        return true;
    }
}
