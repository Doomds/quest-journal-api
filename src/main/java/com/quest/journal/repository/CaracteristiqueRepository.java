package com.quest.journal.repository;

import com.quest.journal.entity.Caracteristique;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CaracteristiqueRepository implements PanacheRepository<Caracteristique> {

    @Transactional
    public Caracteristique create(Caracteristique caracteristique) {
        persist(caracteristique);
        return caracteristique;
    }

    public List<Caracteristique> getAll() {
        return listAll();
    }

    public Caracteristique getById(Long id) {
        return findById(id);
    }

    @Transactional
    public Caracteristique update(Long id, Caracteristique updated) {
        Caracteristique caracteristiqueExisting = findById(id);
        if (caracteristiqueExisting == null) {
            return null;
        }

        caracteristiqueExisting.setNom(updated.getNom());
        return caracteristiqueExisting;
    }

    @Transactional
    public boolean delete(Long id) {
        return deleteById(id);
    }
}
