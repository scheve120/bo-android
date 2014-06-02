package org.blitzortung.android.alarm;

import org.blitzortung.android.alarm.object.AlarmSector;

public class AlarmResult implements AlertEvent {
	
	private final AlarmSector sector;
    
    private final String distanceUnitName;

    public AlarmResult(AlarmSector sector, String distanceUnitName) {
		this.sector = sector;
        this.distanceUnitName = distanceUnitName;
    }

	public float getClosestStrokeDistance() {
		return sector.getClosestStrokeDistance();
	}

    public String getDistanceUnitName() {
        return distanceUnitName;
    }

    public String getBearingName() {
        return sector.getLabel();
    }
    
    @Override
    public String toString() {
        return String.format("%s %.1f %s", getBearingName(), getClosestStrokeDistance(), getDistanceUnitName());
    }
}
