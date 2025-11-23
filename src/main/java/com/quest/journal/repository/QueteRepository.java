package com.quest.journal.repository;

import com.quest.journal.entity.Quete;
import com.quest.journal.entity.Region;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class QueteRepository implements PanacheRepository<Quete> {

    @Transactional
    public Quete create(Quete quete) {
        persist(quete);
        return quete;
    }

    public List<Quete> getAll() {
        return listAll();
    }

    public Quete getById(Long id) {
        return findById(id);
    }

    public List<Quete> getByRegion(Region region) {
        return find("region", region).list();
    }

    public List<Quete> getByRegionId(Long regionId) {
        return find("region.id", regionId).list();
    }

    @Transactional
    public Quete update(Long id, Quete updated) {
        Quete queteExisting = findById(id);
        if (queteExisting == null) {
            return null;
        }
        queteExisting.setNom(updated.getNom());
        return queteExisting;
    }

    @Transactional
    public boolean delete(Long id) {
        return deleteById(id);
    }
}
