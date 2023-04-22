package domky.vesnicka;

import domky.pocatek.AbsLocation;
import domky.stavby.Panelak;
import org.bukkit.World;

public class Manhattan {
    private final AbsLocation pocatekMesta;
    private final World svet;
    private final int sirkaDomu;
    private final int delkaDomu;
    private final int vyskaSten;


    public Manhattan(AbsLocation pocatekMesta, World svet, int sirkaDomu,
                     int delkaDomu, int vyskaSten) {
        this.pocatekMesta = pocatekMesta;
        this.svet = svet;
        this.sirkaDomu = sirkaDomu;
        this.delkaDomu = delkaDomu;
        this.vyskaSten = vyskaSten;
    }

    private int[][] vytvorMapu(int sirka, int delka) {
        int[][] mapa = new int[delka][sirka];
        for (int i = 0; i < sirka - 1; i++) {
            for (int j = 0; j < delka - 1; j++) {
                mapa[i][j] = (int) Math.round(Math.random() * 100);
                if (mapa[i][j] > 30 && mapa[i][j] < 60) {
                    mapa[i][j] = 6;
                } else if (mapa[i][j] >= 60 && mapa[i][j] < 75) {
                    mapa[i][j] = 4;
                } else mapa[i][j] = 0;
            }
        }
        return mapa;
    }

    public void postavManhattan() {
        int[][] mapa = vytvorMapu(10, 10);

        Panelak panelak = new Panelak();
        AbsLocation pocatekDomu = pocatekMesta;
        for (int[] sloupec : mapa) {
            for (int pocetPater : sloupec) {
                panelak.postavPanelak(svet, pocatekDomu, sirkaDomu, delkaDomu, vyskaSten, pocetPater);
                pocatekDomu = pocatekDomu.plus(sirkaDomu, 0, 0);
            }
            pocatekDomu = pocatekDomu.plus(-sirkaDomu * mapa[0].length, 0, delkaDomu);
        }
    }
}

