package com.quest.journal.repository;

import com.quest.journal.entity.Entite;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;


@ApplicationScoped
public class EntiteRepository implements PanacheRepository<Entite> {

    @Transactional
    public Entite create(Entite entite) {
        persist(entite);
        return entite;
    }

    public List<Entite> getAll() {
        return listAll();
    }

    public Entite getById(Long id) {
        return findById(id);
    }

    @Transactional
    public Entite update(Long id, Entite updated) {
        Entite entiteExisting = findById(id);
        if (entiteExisting == null) {
            return null;
        }
        return entiteExisting;
    }

    @Transactional
    public boolean delete(Long id) {
        return deleteById(id);
    }
}
