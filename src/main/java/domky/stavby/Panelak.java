package domky.stavby;

import domky.PlayerCommandExecutor;
import domky.pocatek.AbsLocation;
import domky.schody.Schody;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Bed;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Player;

public class Panelak extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int sirkaDomu = 10;
        int delkaDomu = 10;
        int vyskaPatra = 6;
        int pocetPodlazi = 6;
        AbsLocation pocatekDomu;


        try {
            if (args.length == 3) {
                sirkaDomu = Integer.parseInt(args[0]);
                delkaDomu = Integer.parseInt(args[1]);
                vyskaPatra = Integer.parseInt(args[2]);
                pocetPodlazi = Integer.parseInt(args[3]);
            } else if (args.length != 4 && args.length != 0) {
                player.sendMessage("Zadej ctyri rozmery, sirku a delku domu, vysku sten a pocet podlazi.");
                return true;
            }
            postavPanelak(world, new AbsLocation(playerLocation), sirkaDomu, delkaDomu, vyskaPatra, pocetPodlazi);
        } catch (NumberFormatException e) {
            player.sendMessage("Jeden z argumentu neni cislo.");
        }
        return true;
    }

    public void postavPanelak(World svet, AbsLocation pocatekDomu, int sirkaDomu, int delkaDomu, int vyskaPatra, int pocetPodlazi){
        Schody schodiste = new Schody();

        for (int podlazi = 0; podlazi < pocetPodlazi; podlazi++) {
            postavPodlazi(svet, pocatekDomu, sirkaDomu, delkaDomu, vyskaPatra, podlazi);
        }
        for (int podlazi = 0; podlazi < pocetPodlazi; podlazi++) {
            schodiste.postavSchodisteDum(svet, pocatekDomu.plus(2, (podlazi * vyskaPatra)+1, 6), 2, vyskaPatra);
        }
    }

    private void postavPodlazi(World svet, AbsLocation pocatekDomu, int sirkaDomu, int delkaDomu, int vyskaPatra, int podlazi) {
        postavZakladDeskuStrop(svet, pocatekDomu, sirkaDomu, delkaDomu, vyskaPatra, podlazi);
        postavStenuSJ(svet,pocatekDomu, 1, delkaDomu, vyskaPatra, podlazi);
        postavStenuSJ(svet, pocatekDomu, sirkaDomu, delkaDomu, vyskaPatra, podlazi);
        postavStenuVZ(svet, pocatekDomu,0,  sirkaDomu, vyskaPatra, podlazi);
        postavStenuVZ(svet, pocatekDomu,delkaDomu - 1,  sirkaDomu,vyskaPatra, podlazi);
        postavZakladDeskuStrop(svet, pocatekDomu,sirkaDomu, delkaDomu,vyskaPatra, podlazi + 1);
        postavPostel(svet, pocatekDomu,  sirkaDomu, delkaDomu, vyskaPatra, podlazi);
        postavDvere(svet, pocatekDomu,  delkaDomu);
    }
    private void postavZakladDeskuStrop(World svet, AbsLocation pocatekDomu, int sirkaDomu, int delkaDomu, int vyskaPatra, int podlazi) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < delkaDomu; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, podlazi * vyskaPatra - 1, j - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
        Block svetlo = svet.getBlockAt(pocatekDomu.plus(sirkaDomu / 2, podlazi * vyskaPatra - 2, delkaDomu / 2).toLocation());
        svetlo.setType(Material.LANTERN);
    }

    private void postavStenuSJ(World svet, AbsLocation pocatekDomu, int posun, int delkaDomu, int vyskaPatra, int podlazi) {
        for (int i = 0; i < delkaDomu; i++) {
            for (int j = 0; j < vyskaPatra; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(posun, (j) + (podlazi * vyskaPatra), i - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
        vyrobOknaSJ(svet, pocatekDomu,posun, delkaDomu, vyskaPatra, podlazi);
    }

    private void postavStenuVZ(World svet, AbsLocation pocatekDomu, int posun, int sirkaDomu, int vyskaPatra, int podlazi) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < vyskaPatra; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, (j) + (podlazi * vyskaPatra), posun - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
        vyrobOknaVZ(svet, pocatekDomu,posun,  sirkaDomu, vyskaPatra, podlazi);
    }

    private void vyrobOknaSJ(World svet, AbsLocation pocatekDomu,int posun,  int delkaDomu, int vyskaPatra, int podlazi) {
        for (int m = 0; m < 2; m++) {
            for (int n = 0; n < 2; n++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(posun, podlazi * vyskaPatra + (n + 1), delkaDomu / 2 - (m + 1)).toLocation());
                okno.setType(Material.GLASS);
            }
        }
    }

    private void vyrobOknaVZ(World svet, AbsLocation pocatekDomu,int posun,  int sirkaDomu, int vyskaPatra, int podlazi) {
        for (int m = 0; m < 2; m++) {
            for (int n = 0; n < 2; n++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(m + sirkaDomu / 2, podlazi * vyskaPatra + (n + 1), posun - 1).toLocation());
                okno.setType(Material.GLASS);
            }
        }
    }

    private void postavDvere(World svet, AbsLocation pocatekDomu, int delkaDomu) {
        Block blok1 = svet.getBlockAt(pocatekDomu.plus(2, 1, delkaDomu - 2).toLocation());
        blok1.setType(Material.AIR);
        Block blok2 = svet.getBlockAt(pocatekDomu.plus(2, 0, delkaDomu - 2).toLocation());
        blok2.setType(Material.AIR);

        blok1.setType(Material.DARK_OAK_DOOR);
        final Door dvere1 = (Door) blok1.getBlockData();
        dvere1.setOpen(false);
        dvere1.setFacing(BlockFace.NORTH);
        dvere1.setHalf(Bisected.Half.TOP);
        dvere1.setHinge(Door.Hinge.LEFT);
        dvere1.setPowered(false);
        blok1.setBlockData(dvere1);

        blok2.setType(Material.DARK_OAK_DOOR);
        final Door dvere2 = (Door) blok2.getBlockData();
        dvere2.setOpen(false);
        dvere2.setFacing(BlockFace.NORTH);
        dvere2.setHalf(Bisected.Half.BOTTOM);
        dvere2.setHinge(Door.Hinge.LEFT);
        dvere2.setPowered(false);
        blok2.setBlockData(dvere2);
    }

    private void postavPostel(World svet, AbsLocation pocatekDomu, int sirkaDomu, int delkaDomu, int vyskaPatra, int podlazi) {
        Block blok1 = svet.getBlockAt(pocatekDomu.plus((sirkaDomu - 1), podlazi * vyskaPatra, -1 + delkaDomu / 2).toLocation());
        blok1.setType(Material.YELLOW_BED);
        final Bed postel1 = (Bed) blok1.getBlockData();
        postel1.setPart(Bed.Part.HEAD);
        postel1.setFacing(BlockFace.NORTH);
        blok1.setBlockData(postel1);
        Block blok2 = svet.getBlockAt(pocatekDomu.plus(sirkaDomu - 1, podlazi * vyskaPatra, delkaDomu / 2).toLocation());
        blok2.setType(Material.YELLOW_BED);
        final Bed postel2 = (Bed) blok2.getBlockData();
        postel2.setPart(Bed.Part.FOOT);
        postel2.setFacing(BlockFace.NORTH);
        blok2.setBlockData(postel2);

    }
}
