package domky.domek;

import domky.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class RadoveDomky extends PlayerCommandExecutor {
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int pocetDomecku = 5;
        Domek domecek = new Domek();

        for (int i = 0; i < pocetDomecku; i++) {
            Location mistoDomecku = new Location(world, playerLocation.getX()+i*10, playerLocation.getY(), playerLocation.getZ());
            domecek.onCommandPlayer(player, world, mistoDomecku, args);
        }
        return true;
    }
}
