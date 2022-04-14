package site.metacoding.userupdate.domain.pet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    @Query(value = "SELECT * FROM pet WHERE userId = :userId", nativeQuery = true)
    List<Pet> pUpdate(@Param("userId") int userId);
}
