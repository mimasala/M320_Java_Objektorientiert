package ch.tbz.beatmap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class Beatmap {
    private Integer beatmapId;
    private String title;
    private String artist;
    private String creator;
    private String genre;
    private String background;
}
