package ch.tbz.entity.osu;

import ch.tbz.generic.AbstractEntityRepository;
import ch.tbz.util.API;
/**
 * Osu Repository
 * @author mytal
 * @version 1.0.0
 */
public class OsuRepository extends AbstractEntityRepository<Osu> {
    public OsuRepository(API api) {
        super(api);
    }
}
