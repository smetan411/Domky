package domky;

import domky.desky.Deska;
import domky.domek.Domecek;
import domky.domek.StandardDomek;
import domky.panelak.Panelak;
import domky.panelak.PanelakOkna;
import domky.panelak.PanelakOknaSchody;
import domky.pocatek.AbsLocation;
import domky.teren.ZarovnaniTerenu;
import domky.teren.ZarovnaniTerenuNahoru;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainDomky extends JavaPlugin {

    @Override
    public void onEnable() {
        World world = getServer().getWorlds().get(0);

        getCommand("+zarovnejTeren").setExecutor(new ZarovnaniTerenu());
        getCommand("+zarovnejTerenNahoru").setExecutor(new ZarovnaniTerenuNahoru());
        getCommand("+zakladovaDeska").setExecutor(new Deska(10, 15));
        getCommand("+domecek").setExecutor(new Domecek(world, 10, 10, 6));
        getCommand("+standardniDomek").setExecutor(new StandardDomek(world));
        getCommand("+panelak").setExecutor(new Panelak(world, 10, 10, 6, 6));
        getCommand("+panelakOkna").setExecutor(new PanelakOkna(world,10, 10, 6, 6));
        getCommand("+panelakOknaSchody").setExecutor(new PanelakOknaSchody(world,10, 10, 6, 6));

    }
}
