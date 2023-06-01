package com.gsc.portalapps.repository;

import com.gsc.portalapps.model.entity.LoginKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginKeyRepository extends JpaRepository<LoginKey, Long> {

    Optional<LoginKey> findFirstByEnabledIsTrue();
}

