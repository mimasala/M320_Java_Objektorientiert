package ch.tbz.data;

import ch.tbz.entities.beatmap.Beatmap;

import java.util.ArrayList;
import java.util.List;

public class BeatmapDB extends ArrayList<Beatmap> {
    public BeatmapDB() {
        super();
    }

    public BeatmapDB(List<Beatmap> beatmaps) {
        super(beatmaps);
    }
}

