package domky.schody;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class SchodyH {

    public void vytvorSchody(World svet, Location misto, int sirka, int vyska, Material material) {
        Location mistoSchodu = misto.add(1, -1, 0);
        for (int v = 0; v < vyska; v++) {
            for (int i = 0; i < sirka; i++) {
                Block block = svet.getBlockAt(mistoSchodu);
                block.setType(Material.PRISMARINE_STAIRS);
                mistoSchodu.add(0, 1, 0);
                block = svet.getBlockAt(mistoSchodu);
                block.setType(Material.PRISMARINE_STAIRS);
                mistoSchodu.add(1, -1, 0);
            }
            mistoSchodu.add(-sirka, 1, -1);
        }
    }
}
