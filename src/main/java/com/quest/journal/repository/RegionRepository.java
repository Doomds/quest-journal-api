package com.quest.journal.repository;

import com.quest.journal.entity.Quete;
import com.quest.journal.entity.Region;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RegionRepository implements PanacheRepository<Region> {

    @Transactional
    public Region create(Region region) {
        persist(region);
        return region;
    }

    public List<Region> getAll() {
        return listAll();
    }

    public Region getById(Long id) {
        return findById(id);
    }

    @Transactional
    public Region update(Long id, Region updated) {
        Region existing = findById(id);
        if (existing == null) {
            return null;
        }
        existing.setNom(updated.getNom());
        return existing;
    }

    @Transactional
    public boolean delete(Long id) {
        return deleteById(id);
    }
}
