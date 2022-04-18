package domky.panelak;

import domky.pocatek.AbsLocation;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class PanelakOkna extends Panelak {

    public PanelakOkna(World svet, AbsLocation pocatekDomu, int delkaDomu, int sirkaDomu, int pocetPodlazi, int vyskaPatra) {
        super(svet, pocatekDomu, delkaDomu, sirkaDomu, pocetPodlazi, vyskaPatra);
    }

    @Override
    protected void postavStenuSJ(int podlazi, int posun) {
        super.postavStenuSJ(podlazi, posun);
        vyrobOknaSJ(podlazi, posun);
    }

    @Override
    protected void postavStenuVZ(int podlazi, int posun) {
        super.postavStenuVZ(podlazi, posun);
        vyrobOknaVZ(podlazi, posun);
    }

    private void vyrobOknaSJ(int podlazi, int posun) {
        for (int m = 0; m < 2; m++) {
            for (int n = 0; n < 2; n++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(posun, podlazi * vyskaPatra + (n + 1), delkaDomu / 2 - (m + 1)).toLocation());
                okno.setType(Material.AIR);
            }
        }
    }

    private void vyrobOknaVZ(int podlazi, int posun) {
        for (int m = 0; m < 2; m++) {
            for (int n = 0; n < 2; n++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(m + sirkaDomu / 2, podlazi * vyskaPatra + (n + 1), posun - 1).toLocation());
                okno.setType(Material.AIR);
            }
        }
    }
}
