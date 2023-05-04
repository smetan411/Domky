package domky;

import domky.desky.Deska;
import domky.desky.DeskaTryCatch;
import domky.desky.ZedSJ;
import domky.desky.ZedVZ;
import domky.pocatek.AbsLocation;
import domky.schody.Schodky;
import domky.stavby.Domek;
import domky.stavby.DomekOtoceny;
import domky.stavby.DomekVetsiOkna;
import domky.stavby.Panelak;
import domky.teren.MazaniKolemHrace;
import domky.teren.ZarovnaniTerenu;
import domky.teren.ZarovnaniTerenuNahoru;
import domky.vesnicka.Manhattan;
import domky.vesnicka.Sidliste;
import domky.vesnicka.Vesnicka;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public final class MainDomky extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("+zarovnejTeren").setExecutor(new ZarovnaniTerenu());
        getCommand("+zarovnejTerenNahoru").setExecutor(new ZarovnaniTerenuNahoru());
        getCommand("+vymazKolemHrace").setExecutor(new MazaniKolemHrace());
        getCommand("+zakladovaDeska").setExecutor(new Deska(10, 15));
        getCommand("+zedSeverJih").setExecutor(new ZedSJ(10, 15));
        getCommand("+zedVychodZapad").setExecutor(new ZedVZ(10, 15));
        getCommand("+domek").setExecutor(new Domek());
        getCommand("+domekOtoceny").setExecutor(new DomekOtoceny());
        getCommand("+panelak").setExecutor(new Panelak());
        getCommand("+deskaZadani").setExecutor(new DeskaTryCatch());
        getCommand("+domekVetsiOkna").setExecutor(new DomekVetsiOkna());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        World world = player.getWorld();
        Location location = player.getLocation();
        Schodky schodky = new Schodky();
        AbsLocation pocatekDomu = new AbsLocation(location);
        Sidliste sidliste = new Sidliste(pocatekDomu, world, 10,10,6);
        Vesnicka vesnicka = new Vesnicka(pocatekDomu, world, 10,10,6);
        Manhattan manhattan = new Manhattan(pocatekDomu, world, 10,10,6,6);

        switch(command.getName()){
            case "+vesnicka":
                vesnicka.postavVesnicku();
                break;
            case "+sidliste":
                sidliste.postavSidliste();
                break;
            case "+manhattan":
                manhattan.postavManhattan();
                break;
            case "+schodySever":
                schodky.postavSchodisteSever(world, location);
                break;
            case "+schodyJih":
                schodky.postavSchodisteJih(world, location);
                break;
            case "+schodyVychod":
                schodky.postavSchodisteVychod(world, location);
                break;
            case "+schodyZapad":
                schodky.postavSchodisteZapad(world, location);
                break;
        }
        return true;
    }
}
