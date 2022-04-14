package site.metacoding.userupdate.domain.pet;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Query(value = "SELECT * FROM pet p WHERE p.userId = :id", nativeQuery = true)
    Pet pUpdate(@Param("userId") int userId);
}
