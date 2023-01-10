package ch.tbz.entities.beatmap;

import ch.tbz.entities.Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class Beatmap extends Entities {
    private String title;
    private String artist;
    private Double gamemode;
    private String mapper;
    private Double difficulty_ar;
    private Double difficulty_hp;
    private String source;
    private Double bpm;
    private Double play_length;
    private Double difficulty_od;
    private Double beatmapset;
    private Double favorites;
    private String date;
    private String genre;
    private Double difficulty;
    private Double difficulty_cs;
    private String difficulty_name;
    private Double pass_count;
    private Double beatmap_id;
    private Double beatmapset_id;
    private String language;
    private Double total_length;
    private Double beatmap_status;
    private Double map_count;
    private Double play_count;
    private Object ignored;
}
