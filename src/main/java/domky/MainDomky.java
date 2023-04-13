package domky;

import domky.desky.Deska;
import domky.desky.DeskaTryCatch;
import domky.desky.ZedSJ;
import domky.desky.ZedVZ;
import domky.schody.Schodky;
import domky.stavby.Domek;
import domky.stavby.DomekVetsiOkna;
import domky.stavby.Panelak;
import domky.teren.MazaniKolemHrace;
import domky.teren.ZarovnaniTerenu;
import domky.teren.ZarovnaniTerenuNahoru;
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
        getCommand("+panelak").setExecutor(new Panelak());
        getCommand("+deskaZadani").setExecutor(new DeskaTryCatch());
        getCommand("+domekVetsiOkna").setExecutor(new DomekVetsiOkna());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player hrac = (Player) sender;
        World world = hrac.getWorld();
        Location location = hrac.getLocation();

        Schodky schodky = new Schodky();

        switch(command.getName()){
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
