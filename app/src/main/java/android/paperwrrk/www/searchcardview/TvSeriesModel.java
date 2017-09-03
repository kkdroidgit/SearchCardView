package android.paperwrrk.www.searchcardview;

/**
 * Created by Kartik on 13-8-17.
 */

public class TvSeriesModel {
    private String name;
    private int drawable;

    public TvSeriesModel(String name, int drawable) {
        this.name = name;
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public int getDrawable() {
        return drawable;
    }
}
