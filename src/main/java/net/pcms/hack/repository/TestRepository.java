package net.pcms.hack.repository;

import net.pcms.hack.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TestRepository extends JpaRepository<Test, Long> {
    Test findByHash(String hash);

    @Transactional
    @Modifying
    @Query("update Test set answer = ?1 where hash = ?2")
    void setAnswerByHash(String answer, String hash);
}
