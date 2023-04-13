package domky.schody;

import domky.pocatek.AbsLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Schody {

    private AbsLocation pocatekDomu;

    public void postavSchodisteSever(World svet, AbsLocation misto, int sirkaSchodiste, int naslapnaHloubkaSchodu, int pocetSchodu) {
        var polohaSchodiste = misto.plus(0, -1, 0);
        for (int i = 0; i < pocetSchodu; i++) {
            postavSchodS(svet, polohaSchodiste, naslapnaHloubkaSchodu, sirkaSchodiste);
            polohaSchodiste = polohaSchodiste.plus(naslapnaHloubkaSchodu / 2, 1, 0);
        }
    }

    public void postavSchodisteJih(World svet, AbsLocation misto, int sirkaSchodiste, int naslapnaHloubkaSchodu, int pocetSchodu) {
        var polohaSchodiste = misto.plus(0, -1, 0);
        for (int i = 0; i < pocetSchodu; i++) {
            postavSchodS(svet, polohaSchodiste, naslapnaHloubkaSchodu, sirkaSchodiste);
            polohaSchodiste = polohaSchodiste.plus(-naslapnaHloubkaSchodu / 2, 1, 0);
        }
    }

    public void postavSchodisteVychod(World svet, AbsLocation misto, int sirkaSchodiste, int naslapnaHloubkaSchodu,int pocetSchodu) {
        var polohaSchodiste = misto.plus(0, -1, 0);
        for (int i = 0; i < pocetSchodu; i++) {
            postavSchodV(svet, polohaSchodiste, naslapnaHloubkaSchodu, sirkaSchodiste);
            polohaSchodiste = polohaSchodiste.plus(0, 1, naslapnaHloubkaSchodu / 2);
        }
    }

    public void postavSchodisteZapad(World svet, AbsLocation misto, int sirkaSchodiste,int naslapnaHloubkaSchodu, int pocetSchodu) {
        var polohaSchodiste = misto.plus(0, -1, 0);
        for (int i = 0; i < pocetSchodu; i++) {
            postavSchodV(svet, polohaSchodiste, naslapnaHloubkaSchodu, sirkaSchodiste);
            polohaSchodiste = polohaSchodiste.plus(0, 1, -naslapnaHloubkaSchodu / 2);
        }
    }

    public void postavSchodisteDum(World svet, AbsLocation misto, int sirkaSchodiste, int pocetSchodu) {
        var polohaSchodiste = misto.plus(0, -1, 0);
        int naslapnaHloubkaSchodu = 1;
        for (int i = 0; i < pocetSchodu; i++) {
            postavSchodV(svet, polohaSchodiste, naslapnaHloubkaSchodu, sirkaSchodiste);
            polohaSchodiste = polohaSchodiste.plus(0, 1, -naslapnaHloubkaSchodu);
        }
    }

    public void postavSchodS(World svet, AbsLocation misto, int naslapnaHloubka, int sirkaSchodu) {
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

    public void postavSchodV(World svet, AbsLocation misto, int naslapnaHloubka, int sirkaSchodu) {
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
