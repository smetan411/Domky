package domky.pocatek;

import org.bukkit.Location;

public class AbsLocation {
    private final Location location;

    public AbsLocation(Location location) {

        this.location = location.clone();
    }

    public AbsLocation plus(int x, int y, int z) {
        return new AbsLocation(this.location.clone().add(x, y, z));
    }

    public Location toLocation() {
        return location.clone();
    }
}
