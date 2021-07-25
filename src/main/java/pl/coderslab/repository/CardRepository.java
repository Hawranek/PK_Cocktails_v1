package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Card;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {
    List<Card> findByUserId(Long id);
}
