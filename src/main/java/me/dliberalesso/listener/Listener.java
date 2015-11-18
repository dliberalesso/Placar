package me.dliberalesso.listener;

import me.dliberalesso.model.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Instant;
import java.util.Date;

/**
 * @author Douglas Liberalesso
 */

public class Listener {
    @PrePersist
    void prePersist(BaseEntity entity) {
        Date date = Date.from(Instant.now());
        entity.setCreatedAt(date);
        preUpdate(entity);
    }

    @PreUpdate
    void preUpdate(BaseEntity entity) {
        entity.setUpdatedAt(Date.from(Instant.now()));
    }
}
