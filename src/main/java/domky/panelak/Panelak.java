package domky.panelak;

import domky.PlayerCommandExecutor;
import domky.pocatek.AbsLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Panelak extends PlayerCommandExecutor {
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int sirka = 10;
        int delka = 14;
        int vyskaPatra = 6;
        int pocetPodlazi = 6;
        try {
            if (args.length == 4) {
                sirka = Integer.parseInt(args[0]);
                delka = Integer.parseInt(args[1]);
                vyskaPatra = Integer.parseInt(args[2]);
                pocetPodlazi = Integer.parseInt(args[3]);
            } else if (args.length != 4 && args.length != 0) {
                player.sendMessage("Zadej ctyri rozmery, sirku a delku domu, vysku patra a pocet podlazi.");
                return true;
            }
            postavPodlazi(world, new AbsLocation(playerLocation), 0, sirka, delka, vyskaPatra, 0);
            postavDum(world, new AbsLocation(playerLocation), sirka, delka, vyskaPatra, pocetPodlazi, vyskaPatra);
        } catch (NumberFormatException e) {
            player.sendMessage("Jeden z argumentu neni cislo.");
        }
        return true;
    }

    public void postavDum(World svet, AbsLocation pocatekDomu, int sirkaDomu, int delkaDomu, int vyskaPatra, int pocetPodlazi, int posun) {
        for (int podlazi = 0; podlazi < pocetPodlazi; podlazi++) {
            postavPodlazi(svet, pocatekDomu, podlazi, sirkaDomu, delkaDomu, vyskaPatra, posun);
        }
    }

    protected void postavPodlazi(World svet, AbsLocation pocatekDomu, int podlazi, int sirkaDomu, int delkaDomu, int vyskaPatra, int posun) {
        postavZakladDeskuStrop(svet, pocatekDomu, podlazi, sirkaDomu, delkaDomu, vyskaPatra);
        postavStenuSJ(svet, pocatekDomu, podlazi, delkaDomu, vyskaPatra, 1);
        postavStenuSJ(svet, pocatekDomu, podlazi, delkaDomu, vyskaPatra, sirkaDomu);
        postavStenuVZ(svet, pocatekDomu, podlazi, sirkaDomu, vyskaPatra, 0);
        postavStenuVZ(svet, pocatekDomu, podlazi, sirkaDomu, vyskaPatra, delkaDomu - 1);
        postavZakladDeskuStrop(svet, pocatekDomu, podlazi, sirkaDomu, delkaDomu, vyskaPatra);
    }

    protected void postavZakladDeskuStrop(World svet, AbsLocation pocatekDomu, int podlazi, int sirkaDomu, int delkaDomu, int vyskaPatra) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < delkaDomu; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, podlazi * vyskaPatra - 1, j - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
    }

    protected void postavStenuSJ(World svet, AbsLocation pocatekDomu, int podlazi, int delkaDomu, int vyskaPatra, int posun) {
        for (int i = 0; i < delkaDomu; i++) {
            for (int j = 0; j < vyskaPatra; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(posun, (j) + (podlazi * vyskaPatra), i - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
    }

    protected void postavStenuVZ(World svet, AbsLocation pocatekDomu, int podlazi, int sirkaDomu, int vyskaPatra, int posun) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < vyskaPatra; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, (j) + (podlazi * vyskaPatra), posun - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
    }
}
