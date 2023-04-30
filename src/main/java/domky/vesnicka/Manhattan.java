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
    private final int pocetPodlazi;


    public Manhattan(AbsLocation pocatekMesta, World svet, int sirkaDomu,
                     int delkaDomu, int vyskaSten, int pocetPodlazi) {
        this.pocatekMesta = pocatekMesta;
        this.svet = svet;
        this.sirkaDomu = sirkaDomu;
        this.delkaDomu = delkaDomu;
        this.vyskaSten = vyskaSten;
        this.pocetPodlazi = pocetPodlazi;
    }

    public void postavManhattan() {

        int delka = 10;
        int sirka = 10;
        int[][] mapa = new int[delka][sirka];
        for (int i = 0; i < sirka-1; i++) {
            for (int j = 0; j < delka-1; j++) {
                mapa[i][j] = (int) Math.round(Math.random() * 100);
                if(mapa[i][j] > 30 && mapa[i][j] < 60){
                    mapa[i][j] = 1;
                }
                else if(mapa[i][j] >= 60 && mapa[i][j] < 75){
                    mapa[i][j] = 2;
                }
                else mapa [i][j] = 0;
            }
        }

        Panelak panelak = new Panelak();
        AbsLocation pocatekDomu = pocatekMesta;
        for (int sloupec = 0; sloupec < mapa.length; sloupec++) {
            for (int radek = 0; radek < mapa[sloupec].length; radek++) {
                if (mapa[radek][sloupec] == 1) {
                    panelak.postavPanelak(svet, pocatekDomu, 10, 10, 6, 6);
                }
                if (mapa[radek][sloupec] == 2) {
                    panelak.postavPanelak(svet, pocatekDomu, 10, 10, 6, 4);
                }
                pocatekDomu = pocatekDomu.plus(sirkaDomu, 0, 0);
            }
            pocatekDomu = pocatekDomu.plus(-sirkaDomu * mapa[0].length, 0, delkaDomu);
        }
    }
}

