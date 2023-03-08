package domky.panelak;

import domky.pocatek.AbsLocation;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class PanelakOkna extends Panelak{

    public PanelakOkna() {
    }

    @Override
    protected void postavStenuSJ(World svet, AbsLocation pocatekDomu, int podlazi, int delkaDomu, int vyskaPatra, int posun) {
        super.postavStenuSJ(svet, pocatekDomu, podlazi, delkaDomu, vyskaPatra, posun);
        vyrobOknaSJ(svet, pocatekDomu, podlazi, delkaDomu, vyskaPatra, posun);
    }

    @Override
    protected void postavStenuVZ(World svet, AbsLocation pocatekDomu, int podlazi, int delkaDomu, int vyskaPatra, int posun) {
        super.postavStenuVZ(svet, pocatekDomu, podlazi, delkaDomu, vyskaPatra, posun);
        vyrobOknaVZ(svet, pocatekDomu, podlazi, delkaDomu, vyskaPatra, posun);
    }

    private void vyrobOknaSJ(World svet, AbsLocation pocatekDomu, int podlazi, int sirkaDomu, int vyskaPatra, int posun) {
        for (int m = 0; m < 2; m++) {
            for (int n = 0; n < 2; n++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(posun, podlazi * vyskaPatra + (n + 1), sirkaDomu / 2 - (m + 1)).toLocation());
                okno.setType(Material.AIR);
            }
        }
    }

    private void vyrobOknaVZ(World svet, AbsLocation pocatekDomu, int podlazi, int delkaDomu, int vyskaPatra, int posun) {
        for (int m = 0; m < 2; m++) {
            for (int n = 0; n < 2; n++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(m + delkaDomu / 2, podlazi * vyskaPatra + (n + 1), posun - 1).toLocation());
                okno.setType(Material.AIR);
            }
        }
    }
}
