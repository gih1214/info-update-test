package site.metacoding.userupdate.domain.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    // 펫정보 가져오는 쿼리문
    @Query(value = "SELECT * FROM pet WHERE userId = :userId", nativeQuery = true)
    Pet pUpdate(@Param("userId") int userId);
}
