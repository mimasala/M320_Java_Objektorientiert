package ch.tbz.TUI;

import ch.tbz.entities.beatmap.BeatmapService;
import ch.tbz.helpers.InputService;
import ch.tbz.log.OsuLog;

public class BeatmapTUI extends TUI {
    BeatmapService service = new BeatmapService();
    public BeatmapTUI(String name) {
        super(name);
    }

    @Override
    public void startMenu() {
        System.out.println(mainScreen);
        String inp = InputService.getString();
        switch (inp) {
            case "1" -> OsuLog.info(service.getAll().toString());
            case "2" -> OsuLog.info(service.get(InputService.getNum("Enter id: ")).toString());
            case "3" -> {
                service.saveBeatmapFromJsonString(InputService.getString("Enter beatmap json: "));
                OsuLog.info("added beatmap");
            }
            case "4" -> service.delete(InputService.getNum("Enter id: "));
            case "5" -> service.deleteBeatmapByTitle(InputService.getString("Enter title: "));
            case"6" -> OsuLog.info(service.searchBeatmap(InputService.getString("Enter search term: ")));
            case "7" -> service.addBeatmaps(InputService.getString("Enter title: "));
            case "8" -> OsuLog.info(service.updateBeatmapFromJsonString(InputService.getString("enter json: "), InputService.getNum("Enter id: ")).toString());
        }
    }
}
