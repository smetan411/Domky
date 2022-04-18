package domky;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PlayerCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) throw new RuntimeException("zadavatel neni player");

        Player player = (Player) sender;
        World world = player.getWorld();
        Location playerLocation = player.getLocation();

        return onCommandPlayer(player, world, playerLocation, args);
    }

    public abstract boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args);

}
