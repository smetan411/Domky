package domky.domek;

import domky.PlayerCommandExecutor;
import domky.pocatek.AbsLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.type.Bed;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Player;

public class Domek extends PlayerCommandExecutor {
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int sirka = 10;
        int delka = 10;
        int vyskaSten = 6;
        try {
        if (args.length == 3) {
                sirka = Integer.parseInt(args[0]);
                delka = Integer.parseInt(args[1]);
                vyskaSten = Integer.parseInt(args[2]);
            } else if (args.length != 3 && args.length != 0) {
                player.sendMessage("Zadej tri rozmery, sirku a delku domu a vysku sten kazdeho patra.");
                return true;
            }
            postavDomek(world, new AbsLocation(playerLocation), sirka, delka, vyskaSten);
        } catch (NumberFormatException e) {
            player.sendMessage("Jeden z argumentu neni cislo.");
        }
        return true;
    }

    public void postavDomek(World svet, AbsLocation pocatekDomu, int sirkaDomu, int delkaDomu, int vyskaSten) {
        postavZakladDesku(svet, pocatekDomu, sirkaDomu, delkaDomu);
        postavStenuSJ(svet, pocatekDomu, 0, delkaDomu, vyskaSten);
        postavStenuSJ(svet, pocatekDomu, sirkaDomu - 1, delkaDomu, vyskaSten);
        postavStenuVZ(svet, pocatekDomu, 0, sirkaDomu, vyskaSten);
        postavStenuVZ(svet, pocatekDomu, delkaDomu - 1, sirkaDomu, vyskaSten);
        postavStrop(svet, pocatekDomu, sirkaDomu, delkaDomu, vyskaSten);
        postavSloupy(svet, pocatekDomu, delkaDomu, sirkaDomu, vyskaSten);
        postavPostel(svet, pocatekDomu, sirkaDomu, delkaDomu);
        postavDvere(svet, pocatekDomu, delkaDomu);
        postavStrechu1(svet, pocatekDomu, 0, sirkaDomu, delkaDomu, vyskaSten);
        postavStrechu2(svet, pocatekDomu, delkaDomu - 1, sirkaDomu, delkaDomu, vyskaSten);
        postavStitStrechy(svet, pocatekDomu, 0, vyskaSten);
        postavStitStrechy(svet, pocatekDomu, sirkaDomu - 1, vyskaSten);
    }

    private void postavStitStrechy(World svet, AbsLocation pocatekDomu, int posun, int vyskaSten) {

        for (int i = 0; i < 8; i++) {
            Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(1 + posun, 1 + vyskaSten, i).toLocation());
            aktualniBlok.setType(Material.OAK_WOOD);
        }
        for (int i = 0; i < 6; i++) {
            Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(1 + posun, 2 + vyskaSten, i + 1).toLocation());
            aktualniBlok.setType(Material.OAK_WOOD);
        }
        for (int i = 0; i < 4; i++) {
            Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(1 + posun, 3 + vyskaSten, i + 2).toLocation());
            aktualniBlok.setType(Material.OAK_WOOD);
        }
        for (int i = 0; i < 2; i++) {
            Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(1 + posun, 4 + vyskaSten, i + 3).toLocation());
            aktualniBlok.setType(Material.OAK_WOOD);
        }
    }

    private void postavZakladDesku(World svet, AbsLocation pocatekDomu, int sirkaDomu, int delkaDomu) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < delkaDomu; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, -1, j - 1).toLocation());
                aktualniBlok.setType(Material.OAK_WOOD);
            }
        }
    }

    private void postavStrop(World svet, AbsLocation pocatekDomu, int sirkaDomu, int delkaDomu, int vyskaSten) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < delkaDomu; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, vyskaSten, j - 1).toLocation());
                aktualniBlok.setType(Material.CHISELED_QUARTZ_BLOCK);
            }
        }
        Block svetlo = svet.getBlockAt(pocatekDomu.plus(sirkaDomu / 2, vyskaSten - 1, delkaDomu / 2).toLocation());
        svetlo.setType(Material.LANTERN);
    }

    private void postavStenuSJ(World svet, AbsLocation pocatekDomu, int posun, int delkaDomu, int vyskaSten) {
        for (int i = 0; i < delkaDomu; i++) {
            for (int j = 0; j < vyskaSten; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(posun + 1, (j), i - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
        for (int k = 0; k < 2; k++) {
            for (int l = 0; l < 2; l++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(posun + 1, (l + 2), delkaDomu / 2 - (k + 1)).toLocation());
                okno.setType(Material.GLASS);
            }
        }
    }

    private void postavStenuVZ(World svet, AbsLocation pocatekDomu, int posun, int sirkaDomu, int vyskaSten) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < vyskaSten; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, (j), posun - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
        for (int k = 0; k < 2; k++) {
            for (int l = 0; l < 2; l++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(k + sirkaDomu / 2, (l + 2), posun - 1).toLocation());
                okno.setType(Material.GLASS);
            }
        }
    }

    private void postavSloupy(World svet, AbsLocation pocatekDomu, int delkaDomu, int sirkaDomu, int vyskaSten) {
        for (int i = 0; i < vyskaSten; i++) {
            Block sloup1 = svet.getBlockAt(pocatekDomu.plus(1, i, -1).toLocation());
            sloup1.setType(Material.OAK_WOOD);
            Block sloup2 = svet.getBlockAt(pocatekDomu.plus(1, i, delkaDomu - 2).toLocation());
            sloup2.setType(Material.OAK_WOOD);
            Block sloup3 = svet.getBlockAt(pocatekDomu.plus(sirkaDomu, i, -1).toLocation());
            sloup3.setType(Material.OAK_WOOD);
            Block sloup4 = svet.getBlockAt(pocatekDomu.plus(sirkaDomu, i, delkaDomu - 2).toLocation());
            sloup4.setType(Material.OAK_WOOD);
        }
    }

    public void postavDvere(World svet, AbsLocation pocatekDomu, int delkaDomu) {
        Block blok1 = svet.getBlockAt(pocatekDomu.plus(2, 1, delkaDomu - 2).toLocation());
        blok1.setType(Material.AIR);
        Block blok2 = svet.getBlockAt(pocatekDomu.plus(2, 0, delkaDomu - 2).toLocation());
        blok2.setType(Material.AIR);

        blok1.setType(Material.DARK_OAK_DOOR);
        final Door dvere1 = (Door) blok1.getBlockData();
        dvere1.setOpen(false);
        dvere1.setFacing(BlockFace.NORTH);
        dvere1.setHalf(Bisected.Half.TOP);
        dvere1.setHinge(Door.Hinge.LEFT);
        dvere1.setPowered(false);
        blok1.setBlockData(dvere1);

        blok2.setType(Material.DARK_OAK_DOOR);
        final Door dvere2 = (Door) blok2.getBlockData();
        dvere2.setOpen(false);
        dvere2.setFacing(BlockFace.NORTH);
        dvere2.setHalf(Bisected.Half.BOTTOM);
        dvere2.setHinge(Door.Hinge.LEFT);
        dvere2.setPowered(false);
        blok2.setBlockData(dvere2);
    }

    private void postavStrechu1(World svet, AbsLocation pocatekDomu, int posun, int sirkaDomu, int delkaDomu, int vyskaSten) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < delkaDomu / 2; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, j + 1 + vyskaSten, (posun - 1) + j).toLocation());
                aktualniBlok.setType(Material.RED_NETHER_BRICK_STAIRS);
                Directional kridlice = (Directional) aktualniBlok.getBlockData();
                kridlice.setFacing(BlockFace.SOUTH);
                aktualniBlok.setBlockData(kridlice);
            }
        }
    }

    private void postavStrechu2(World svet, AbsLocation pocatekDomu, int posun, int sirkaDomu, int delkaDomu, int vyskaSten) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < delkaDomu / 2; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, j + 1 + vyskaSten, (posun - 1) - j).toLocation());
                aktualniBlok.setType(Material.RED_NETHER_BRICK_STAIRS);
                Directional kridlice = (Directional) aktualniBlok.getBlockData();
                kridlice.setFacing(BlockFace.NORTH);
                aktualniBlok.setBlockData(kridlice);
            }
        }
    }

    public void postavPostel(World svet, AbsLocation pocatekDomu, int sirkaDomu, int delkaDomu) {
        Block blok1 = svet.getBlockAt(pocatekDomu.plus((sirkaDomu - 1), 0, -1 + delkaDomu / 2).toLocation());
        blok1.setType(Material.YELLOW_BED);
        final Bed postel1 = (Bed) blok1.getBlockData();
        postel1.setPart(Bed.Part.HEAD);
        postel1.setFacing(BlockFace.NORTH);
        blok1.setBlockData(postel1);
        Block blok2 = svet.getBlockAt(pocatekDomu.plus(sirkaDomu - 1, 0, delkaDomu / 2).toLocation());
        blok2.setType(Material.YELLOW_BED);
        final Bed postel2 = (Bed) blok2.getBlockData();
        postel2.setPart(Bed.Part.FOOT);
        postel2.setFacing(BlockFace.NORTH);
        blok2.setBlockData(postel2);
    }
}

