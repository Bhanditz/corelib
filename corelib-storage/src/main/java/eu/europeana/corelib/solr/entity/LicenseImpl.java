package eu.europeana.corelib.solr.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import org.mongodb.morphia.annotations.Entity;

import eu.europeana.corelib.definitions.edm.entity.License;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonSerialize(include = Inclusion.NON_EMPTY)
@JsonInclude(NON_EMPTY)
@Entity("License")
public class LicenseImpl extends AbstractEdmEntityImpl implements License {

	private String odrlInheritFrom;
	private Date ccDeprecatedOn;
	
	@Override
	public String getOdrlInheritFrom() {
		return this.odrlInheritFrom;
	}

	@Override
	public void setOdrlInheritFrom(String odrlInheritFrom) {
		this.odrlInheritFrom = odrlInheritFrom;
	}

	@Override
	public Date getCcDeprecatedOn() {
		return this.ccDeprecatedOn;
	}

	@Override
	public void setCcDeprecatedOn(Date ccDeprecatedOn) {
		this.ccDeprecatedOn = ccDeprecatedOn;
	}

}
