package com.app.infraestructure.bus.event.mysql.infra;

import com.app.infraestructure.bus.event.mysql.domain.DomainEventData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAEventBusRepository extends JpaRepository<DomainEventData,String> {



    @Query("SELECT e FROM DomainEventData e")
    List<DomainEventData> findFirstN(@Param("count") int count);;
}
