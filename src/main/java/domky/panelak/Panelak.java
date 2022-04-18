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
        Panelak mujDum = new Panelak(svet, pocatekDomu, delkaDomu, sirkaDomu, pocetPodlazi, vyskaPatra);
        mujDum.postavDum();
        return true;
    }

    protected final World svet;
    protected final AbsLocation pocatekDomu;
    protected final int delkaDomu;
    protected final int sirkaDomu;
    protected final int pocetPodlazi;
    protected final int vyskaPatra;

    public Panelak(World svet, AbsLocation pocatekDomu, int delkaDomu, int sirkaDomu, int pocetPodlazi, int vyskaPatra) {
        this.svet = svet;
        this.pocatekDomu = pocatekDomu;
        this.delkaDomu = delkaDomu;
        this.sirkaDomu = sirkaDomu;
        this.pocetPodlazi = pocetPodlazi;
        this.vyskaPatra = vyskaPatra;
    }

    public void postavDum() {
        for (int podlazi = 0; podlazi < pocetPodlazi; podlazi++) {
            postavPodlazi(podlazi);
        }
    }

    protected void postavPodlazi(int podlazi) {
        postavZakladDeskuStrop(podlazi);
        postavStenuSJ(podlazi, 1);
        postavStenuSJ(podlazi, sirkaDomu);
        postavStenuVZ(podlazi, 0);
        postavStenuVZ(podlazi, delkaDomu - 1);
        postavZakladDeskuStrop(podlazi + 1);
    }

    protected void postavZakladDeskuStrop(int podlazi) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < delkaDomu; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, podlazi * vyskaPatra - 1, j - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
    }

    protected void postavStenuSJ(int podlazi, int posun) {
        for (int i = 0; i < delkaDomu; i++) {
            for (int j = 0; j < vyskaPatra; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(posun, (j) + (podlazi * vyskaPatra), i - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
    }

    protected void postavStenuVZ(int podlazi, int posun) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < vyskaPatra; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, (j) + (podlazi * vyskaPatra), posun - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
    }
}
