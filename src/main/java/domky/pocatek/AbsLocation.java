package domky.pocatek;

import org.bukkit.Location;
import org.bukkit.World;

public class AbsLocation {
    private final Location location;

    public AbsLocation(Location location) {

        this.location = location.clone();
    }

    public AbsLocation plus(int x, int y, int z) {
        return new AbsLocation(this.location.clone().add(x, y, z));
    }

    public double getX() {
        return location.getX();
    }

    public double getY() {
        return location.getY();
    }

    public double getZ() {
        return location.getZ();
    }

    public World getWorld()
    {
        return location.getWorld();
    }

    public Location toLocation() {
        return location.clone();
    }
}
