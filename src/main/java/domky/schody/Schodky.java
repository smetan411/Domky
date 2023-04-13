package domky.schody;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;


public class Schodky {
        int sirkaSchodiste = 10;
        int naslapnaHloubkaSchodu = 2;
        int pocetSchodu = 5;

        public void postavSchodSJ(World world, Location location) {
            for (double x = location.getX(); x < location.getX() + naslapnaHloubkaSchodu; x++) {
                for (double z = location.getZ(); z < location.getZ() + sirkaSchodiste; z++) {
                    Location mistoSchodu = new Location(world, x, location.getY(), z);
                    Block schod = world.getBlockAt(mistoSchodu);
                    schod.setType(Material.GRAY_CONCRETE);
                }
            }
        }

        public void postavSchodVZ(World world, Location location) {
            for (double x = location.getX(); x < location.getX() + sirkaSchodiste; x++) {
                for (double z = location.getZ(); z < location.getZ() + naslapnaHloubkaSchodu; z++) {
                    Location mistoSchodu = new Location(world, x, location.getY(), z);
                    Block schod = world.getBlockAt(mistoSchodu);
                    schod.setType(Material.GRAY_CONCRETE);
                }
            }
        }
        public void postavSchodisteSever(World world, Location location) {
            for (int i = 0; i < pocetSchodu; i++) {
                postavSchodSJ(world, location);
                location.add(1,1,0);
            }
        }

        public void postavSchodisteJih(World world, Location location) {
            for (int i = 0; i < pocetSchodu; i++) {
                postavSchodSJ(world, location);
                location.add(-1,1,0);
            }
        }

        public void postavSchodisteVychod(World world, Location location) {
            for (int i = 0; i < pocetSchodu; i++) {
                postavSchodVZ(world, location);
                location.add(0,1,1);
            }
        }

        public void postavSchodisteZapad(World world, Location location) {
            for (int i = 0; i < pocetSchodu; i++) {
                postavSchodVZ(world, location);
                location.add(0,1,-1);
            }
        }
}
