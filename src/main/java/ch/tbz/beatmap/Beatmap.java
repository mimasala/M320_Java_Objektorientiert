package ch.tbz.beatmap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter@Setter@AllArgsConstructor@ToString
public class Beatmap {
    private Double difficulty_ar;
    private Double difficulty_hp;
    private String source;
    private Double bpm;
    private Double play_length;
    private Double difficulty_od;
    private Double beatmapset;
    private Double favorites;
    private Double gamemode;
    private String date;
    private String mapper;
    private String genre;
    private Double difficulty;
    private Double difficulty_cs;
    private String difficulty_name;
    private Double pass_count;
    private Double beatmap_id;
    private String artist;
    private Double beatmapset_id;
    private String language;
    private Double total_length;
    private Double beatmap_status;
    private String title;
    private Double map_count;
    private Double play_count;
    private Object ignored;
}
