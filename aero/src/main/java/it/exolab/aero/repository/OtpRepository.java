package it.exolab.aero.repository;

import it.exolab.aero.airport_01Model.models.entities.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {

    Optional<Otp> findByCustomerIdAndCode(Long customerId, String code);

    int removeOtpsByCustomerId(Long customerId);
}
