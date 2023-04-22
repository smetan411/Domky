package domky.desky;

import domky.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Zed  {

    private int vyskaZdi;
    private int delkaZdi;

    public Zed(int vyskaZdi, int delkaZdi) {
        this.vyskaZdi = vyskaZdi;
        this.delkaZdi = delkaZdi;
    }

    public void postavZedSJ(World svet, Location misto, int vyskaZdi, int delkaZdi) {
        for (double y = misto.getY(); y < misto.getY() + vyskaZdi; y++) {
            for (double x = misto.getX(); x < misto.getX() + delkaZdi; x++) {
                Location mistoZdi = new Location(svet, x, y, misto.getZ());
                Block aktualniBlok = svet.getBlockAt(mistoZdi);
                if (aktualniBlok.getType().equals(Material.AIR)) {
                    aktualniBlok.setType(Material.GRAY_CONCRETE);
                }
            }
        }
    }

    public void postavZedVZ(World svet, Location misto, int vyskaZdi, int delkaZdi) {
        for (double y = misto.getY(); y < misto.getY() + vyskaZdi; y++) {
            for (double z = misto.getZ(); z < misto.getZ() + delkaZdi; z++) {
                Location mistoZdi = new Location(svet, misto.getX(), y, z);
                Block aktualniBlok = svet.getBlockAt(mistoZdi);
                if (aktualniBlok.getType().equals(Material.AIR)) {
                    aktualniBlok.setType(Material.GRAY_CONCRETE);
                }
            }
        }
    }
}
