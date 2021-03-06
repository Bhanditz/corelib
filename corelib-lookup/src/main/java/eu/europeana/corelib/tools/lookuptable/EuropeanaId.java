/*
 * Copyright 2007-2012 The Europeana Foundation
 *
 *  Licenced under the EUPL, Version 1.1 (the "Licence") and subsequent versions as approved
 *  by the European Commission;
 *  You may not use this work except in compliance with the Licence.
 * 
 *  You may obtain a copy of the Licence at:
 *  http://joinup.ec.europa.eu/software/page/eupl
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under
 *  the Licence is distributed on an "AS IS" basis, without warranties or conditions of
 *  any kind, either express or implied.
 *  See the Licence for the specific language governing permissions and limitations under
 *  the Licence.
 */
package eu.europeana.corelib.tools.lookuptable;

import org.bson.types.ObjectId;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
/**
 * Mongo Entity for the representation of the lookup table of the EuropeanaIDs
 * @author yorgos.mamakis@ kb.nl
 *
 */
@Entity ("EuropeanaID")
public class EuropeanaId{
	
	@Id
	private ObjectId id;
	@Indexed (unique=true)
	private String oldId;
	@Indexed (unique=false)
	private String newId;
	private long timestamp;
	private long lastAccess; 

	/**
	 * Get the record ID
	 * @return the record ID
	 */
	public ObjectId getObjectId() {
		return id;
	}

	/**
	 * Set the recordID
	 * @param id The id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	/**
	 * Get the oldID field
	 * @return
	 */
	public String getOldId() {
		return oldId;
	}
	
	/**
	 * Set the oldID field
	 * @param oldId
	 */
	public void setOldId(String oldId) {
		this.oldId = oldId;
	}
	
	/**
	 * Get the newID field
	 * @return the newID Field
	 */
	public String getNewId() {
		return newId;
	}
	
	/**
	 * Get a long representing the date the record was imported
	 * @return The date the record was imported
	 */
	public long getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Set the date the record was imported
	 * @param timestamp The date the record was imported
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * The date the records was last accessed
	 * @return
	 */
	public long getLastAccess() {
		return lastAccess;
	}
	
	/**
	 * Set the date the record was last accessed
	 * @param lastAccess
	 */
	public void setLastAccess(long lastAccess) {
		this.lastAccess = lastAccess;
	}
	
	/**
	 * Set the newId field
	 * @param newId
	 */
	public void setNewId(String newId) {
		this.newId = newId;
	}

}
