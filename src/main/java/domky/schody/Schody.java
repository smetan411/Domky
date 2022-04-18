package domky.schody;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Schody {

    public void postavSchodisteSever(World svet, Location misto, int sirkaSchodiste, int pocetSchodu) {
        Location polohaSchodiste = misto.add(0, -1, 0);
        int naslapnaHloubkaSchodu = 2;
        for (int i = 0; i < pocetSchodu; i++) {
            postavSchodS(svet, polohaSchodiste, naslapnaHloubkaSchodu, sirkaSchodiste);
            polohaSchodiste.add(naslapnaHloubkaSchodu / 2, 1, 0);
        }
    }

    public void postavSchodisteJih(World svet, Location misto, int sirkaSchodiste, int pocetSchodu) {
        Location polohaSchodiste = misto.add(0, -1, 0);
        int naslapnaHloubkaSchodu = 2;
        for (int i = 0; i < pocetSchodu; i++) {
            postavSchodS(svet, polohaSchodiste, naslapnaHloubkaSchodu, sirkaSchodiste);
            polohaSchodiste.add(-naslapnaHloubkaSchodu / 2, 1, 0);
        }
    }

    public void postavSchodisteVychod(World svet, Location misto, int sirkaSchodiste, int pocetSchodu) {
        Location polohaSchodiste = misto.add(0, -1, 0);
        int naslapnaHloubkaSchodu = 2;
        for (int i = 0; i < pocetSchodu; i++) {
            postavSchodV(svet, polohaSchodiste, naslapnaHloubkaSchodu, sirkaSchodiste);
            polohaSchodiste.add(0, 1, naslapnaHloubkaSchodu / 2);
        }
    }

    public void postavSchodisteZapad(World svet, Location misto, int sirkaSchodiste, int pocetSchodu) {
        Location polohaSchodiste = misto.add(0, -1, 0);
        int naslapnaHloubkaSchodu = 2;
        for (int i = 0; i < pocetSchodu; i++) {
            postavSchodV(svet, polohaSchodiste, naslapnaHloubkaSchodu, sirkaSchodiste);
            polohaSchodiste.add(0, 1, -naslapnaHloubkaSchodu / 2);
        }
    }

    public void postavSchodisteDum(World svet, Location misto, int sirkaSchodiste, int pocetSchodu) {
        Location polohaSchodiste = misto.add(0, -1, 0);
        int naslapnaHloubkaSchodu = 1;
        for (int i = 0; i < pocetSchodu; i++) {
            postavSchodV(svet, polohaSchodiste, naslapnaHloubkaSchodu, sirkaSchodiste);
            polohaSchodiste.add(0, 1, -naslapnaHloubkaSchodu);
        }
    }

    public void postavSchodS(World svet, Location misto, int naslapnaHloubka, int sirkaSchodu) {
        for (double x = misto.getX(); x < misto.getX() + naslapnaHloubka; x++) {
            for (double z = misto.getZ(); z < misto.getZ() + sirkaSchodu; z++) {
                Location mistoSchodu = new Location(svet, x, misto.getY(), z);
                Block schod = svet.getBlockAt(mistoSchodu);
                schod.setType(Material.GRAY_CONCRETE);
                int pocetBlokuVzduchuNadSchodistem = 3;
                for (int i = 0; i < pocetBlokuVzduchuNadSchodistem; i++) {
                    Location polohaProVzduch = mistoSchodu.add(0, 1, 0);
                    Block vzduchNadSchodem = svet.getBlockAt(polohaProVzduch);
                    vzduchNadSchodem.setType(Material.AIR);
                }
            }
        }
    }

    public void postavSchodV(World svet, Location misto, int naslapnaHloubka, int sirkaSchodu) {
        for (double x = misto.getX(); x < misto.getX() + sirkaSchodu; x++) {
            for (double z = misto.getZ(); z < misto.getZ() + naslapnaHloubka; z++) {
                Location mistoSchodu = new Location(svet, x, misto.getY(), z);
                Block schod = svet.getBlockAt(mistoSchodu);
                schod.setType(Material.GRAY_CONCRETE);
                int pocetBlokuVzduchuNadSchodistem = 3;
                for (int i = 0; i < pocetBlokuVzduchuNadSchodistem; i++) {
                    Location polohaProVzduch = mistoSchodu.add(0, 1, 0);
                    Block vzduchNadSchodem = svet.getBlockAt(polohaProVzduch);
                    vzduchNadSchodem.setType(Material.AIR);
                }
            }
        }
    }
}
