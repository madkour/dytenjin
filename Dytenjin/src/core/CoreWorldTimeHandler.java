/*
 *  Dytenjin is an engine for making dynamic text-based java games.
 *  Copyright (C) 2012 SuperSimpleGuy
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package core;

import core.temporal.WorldCalendar;
import core.temporal.WorldCompleteDate;
import core.temporal.WorldDate;

/**
 * 
 * @author SuperSimpleGuy
 */
public abstract class CoreWorldTimeHandler {

	private WorldCompleteDate currDate;
	private WorldCalendar systemCalendar;
	
	public CoreWorldTimeHandler(WorldCompleteDate currDate, WorldCalendar systemCalendar) {
		this.currDate = currDate;
		this.systemCalendar = systemCalendar;
	}
	
	public WorldCompleteDate getCurrDate() {
		return currDate;
	}
	
	public WorldCalendar getSystemCalendar() {
		return systemCalendar;
	}
	
	public WorldDate getCurrDateInOtherCalendar(WorldCalendar other) {
		return other.getDateFromOtherCalendarDate(currDate, systemCalendar);
	}
	
}
