package domky.desky;

import domky.PlayerCommandExecutor;
import domky.pocatek.AbsLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;


public class Fontana extends PlayerCommandExecutor {
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int sirka = 10;
        int delka = 10;
        int vyskaSten = 6;
        try {
            if (args.length == 3) {
                sirka = Integer.parseInt(args[0]);
                delka = Integer.parseInt(args[1]);
                vyskaSten = Integer.parseInt(args[2]);
            } else if (args.length != 3 && args.length != 0) {
                player.sendMessage("Zadej tri rozmery, sirku a delku domu a vysku sten kazdeho patra.");
                return true;
            }
            postavFontanu(world, new AbsLocation(playerLocation), sirka, delka, vyskaSten);
        } catch (NumberFormatException e) {
            player.sendMessage("Jeden z argumentu neni cislo.");
        }
        return true;
    }

    public void postavFontanu(World svet, AbsLocation pocatekDomu, int sirkaDomu, int delkaDomu, int vyskaSten) {
        postavZakladDesku(svet, pocatekDomu, sirkaDomu, delkaDomu);
//        postavStenuSJ(svet, pocatekDomu, 0, delkaDomu, vyskaSten);
//        postavStenuSJ(svet, pocatekDomu, sirkaDomu - 1, delkaDomu, vyskaSten);
//        postavStenuVZ(svet, pocatekDomu, 0, sirkaDomu, vyskaSten);
//        postavStenuVZ(svet, pocatekDomu, delkaDomu - 1, sirkaDomu, vyskaSten);
//        postavStrop(svet, pocatekDomu, sirkaDomu, delkaDomu, vyskaSten);
//        postavSloupy(svet, pocatekDomu, delkaDomu, sirkaDomu, vyskaSten);
//        postavPostel(svet, pocatekDomu, sirkaDomu, delkaDomu);
//        postavDvere(svet, pocatekDomu, delkaDomu);
//        postavStrechu1(svet, pocatekDomu, 0, sirkaDomu, delkaDomu, vyskaSten);
//        postavStrechu2(svet, pocatekDomu, delkaDomu - 1, sirkaDomu, delkaDomu, vyskaSten);
//        postavStitStrechy(svet, pocatekDomu, 0, vyskaSten);
//        postavStitStrechy(svet, pocatekDomu, sirkaDomu - 1, vyskaSten);
    }

    private void postavZakladDesku(World svet, AbsLocation pocatekDomu, int sirkaDomu, int delkaDomu) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < delkaDomu; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, -1, j - 1).toLocation());
                aktualniBlok.setType(Material.OAK_WOOD);
            }
        }
    }


  }
