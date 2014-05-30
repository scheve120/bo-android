package org.blitzortung.android.data.provider.result;

import org.blitzortung.android.data.Parameters;
import org.blitzortung.android.data.beans.AbstractStroke;
import org.blitzortung.android.data.beans.Station;
import org.blitzortung.android.data.beans.RasterParameters;
import org.blitzortung.android.data.beans.Stroke;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultEvent implements DataEvent {

	private final List<List<AbstractStroke>> strokes;
  
	private List<Station> stations;
  
	private RasterParameters rasterParameters = null;
  
    private int[] histogram;

    private boolean fail;
	
	private boolean incrementalData;
    
    private long referenceTime;

    private Parameters parameters;

    public ResultEvent() {
        strokes = new ArrayList<List<AbstractStroke>>();
		fail = true;
		incrementalData = false;
	}
	
	public void setStrokes(List<AbstractStroke> strokes) {
        this.strokes.clear();
		this.strokes.add(strokes);
		fail = false;
	}
	
	public boolean containsStrokes() {
		return ! strokes.isEmpty();
	}
	
	public List<AbstractStroke> getStrokes() {
		return strokes.get(0);
	}
	
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	
	public boolean containsParticipants() {
		return stations != null;
	}
	
	public List<Station> getStations() {
		return stations;
	}
	
	public boolean hasFailed() {
		return fail;
	}
	
	public boolean hasRasterParameters() {
		return rasterParameters != null;
	}
	
	public RasterParameters getRasterParameters() {
		return rasterParameters;
	}
	
	public void setRasterParameters(RasterParameters rasterParameters) {
		this.rasterParameters = rasterParameters;
	}

	public boolean containsIncrementalData() {
		return incrementalData;
	}
	
	public void setContainsIncrementalData() {
		incrementalData = true;
	}

    public void setHistogram(int[] histogram) {
        this.histogram = histogram;
    }

    public int[] getHistogram() {
        return histogram;
    }

    public void setReferenceTime(long referenceTime) {
        this.referenceTime = referenceTime;
    }

    public long getReferenceTime() {
        return referenceTime;
    }

    public boolean containsRealtimeData() {
        return parameters.getIntervalOffset() == 0;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Parameters getParameters() {
        return parameters;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (fail) {
            sb.append("FailedResult()");
        } else {
            sb.append("Result(");
            final List<AbstractStroke> currentStrokes = getStrokes();
            sb.append(currentStrokes != null ? currentStrokes.size() : 0).append(" strokes, ");
            sb.append(getParameters());
            if (hasRasterParameters()) {
                sb.append(", ").append(getRasterParameters());
            }
            sb.append(")");
        }

        return sb.toString();
    }
}