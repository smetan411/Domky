package domky.desky;

import domky.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class ZedVZ extends PlayerCommandExecutor {
    private int vyskaZdi;
    private int delkaZdi;

    public ZedVZ(int vyskaZdi, int delkaZdi) {
        this.vyskaZdi = vyskaZdi;
        this.delkaZdi = delkaZdi;
    }

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        for (double y = playerLocation.getY(); y < playerLocation.getY() + vyskaZdi; y++) {
            for (double z = playerLocation.getZ(); z < playerLocation.getZ() + delkaZdi; z++) {
                Location mistoZdi = new Location(world, playerLocation.getX(), y, z);
                Block aktualniBlok = world.getBlockAt(mistoZdi);
                if (aktualniBlok.getType().equals(Material.AIR)) {
                    aktualniBlok.setType(Material.GRAY_CONCRETE);
                }
            }
        }
        return true;
    }
}
