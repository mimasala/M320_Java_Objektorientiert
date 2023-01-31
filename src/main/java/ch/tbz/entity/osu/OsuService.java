package ch.tbz.entity.osu;

import ch.tbz.generic.AbstractEntityService;

import java.lang.reflect.Type;

public class OsuService extends AbstractEntityService<Osu> {
    public OsuService(OsuRepository repository, Type type) {
        super(repository, type);
    }
}
