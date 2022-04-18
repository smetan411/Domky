package domky.panelak;

import domky.pocatek.AbsLocation;
import domky.schody.Schody;
import org.bukkit.World;

public class PanelakOknaSchody extends PanelakOkna{

    private final Schody schody = new Schody();

    public PanelakOknaSchody(World svet, AbsLocation pocatekDomu, int delkaDomu, int sirkaDomu, int pocetPodlazi, int vyskaPatra) {
        super(svet, pocatekDomu, delkaDomu, sirkaDomu, pocetPodlazi, vyskaPatra);
    }

    @Override
    protected void postavPodlazi(int podlazi) {
        postavZakladDeskuStrop(podlazi);
        schody.postavSchodisteDum(svet, pocatekDomu.toLocation().add(2, podlazi * vyskaPatra, 4), 2, vyskaPatra);
        postavStenuSJ(podlazi, 1);
        postavStenuSJ(podlazi, sirkaDomu);
        postavStenuVZ(podlazi, 0);
        postavStenuVZ(podlazi, delkaDomu - 1);
        postavZakladDeskuStrop(podlazi + 1);
    }
}
