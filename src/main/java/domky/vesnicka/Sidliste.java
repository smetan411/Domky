package domky.vesnicka;

import domky.pocatek.AbsLocation;
import domky.stavby.Panelak;
import org.bukkit.World;

public class Sidliste {
    private final AbsLocation pocatekSidliste;
    private final World svet;
    private final int sirkaDomu;
    private final int delkaDomu;
    private final int vyskaSten;

    public Sidliste(AbsLocation pocatekMesta, World svet, int sirkaDomu,
                    int delkaDomu, int vyskaSten) {
        this.pocatekSidliste = pocatekMesta;
        this.svet = svet;
        this.sirkaDomu = sirkaDomu;
        this.delkaDomu = delkaDomu;
        this.vyskaSten = vyskaSten;
    }

    public void postavSidliste() {
        int[][] mapa = {
                {4, 4, 4, 4, 4, 4},
                {4, 6, 6, 6, 6, 4},
                {4, 6, 12, 8, 6, 4},
                {4, 6, 8, 8, 6, 4},
                {4, 6, 6, 6, 6, 4},
                {4, 4, 4, 4, 4, 4}
        };

        Panelak panelak = new Panelak();
        AbsLocation pocatekDomu = pocatekSidliste;
        for (int[] sloupec : mapa) {
            for (int pocetPater : sloupec) {
                panelak.postavPanelak(svet, pocatekDomu, sirkaDomu, delkaDomu, vyskaSten, pocetPater);
                pocatekDomu = pocatekDomu.plus(sirkaDomu, 0, 0);
            }
            pocatekDomu = pocatekDomu.plus(-sirkaDomu * mapa[0].length, 0, delkaDomu);
        }
    }
}

