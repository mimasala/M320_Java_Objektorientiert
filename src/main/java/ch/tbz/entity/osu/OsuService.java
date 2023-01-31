package ch.tbz.entity.osu;

import ch.tbz.generic.AbstractEntityService;

import java.lang.reflect.Type;
/**
 * Osu Service
 * @author mytal
 * @version 1.0.0
 */
public class OsuService extends AbstractEntityService<Osu> {
    public OsuService(OsuRepository repository, Type type) {
        super(repository, type);
    }
}
