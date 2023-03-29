package domky;

import domky.desky.Deska;
import domky.desky.DeskaTryCatch;
import domky.desky.ZedSJ;
import domky.desky.ZedVZ;
import domky.domek.Domek;
import domky.domek.RadoveDomky;
import domky.panelak.Panelak;
import domky.panelak.PanelakOkna;
import domky.panelak.PanelakOknaSchody;
import domky.teren.ZarovnaniTerenu;
import domky.teren.ZarovnaniTerenuNahoru;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainDomky extends JavaPlugin {

    @Override
    public void onEnable() {
        World world = getServer().getWorlds().get(0);
        getCommand("+zarovnejTeren").setExecutor(new ZarovnaniTerenu());
        getCommand("+zarovnejTerenNahoru").setExecutor(new ZarovnaniTerenuNahoru());
        getCommand("+zakladovaDeska").setExecutor(new Deska(10, 15));
        getCommand("+zedSeverJih").setExecutor(new ZedSJ(10, 15));
        getCommand("+zedVychodZapad").setExecutor(new ZedVZ(10, 15));
        getCommand("+domek").setExecutor(new Domek());
        getCommand("+radoveDomky").setExecutor(new RadoveDomky());
        getCommand("+panelak").setExecutor(new Panelak());
        getCommand("+panelakOkna").setExecutor(new PanelakOkna());
        getCommand("+panelakOknaSchody").setExecutor(new PanelakOknaSchody());
        getCommand("+deskaZadani").setExecutor(new DeskaTryCatch());


    }
}
