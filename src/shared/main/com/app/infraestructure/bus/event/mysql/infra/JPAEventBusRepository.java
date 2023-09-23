package com.app.infraestructure.bus.event.mysql.infra;

import com.app.infraestructure.bus.event.mysql.domain.DomainEventData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAEventBusRepository extends JpaRepository<DomainEventData,String> {
}
