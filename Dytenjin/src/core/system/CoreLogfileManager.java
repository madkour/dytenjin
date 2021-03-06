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
package core.system;

import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import core.CoreConstants;

/**
 * @author SuperSimpleGuy
 */
public class CoreLogfileManager {

	public static CoreLogfileManager ENGINE_LOGMNGR = new CoreLogfileManager();
	
	private HashMap<String, Level> logLevel;
	
	private CoreLogfileManager() {
		logLevel = new HashMap<String, Level>();
	}
	
	private FileHandler getFileHandler(String fileName) throws RuntimeException {
		FileHandler fHand = null;
		try {
			fHand = new FileHandler(fileName, CoreConstants.MAX_LOG_BYTES, CoreConstants.MAX_LOG_FILES, CoreConstants.LOG_APPEND);
			fHand.setFormatter(new SimpleFormatter());
			fHand.setFormatter(new DytenjinFormatter());
		} catch (Exception e) {
			if (fileName.equals(CoreConstants.SYS_LOG_FILE)) {
				throw new RuntimeException("Could not register the core system's logging file (FileHandler failed).", e);
			} else {
				logWithParams(CoreConstants.SYS_LOG_FILE, Level.WARNING, this.getClass(), "registerFileLogger", "Could not register a file logger.", new String[] {fileName, e.getMessage()});
			}
		}
		return fHand;
	}
	
	public void setLogLevelForFile(String fileName, Level level) {
		logLevel.put(fileName, level);
	}
	
	public void removeLogLevelForFile(String fileName) {
		logLevel.remove(fileName);
	}
	
	public boolean logWithParams(String fileName,
			Level level,
			Class<?> clazz,
			String methodName,
			String message,
			Object[] args) {
		FileHandler f = getFileHandler(fileName);
		if (f == null) {
			return false;
		}
		Logger l = Logger.getLogger(clazz.toString());
		l.setUseParentHandlers(false);
		l.addHandler(f);
		Level logL = logLevel.get(fileName);
		Level oldLogL = l.getLevel();
		if (logL != null) {
			l.setLevel(logL);
		}
		l.logp(level, clazz.toString(), methodName, message, args);
		if (logL != null) {
			l.setLevel(oldLogL);
		}
		l.removeHandler(f);
		l.setUseParentHandlers(true);
		f.close();
		return true;
	}
	
	public boolean logWithoutParams(String fileName,
			Level level,
			Class<?> clazz,
			String methodName,
			String message) {
		FileHandler f = getFileHandler(fileName);
		if (f == null) {
			return false;
		}
		Logger l = Logger.getLogger(clazz.toString());
		l.setUseParentHandlers(false);
		l.addHandler(f);
		Level logL = logLevel.get(fileName);
		Level oldLogL = l.getLevel();
		if (logL != null) {
			l.setLevel(logL);
		}
		l.logp(level, clazz.toString(), methodName, message);
		if (logL != null) {
			l.setLevel(oldLogL);
		}
		l.removeHandler(f);
		l.setUseParentHandlers(true);
		f.close();
		return true;
	}
	
	public boolean enteringWithParams(Class<?> clazz,
			String fileName,
			String methodName,
			String message,
			Object[] args) {
		FileHandler f = getFileHandler(fileName);
		if (f == null) {
			return false;
		}
		Logger l = Logger.getLogger(clazz.toString());
		l.setUseParentHandlers(false);
		l.addHandler(f);
		Level logL = logLevel.get(fileName);
		Level oldLogL = l.getLevel();
		if (logL != null) {
			l.setLevel(logL);
		}
		l.entering(methodName, message, args);
		if (logL != null) {
			l.setLevel(oldLogL);
		}
		l.removeHandler(f);
		l.setUseParentHandlers(true);
		f.close();
		return true;
	}
		
	public boolean enteringWithoutParams(Class<?> clazz,
			String fileName,
			String methodName,
			String message) {
		FileHandler f = getFileHandler(fileName);
		if (f == null) {
			return false;
		}
		Logger l = Logger.getLogger(clazz.toString());
		l.setUseParentHandlers(false);
		l.addHandler(f);
		Level logL = logLevel.get(fileName);
		Level oldLogL = l.getLevel();
		if (logL != null) {
			l.setLevel(logL);
		}
		l.entering(methodName, message);
		if (logL != null) {
			l.setLevel(oldLogL);
		}
		l.removeHandler(f);
		l.setUseParentHandlers(true);
		f.close();
		return true;
	}
	
	public boolean exitingWithResult(Class<?> clazz,
			String fileName,
			String methodName,
			String message,
			Object args) {
		FileHandler f = getFileHandler(fileName);
		if (f == null) {
			return false;
		}
		Logger l = Logger.getLogger(clazz.toString());
		l.setUseParentHandlers(false);
		l.addHandler(f);
		Level logL = logLevel.get(fileName);
		Level oldLogL = l.getLevel();
		if (logL != null) {
			l.setLevel(logL);
		}
		l.exiting(methodName, message, args);
		if (logL != null) {
			l.setLevel(oldLogL);
		}
		l.removeHandler(f);
		l.setUseParentHandlers(true);
		f.close();
		return true;
	}
		
	public boolean exitingWithoutResult(Class<?> clazz,
			String fileName,
			String methodName,
			String message) {
		FileHandler f = getFileHandler(fileName);
		if (f == null) {
			return false;
		}
		Logger l = Logger.getLogger(clazz.toString());
		l.setUseParentHandlers(false);
		l.addHandler(f);
		Level logL = logLevel.get(fileName);
		Level oldLogL = l.getLevel();
		if (logL != null) {
			l.setLevel(logL);
		}
		l.exiting(methodName, message);
		if (logL != null) {
			l.setLevel(oldLogL);
		}
		l.removeHandler(f);
		l.setUseParentHandlers(true);
		f.close();
		return true;
	}
	
}
