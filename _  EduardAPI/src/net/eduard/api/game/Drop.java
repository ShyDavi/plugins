package net.eduard.api.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.API;
import net.eduard.api.manager.EventsManager;

public class Drop extends EventsManager{
	
	public static final Map<World, Map<EntityType, Drop>> ALL_DROPS = new HashMap<>();

	public static final Map<World, Boolean> CAN_DROP = new HashMap<>();

	public static void disable(World world) {
		CAN_DROP.put(world, false);
	}

	public static void enable(World world) {
		CAN_DROP.put(world, true);
	}

	public static Drop getDrop(World world, EntityType type) {
		Map<EntityType, Drop> all = null;
		if (!ALL_DROPS.containsKey(world)) {
			all = new HashMap<>();
			ALL_DROPS.put(world, all);
		} else {
			all = ALL_DROPS.get(world);
		}
		Drop value = null;
		if (!all.containsKey(type)) {
			value = new Drop();
			all.put(type, value);
		} else {
			value = all.get(type);
		}
		return value;
	}

	public static void setDrop(World world, EntityType type, Drop drop) {
		Map<EntityType, Drop> all = null;
		if (!ALL_DROPS.containsKey(world)) {
			all = new HashMap<>();
			ALL_DROPS.put(world, all);
		} else {
			all = ALL_DROPS.get(world);
		}
		all.put(type, drop);
	}

	private boolean enable;

	private boolean normalDrops;

	private int minXp;

	private int maxXp;

	private List<ItemRandom> drops=new ArrayList<>();

	public Drop() {
	}

	public Drop(boolean enable, boolean drop, int min, int max, List<ItemRandom> drops) {
		setEnable(enable);
		setNormalDrops(drop);
		setMinXp(min);
		setMaxXp(max);
		setDrops(drops);
	}

	@EventHandler
	public void event(EntityDeathEvent e) {

		if (e.getEntity() instanceof Player) {
			return;
		}
		LivingEntity entity = e.getEntity();
		Drop drop = Drop.getDrop(entity.getWorld(), e.getEntityType());
		if (drop.isEnable()) {
			if (!drop.isNormalDrops()) {
				e.getDrops().clear();
			}
			e.setDroppedExp(drop.getRandomXp());
			for (ItemRandom itemDrop : drop.getDrops()) {
				ItemStack item = itemDrop.create();
				e.getDrops().add(item);
			}
		}

	}


	/*
	 * Aew
	 */
	public List<ItemRandom> getDrops() {

		return drops;
	}

	public int getMaxXp() {

		return maxXp;
	}

	public int getMinXp() {

		return minXp;
	}

	public int getRandomXp() {

		return API.getRandomInt(getMinXp(), getMaxXp());
	}

	public boolean isEnable() {

		return enable;
	}

	public boolean isNormalDrops() {

		return normalDrops;
	}


	public void setDrops(List<ItemRandom> drops) {

		this.drops = drops;
	}

	public void setEnable(boolean enable) {

		this.enable = enable;
	}

	public void setMaxXp(int maxXp) {

		this.maxXp = maxXp;
	}

	public void setMinXp(int minXp) {

		this.minXp = minXp;
	}

	public void setNormalDrops(boolean normalDrops) {

		this.normalDrops = normalDrops;
	}

	@Override
	public Object restore(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Map<String, Object> map, Object object) {
		// TODO Auto-generated method stub
		
	}

}