package de.hyper.worlds.common.util.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GlassPane {
	
	public static final ItemStack C0 = get(Material.STAINED_GLASS_PANE, 0),
			C1 = get(Material.STAINED_GLASS_PANE, 1),
			C2 = get(Material.STAINED_GLASS_PANE, 2),
			C3 = get(Material.STAINED_GLASS_PANE, 3),
			C4 = get(Material.STAINED_GLASS_PANE, 4),
			C5 = get(Material.STAINED_GLASS_PANE, 5),
			C6 = get(Material.STAINED_GLASS_PANE, 6),
			C7 = get(Material.STAINED_GLASS_PANE, 7),
			C8 = get(Material.STAINED_GLASS_PANE, 8),
			C9 = get(Material.STAINED_GLASS_PANE, 9),
			C10 = get(Material.STAINED_GLASS_PANE, 10),
			C11 = get(Material.STAINED_GLASS_PANE, 11),
			C12 = get(Material.STAINED_GLASS_PANE, 12),
			C13 = get(Material.STAINED_GLASS_PANE, 13),
			C14 = get(Material.STAINED_GLASS_PANE, 14),
			C15 = get(Material.STAINED_GLASS_PANE, 15);
	public static final ItemStack WHITE = C0,
			ORANGE = C1,
			MAGENTA = C2,
			LIGHT_BLUE = C3,
			YELLOW = C4,
			LIME = C5,
			PINK = C6,
			GRAY = C7,
			LIGHT_GRAY = C8,
			CYAN = C9,
			PURPLE = C10,
			BLUE = C11,
			BROWN = C12,
			GREEN = C13,
			RED = C14,
			BLACK = C15;

	private static final ItemStack get(Material mat, int subID) {
		ItemStack is = new ItemStack(mat, 1, (byte) subID);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("§a");
		is.setItemMeta(im);
		return is;
	}
}
