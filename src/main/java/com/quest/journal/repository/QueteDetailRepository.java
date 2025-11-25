package com.quest.journal.repository;

import com.quest.journal.entity.QueteDetail;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class QueteDetailRepository implements PanacheRepository<QueteDetail> {

    @Transactional
    public QueteDetail create(QueteDetail queteDetail) {
        persist(queteDetail);
        return queteDetail;
    }

    public List<QueteDetail> getAll() {
        return listAll();
    }

    public QueteDetail getByID(Long id) {
        return findById(id);
    }

    @Transactional
    public QueteDetail update(Long id, QueteDetail updated) {
        QueteDetail queteExisting = findById(id);
        if (queteExisting == null) {
            return null;
        }
        return queteExisting;
    }

    public boolean delete(Long id){
        return deleteById(id);
    }
}
