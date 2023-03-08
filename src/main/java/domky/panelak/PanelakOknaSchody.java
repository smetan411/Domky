package domky.panelak;

import domky.pocatek.AbsLocation;
import domky.schody.Schody;
import org.bukkit.World;

public class PanelakOknaSchody extends PanelakOkna {
    private final Schody schody = new Schody();

    public PanelakOknaSchody() {
    }


    @Override
    protected void postavPodlazi(World svet, AbsLocation pocatekDomu, int podlazi, int sirkaDomu, int delkaDomu, int vyskaPatra, int posun) {
        postavZakladDeskuStrop(svet, pocatekDomu, podlazi, sirkaDomu, delkaDomu, vyskaPatra);
        schody.postavSchodisteDum(svet, pocatekDomu.toLocation().add(2, podlazi * vyskaPatra, 4), 2, vyskaPatra);
        postavStenuSJ(svet, pocatekDomu, podlazi, delkaDomu, vyskaPatra, 1);
        postavStenuSJ(svet, pocatekDomu, podlazi, delkaDomu, vyskaPatra, sirkaDomu);
        postavStenuVZ(svet, pocatekDomu, podlazi, sirkaDomu, vyskaPatra, 0);
        postavStenuVZ(svet, pocatekDomu, podlazi, sirkaDomu, vyskaPatra, delkaDomu - 1);
        postavZakladDeskuStrop(svet, pocatekDomu, podlazi, sirkaDomu, delkaDomu, vyskaPatra);
    }

}
