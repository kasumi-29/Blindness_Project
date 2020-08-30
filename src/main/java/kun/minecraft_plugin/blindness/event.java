package kun.minecraft_plugin.blindness;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.type.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Locale;

public class event implements Listener {
    private final main m;
    public event(main main) {
        m=main;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        m.getServer().getScheduler().runTask(m, () -> {
            Player player=event.getPlayer();
            Location l=player.getLocation();
            l.setY(l.getY()-1);
            l.getBlock().setType(Material.BEDROCK);

            player.sendBlockChange(player.getLocation(), Material.BEDROCK.createBlockData());
            player.sendMessage("ようこそ");
        });
    }
}
