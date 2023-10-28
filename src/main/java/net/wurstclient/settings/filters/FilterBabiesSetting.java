/*
 * Copyright (c) 2014-2023 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.settings.filters;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TadpoleEntity;

public final class FilterBabiesSetting extends EntityFilterCheckbox
{
	private static final String EXCEPTIONS_TEXT = "这个过滤器不会"
		+ "影响僵尸宝宝和其他敌对的宝宝生物。";
	
	public FilterBabiesSetting(String description, boolean checked)
	{
		super("过滤宝宝", description + EXCEPTIONS_TEXT, checked);
	}
	
	@Override
	public boolean test(Entity e)
	{
		// filter out passive entity babies
		if(e instanceof PassiveEntity pe && pe.isBaby())
			return false;
		
		// filter out tadpoles
		if(e instanceof TadpoleEntity)
			return false;
		
		return true;
	}
	
	public static FilterBabiesSetting genericCombat(boolean checked)
	{
		return new FilterBabiesSetting(
			"不会攻击小猪，小村民等。", checked);
	}
}
