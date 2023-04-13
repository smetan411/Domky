package domky.vesnicka;

import domky.pocatek.AbsLocation;
import domky.stavby.Domek;
import org.bukkit.World;

public class Vesnicka {
    private final AbsLocation pocatekVesnice;
    private final World svet;
    private final int sirkaDomu;
    private final int delkaDomu;
    private final int vyskaSten;
    private final int pocetPater;


    public Vesnicka(AbsLocation pocatekVesnice, World svet, int sirkaDomu, int delkaDomu, int vyskaSten, int pocetPater) {
        this.pocatekVesnice = pocatekVesnice;
        this.svet = svet;
        this.sirkaDomu = sirkaDomu;
        this.delkaDomu = delkaDomu;
        this.vyskaSten = vyskaSten;
        this.pocetPater = pocetPater;
    }
    public void postavVesnicku() {

        int[][] mapa = {
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {1, 0, 0, 1},
        };

        Domek domek = new Domek();
        AbsLocation pocatekDomu = pocatekVesnice;
        for (int sloupec = 0; sloupec < mapa.length; sloupec++) {
            for (int radek = 0; radek < mapa[sloupec].length; radek++) {
                if (mapa[radek][sloupec] == 1) {
                    domek.postavDomek(svet, pocatekDomu, 10, 10, 6);
                }
                pocatekDomu = pocatekDomu.plus(sirkaDomu, 0, 0);

            }
            pocatekDomu = pocatekDomu.plus(-sirkaDomu*mapa[0].length, 0, delkaDomu);

        }
    }
    //        for (int[]sloupec :mapa ) {
//            for (int radek: sloupec) {
//                if (radek == 1) {
//                    domek.postavDomek(svet, pocatekDomu, 10, 10, 6);
//                }
//            }
//        }
}

