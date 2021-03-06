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
package core.management.game;

/**
 * Requires the implemented object to have a unique
 * id compared to others that share its id type.
 * Typically a new UniqueId is created from the
 * IdentityManager class and given to the
 * implementing subclass's constructor
 * @author SuperSimpleGuy
 */
public interface IHasUniqueId {
	
	/**
	 * Gets the UniqueId object that belongs to the
	 * implementing class
	 * @return the implementing class's UniqueId
	 * containing the specific id information
	 */
	UniqueId getUniqueId();
}
