package com.tarotmate.tarot.global.certification;

import com.tarotmate.tarot.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
    VerificationToken findByUser(User user);
    @Modifying @Query("delete from VerificationToken t where t.expiryDate<=?1")
    void deleteAllExpiredTokens(LocalDateTime now);
}
